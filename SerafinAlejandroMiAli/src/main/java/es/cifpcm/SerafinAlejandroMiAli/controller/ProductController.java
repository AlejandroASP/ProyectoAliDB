package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.MunicipiosService;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProvinciasService;
import es.cifpcm.SerafinAlejandroMiAli.model.Carrito;
import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;
import es.cifpcm.SerafinAlejandroMiAli.model.Provincias;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProvinciasService provinciasService;
    @Autowired
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
        List<Provincias> provincias = provinciasService.obtenerProvincias();
        model.addAttribute("provincias", provincias);
        return "create";
    }

    @PostMapping("/producto/create")
    public String createProduct(@ModelAttribute("product") Productoffer product) {
        productService.save(product);
        return "redirect:/producto";
    }
    @GetMapping("/verCarrito")
    public String verCarrito(@ModelAttribute("carrito") Carrito carrito, Model model) {
        List<Productoffer> productosEnCarrito = carrito.getProductos();
        model.addAttribute("productosEnCarrito", productosEnCarrito);
        return "verCarrito";
    }

}