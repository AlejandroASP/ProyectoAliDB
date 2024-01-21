package es.cifpcm.SerafinAlejandroMiAli.data.services;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.UsersGroupsRepository;
import es.cifpcm.SerafinAlejandroMiAli.model.UsersGroups;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsersGroupsService {

    @Autowired
    private UsersGroupsRepository usersGroupsRepository;

    public Integer save(@Valid UsersGroups vO) {
        UsersGroups bean = new UsersGroups();
        BeanUtils.copyProperties(vO, bean);
        bean = usersGroupsRepository.save(bean);
        return bean.getGroupId();
    }

    public void delete(String id) {
        usersGroupsRepository.deleteById(id);
    }

    public void update(String id, @Valid UsersGroups vO) {
        UsersGroups bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        usersGroupsRepository.save(bean);
    }

    public UsersGroups getById(String id) {
        UsersGroups original = requireOne(id);
        return toDTO(original);
    }

    public Page<UsersGroups> query(@Valid UsersGroups vO) {
        throw new UnsupportedOperationException();
    }

    private UsersGroups toDTO(UsersGroups original) {
        UsersGroups bean = new UsersGroups();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private UsersGroups requireOne(String id) {
        return usersGroupsRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
