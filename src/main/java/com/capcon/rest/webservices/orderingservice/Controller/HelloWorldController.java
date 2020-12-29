package com.capcon.rest.webservices.orderingservice.Controller;

import com.capcon.rest.webservices.orderingservice.Model.HelloWorldBean;
import org.springframework.web.bind.annotation.*;

//Controller - tell spring it will be handling requests
@RestController
public class HelloWorldController {
    // GET
    // URI - /hello-world
    // Method - "Hello World"



    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("hello-world-bean");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("hello world, %s", name));
    }
}
