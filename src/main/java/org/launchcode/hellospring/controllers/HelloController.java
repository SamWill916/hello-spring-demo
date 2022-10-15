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
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method='post'>" + //submits request to /hello
                "<input type = 'text' name = 'name'>" +
                "<input type = 'submit' value = 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";

    }

}

