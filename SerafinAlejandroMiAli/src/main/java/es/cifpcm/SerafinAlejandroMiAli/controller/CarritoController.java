package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.ProductofferRepository;
import es.cifpcm.SerafinAlejandroMiAli.model.Carrito;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarritoController {

    @Autowired
    private Carrito carrito;

    @Autowired
    private ProductofferRepository productofferRepository;

    @GetMapping("/verCarrito")
    public String verCarrito(Model model) {
        model.addAttribute("productosEnCarrito", carrito.getProductos());
        return "verCarrito";
    }
    @PostMapping("/agregar-al-carrito")
    public String agregarAlCarrito(@RequestParam("idProducto") Long idProducto) {
        Productoffer producto = productofferRepository.findById(Math.toIntExact(idProducto)).orElse(null);
        if (producto != null) {
            carrito.agregarProducto(producto);
        }
        return "redirect:/order/pedido";
    }
}
