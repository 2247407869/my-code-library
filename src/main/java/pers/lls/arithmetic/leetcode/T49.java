package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class T49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] letters = new int[26];
            for (int i = 0; i < str.length(); i++) {
                letters[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int letter : letters) {
                sb.append("#").append(letter);
            }
            if (map.containsKey(sb.toString())){
                map.get(sb.toString()).add(str);
            } else {
                map.put(sb.toString(),new ArrayList<String>(){{add(str);}});
            }
        }
        return new ArrayList<>(map.values());
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {

        int[][] intarrays = new int[][]{};

        int[] intarray = new int[]{
                1,2,3
        };

        int i = 1 ;

        String string ="123";

        String string2 = "456";

        ListNode listNode = new ListNode(1,new ListNode(2,new ListNode(4)));

        ListNode listNode2 = new ListNode(1,new ListNode(3,new ListNode(4)));


//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.add(1);
//        deque.add(2);
//        deque.();
//        System.out.println(deque);
        String[] stringArray = new String[]{};
        ;
        System.out.println(JSONObject.toJSONString(new T49().groupAnagrams(stringArray)));
    }
}

