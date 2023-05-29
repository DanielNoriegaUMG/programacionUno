/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.programacion.db.Cars;
import com.programacion.db.CarsJpaController;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Noriega UMG
 */
public class Read {
    public void listarCarros(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        List<Cars> carros = new ArrayList<>();
        CarsJpaController carsJPA = new CarsJpaController(emf);
        
        try {
            carros = carsJPA.findCarsEntities();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        for(Cars car: carros){
            System.out.println("ID: " + car.getId());
            System.out.println("MATRICULA: " + car.getMatricula());
            System.out.println("MARCA: " + car.getMarca());
            System.out.println("MODELO: " + car.getModelo());
            System.out.println("MOTOR: " + car.getMotor());
            System.out.println("GASOLINA: " + car.getGasolina());
            System.out.println("RUEDAS: " + car.getRuedas());
            System.out.println("PUERTAS: " + car.getPuertas());
            System.out.println("");
            System.out.println("");
        }
    }
}
