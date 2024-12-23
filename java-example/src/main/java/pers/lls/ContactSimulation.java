package pers.lls;

import java.text.DecimalFormat;
import java.util.Random;

public class ContactSimulation {
    public static void main(String[] args) {
        int numExamples = 10; // 模拟的例子数量
        simulateContact(numExamples);
    }

    private static void simulateContact(int numExamples) {
        Random random = new Random();
        for (int i = 0; i < numExamples; i++) {
            double probability = 1;
            double girlprobability = 0.3;
            DecimalFormat df = new DecimalFormat("0.00");
            System.out.println("例子 " + (i + 1) + ":");
            for (int day = 1; day <= 20; day++) {
                if (random.nextDouble() < probability) {
                    System.out.print("1," + df.format(probability) + ", "); // 联系了
                    System.out.println();
                } else {
                    System.out.print("0," + df.format(probability) + ", "); // 没有联系
                    System.out.println();
                }
                if (random.nextDouble() < girlprobability) {
//                    probability += 0.3;
                }
                probability = probability - 0.1; // 计算当天的概率
            }
            System.out.println(); // 换行到下一个例子
        }
    }
}