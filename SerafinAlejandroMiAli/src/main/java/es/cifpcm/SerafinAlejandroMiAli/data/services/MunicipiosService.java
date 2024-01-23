package es.cifpcm.SerafinAlejandroMiAli.data.services;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.MunicipiosRepository;
import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MunicipiosService {

    @Autowired
    private MunicipiosRepository municipiosRepository;

    public Integer save(@Valid Municipios vO) {
        Municipios bean = new Municipios();
        BeanUtils.copyProperties(vO, bean);
        bean = municipiosRepository.save(bean);
        return bean.getIdMunicipio();
    }

    public void delete(Integer id) {
        municipiosRepository.deleteById(id);
    }

    public void update(Integer id, @Valid Municipios vO) {
        Municipios bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        municipiosRepository.save(bean);
    }

    public Municipios getById(Integer id) {
        Municipios original = requireOne(id);
        return toDTO(original);
    }

    public Page<Municipios> query(@Valid Municipios vO) {
        throw new UnsupportedOperationException();
    }

    private Municipios toDTO(Municipios original) {
        Municipios bean = new Municipios();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Municipios requireOne(Integer id) {
        return municipiosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }

//    public List<Municipios> findByProvinciaId(int provinciaId) {
//    }
}
