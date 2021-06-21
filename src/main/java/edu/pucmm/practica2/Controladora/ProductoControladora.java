package edu.pucmm.practica2.Controladora;
import edu.pucmm.practica2.encapsulaciones.Producto;

import java.util.ArrayList;

public class ProductoControladora {
    public static ProductoControladora instance;
    private ArrayList<Producto> productos;

    private ProductoControladora() {
        super();
        this.productos = new ArrayList<>();
    }

    public static ProductoControladora getInstance() {
        if(instance == null){
            instance = new ProductoControladora();

        }
        return instance;
    }

    public ArrayList<Producto> getProductos() {return  productos;}

    public void setProductos(ArrayList<Producto> productos) {this.productos = productos;}

    public Producto getProductoId(int id){
        return productos.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }
    public Producto actualizarProducto(Producto producto){
        if(producto == null){//no existe, no puede se actualizado
            System.out.println("No exixte");
        }
        //producto.mezclar(producto);
        return producto;
    }

}
