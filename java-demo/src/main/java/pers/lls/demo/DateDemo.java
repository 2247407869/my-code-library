package pers.lls.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {
   public static void main(String args[]) {

      //18-6月-20 03.12.11.809000 下午
 
      Date dNow = new Date(1640502236123l );
      SimpleDateFormat ft = new SimpleDateFormat ("yy-M月-d hh.mm.ss.SSS000 a");
 
      System.out.println("当前时间为: " + ft.format(dNow));
   }
}