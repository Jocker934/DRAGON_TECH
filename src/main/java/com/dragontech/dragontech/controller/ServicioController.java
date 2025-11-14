package com.dragontech.dragontech.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dragontech.dragontech.service.ServicioService;

@Controller
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping("/servicios")
    public String servicios(Model model) {
        model.addAttribute("title", "Servicios - DRAGON TECH");
        model.addAttribute("servicios", servicioService.obtenerActivos());
        return "servicios";
    }

    @GetMapping("/servicios/{slug}")
    public String detalleServicio(@PathVariable String slug, Model model) {
        var servicioOpt = servicioService.buscarPorSlug(slug);

        if (servicioOpt.isEmpty()) {
            return "redirect:/servicios";
        }

        var servicio = servicioOpt.get();
        model.addAttribute("title", servicio.getNombre() + " - DRAGON TECH");
        model.addAttribute("servicio", servicio);
        return "servicio-detalle";
    }
}


