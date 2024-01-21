package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.GroupsService;

import es.cifpcm.SerafinAlejandroMiAli.model.Groups;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/groups")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;

    @PostMapping
    public String save(@Valid @RequestBody Groups vO) {
        return groupsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        groupsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Groups vO) {
        groupsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public Groups getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return groupsService.getById(id);
    }

    @GetMapping
    public Page<Groups> query(@Valid Groups vO) {
        return groupsService.query(vO);
    }
}
