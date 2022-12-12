package org.apache.dubbo.springboot.demo.provider;

public class Zk {
    public static void main(String[] args) {
        new EmbeddedZooKeeper(2181, false).start();
    }
}
