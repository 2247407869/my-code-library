package pers.lls.jvm;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 弱引用关联对象何时被回收
 * Created by ccr at 2018/7/14.
 */
public class WeakReferenceDemo2 {
    public static void main(String[] args) throws InterruptedException {
        String savePoint = new String("Random"); // 创建一个强引用
        ReferenceQueue<String> savepointQ = new ReferenceQueue<String>();//引用队列
        WeakReference<String> savePointWRefernce = new WeakReference<String>(savePoint, savepointQ);
        System.out.println("SavePoint 被作为一个弱引用来创建" + savePointWRefernce);
        Runtime.getRuntime().gc();
        System.out.println("在引用队列中存在引用型对象吗 ? " + (savepointQ.poll() != null));
        savePoint = null; // 唯一的强引用被删除掉，在堆中的对象现在只具有弱可达性
        System.out.println("现在调用GC");
        Runtime.getRuntime().gc(); // 对象会在这里被回收掉，finalize方法会被调用
//        System.out.println("在引用队列中的引用型对象 " + (savepointQ.poll().get()));
        System.out.println("在引用队列中有任何弱引用吗? " + (savepointQ.remove() != null));
        System.out.println("弱引用型对象还引用着堆中的对象吗?" + (savePointWRefernce.get() != null));
        System.out.println("弱引用型对象被添加到引用队列中了吗?" + (savePointWRefernce.isEnqueued()));
    }
}