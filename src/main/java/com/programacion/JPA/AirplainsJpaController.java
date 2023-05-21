/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.JPA;

import com.programacion.JPA.exceptions.NonexistentEntityException;
import com.programacion.db.Airplains;
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
 * @author alumno
 */
public class AirplainsJpaController implements Serializable {

    public AirplainsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Airplains airplains) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(airplains);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Airplains airplains) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            airplains = em.merge(airplains);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                BigDecimal id = airplains.getId();
                if (findAirplains(id) == null) {
                    throw new NonexistentEntityException("The airplains with id " + id + " no longer exists.");
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
            Airplains airplains;
            try {
                airplains = em.getReference(Airplains.class, id);
                airplains.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The airplains with id " + id + " no longer exists.", enfe);
            }
            em.remove(airplains);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Airplains> findAirplainsEntities() {
        return findAirplainsEntities(true, -1, -1);
    }

    public List<Airplains> findAirplainsEntities(int maxResults, int firstResult) {
        return findAirplainsEntities(false, maxResults, firstResult);
    }

    private List<Airplains> findAirplainsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Airplains.class));
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

    public Airplains findAirplains(BigDecimal id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Airplains.class, id);
        } finally {
            em.close();
        }
    }

    public int getAirplainsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Airplains> rt = cq.from(Airplains.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
