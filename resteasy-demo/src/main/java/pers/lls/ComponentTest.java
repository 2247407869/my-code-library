package pers.lls;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ComponentTest {
    static {
        System.out.println("hello1");
    }
}
