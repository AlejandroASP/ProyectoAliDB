package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.PedidosService;

import es.cifpcm.SerafinAlejandroMiAli.model.Carrito;
import es.cifpcm.SerafinAlejandroMiAli.model.Pedidos;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Validated
@Controller
@RequestMapping("/pedidos")
public class PedidosController {

    @Autowired
    private PedidosService pedidosService;

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
//    @PostMapping("/nuevoPedido")
//    public String nuevoPedido(@RequestParam("usuario") String usuario,
//                              @ModelAttribute("carrito") Carrito carrito,
//                              Model model) {
//        // Crea un nuevo pedido
//        Pedidos nuevoPedido = new Pedidos();
//        nuevoPedido.setUserName(usuario);
//        nuevoPedido.setFechaPedido(new Date());  // Puedes usar java.util.Date o java.sql.Date según tu entidad Pedidos
//
//
//        // Guarda el nuevo pedido
//        pedidosService.save(nuevoPedido);
//
//        // Limpia el carrito después de realizar el pedido
//        carrito.getProductos().clear();
//
//        // Redirige a la vista de verCarrito o a donde desees
//        return "redirect:/verCarrito";
//    }
}
