package edu.pucmm.practica2.encapsulaciones;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Entity
public class VentaProducto implements Serializable {
    private static final AtomicInteger count = new AtomicInteger(0);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Integer id;
    @Column(name = "Fecha_Compra")
    private String fechaCompra;
    @OneToMany()
    private Set<Producto> productosVenta;

    public VentaProducto(){

    }

    public VentaProducto(String fechaCompra, Set<Producto> productosVenta){
        this.setFechaCompra(fechaCompra);
        this.setProductosVenta(productosVenta);
    }

    public Set<Producto> getProductosVenta() {
        return productosVenta;
    }

    public void setProductosVenta(Set<Producto> productosVenta) {
        this.productosVenta = productosVenta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
