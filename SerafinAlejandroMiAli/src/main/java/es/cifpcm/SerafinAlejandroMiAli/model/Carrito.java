package es.cifpcm.SerafinAlejandroMiAli.model;

import java.util.ArrayList;
import java.util.List;

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
