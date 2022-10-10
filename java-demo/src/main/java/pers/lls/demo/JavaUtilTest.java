package pers.lls.demo;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
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
