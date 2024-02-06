package es.cifpcm.SerafinAlejandroMiAli.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id_pedido", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPedido;

    @Column(name = "user_name", nullable = true) // Cambiar a true para permitir valores nulos
    private String userName;

    @Column(name = "precio_total", nullable = false)
    private BigDecimal precioTotal;

    @Column(name = "fecha_pedido", nullable = false)
    private Date fechaPedido;

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        this.precioTotal = precioTotal;
    }

    public BigDecimal getPrecioTotal() {
        return precioTotal;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    @Override
    public String toString() {
        return "Pedidos{" +
                "idPedido=" + idPedido + '\'' +
                "userName=" + userName + '\'' +
                "precioTotal=" + precioTotal + '\'' +
                "fechaPedido=" + fechaPedido + '\'' +
                '}';
    }
}
