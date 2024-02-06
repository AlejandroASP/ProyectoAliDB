package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.ProductofferRepository;
import es.cifpcm.SerafinAlejandroMiAli.data.services.MunicipiosService;
import es.cifpcm.SerafinAlejandroMiAli.model.Carrito;
import es.cifpcm.SerafinAlejandroMiAli.model.Pedidos;
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
    private ProductofferService productofferService;
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
        model.addAttribute("pedido", new Pedidos()); // Agregar el objeto 'pedido' al modelo
        return "verCarrito";
    }


    @PostMapping("/agregar-al-carrito")
    public String agregarAlCarrito(@RequestParam("idProducto") Integer idProducto, RedirectAttributes redirectAttributes, HttpSession session) {
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito == null) {
            carrito = new Carrito();
            session.setAttribute("carrito", carrito);
        }

        Productoffer producto = productofferService.getById(idProducto);
        if (producto != null && producto.getProductStock() > 0) {
            // Reducir el stock del producto
            productofferService.reduceStock(idProducto, 1); // Reducir en 1 unidad

            // Agregar el producto al carrito
            carrito.agregarProducto(producto);

            // Obtener las provincias y agregarlas al modelo
            List<Provincias> provincias = municipiosService.getAllProvincias();
            redirectAttributes.addFlashAttribute("provincias", provincias);

            return "redirect:/order/pedido";
        } else {
            // Si el stock es 0, agregar mensaje de error y provincias al modelo
            redirectAttributes.addFlashAttribute("error", "El producto seleccionado no está disponible.");
            List<Provincias> provincias = municipiosService.getAllProvincias();
            redirectAttributes.addFlashAttribute("provincias", provincias);
            return "redirect:/order/pedido";
        }
    }

}

