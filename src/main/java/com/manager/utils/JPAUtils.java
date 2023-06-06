/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manager.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Noriega UMG
 */
public class JPAUtils {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("daniel_denc"); // viene de la opcion de xml

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
}
