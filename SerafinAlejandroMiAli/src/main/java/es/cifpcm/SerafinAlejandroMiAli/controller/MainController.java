package es.cifpcm.SerafinAlejandroMiAli.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String inicio() {
        return "inicio";
    }
    @GetMapping("/usuario/create")
    public String usuario() {
        return "/usuario/create";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/order/pedido")
    public String order() {
        return "/order/pedido";
    }
}
