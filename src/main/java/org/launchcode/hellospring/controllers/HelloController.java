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


    //Handles requests of the form /hello?name=Sam
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name){
//        return "Hello, " + name + "!";
//    }
//
//    //    //Handles requests of the form /hello/Sam
//    @GetMapping("{name}")
//    public String helloWithPathParam(@PathVariable String name){
//        return "Hello, " + name + "!";
//    }

    //    @GetMapping("form") //this is the old button form
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
    @GetMapping("form")//lives in /hello/form
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post'>" + //submits request to /hello
                "<input type = 'text' name = 'name'>" +
                "<select name = 'language' id='language-select'>" +
                    "<option value=''>--Please choose an option--</option>" +
                    "<option value='Russian'>Russian</option>" +
                    "<option value='Italian'>Italian</option>" +
                    "<option value='Spanish'>Spanish</option>" +
                    "<option value='French'>French</option>" +
                    "<option value='Chinese'>Chinese</option>'" +
                "</select>" +
                "<input type='submit' value = 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";

   }
////    @RequestMapping(value="hello", method = RequestMethod.POST)
////    @ResponseBody
////    public String helloPost(@RequestParam String name, @RequestParam String language) {
////        if (name == null) {
////            name = "World";
////        }
////
////        return createMessage(name, language);
//
//        // For a bonus mission, students can change this response text to look nicer.
//        // This is subjective, but students should be modifying the HTML of the response string.
//    }
@RequestMapping(value ="hello", method = RequestMethod.POST)
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        String greeting = "";

        if (language.equals("English")) {
            greeting = "Hello";
        }
        else if (language.equals("French")) {
            greeting = "Bonjour";
        }
        else if (language.equals("Italian")) {
            greeting = "Bonjourno";
        }
        else if (language.equals("Spanish")) {
            greeting = "Hola";
        }
        else if (language.equals("German")) {
            greeting = "Hallo";
        }
        else if (language.equals("Chinese")){
            greeting = "Ni Hao";
        }
        else if (language.equals("Russian")){
            greeting = "Privyet";
        }

        return greeting + " " + name;
    }

}

