package es.cifpcm.SerafinAlejandroMiAli.data.repositories;

import es.cifpcm.SerafinAlejandroMiAli.model.Groups;
import es.cifpcm.SerafinAlejandroMiAli.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {

}