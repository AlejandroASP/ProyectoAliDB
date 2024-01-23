package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.MunicipiosService;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProvinciasService;
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
//    @GetMapping("/crear")
//    public String mostrarFormulario(Model model) {
//        List<Provincias> provincias = municipiosService.getAllProvincias(); // Obtener provincias desde el servicio
//        model.addAttribute("provincias", provincias);
//        model.addAttribute("product", new Productoffer()); // Instancia de tu clase de producto
//        return "create";
//    }
//
//    @PostMapping("/crear")
//    public String crearProducto(@ModelAttribute("product") @Valid Productoffer product, BindingResult result,
//                                @RequestParam("idProvincia") int idProvincia,
//                                @RequestParam("idMunicipio") int idMunicipio, Model model) {
//        if (result.hasErrors()) {
//            // Manejar errores de validación
//            return "create";
//        }
//
//        // Setear el ID de provincia y municipio en el producto
//        product.setProvincia(idProvincia);
//        product.setIdMunicipio(idMunicipio);
//
//        // Guardar el producto en la base de datos
//        productService.save(product);
//
//        // Redirigir a la página de éxito o a donde desees
//        return "redirect:/producto/exito";
//    }
}