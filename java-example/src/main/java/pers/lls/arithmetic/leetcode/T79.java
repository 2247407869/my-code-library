package pers.lls.arithmetic.leetcode;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;


public class T79 {
    List<String> path = new ArrayList<>();

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]){
                    if(backtrace(board, word,i,j))
                        return true;
                }
            }
        }
        return false;
    }

    private boolean backtrace(char[][] board, String substring, int high, int weigh) {
        char target = substring.charAt(0);
        if (high < 0 || high > board.length - 1 || weigh < 0 || weigh > board[0].length - 1) return false;
        if (path.contains(high + "/" + weigh)) return false;
        if (board[high][weigh] != target) return false;
        if (substring.length() == 1) return true;
        path.add(high + "/" + weigh);
        if (backtrace(board, substring.substring(1), high + 1, weigh) ||
        backtrace(board, substring.substring(1), high - 1, weigh) ||
        backtrace(board, substring.substring(1), high, weigh + 1) ||
        backtrace(board, substring.substring(1), high, weigh - 1))
            return true;
        path.remove(high + "/" + weigh);
        return false;
    }


    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {


        int[] intarray = new int[]{
1,2,3
        };

        int i = 3;
        int i2 = 3;

        String string = "abdc";

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(4)));

        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        char[][] chararray = new char[][]{
                {'a','b'},
                {'c','d'}};
        System.out.println(JSONObject.toJSONString(new T79().exist(chararray,string), SerializerFeature.PrettyFormat));
    }
}

