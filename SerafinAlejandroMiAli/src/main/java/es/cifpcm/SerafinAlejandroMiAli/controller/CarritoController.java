package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.ProductofferRepository;
import es.cifpcm.SerafinAlejandroMiAli.data.services.MunicipiosService;
import es.cifpcm.SerafinAlejandroMiAli.model.Carrito;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;
import es.cifpcm.SerafinAlejandroMiAli.model.Provincias;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarritoController {

    @Autowired
    private Carrito carrito;

    @Autowired
    private ProductofferRepository productofferRepository;
    @Autowired
    private MunicipiosService municipiosService;

    @GetMapping("/verCarrito")
    public String verCarrito(Model model, HttpSession session) {
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }
        model.addAttribute("productosEnCarrito", carrito.getProductos());
        return "verCarrito";
    }

    @PostMapping("/agregar-al-carrito")
    public String agregarAlCarrito(@RequestParam("idProducto") Long idProducto, RedirectAttributes redirectAttributes, HttpSession session) {
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }
        Productoffer producto = productofferRepository.findById(Math.toIntExact(idProducto)).orElse(null);
        if (producto != null) {
            carrito.agregarProducto(producto);
        }
        List<Provincias> provincias = municipiosService.getAllProvincias();
        redirectAttributes.addFlashAttribute("provincias", provincias);
        return "redirect:/order/pedido";
    }
}

