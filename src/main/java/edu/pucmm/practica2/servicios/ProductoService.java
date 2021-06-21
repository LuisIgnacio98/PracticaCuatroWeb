package edu.pucmm.practica2.servicios;

import edu.pucmm.practica2.encapsulaciones.Producto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Set;

public class ProductoService extends  GestionDB<Producto>{
    private static ProductoService instance;

    private ProductoService() { super(Producto.class);}

    public static ProductoService getInstance(){
        if(instance == null){
            instance = new ProductoService();
        }
        return instance;
    }

    public List<Producto> consultaNativa(){
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from producto ", Producto.class);
        List<Producto> lista = query.getResultList();
        return lista;
    }

    public Producto findProduct(Integer id){
        EntityManager em = getEntityManager();
        Query query = em.createNativeQuery("select * from producto where id = :id", Producto.class);
        query.setParameter("id", id);
        List<Producto> lista = query.getResultList();
        if (lista.size() > 0)
            return lista.get(0);
        else
            return null;
    }

}
