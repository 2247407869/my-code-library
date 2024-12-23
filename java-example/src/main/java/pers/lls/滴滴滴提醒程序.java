package pers.lls;

import java.util.*;

public class 滴滴滴提醒程序 {  
    public static void main(String[] args) {  
        Scanner scanner = new Scanner(System.in);  
        int hour = 9; // 早上 9 点  
        int minute = 0; // 每隔半个小时提醒一次  
        while (true) {  
            System.out.println("请输入当前时间 (HH:MM):");  
            String timeString = scanner.nextLine();  
            int hourInt = Integer.parseInt(timeString.substring(0, 2));  
            int minuteInt = Integer.parseInt(timeString.substring(3, 5));  
            if (hour < 9 || hour > 12 || minute < 0 || minute > 59) {  
                System.out.println("当前时间为" + timeString + ",不需要提醒");  
                continue;  
            } else {  
                if (minute == 0) {  
                    System.out.println("滴滴滴，提醒 1");  
                } else {  
                    System.out.println("滴滴滴，提醒 2");  
                }  
                System.out.println("再过" + ((hour - hourInt) * 30 + minute) + "分钟");  
                minute = minute + 5;  
            }  
        }  
    }  
}
