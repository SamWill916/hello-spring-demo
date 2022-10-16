package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//This is for first 1.1 Section
@Controller
public class HelloController {

    //Handles request at path /hello
//    @ResponseBody
//    @GetMapping("hello")
//    public String hello(){
//        return "Hello, Spring!";
//    }

    @ResponseBody
    @GetMapping("goodbye")
        public String goodbye() {
        return "Goodbye, Spring!";
    }


    //Handles requests of the form /hello?name=Sam
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }
    @GetMapping("form")
    public String helloForm(){
        return "form";
//returning form.html - just returning name of template
    }

}

