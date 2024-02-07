package es.cifpcm.SerafinAlejandroMiAli.data.repositories;

import es.cifpcm.SerafinAlejandroMiAli.model.Groups;
import es.cifpcm.SerafinAlejandroMiAli.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer>, JpaSpecificationExecutor<Users> {
//    @Query("SELECT u FROM Users u WHERE u.userName = :username")
//    Optional<Users> findByUserName(@Param("username") String username);
//    @Query("SELECT g FROM Groups g JOIN USER_GROUPS ug ON g.groupId = ug.groupId WHERE ug.userName = :username")
//    List<Groups> findGroupsByUsername(@Param("username") String username);
}