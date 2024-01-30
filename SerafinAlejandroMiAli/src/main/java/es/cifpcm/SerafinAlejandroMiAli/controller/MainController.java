package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProvinciasService;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import es.cifpcm.SerafinAlejandroMiAli.model.Provincias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    private ProvinciasService provinciasService;
    private ProductofferService productofferService;

    @Autowired
    public MainController(ProvinciasService provinciasService) {
        this.provinciasService = provinciasService;
    }
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
    @GetMapping("/redirectToCreate")
    public String redirectToCreate(Model model) {
        model.addAttribute("product", new Productoffer());
        List<Provincias> provincias = provinciasService.obtenerProvincias();
        model.addAttribute("provincias", provincias);
        return "create";
    }

}
