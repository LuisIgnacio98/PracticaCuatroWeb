package edu.pucmm.practica2.servicios;

import edu.pucmm.practica2.encapsulaciones.Carrito;
import edu.pucmm.practica2.encapsulaciones.Producto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class CarritoService extends GestionDB<Carrito> {
    private static CarritoService instance;

    private CarritoService() {
        super(Carrito.class);
    }

    public static CarritoService getInstance() {
        if (instance == null) {
            instance = new CarritoService();
        }
        return instance;
    }

    public List<Carrito> consultaNativa() {
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from carrito ", Carrito.class);
        List<Carrito> lista = query.getResultList();
        return lista;
    }

    public List<Carrito> consultaNativaID(Integer id) {
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from carrito where id = :id ", Carrito.class);
        query.setParameter("id", id);
        List<Carrito> lista = query.getResultList();
        return lista;
    }

   /* public List<Producto> consultaProducto() {
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select productos from carrito", Carrito.class);
        List<Producto> lista = query.getResultList();
        return lista;
    }*/

    public Carrito find() {
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from carrito where id = 1", Carrito.class);
        List<Carrito> lista = query.getResultList();
        if (lista.size() > 0)
            return lista.get(0);
        else
            return null;
    }
}
