package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//s = adobecodebanc
//t = abc
public class T76 {
    HashMap<Character, Integer> cnt = new HashMap<>();//ADOBECODEBANC
    HashMap<Character, Integer> ori = new HashMap<>();//abc
    public String minWindow(String s, String t) {

        for (int i = 0; i < t.length(); i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0;
        int r = 0;
        int rl = -1;
        int rr = s.length()-1;
        int length = s.length();
        while (r < s.length()){
            if (ori.containsKey(s.charAt(r)))
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r),0)+1);
            while (check()){
                if (r - l + 1 <= length){
                    rl = l;
                    rr = r;
                    length = rr - rl + 1;
                }
                if (ori.containsKey(s.charAt(l)))
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l), 0) - 1);
                l++;
            }
            r++;
        }
        return rl == -1 ?"": s.substring(rl,rr+1);
    }

    private boolean check() {
        Iterator iterator = ori.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry =  (Map.Entry) iterator.next();
            Character character = (Character) entry.getKey();
            Integer integer = (Integer) entry.getValue();
            if (cnt.getOrDefault(character,0) < integer)
                return false;
        }
        return true;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        int[][] dubblearray = new int[][]{
                {1,3}
        };

        int[] intarray = new int[]{
                5, 1, 3
        };

        int i = 3;
        int i2 = 3;

        String string = "[";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        String s1 = "adobecodebanc";
        String s2 = "abc";

//        System.out.println(JSONObject.toJSONString(new T76().minWindow(s1,s2), SerializerFeature.PrettyFormat));
//        System.out.println(JSONObject.toJSONString(new T76().minWindow("a","aa"), SerializerFeature.PrettyFormat));
        System.out.println(JSONObject.toJSONString(new T76().minWindow("a","a"), SerializerFeature.PrettyFormat));
    }
}

