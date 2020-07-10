package pers.lls.arithmetic.leetcode;

import javax.print.DocFlavor;

public class T12 {
    int[] values = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] simbols = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};


    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]){
                result.append(simbols[i]);
                num-=values[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new T12().intToRoman(58));
    }
}
