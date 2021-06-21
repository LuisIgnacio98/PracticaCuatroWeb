package edu.pucmm.practica2.encapsulaciones;

import edu.pucmm.practica2.servicios.CarritoService;


import java.util.concurrent.atomic.AtomicInteger;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "producto")
public class Producto implements Serializable{

    private static final AtomicInteger count = new AtomicInteger(-1);
    @Id
    private Integer id;
    private String nombre;
    @Column(name = "Precio_Producto")
    private Double precio;

   @ManyToOne()
   private Carrito carrito;
   @ManyToOne()
   private VentaProducto venta;

    public Producto() {

    }

    public Producto(String nombre , Double precio){
        this.setId(count.incrementAndGet());
        this.setNombre(nombre);
        this.setPrecio(precio);
    }

    public Producto(Integer id ,String nombre , Double precio){
        this.setId(id);
        this.setNombre(nombre);
        this.setPrecio(precio);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Carrito getCarrito() {
        return carrito;
    }
    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
