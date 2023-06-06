/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.programacion.db.AirplainsJpaController;
import com.programacion.db.BoatsJpaController;
import com.programacion.db.CarsJpaController;
import java.math.BigDecimal;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Noriega UMG
 */
public class Eliminar {

    public void eliminarCarro() {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        System.out.print("Digite el ID del carro: ");
        BigDecimal id = sc.nextBigDecimal();
        
        try{
            CarsJpaController carsJPA = new CarsJpaController(emf);
            carsJPA.destroy(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public void eliminarBalsa(){
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        System.out.print("Digite el ID de la balsa: ");
        BigDecimal id = sc.nextBigDecimal();
        
        try{
            BoatsJpaController boatJPA = new BoatsJpaController(emf);
            boatJPA.destroy(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    
    public void eliminarAvion(){
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        System.out.print("Digite el ID del avion: ");
        BigDecimal id = sc.nextBigDecimal();
        
        try{
            AirplainsJpaController airplainJPA = new AirplainsJpaController(emf);
            airplainJPA.destroy(id);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}
