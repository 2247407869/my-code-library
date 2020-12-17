package pers.lls.aop.cglib;

public class Main {
    public static void main(String[] args) {
        UserManage um = new UserManage();
        TimeInterceptor time = new TimeInterceptor(um);
        um = ProxyUtil.proxyOne(um.getClass(), time);
        um.addUser("111", "老王");
    }
}
