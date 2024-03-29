package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.MunicipiosService;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProvinciasService;
import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;
import es.cifpcm.SerafinAlejandroMiAli.model.Provincias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProvinciasService provinciasService;
    private MunicipiosService municipiosService;
    @Autowired
    private ProductofferService productService;

    @GetMapping("/producto")
    public String getProductos(Model model) {
        List<Productoffer> productos = productService.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }
    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Productoffer());
        return "create";
    }

    @PostMapping("/producto/create")
    public String createProduct(@ModelAttribute("product") Productoffer product) {
        productService.save(product);
        return "redirect:/producto";
    }
    @PostMapping("/producto/delete")
    public String deleteProduct(@RequestParam("productId") int productId) {
        Productoffer product = productService.findById(productId);
        if (product != null) {
            productService.delete(product.getProductId());
            return "redirect:/producto";
        } else {
            // Aquí puedes manejar el caso en que el producto no se encuentra
            // Por ejemplo, podrías redirigir a una página de error personalizada
            return "redirect:/error";
        }
    }
//    @GetMapping("/provincia")
//    public String getProvincias(Model model) {
//        List<Provincias> provincias = provinciasService.findAll();
//        model.addAttribute("provincias", provincias);
//        return "provincia";
//    }

//    @GetMapping("/producto")
//    public String getProductos(@RequestParam("provinciaId") int provinciaId, Model model) {
//        List<Municipios> municipios = municipiosService.findByProvinciaId(provinciaId);
//        List<Productoffer> productos = productService.findByMunicipioIn(municipios);
//        model.addAttribute("productos", productos);
//        return "producto";
//    }

}