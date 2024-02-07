package es.cifpcm.SerafinAlejandroMiAli.data.services;

import es.cifpcm.SerafinAlejandroMiAli.data.repositories.UsersRepository;
import es.cifpcm.SerafinAlejandroMiAli.model.Users;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UsersService{

    @Autowired
    private UsersRepository usersRepository;

    public Integer save(@Valid Users vO) {
        Users bean = new Users();
        BeanUtils.copyProperties(vO, bean);
        bean = usersRepository.save(bean);
        return bean.getUserId();
    }

    public void delete(Integer id) {
        usersRepository.deleteById(id);
    }

    public void update(Integer id, @Valid Users vO) {
        Users bean = requireOne(id);
        BeanUtils.copyProperties(vO, bean);
        usersRepository.save(bean);
    }

    public Users getById(Integer id) {
        Users original = requireOne(id);
        return toDTO(original);
    }

    public Page<Users> query(@Valid Users vO) {
        throw new UnsupportedOperationException();
    }

    private Users toDTO(Users original) {
        Users bean = new Users();
        BeanUtils.copyProperties(original, bean);
        return bean;
    }

    private Users requireOne(Integer id) {
        return usersRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Resource not found: " + id));
    }
}
