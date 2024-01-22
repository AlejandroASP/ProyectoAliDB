package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductofferService productService;

    @GetMapping("/producto")
    public String getProductos(Model model) {
        List<Productoffer> productos = productService.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }
}

