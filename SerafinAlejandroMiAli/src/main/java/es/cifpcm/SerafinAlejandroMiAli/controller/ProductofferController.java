package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.ProductofferService;


import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/productoffer")
public class ProductofferController {

    @Autowired
    private ProductofferService productofferService;

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
}
