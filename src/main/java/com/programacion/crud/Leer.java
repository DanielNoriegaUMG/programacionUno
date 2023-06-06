/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.programacion.db.Airplains;
import com.programacion.db.AirplainsJpaController;
import com.programacion.db.Boats;
import com.programacion.db.BoatsJpaController;
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
public class Leer {

    public void listarCarros() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        List<Cars> carros = new ArrayList<>();
        CarsJpaController carsJPA = new CarsJpaController(emf);

        try {
            carros = carsJPA.findCarsEntities();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Cars car : carros) {
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

    public void buscarCarro() {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        ArrayList<Cars> busqueda = new ArrayList<>();
        CarsJpaController carsJPA = new CarsJpaController(emf);

        System.out.print("Digita el numero de ID para buscar el carro: ");
        BigDecimal id = sc.nextBigDecimal();

        Cars encontrado = carsJPA.findCars(id);
        if (encontrado != null) {
            busqueda.add(encontrado);

            for (Cars mostrar : busqueda) {
                System.out.println("ID: " + mostrar.getId());
                System.out.println("MATRICULA: " + mostrar.getMatricula());
                System.out.println("MARCA: " + mostrar.getMarca());
                System.out.println("MODELO: " + mostrar.getModelo());
                System.out.println("MOTOR: " + mostrar.getMotor());
                System.out.println("PUERTAS: " + mostrar.getPuertas());
                System.out.println("RUEDAS: " + mostrar.getRuedas());
            }
        } else {
            System.out.println("No se encontro el carro con ID: " + id);
        }
    }

    public void listarBalsas() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        List<Boats> botes = new ArrayList<>();
        BoatsJpaController botesJPA = new BoatsJpaController(emf);

        try {
            botes = botesJPA.findBoatsEntities();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Boats boat : botes) {
            System.out.println("ID: " + boat.getId());
            System.out.println("MATRICULA: " + boat.getMatricula());
            System.out.println("MARCA: " + boat.getMarca());
            System.out.println("MOTOR: " + boat.getMotor());
            System.out.println("GASOLINA: " + boat.getGasolina());
            short tieneRemos = boat.getRemos();
            if (tieneRemos == 1) {
                System.out.println("REMOS: SI");
            } else {
                System.out.println("REMOS: NO");
            }

            System.out.println("");
        }
    }

    public void buscarBalsa() {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        ArrayList<Boats> busqueda = new ArrayList<>();
        BoatsJpaController boatsJPA = new BoatsJpaController(emf);

        System.out.print("Digita el numero de ID para buscar la balsa: ");
        BigDecimal id = sc.nextBigDecimal();

        Boats encontrado = boatsJPA.findBoats(id);
        if (encontrado != null) {
            busqueda.add(encontrado);

            for (Boats mostrar : busqueda) {
                System.out.println("ID: " + mostrar.getId());
                System.out.println("MATRICULA: " + mostrar.getMatricula());
                System.out.println("MARCA: " + mostrar.getMarca());
                System.out.println("MOTOR: " + mostrar.getMotor());
                short tieneRemos = mostrar.getRemos();
                if (tieneRemos == 1) {
                    System.out.println("REMOS: SI");
                } else {
                    System.out.println("REMOS: NO");
                }
            }
        } else {
            System.out.println("No se encontro la balsa con ID: " + id);
        }
    }

    public void listarAviones() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        List<Airplains> aviones = new ArrayList<>();
        AirplainsJpaController avionJPA = new AirplainsJpaController(emf);

        try {
            aviones = avionJPA.findAirplainsEntities();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (Airplains airplain : aviones) {
            System.out.println("ID: " + airplain.getId());
            System.out.println("MATRICULA: " + airplain.getMatricula());
            System.out.println("MARCA: " + airplain.getMarca());
            System.out.println("MOTOR: " + airplain.getMotor());
            System.out.println("GASOLINA: " + airplain.getGasolina());
            System.out.println("NUMERO DE PASAJEROS: " + airplain.getNumPasajeros());
            System.out.println("");
        }
    }

    public void buscarAvion() {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        ArrayList<Airplains> busqueda = new ArrayList<>();
        AirplainsJpaController avionJPA = new AirplainsJpaController(emf);

        System.out.print("Digita el numero de ID para buscar el avion: ");
        BigDecimal id = sc.nextBigDecimal();

        Airplains encontrado = avionJPA.findAirplains(id);
        if (encontrado != null) {
            busqueda.add(encontrado);

            for (Airplains mostrar : busqueda) {
                System.out.println("ID: " + mostrar.getId());
                System.out.println("MATRICULA: " + mostrar.getMatricula());
                System.out.println("MARCA: " + mostrar.getMarca());
                System.out.println("MOTOR: " + mostrar.getMotor());
                System.out.println("GASOLINA: " + mostrar.getGasolina());
                System.out.println("NUMERO DE PASAJEROS: " + mostrar.getNumPasajeros());
            }
        } else {
            System.out.println("No se encontro el avion con ID: " + id);
        }
    }
}
