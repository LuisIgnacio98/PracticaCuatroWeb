package edu.pucmm.practica2.servicios;

import edu.pucmm.practica2.encapsulaciones.Carrito;
import edu.pucmm.practica2.encapsulaciones.VentaProducto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class VentaProductoService extends GestionDB<VentaProducto>{
    private static VentaProductoService instance;

    private VentaProductoService() {
        super(VentaProducto.class);
    }

    public static VentaProductoService getInstance(){
        if (instance == null){
            instance = new VentaProductoService();
        }

        return instance;
    }

    public List<VentaProducto> consultaNativa() {
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from ventaProducto ", VentaProducto.class);
        List<VentaProducto> lista = query.getResultList();
        return lista;
    }

    public Carrito find(Integer id) {
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from carrito where id = :id", Carrito.class);
        List<Carrito> lista = query.getResultList();
        if (lista.size() > 0)
            return lista.get(0);
        else
            return null;
    }

}
