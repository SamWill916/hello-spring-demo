package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//This is for first 1.1 Section
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //Handles request at path /hello
//    @ResponseBody
//    @GetMapping("hello")
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //lives at /hello/goodbye

    @GetMapping("goodbye")
        public String goodbye() {
        return "Goodbye, Spring!";
    }


    //Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //    //Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }
//    @GetMapping("form")
//    public String helloForm(){
//        return "<html>" +
//                "<body>" +
//                "<form action = 'hello' method = 'post'>" + //submits request to /hello
//                "<input type = 'text' name = 'name'>" +
//                "<input type = 'submit' value = 'Greet Me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//
//    }
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post'>" + //submits request to /hello
                "<input type = 'text' name = 'name'>" +
                "<select name = \"language\" id=\"language-select\">\n" +
                    "<option value=\"\">--Please choose an option--</option>" +
                    "<option value=\"Russian\">Russian</option>\n" +
                    "<option value=\"Italian\">Italian</option>\n" +
                    "<option value=\"Spanish\">Spanish</option>\n" +
                    "<option value=\"French\">French</option>\n" +
                    "<option value=\"Chinese\">Chinese</option>\n" +
                "</select>" +
                "<input type='submit' value = 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";

    }
    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null) {
            name = "World";
        }

        return createMessage(name, language);

        // For a bonus mission, students can change this response text to look nicer.
        // This is subjective, but students should be modifying the HTML of the response string.
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("english")) {
            greeting = "Hello";
        }
        else if (l.equals("french")) {
            greeting = "Bonjour";
        }
        else if (l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("spanish")) {
            greeting = "Hola";
        }
        else if (l.equals("german")) {
            greeting = "Hallo";
        }
        else if (l.equals("chinese")){
            greeting = "Ni Hao";
        }
        else if (l.equals("russian")){
            greeting = "Privyet";
        }

        return greeting + " " + n;
    }


}

