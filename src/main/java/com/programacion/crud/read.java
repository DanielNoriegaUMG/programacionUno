/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.programacion.db.Cars;
import com.programacion.db.CarsJpaController;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        }
    }
    
    public void buscarCarro(){
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        ArrayList<Cars> busqueda = new ArrayList<>();
        CarsJpaController carsJPA = new CarsJpaController(emf);
        
        System.out.print("Digita el numero de ID para buscar el carro: ");
        BigDecimal id = sc.nextBigDecimal();
        
        Cars encontrado = carsJPA.findCars(id);
        if(encontrado != null){
            busqueda.add(encontrado);

            for(Cars mostrar:busqueda){
                System.out.println("ID: " + mostrar.getId());
                System.out.println("MATRICULA: " + mostrar.getMatricula());
                System.out.println("MARCA: " + mostrar.getMarca());
                System.out.println("MODELO: " + mostrar.getModelo());
                System.out.println("MOTOR: " + mostrar.getMotor());
                System.out.println("PUERTAS: " + mostrar.getPuertas());
                System.out.println("RUEDAS: " + mostrar.getRuedas());
            }
        }else{
            System.out.println("No se encontro el carro con ID: " +  encontrado);
        }   
    }
    
    public void listarBalsas(){
        
    }
    
    public void buscarBalsa(){
        
    }
    
    public void listarAviones(){
        
    }
    
    public void buscarAvion(){
        
    }
}
