package es.cifpcm.SerafinAlejandroMiAli.data.repositories;

import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MunicipiosRepository extends JpaRepository<Municipios, Integer>, JpaSpecificationExecutor<Municipios> {

    @Query("SELECT m FROM Municipios m WHERE m.idProvincia = :idProvincia")
    List<Municipios> findByProvinciaId(@Param("idProvincia") int idProvincia);

}
