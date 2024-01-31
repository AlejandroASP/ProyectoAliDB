package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.MunicipiosService;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProvinciasService;
import es.cifpcm.SerafinAlejandroMiAli.model.Carrito;
import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;
import es.cifpcm.SerafinAlejandroMiAli.model.Provincias;
import jakarta.servlet.http.HttpSession;
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
    private ProductofferService productofferService;

    @GetMapping("/producto")
    public String getProductos(Model model) {
        List<Productoffer> productos = productofferService.findAll();
        model.addAttribute("productos", productos);
        return "producto";
    }

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    @PostMapping("/producto/create")
    public String createProduct(@ModelAttribute("product") Productoffer product, HttpSession session) {
        Integer municipioId = (Integer) session.getAttribute("selectedMunicipioId");
        if (municipioId != null) {
            product.setIdMunicipio(municipioId);
            Integer provinciaId = municipiosService.getProvinciaByMunicipio(municipioId);
            product.setProvincia(provinciaId);
        }
        productofferService.save(product);
        return "redirect:/producto";
    }

}