package com.example.demo.controller;

import com.example.demo.dao.UserRepositoty;
import com.example.demo.domain.User;
import com.example.demo.dto.UserDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * test0
 */
//@Tag(name = "TestController", description = "xxx管理")
@RestController
public class TestController {

//    @Resource
//    UserDao userDao;

    @Resource
    UserRepositoty userRepositoty;

    //    private static final org.apache.log4j.Logger log4jLogger = org.apache.log4j.Logger.getLogger(TestController.class);
    private static final Logger log4j2Logger = LogManager.getLogger(TestController.class);
    private static final org.slf4j.Logger slf4jLogger = LoggerFactory.getLogger(TestController.class);

    /**
     * test1
     */
    @PostMapping("/test")
    @ResponseBody
    public String testDemo() {
//        log4jLogger.info("log4j1 info {}", 123);
        log4j2Logger.info("log4j2 info {}", 123);
        slf4jLogger.info("slf4j info");
        return "Hello World!";
    }

    /**
     * test2
     */
    @GetMapping("/users/{id}")
    @ResponseBody
    public UserDTO getUser(@PathVariable("id") Long id) {
//        User user = userDao.selectByPrimaryKey(id);
        User user = userRepositoty.getOne(id);
        return UserDTO.formPO(user);
    }

    /**
     * lkadjslfk
     * @param user
     */
    @PostMapping("/users/{id}")
    @ResponseBody
    public void saveUser(@RequestBody User user) {
        userRepositoty.save(user);
    }
}