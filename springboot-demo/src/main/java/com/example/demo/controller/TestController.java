package com.example.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/app")
public class TestController {
    private static final Logger log4jLogger = LogManager.getLogger(TestController.class);
    private static final org.slf4j.Logger slf4jLogger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping("/test")
    @ResponseBody
    public String testDemo() {
        log4jLogger.info("log4j info {}", 123);
        slf4jLogger.info("slf4j info");
        return "Hello World!";
    }
}