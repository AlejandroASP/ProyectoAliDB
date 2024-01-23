package es.cifpcm.SerafinAlejandroMiAli.data.services;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.ProductofferRepository;
import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductofferService {

    @Autowired
    private ProductofferRepository productofferRepository;

    public Integer save(@Valid Productoffer vO) {
        Productoffer bean = new Productoffer();
        BeanUtils.copyProperties(vO, bean);
        bean = productofferRepository.save(bean);
        return bean.getProductId();
    }

    public void delete(Integer id) {
        productofferRepository.deleteById(id);
    }

    public void update(Integer id, @Valid Productoffer vO) {
        Productoffer bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        productofferRepository.save(bean);
    }

    public Productoffer getById(Integer id) {
        Productoffer original = requireOne(id);
        return toDTO(original);
    }

    public Page<Productoffer> query(@Valid Productoffer vO) {
        throw new UnsupportedOperationException();
    }

    private Productoffer toDTO(Productoffer original) {
        Productoffer bean = new Productoffer();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Productoffer requireOne(Integer id) {
        return productofferRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

    public List<Productoffer> findAll() {
        return productofferRepository.findAll();
    }

    public Productoffer findById(int id) {
        return productofferRepository.findById(id).orElse(null);
    }

}
