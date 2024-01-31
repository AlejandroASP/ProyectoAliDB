package es.cifpcm.SerafinAlejandroMiAli.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class Carrito {
    private List<Productoffer> productos;

    public Carrito() {
        this.productos = new ArrayList<>();
    }

    public List<Productoffer> getProductos() {
        return productos;
    }

    public void agregarProducto(Productoffer producto) {
        this.productos.add(producto);
    }
}
