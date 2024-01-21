package es.cifpcm.SerafinAlejandroMiAli.data.repositories;

import es.cifpcm.SerafinAlejandroMiAli.model.UsersGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UsersGroupsRepository extends JpaRepository<UsersGroups, String>, JpaSpecificationExecutor<UsersGroups> {

}