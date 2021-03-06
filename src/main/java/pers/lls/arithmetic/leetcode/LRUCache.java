package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.HashMap;

class LRUCache {
    HashMap<Integer,DlinkedNode> cache = new HashMap<>();
    int capacity = 0;
    int count = 0;
    DlinkedNode head;
    DlinkedNode tail;



    class DlinkedNode {
        int key;
        int value;
        DlinkedNode prev;
        DlinkedNode next;
        public DlinkedNode(){}
        public DlinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        DlinkedNode firstNdoe = new DlinkedNode();
        DlinkedNode lastNode = new DlinkedNode();

        this.head= firstNdoe;
        this.tail = lastNode;
        head.next = tail;
        this.capacity = capacity;
    }

    public int get(int key) {
        DlinkedNode node = cache.get(key);
        if (node != null){
            move2head(node);
            return node.value;
        } else {
            return -1;
        }
    }

    private void move2head(DlinkedNode node) {
        remove(node);
        add2head(node);
    }

    private void add2head(DlinkedNode node) {
        DlinkedNode first = head.next;
        head.next = node;
        node.next = first;
        node.prev = head;
        first.prev = node;
        cache.put(node.key, node);
    }

    private void remove(DlinkedNode node) {
        DlinkedNode prev = node.prev;
        DlinkedNode next = node.next;
        prev.next = next;
        next.prev = prev;
        cache.remove(node.key);
    }

    public void put(int key, int value) {
        DlinkedNode node = cache.get(key);

        if (node != null){
            node.value = value;
            move2head(node);
        }else {
            DlinkedNode dlinkedNode = new DlinkedNode(key, value);
            if (count < capacity){
                count++;
            } else {
                DlinkedNode lastnode = tail.prev;
                remove(lastnode);
            }
            add2head(dlinkedNode);
        }

    }

    public static void main(String[] args) {

        int[] intarray = new int[]{
                3,2,0,-4
        };

        Integer[] integerarray = new Integer[]{
                -10,9,20,null,null,15,7
        };
        int[] intarray2 = new int[]{
                1,2,3
        };

        int i = 2;
        int i2 = 3;
        int i3 = 0;
        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray,i);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);


        LRUCache lruCache = new LRUCache(i);
        lruCache.put(2,1);
//        System.out.println(JSONObject.toJSONString(lruCache.get(2), SerializerFeature.PrettyFormat));
        lruCache.put(1,1);
        System.out.println(JSONObject.toJSONString(lruCache.get(2), SerializerFeature.PrettyFormat));
        lruCache.put(4,1);
        System.out.println(JSONObject.toJSONString(lruCache.get(1), SerializerFeature.PrettyFormat));
        System.out.println(JSONObject.toJSONString(lruCache.get(2), SerializerFeature.PrettyFormat));
//        System.out.println(JSONObject.toJSONString(lruCache.get(4), SerializerFeature.PrettyFormat));
    }
}