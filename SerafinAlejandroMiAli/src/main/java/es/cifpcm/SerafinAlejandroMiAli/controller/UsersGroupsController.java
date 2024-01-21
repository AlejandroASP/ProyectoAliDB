package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.UsersGroupsService;

import es.cifpcm.SerafinAlejandroMiAli.model.UsersGroups;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/usersGroups")
public class UsersGroupsController {

    @Autowired
    private UsersGroupsService usersGroupsService;

    @PostMapping
    public String save(@Valid @RequestBody UsersGroups vO) {
        return usersGroupsService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") String id) {
        usersGroupsService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") String id,
                       @Valid @RequestBody UsersGroups vO) {
        usersGroupsService.update(id, vO);
    }

    @GetMapping("/{id}")
    public UsersGroups getById(@Valid @NotNull @PathVariable("id") String id) {
        return usersGroupsService.getById(id);
    }

    @GetMapping
    public Page<UsersGroups> query(@Valid UsersGroups vO) {
        return usersGroupsService.query(vO);
    }
}
