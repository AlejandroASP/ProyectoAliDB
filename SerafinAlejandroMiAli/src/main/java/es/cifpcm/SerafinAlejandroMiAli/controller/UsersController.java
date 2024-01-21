package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.UsersService;
import es.cifpcm.SerafinAlejandroMiAli.model.Users;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping
    public String save(@Valid @RequestBody Users vO) {
        return usersService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        usersService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Users vO) {
        usersService.update(id, vO);
    }

    @GetMapping("/{id}")
    public Users getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return usersService.getById(id);
    }

    @GetMapping
    public Page<Users> query(@Valid Users vO) {
        return usersService.query(vO);
    }
}
