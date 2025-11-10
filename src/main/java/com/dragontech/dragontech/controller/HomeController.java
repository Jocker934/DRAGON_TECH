package com.dragontech.dragontech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/nosotros")
    public String nosotros() {
        return "nosotros";
    }
    
    @GetMapping("/servicios")
    public String servicios() {
        return "servicios";
    }

    @GetMapping("/proyectos")
    public String proyectos() {
        return "proyectos";
    }

    @GetMapping("/clientes")
    public String clientes() {
        return "clientes";
    }

    @GetMapping("/blog")
    public String blog() {
        return "blog";
    }

    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }

   
    
}
