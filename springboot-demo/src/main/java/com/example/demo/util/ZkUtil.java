package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.example.demo.config.CommonConfig;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * 就目前而言LeaderLatch应该算满足需求.即一台机器确定为leader后,就一直是它除非死掉
 * LeaderSelector倒是可以更智能，可以释放，然后再选举为leader。不过使用上要考虑较多，还是先不用这个了
 * <p>
 * 结论：http://uyunsoft.cn/kb/pages/viewpage.action?pageId=14649586
 *
 * @author Ling
 */
public class ZkUtil {
    private ZkClient zkClient = CommonConfig.zkClient;

    private String path;
    private String data = "";

    private boolean isLeader = false;
    private static final Logger logger = LoggerFactory.getLogger(ZkUtil.class);
    private static final String ROOT_CATALOG = "/databank";
    private static final String REMOVE = "remove";
    public static final String JOB_ADDRESS = "/databank/uyun.manager.job.";

    private static List<ZkUtil> zkUtilList = new ArrayList<ZkUtil>();

    public static Boolean selectLeader(String path) {
        if (CommonConfig.alwaysLeader) return true;
        ZkUtil selector = new ZkUtil(path);
        Object data = selector.zkClient.readData(ROOT_CATALOG + path);
        if (data != null) {
            try {
                if (data.toString().contains(InetAddress.getLocalHost().getHostAddress())) {
                    return true;
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return selector.isLeader();
    }

    public static String getLeaderIPAddress(String path) {
        if (CommonConfig.alwaysLeader) {
            try {
                return InetAddress.getLocalHost().getHostAddress();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        ZkUtil selector = new ZkUtil(path);
        String data = selector.zkClient.readData(ROOT_CATALOG + path).toString();
        return data.split("/")[1].split("-")[0];
    }

    public static void closeBatLeaderSelector() {
        for (int i = 0; i < zkUtilList.size(); i++) {
            ZkUtil ll = zkUtilList.get(i);
            ll.close();
            i--;
        }
    }

    /**
     * @param path 不能与其他业务逻辑重复,且只能单级目录。e.g. /uyun.bat.tenant.producedata
     */
    private ZkUtil(String path) {
        if (path == null || path.length() == 0)
            throw new IllegalArgumentException("illegal path.[path=" + path + "]");

        this.path = ROOT_CATALOG + path;

        data = generateData();

        try {
            init();
        } catch (Exception e) {
            throw new RuntimeException(String.format("ZkUtil init error.[path=%s]", this.path), e);
        }
    }

    private void init() {
        initDirectory();
        tryLeader();
        zkClient.subscribeDataChanges(path, new IZkDataListener() {
            @Override
            public void handleDataChange(String dataPath, Object data) throws Exception {
                // 另一台机器成为leader
                logger.info("dataPath: {}, data: {}", dataPath, JSON.toJSONString(data));

            }

            @Override
            public void handleDataDeleted(String dataPath) throws Exception {
                logger.info(String.format("handleDataDeleted.dataPath=%s", dataPath));
                //另一台机器挂了
                Object data = zkClient.readData(dataPath);
                if (data != null) {
                    if (REMOVE.equals(data.toString())) {
                        return;
                    }
                }
                tryLeader();
            }
        });

        zkUtilList.add(this);
    }

    private void initDirectory() {
        if (zkClient == null || zkClient.exists(ROOT_CATALOG))
            return;
        Exception except = null;
        try {
            zkClient.createPersistent(ROOT_CATALOG);
        } catch (Exception e) {
            except = e;
        }
        if (!zkClient.exists(ROOT_CATALOG)) {
            logger.warn(String.format("create root directory[%s]failed.[%s]", ROOT_CATALOG, except != null ? except.getMessage()
                    : "exception is null"));
            logger.debug("Stack：", except);
        }
    }

    public static void updateData(String path, String data) {
        if (CommonConfig.zkClient.exists(path)) {
            try {
                CommonConfig.zkClient.writeData(path, data);
                logger.info(String.format("superior successfully.[data=%s]", data));
            } catch (Exception e) {
                logger.info(String.format("elect for leader failed,wait for next elect。[data=%s]", data), e);
            }
        }
    }

    private void tryLeader() {
        if (!zkClient.exists(path)) {
            try {
                zkClient.createEphemeral(path, data);
                isLeader = true;
                logger.info(String.format("superior successfully.[data=%s]", data));
            } catch (Exception e) {
                isLeader = false;
                logger.info(String.format("elect for leader failed,wait for next elect。[data=%s]", data), e);
            }
        }
        logger.info(String.format("temporary point has built,wait for next leader elect。[path=%s]", path));
    }

    private String generateData() {
        String prefix = "";
        try {
            prefix = InetAddress.getLocalHost().toString();
        } catch (Exception e) {
            logger.warn("gain LocalHost message failed！", e);
        }

        return prefix + "-" + System.currentTimeMillis() + "-" + (int) (Math.random() * 100);
    }

    private boolean isLeader() {
        return isLeader;
    }

    public void close() {
        try {
            zkClient.unsubscribeAll();
            zkClient.close();
        } catch (Exception e) {
            logger.warn("Close zkClient error:", e);
        }
        isLeader = false;
        zkUtilList.remove(this);
    }

    public String getPath() {
        return path;
    }

}
