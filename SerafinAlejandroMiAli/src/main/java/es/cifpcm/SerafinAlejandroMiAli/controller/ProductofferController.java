package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.MunicipiosService;
import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;


import es.cifpcm.SerafinAlejandroMiAli.model.Carrito;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@Controller
@RequestMapping("/productoffer")
public class ProductofferController {

    @Autowired
    private ProductofferService productofferService;
    @Autowired
    private MunicipiosService municipiosService;

    @PostMapping
    public String save(@Valid @RequestBody Productoffer vO) {
        return productofferService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        productofferService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Productoffer vO) {
        productofferService.update(id, vO);
    }

    @GetMapping("/{id}")
    public Productoffer getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return productofferService.getById(id);
    }

    @GetMapping
    public Page<Productoffer> query(@Valid Productoffer vO) {
        return productofferService.query(vO);
    }
    @GetMapping("/filtrarPorMunicipio")
    public String filtrarPorMunicipio(@RequestParam("idMunicipio") String idMunicipio, Model model) {
        int municipioId = Integer.parseInt(idMunicipio);
        List<Productoffer> productos = productofferService.getProductosByMunicipio(municipioId);
        model.addAttribute("productos", productos);
        model.addAttribute("provincias", municipiosService.getAllProvincias());
        return "order/pedido";
    }
    @GetMapping("/añadirAlCarrito/{productId}")
    public String añadirAlCarrito(@PathVariable("productId") int productId,
                                  @ModelAttribute("carrito") Carrito carrito,
                                  Model model) {
        Productoffer producto = productofferService.findById(productId);
        carrito.agregarProducto(producto);
        model.addAttribute("carrito", carrito);
        return "redirect:/verCarrito";
    }

    @GetMapping("/verCarrito")
    public String verCarrito(@ModelAttribute("carrito") Carrito carrito,
                             Model model) {
        List<Productoffer> productosEnCarrito = carrito.getProductos();
        model.addAttribute("productosEnCarrito", productosEnCarrito);
        return "verCarrito";
    }
}
