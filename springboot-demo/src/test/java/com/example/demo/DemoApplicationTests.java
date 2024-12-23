package com.example.demo;

import com.example.demo.dao.UserRepositoty;
import com.example.demo.domain.User;
import org.apache.commons.lang3.RandomUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest
class DemoApplicationTests {
    @Resource
    UserRepositoty userRepositoty;

    @Test
    void contextLoads() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            User user = new User();
            user.setId((long) (20230000 + i));
            user.setName("lls1" + i);
            user.setStatus("status" + i);
            users.add(user);
        }
        userRepositoty.saveAll(users);
//		User one = userRepositoty.findById(12L).get();
//		System.out.println(one.getName());
    }

}
