package pers.lls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class ComponentTest2 {
    @Autowired
    ComponentTest componentTest;
    static {
        System.out.println("hello2");
    }
}
