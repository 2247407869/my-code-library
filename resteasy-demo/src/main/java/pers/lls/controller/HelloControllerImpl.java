package pers.lls.controller;

import org.apache.dubbo.config.annotation.DubboService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@DubboService(protocol = "dubbo")
//@Path("/hello")
public class HelloControllerImpl implements HelloController {

//    @GET
    public String sayHello(){

        return "hello";
    }
}
