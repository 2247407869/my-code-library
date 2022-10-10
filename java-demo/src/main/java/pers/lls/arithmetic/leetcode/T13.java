package pers.lls.arithmetic.leetcode;

//I             1
//        V             5
//        X             10
//        L             50
//        C             100
//        D             500
//        M             1000
public class T13 {
    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            int now = num(s.charAt(i));
            int right = i == length-1?Integer.MIN_VALUE:num(s.charAt(i+1));
            if (now < right)
                result -= now;
            else result += now;
        }
        return result;
    }

    int num(char c){
        switch (c){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
throw  new RuntimeException("不支持的字符");
    }

    public static void main(String[] args) {
        System.out.println(new T13().romanToInt("MCMXCIV"));
    }
}
