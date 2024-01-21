package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.ProvinciasService;


import es.cifpcm.SerafinAlejandroMiAli.model.Provincias;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/provincias")
public class ProvinciasController {

    @Autowired
    private ProvinciasService provinciasService;

    @PostMapping
    public String save(@Valid @RequestBody Provincias vO) {
        return provinciasService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        provinciasService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Provincias vO) {
        provinciasService.update(id, vO);
    }

    @GetMapping("/{id}")
    public Provincias getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return provinciasService.getById(id);
    }

    @GetMapping
    public Page<Provincias> query(@Valid Provincias vO) {
        return provinciasService.query(vO);
    }
}
