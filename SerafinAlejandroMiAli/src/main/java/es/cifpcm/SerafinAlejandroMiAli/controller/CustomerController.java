package es.cifpcm.SerafinAlejandroMiAli.controller;

import es.cifpcm.SerafinAlejandroMiAli.data.services.CustomerService;

import es.cifpcm.SerafinAlejandroMiAli.model.Customer;
import jakarta.validation.Valid;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public String save(@Valid @RequestBody Customer vO) {
        return customerService.save(vO).toString();
    }

    @DeleteMapping("/{id}")
    public void delete(@Valid @NotNull @PathVariable("id") Integer id) {
        customerService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@Valid @NotNull @PathVariable("id") Integer id,
                       @Valid @RequestBody Customer vO) {
        customerService.update(id, vO);
    }

    @GetMapping("/{id}")
    public Customer getById(@Valid @NotNull @PathVariable("id") Integer id) {
        return customerService.getById(id);
    }

    @GetMapping
    public Page<Customer> query(@Valid Customer vO) {
        return customerService.query(vO);
    }
}
