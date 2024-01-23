package es.cifpcm.SerafinAlejandroMiAli.data.repositories;

import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MunicipiosRepository extends JpaRepository<Municipios, Integer>, JpaSpecificationExecutor<Municipios> {

}