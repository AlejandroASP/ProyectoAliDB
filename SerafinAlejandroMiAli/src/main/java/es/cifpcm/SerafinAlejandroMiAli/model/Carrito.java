package es.cifpcm.SerafinAlejandroMiAli.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Carrito {
    private Map<Productoffer, Integer> productos;

    public Carrito() {
        this.productos = new HashMap<>();
    }

    public Map<Productoffer, Integer> getProductos() {
        return productos;
    }

    public void agregarProducto(Productoffer producto) {
        agregarProducto(producto, 1); // Por defecto, se agrega 1 unidad
    }

    public void agregarProducto(Productoffer producto, int cantidad) {
        if (productos.containsKey(producto)) {
            productos.put(producto, productos.get(producto) + cantidad); // Si ya está en el carrito, se incrementa la cantidad
        } else {
            productos.put(producto, cantidad); // Si no está en el carrito, se añade con la cantidad especificada
        }
    }

    public void limpiarCarrito() {
        productos.clear(); // Elimina todos los productos del carrito
    }

}
