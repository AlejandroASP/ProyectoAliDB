package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.MunicipiosService;

import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import es.cifpcm.SerafinAlejandroMiAli.model.Provincias;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("/seleccionarProvincia")
    public String seleccionarProvincia(@RequestParam(name = "idProvincia", required = false, defaultValue = "-1") int idProvincia, Model model, @RequestParam(name = "vista", required = false, defaultValue = "order/pedido") String vista) {
        List<Provincias> provincias = municipiosService.getAllProvincias();
        model.addAttribute("provincias", provincias);
        model.addAttribute("provinciaId", idProvincia);
        String provinciaNombre = provincias.stream().filter(p -> p.getIdProvincia() == idProvincia).findFirst().map(Provincias::getNombre).orElse(null);
        model.addAttribute("provinciaNombre", provinciaNombre);
        List<Municipios> municipios = new ArrayList<>();
        if (idProvincia > 0) {
            municipios = municipiosService.obtenerMunicipiosPorProvincia(idProvincia);
        }
        model.addAttribute("municipios", municipios);
        if (vista.equals("create")) {
            model.addAttribute("product", new Productoffer());
            return "create";
        } else {
            return "order/pedido";
        }
    }

    @GetMapping("/cargarMunicipios")
    @ResponseBody
    public List<Municipios> getMunicipiosByProvincia(@RequestParam("idProvincia") int idProvincia) {
        return municipiosService.obtenerMunicipiosPorProvincia(idProvincia);
    }

}
