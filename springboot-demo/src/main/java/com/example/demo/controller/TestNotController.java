package com.example.demo.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 123
 */
@Tag(name = "TestNotController", description = "非controller测试")
public class TestNotController {

    /**
     * abc
     */
    void testVoid(){
        System.out.println("dosth");
    }
}
