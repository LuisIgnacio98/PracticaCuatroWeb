package edu.pucmm.practica2.Controladora;

import edu.pucmm.practica2.encapsulaciones.Producto;

import java.util.ArrayList;

public class CarritoControladora {
    public static CarritoControladora instance;
    private ArrayList<Producto> productos;

    private CarritoControladora() {
        super();
        this.productos = new ArrayList<>();
    }

    public static CarritoControladora getInstance(){
        if (instance == null){
            instance = new CarritoControladora();
        }
        return instance;
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

}
