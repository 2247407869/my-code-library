import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Tuple;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DelayQuqueByRedis {

    private static final String ADDR = "10.1.240.116";
    private static final int PORT = 6379;
    private static JedisPool jedisPool = new JedisPool(ADDR, PORT);
    private static CountDownLatch cdl = new CountDownLatch(10);

    public static Jedis getJedis() {
        return jedisPool.getResource();
    }

    /**
     * 生产者,生成5个订单
     */
    public void productionDelayMessage() {
        for (int i = 0; i < 5; i++) {
            Calendar instance = Calendar.getInstance();
            // 3秒后执行
            instance.add(Calendar.SECOND, 3 + i);
            // zadd 添加到有序集合中
            DelayQuqueByRedis.getJedis().zadd("orderId", (instance.getTimeInMillis()) / 1000D, StringUtils.join(
                    "000000000", i + 1));
            System.out.println("生产订单: " + StringUtils.join("000000000", i + 1) + " 当前时间：" + new SimpleDateFormat(
                    "yyyy-MM-dd HH:mm:ss").format(new Date()));
            System.out.println((3 + i) + "秒后执行");
        }
    }

    //消费者，取订单
    @SuppressWarnings("InfiniteLoopStatement")
    public static void consumerDelayMessage() {
        Jedis jedis = DelayQuqueByRedis.getJedis();
        while (true) {
            // 获取时间最早的任务
            Set<Tuple> order = jedis.zrangeWithScores("orderId", 0, 0);
            if (order == null || order.isEmpty()) {
                System.out.println("当前没有等待的任务");
                try {
                    TimeUnit.MICROSECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            Tuple tuple = (Tuple) order.toArray()[0];
            double score = tuple.getScore();
            Calendar instance = Calendar.getInstance();
            long nowTime = instance.getTimeInMillis() / 1000;
            if (nowTime >= score) {
                String element = tuple.getElement();
                Long orderId = jedis.zrem("orderId", element);
                if (orderId > 0) {
                    System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + ":redis" +
                            "消费了一个任务：消费的订单OrderId为" + element);
                }
            }
        }
    }

    static class DelayMessage implements Runnable{
        @Override
        public void run() {
            try {
                // 等待所有线程同时开始
                cdl.await();
                consumerDelayMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        DelayQuqueByRedis delayQuqueByRedis = new DelayQuqueByRedis();
        delayQuqueByRedis.productionDelayMessage();
        for (int i = 0; i < 10; i++) {
            new Thread(new DelayMessage()).start();
            cdl.countDown();
        }
    }
}