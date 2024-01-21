package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private Productoffer productOfferService;

    @GetMapping("/productlist")
    public String productList(Model model) {
        List<Productoffer> products = productOfferService.findAll();
        model.addAttribute("products", products);
        return "productlist";
    }
}
