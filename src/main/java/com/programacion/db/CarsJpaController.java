/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.db;

import com.programacion.JPA.exceptions.NonexistentEntityException;
import com.programacion.db.Cars;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Daniel Noriega
 */
public class CarsJpaController implements Serializable {

    public CarsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cars cars) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cars);
            em.getTransaction().commit();
            System.out.println("Carro agregado de forma exitosa!");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cars cars) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cars = em.merge(cars);
            em.getTransaction().commit();
            System.out.println("Los registros del carro se actualizaron con exito!");
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = cars.getId();
                if (findCars(id) == null) {
                    throw new NonexistentEntityException("El carro con ID " + id + " no existe dentro de los registros del sistema.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(BigDecimal id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cars cars;
            try {
                cars = em.getReference(Cars.class, id);
                cars.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El carro con el ID" + id + " no existe dentro de los registros del sistema.", enfe);
            }
            em.remove(cars);
            em.getTransaction().commit();
            System.out.println("Carro eliminado");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cars> findCarsEntities() {
        return findCarsEntities(true, -1, -1);
    }

    public List<Cars> findCarsEntities(int maxResults, int firstResult) {
        return findCarsEntities(false, maxResults, firstResult);
    }

    private List<Cars> findCarsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cars.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cars findCars(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cars.class, id);
        } finally {
            em.close();
        }
    }

    public int getCarsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cars> rt = cq.from(Cars.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
