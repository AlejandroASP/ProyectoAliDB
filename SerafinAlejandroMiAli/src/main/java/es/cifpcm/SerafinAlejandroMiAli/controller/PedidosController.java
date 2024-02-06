package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.PedidosService;

import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;
import es.cifpcm.SerafinAlejandroMiAli.model.Carrito;
import es.cifpcm.SerafinAlejandroMiAli.model.Pedidos;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

@Validated
@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;
    private ProductofferService productOfferService;

    @PostMapping
    public String save(@Valid @RequestBody Pedidos vO) {
        return pedidosService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        pedidosService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Pedidos vO) {
        pedidosService.update(id, vO);
    }

    @GetMapping("/{id}")
    public Pedidos getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return pedidosService.getById(id);
    }

    @GetMapping
    public Page<Pedidos> query(@Valid Pedidos vO) {
        return pedidosService.query(vO);
    }
    @PostMapping("/realizar-pedido")
    public String realizarPedido(RedirectAttributes redirectAttributes, HttpSession session) {
        Carrito carrito = (Carrito) session.getAttribute("carrito");
        if (carrito != null && !carrito.getProductos().isEmpty()) {
            // Crear un nuevo pedido
            Pedidos pedido = new Pedidos();
            // Configurar los detalles del pedido, como el precio total y la fecha
            pedido.setPrecioTotal(calcularPrecioTotal(carrito));
            pedido.setFechaPedido(new Date());
            // Guardar el pedido en la base de datos
            pedidosService.save(pedido);
            // Limpiar el carrito después de realizar el pedido
            carrito.limpiarCarrito();
            session.setAttribute("carrito", carrito);
            // Agregar un mensaje de éxito como flash attribute
            redirectAttributes.addFlashAttribute("mensajeExito", "¡Pedido realizado con éxito!");
        } else {
            // Manejar el caso en que el carrito esté vacío
            redirectAttributes.addFlashAttribute("mensajeError", "No hay productos en el carrito para realizar pedidos.");
        }
        return "redirect:/verCarrito"; // Redirigir a la vista de vercarrito
    }

    // Método para calcular el precio total del carrito
    private BigDecimal calcularPrecioTotal(Carrito carrito) {
        BigDecimal precioTotal = BigDecimal.ZERO;
        for (Map.Entry<Productoffer, Integer> entry : carrito.getProductos().entrySet()) {
            precioTotal = precioTotal.add(BigDecimal.valueOf(entry.getKey().getProductPrice()).multiply(BigDecimal.valueOf(entry.getValue())));
        }
        return precioTotal;
    }

}