package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    //changed to interact with hello form to reference greeting variable in template
    //model.addattrib(First is name on hello.html, second is string above)
    //need to add Model to parameter list to use model.addAttrib
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }
    @GetMapping("form")
    public String helloForm(){
        return "form";
//returning form.html - just returning name of template
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Bingo");
        names.add("Bongo");
        names.add("Bango");
        model.addAttribute("names", names);
        return "hello-list";
    }

}

