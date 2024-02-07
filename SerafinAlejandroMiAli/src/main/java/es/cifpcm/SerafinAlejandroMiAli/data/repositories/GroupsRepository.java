package es.cifpcm.SerafinAlejandroMiAli.data.repositories;

import es.cifpcm.SerafinAlejandroMiAli.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface GroupsRepository extends JpaRepository<Groups, Integer>, JpaSpecificationExecutor<Groups> {

    @Query("SELECT g FROM Groups g WHERE g.groupName = ?1")
    Groups findByGroupName(String groupName);
}