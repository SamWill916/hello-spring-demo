package org.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@Controller //by default has no particular routing information with it
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
//    @GetMapping("hello") //method should handle get requests. will only accept get requests
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring";
//    }

    @GetMapping("goodbye") //method should handle get requests. will only accept get requests
    public String goodbye(){
        return "Goodbye, Spring";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello " + name + "!";
    }

    //Handles the request of the form hello/launchcode
    @GetMapping("{name}")
    public String helloWithStringParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='get'>" +
                "<input type='text' name='name'>" +
                "<select name=\"language\" id=\"language-select\">\n" +
                "    <option value=\"\">--Please choose an option--</option>" +
                "    <option value=\"French\">French</option>\n" +
                "    <option value=\"Italian\">Italian</option>\n" +
                "    <option value=\"Spanish\">Spanish</option>\n" +
                "    <option value=\"German\">German</option>\n" +
                "    <option value=\"Bosnian\">Bosnian</option>\n" +
                "</select>" +
                "<input type='submit' value='Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
