package es.cifpcm.SerafinAlejandroMiAli.data.repositories;

import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductofferRepository extends JpaRepository<Productoffer, Integer>, JpaSpecificationExecutor<Productoffer> {

    List<Productoffer> findByMunicipioIn(List<Municipios> municipios);
}