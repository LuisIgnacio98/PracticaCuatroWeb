package edu.pucmm.practica2.encapsulaciones;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table()
public class Carrito implements Serializable {

    private static final AtomicInteger count = new AtomicInteger(0);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Integer id;

   @OneToMany()
   private  Set<Producto> productos;



    public Carrito() {

    }

    public Carrito(Set<Producto> productos) {
        this.setProductos(productos);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }
}
