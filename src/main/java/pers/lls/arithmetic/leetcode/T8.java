package pers.lls.arithmetic.leetcode;

import pers.lls.demo.HelloWorld;
import pers.lls.parttern.strategy.Character;

import java.util.HashMap;

public class T8 {
    public static void main(String[] args) {
        System.out.println(new T8().myAtoi("-2147483647"));
    }

    public int myAtoi(String str) {
        HashMap<String, String[]> statusMap = new HashMap<>();
        statusMap.put("start", new String[]{"start", "sign", "number", "end"});
        statusMap.put("sign", new String[]{"end", "end", "number", "end"});
        statusMap.put("number", new String[]{"end", "end", "number", "end"});
        statusMap.put("end", new String[]{"end", "end", "end", "end"});

        String status = "start";
        int flag = 1;
        int num = 0;
        for(int p = 0;p<str.length();p++){
            status=statusMap.get(status)[getCol(str.charAt(p))];
            if (status.equals("sign")){
                flag = str.charAt(p) == '+' ? 1 : -1;
            }
            if (status.equals("number")){
                int i = (str.charAt(p) - '0') * flag;
                if (flag ==1 && (num > Integer.MAX_VALUE/10 || (num == Integer.MAX_VALUE/10 && i > Integer.MAX_VALUE % 10)))
                    return Integer.MAX_VALUE;
                if (flag == -1 && (num < Integer.MIN_VALUE/10 || (num == Integer.MIN_VALUE/10 && i < Integer.MIN_VALUE % 10)))
                    return Integer.MIN_VALUE;
                num = num * 10 + i;
            }
        }
        return num;
    }

    public int getCol(char c) {
        if (c == ' ') return 0;
        else if (c == '+' || c == '-') return 1;
        else if (c >= '0' && c <= '9') return 2;
        else return 3;
    }
}
