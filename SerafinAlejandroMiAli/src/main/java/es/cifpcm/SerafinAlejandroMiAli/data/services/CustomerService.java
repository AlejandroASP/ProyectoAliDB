package es.cifpcm.SerafinAlejandroMiAli.data.services;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.CustomerRepository;
import es.cifpcm.SerafinAlejandroMiAli.model.Customer;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Integer save(@Valid Customer vO) {
        Customer bean = new Customer();
        BeanUtils.copyProperties(vO, bean);
        bean = customerRepository.save(bean);
        return bean.getCustomerId();
    }

    public void delete(Integer id) {
        customerRepository.deleteById(id);
    }

    public void update(Integer id, @Valid Customer vO) {
        Customer bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        customerRepository.save(bean);
    }

    public Customer getById(Integer id) {
        Customer original = requireOne(id);
        return toDTO(original);
    }

    public Page<Customer> query(Customer vO) {
        throw new UnsupportedOperationException();
    }

    private Customer toDTO(Customer original) {
        Customer bean = new Customer();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Customer requireOne(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
