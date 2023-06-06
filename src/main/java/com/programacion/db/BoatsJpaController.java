/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.db;

import com.programacion.JPA.exceptions.NonexistentEntityException;
import com.programacion.db.Boats;
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
public class BoatsJpaController implements Serializable {

    public BoatsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Boats boats) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(boats);
            em.getTransaction().commit();
            System.out.println("Balsa agregada de forma exitosa!");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Boats boats) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            boats = em.merge(boats);
            em.getTransaction().commit();
            System.out.println("Balsa actualizada con exito!");
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = boats.getId();
                if (findBoats(id) == null) {
                    throw new NonexistentEntityException("The boats with id " + id + " no longer exists.");
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
            Boats boats;
            try {
                boats = em.getReference(Boats.class, id);
                boats.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("La balsa con ID " + id + " no existe en los registros.", enfe);
            }
            em.remove(boats);
            em.getTransaction().commit();
            System.out.println("Balsa eliminada");
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Boats> findBoatsEntities() {
        return findBoatsEntities(true, -1, -1);
    }

    public List<Boats> findBoatsEntities(int maxResults, int firstResult) {
        return findBoatsEntities(false, maxResults, firstResult);
    }

    private List<Boats> findBoatsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Boats.class));
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

    public Boats findBoats(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Boats.class, id);
        } finally {
            em.close();
        }
    }

    public int getBoatsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Boats> rt = cq.from(Boats.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
