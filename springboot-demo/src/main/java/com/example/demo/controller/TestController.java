package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.MessageFormat;

@Controller
@RequestMapping("/app")
@Slf4j
public class TestController {
    private static final Logger logger = LogManager.getLogger(TestController.class);
    @RequestMapping("/test")
    @ResponseBody
    public String testDemo() {
        log.info("lls");
        logger.info("log4j info");
        String s = "Hello World!";
        return MessageFormat.format("name:{},age:{}","lls","1");
    }
}
