package edu.pucmm.practica2.servicios;

import edu.pucmm.practica2.Main;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class GestionDB<T> {
    private static EntityManagerFactory emf;
    private Class<T> claseEntidad;

    public GestionDB(Class<T> claseEntidad) {
        if(emf == null) {
                emf = Persistence.createEntityManagerFactory("MiUnidadPersistencia");
        }
        this.claseEntidad = claseEntidad;
    }

    public EntityManager getEntityManager(){
        return emf.createEntityManager();
    }

        //aplicando la clase de reflexión.
        private Object getValorCampo(T entidad){
            if(entidad == null){
                return null;
            }
            //aplicando la clase de reflexión.
            for(Field f : entidad.getClass().getDeclaredFields()) {  //tomando todos los campos privados.
                if (f.isAnnotationPresent(Id.class)) { //preguntando por la anotación ID.
                    try {
                        f.setAccessible(true);
                        Object valorCampo = f.get(entidad);

                        System.out.println("Nombre del campo: "+f.getName());
                        System.out.println("Tipo del campo: "+f.getType().getName());
                        System.out.println("Valor del campo: "+valorCampo );

                        return valorCampo;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            return null;
        }


    public T crear(T entidad) throws IllegalArgumentException, EntityExistsException, PersistenceException{
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidad);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return entidad;
    }

    public T editar(T entidad) throws PersistenceException{
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            em.merge(entidad);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return entidad;
    }

    public boolean eliminar(Object entidadId) throws PersistenceException{
        boolean ok = false;
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        try {
            T entidad = em.find(claseEntidad, entidadId);
            em.remove(entidad);
            em.getTransaction().commit();
            ok = true;
        }finally {
            em.close();
        }
        return ok;
    }

    public List<T> findAll() throws PersistenceException {
        EntityManager em = getEntityManager();
        try{
            CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(claseEntidad);
            criteriaQuery.select(criteriaQuery.from(claseEntidad));
            return em.createQuery(criteriaQuery).getResultList();
        } finally {
            em.close();
        }
    }

}
