package es.cifpcm.SerafinAlejandroMiAli.data.repositories;

import es.cifpcm.SerafinAlejandroMiAli.model.Municipios;
import es.cifpcm.SerafinAlejandroMiAli.model.Productoffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductofferRepository extends JpaRepository<Productoffer, Integer>, JpaSpecificationExecutor<Productoffer> {
    @Query("SELECT p FROM Productoffer p WHERE p.idMunicipio = :idMunicipio")
    List<Productoffer> findProductosByMunicipio(@Param("idMunicipio") int idMunicipio);
}