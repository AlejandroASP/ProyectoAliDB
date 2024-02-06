package es.cifpcm.SerafinAlejandroMiAli.data.services;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.GroupsRepository;
import es.cifpcm.SerafinAlejandroMiAli.model.Groups;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class GroupsService {

    @Autowired
    private GroupsRepository groupsRepository;

    public Integer save(@Valid Groups vO) {
        Groups bean = new Groups();
        BeanUtils.copyProperties(vO, bean);
        bean = groupsRepository.save(bean);
        return bean.getGroupId();
    }

    public void delete(Integer id) {
        groupsRepository.deleteById(id);
    }

    public void update(Integer id, @Valid Groups vO) {
        Groups bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        groupsRepository.save(bean);
    }

    public Groups getById(Integer id) {
        Groups original = requireOne(id);
        return toDTO(original);
    }

    public Page<Groups> query(@Valid Groups vO) {
        throw new UnsupportedOperationException();
    }

    private Groups toDTO(Groups original) {
        Groups bean = new Groups();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Groups requireOne(Integer id) {
        return groupsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
