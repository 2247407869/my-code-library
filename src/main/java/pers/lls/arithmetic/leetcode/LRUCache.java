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
        first.next = node;
        node.next = first;
    }

    private void remove(DlinkedNode node) {
        DlinkedNode prev = node.prev;
        prev.next = node.next;
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
            cache.put(key, dlinkedNode);
            move2head(dlinkedNode);
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

        int i = 1;
        int i2 = 3;
        int i3 = 0;
        String string = "[";

        ListNode listNode = new ListNode().buildListNode(intarray,i);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);


        LRUCache lruCache = new LRUCache(i);
        lruCache.put(i2,i3);
        System.out.println(JSONObject.toJSONString(lruCache.get(i2), SerializerFeature.PrettyFormat));
    }
}