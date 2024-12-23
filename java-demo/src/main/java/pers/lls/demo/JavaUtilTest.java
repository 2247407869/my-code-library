package pers.lls.demo;

import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 */
public class JavaUtilTest {

    public static void main(String[] args) {

        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        ConcurrentLinkedDeque<Integer> concurrentLinkedDeque = new ConcurrentLinkedDeque<>();
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Hashtable hashtable = new Hashtable();
    }


}
