package es.cifpcm.SerafinAlejandroMiAli.data.services;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.PedidosRepository;
import es.cifpcm.SerafinAlejandroMiAli.model.Pedidos;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PedidosService {

    @Autowired
    private PedidosRepository pedidosRepository;

    public Integer save(@Valid Pedidos vO) {
        Pedidos bean = new Pedidos();
        BeanUtils.copyProperties(vO, bean);
        bean = pedidosRepository.save(bean);
        return bean.getIdPedido();
    }

    public void delete(Integer id) {
        pedidosRepository.deleteById(id);
    }

    public void update(Integer id, @Valid Pedidos vO) {
        Pedidos bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        pedidosRepository.save(bean);
    }

    public Pedidos getById(Integer id) {
        Pedidos original = requireOne(id);
        return toDTO(original);
    }

    public Page<Pedidos> query(@Valid Pedidos vO) {
        throw new UnsupportedOperationException();
    }

    private Pedidos toDTO(Pedidos original) {
        Pedidos bean = new Pedidos();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Pedidos requireOne(Integer id) {
        return pedidosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
