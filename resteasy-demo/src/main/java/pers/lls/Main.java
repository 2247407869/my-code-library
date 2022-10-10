package pers.lls;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
        System.out.println("11111");
        context.getBean(ComponentTest2.class);
        System.in.read();
    }
}
