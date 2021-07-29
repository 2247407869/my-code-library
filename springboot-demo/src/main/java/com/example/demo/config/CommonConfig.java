package com.example.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.I0Itec.zkclient.ZkClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *
 */
@Slf4j
@Configuration
public class CommonConfig {
    public static ZkClient zkClient;
    public static boolean alwaysLeader;
    public static String baseUrl;
    private static String zkUrl;

    @Value("${zk.url}")
    public void setZkUrl(String zkUrl) {
        log.info("从apollo上的common.properties上获取到参数zk.url值为：{}", zkUrl);
        if (zkClient == null) {
            CommonConfig.zkUrl = zkUrl;
            zkClient = new ZkClient(zkUrl.replace("zookeeper://", "").replace("?backup=", ",").trim(), 30000, 30000);
        }
    }

    @Value("${uyun.baseurl}")
    public void setBaseUrl(String baseUrl) {
        CommonConfig.baseUrl = baseUrl;
    }
}
