package edu.pucmm.practica2.Controladora;

import edu.pucmm.practica2.encapsulaciones.Producto;
import edu.pucmm.practica2.encapsulaciones.VentaProducto;

import java.util.ArrayList;

public class VentaProductoControladora {
    public static  VentaProductoControladora instance;
    private ArrayList<Producto> productos;
    private ArrayList<VentaProducto> ventas;

    private VentaProductoControladora(){
        super();
        this.productos = new ArrayList<>();
        this.ventas = new ArrayList<>();
    }

    public static VentaProductoControladora getInstance(){
        if(instance == null){
            instance = new VentaProductoControladora();
        }
        return instance;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public ArrayList<VentaProducto> getVentas() {
        return ventas;
    }

    public void setVentas(ArrayList<VentaProducto> ventas) {
        this.ventas = ventas;
    }
}
