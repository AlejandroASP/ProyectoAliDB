package es.cifpcm.SerafinAlejandroMiAli.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "productoffer")
public class Productoffer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_price")
    private Float productPrice;

    @Column(name = "product_picture")
    private String productPicture;

    @Column(name = "id_municipio", nullable = false)
    private Integer idMunicipio;
    @Column(name = "id_provincia", nullable = false)
    private Integer idProvincia;
    @Column(name = "product_stock", nullable = false)
    private Integer productStock;

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }
//    public void setProvincia(Integer idProvincia) {
//        this.idProvincia = idProvincia;
//    }
//
//    public Integer getProvincia() {
//        return idProvincia;
//    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getProductStock() {
        return productStock;
    }

    @Override
    public String toString() {
        return "Productoffer{" +
                "productId=" + productId + '\'' +
                "productName=" + productName + '\'' +
                "productPrice=" + productPrice + '\'' +
                "productPicture=" + productPicture + '\'' +
                "idMunicipio=" + idMunicipio + '\'' +
                "productStock=" + productStock + '\'' +
                '}';
    }

}
