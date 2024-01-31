package es.cifpcm.SerafinAlejandroMiAli.controller;

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

    private final Carrito carrito;
    private final ProductofferService productService;

    @Autowired
    public CarritoController(Carrito carrito, ProductofferService productService) {
        this.carrito = carrito;
        this.productService = productService;
    }
    @GetMapping("/verCarrito")
    public String verCarrito(Model model, HttpSession session) {
        // Obtener el carrito de la sesión del usuario
        Carrito carrito = (Carrito) session.getAttribute("carrito");

        // Pasar los productos en el carrito al modelo para mostrar en la vista del carrito
        model.addAttribute("productosEnCarrito", carrito.getProductos());

        // Mostrar la vista del carrito de compras
        return "carrito";
    }

}
