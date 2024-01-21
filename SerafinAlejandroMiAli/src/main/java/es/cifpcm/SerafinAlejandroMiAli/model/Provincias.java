package es.cifpcm.SerafinAlejandroMiAli.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "provincias")
public class Provincias implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_provincia", nullable = false)
    private Integer idProvincia;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }

    public Integer getIdProvincia() {
        return idProvincia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Provincias{" +
                "idProvincia=" + idProvincia + '\'' +
                "nombre=" + nombre + '\'' +
                '}';
    }
}
