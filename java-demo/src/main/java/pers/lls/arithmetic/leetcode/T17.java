package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;

public class T17 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};
    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) return result;
        backtrack("", digits);
        return result;
    }

    private void backtrack(String s, String digits) {
        if (digits.equals("")){
            result.add(s);
        }else {
            String letters = phone.get(digits.substring(0,1));
            for (int i = 0; i < letters.length(); i++) {
                backtrack(s + letters.charAt(i), digits.substring(1));
            }
        }
    }


    public static void main(String[] args) {

        int[] intarray = new int[]{
                1,2,3,1
        };

        Integer[] integerarray = new Integer[]{
                3,1,4,null,2
        };
        int[] intarray2 = new int[]{
                1,2,3
        };

        int i = 1;
        int i2 = 3;

        String string = "";

        ListNode listNode = new ListNode().buildListNode(intarray,-1);

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        TreeNode treeNode = new TreeNode().buildTree(integerarray);


        char[] charArray = new char[]{'h','e','l','l'};
//        new T557().reverseWords(charArray);
//        System.out.println(charArray);
        System.out.println(JSONObject.toJSONString(new T17().letterCombinations(string), SerializerFeature.PrettyFormat));
    }
}
