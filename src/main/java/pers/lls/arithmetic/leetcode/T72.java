package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.omg.CORBA.ShortSeqHelper;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;


public class T72 {
    HashMap<String,Integer> mind = new HashMap<>();

    public int minDistance(String word1, String word2) {
        String key = word1 + "|" + word2;
        if (mind.containsKey(key)) return mind.get(key);
        int l1 = word1.length();
        int l2 = word2.length();
        if (l1 == 0 || l2 == 0){
            int max = Math.max(l1, l2);
            mind.put(key,max);
            return max;
        }
        if (word1.charAt(l1-1) == word2.charAt(l2-1)){
            int i = minDistance(word1.substring(0, l1 - 1), word2.substring(0, l2 - 1));
            mind.put(key,i);
            return i;
        }else {
            int min = Math.min(minDistance(word1.substring(0, l1 - 1), word2.substring(0, l2)),
                    Math.min(minDistance(word1.substring(0, l1), word2.substring(0, l2 - 1)),
                            minDistance(word1.substring(0, l1 - 1), word2.substring(0, l2 - 1)))) + 1;
            mind.put(key,min);
            return min;
        }
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

        String s2 = "horse";
        String s1 = "ros";

        System.out.println(JSONObject.toJSONString(new T72().minDistance(s1,s2), SerializerFeature.PrettyFormat));
    }
}

