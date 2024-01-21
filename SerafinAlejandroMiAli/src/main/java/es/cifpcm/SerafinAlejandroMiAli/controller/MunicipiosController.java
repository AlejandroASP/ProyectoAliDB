package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.MunicipiosService;

import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/municipios")
public class MunicipiosController {

    @Autowired
    private MunicipiosService municipiosService;

    @PostMapping
    public String save(@Valid @RequestBody Municipios vO) {
        return municipiosService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        municipiosService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Municipios vO) {
        municipiosService.update(id, vO);
    }

    @GetMapping("/{id}")
    public Municipios getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return municipiosService.getById(id);
    }

    @GetMapping
    public Page<Municipios> query(@Valid Municipios vO) {
        return municipiosService.query(vO);
    }
}
