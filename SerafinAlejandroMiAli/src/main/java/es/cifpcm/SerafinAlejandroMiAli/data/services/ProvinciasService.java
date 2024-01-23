package es.cifpcm.SerafinAlejandroMiAli.data.services;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.ProvinciasRepository;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import es.cifpcm.SerafinAlejandroMiAli.model.Provincias;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProvinciasService {

    @Autowired
    private ProvinciasRepository provinciasRepository;


    public Integer save(@Valid Provincias vO) {
        Provincias bean = new Provincias();
        BeanUtils.copyProperties(vO, bean);
        bean = provinciasRepository.save(bean);
        return bean.getIdProvincia();
    }

    public void delete(Integer id) {
        provinciasRepository.deleteById(id);
    }

    public void update(Integer id, @Valid Provincias vO) {
        Provincias bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        provinciasRepository.save(bean);
    }

    public Provincias getById(Integer id) {
        Provincias original = requireOne(id);
        return toDTO(original);
    }

    public Page<Provincias> query(@Valid Provincias vO) {
        throw new UnsupportedOperationException();
    }

    private Provincias toDTO(Provincias original) {
        Provincias bean = new Provincias();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Provincias requireOne(Integer id) {
        return provinciasRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
    public List<Provincias> obtenerProvincias() {return provinciasRepository.findAll();}
}
