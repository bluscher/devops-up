package com.luscherbernardo.up.devops.empleado;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//@RestController
@Controller
public class HelloController {

    @GetMapping("/")
    public String hello(){
        //return "Hello Devops / Universidad Palermo";
        return "hello";
    }

    @GetMapping("/message")
    public String message(Model model) {
        model.addAttribute("message", "Esto es una prueba >>  Hello World Devops #1");
        //return model.toString();
        return "message";
    }
}
