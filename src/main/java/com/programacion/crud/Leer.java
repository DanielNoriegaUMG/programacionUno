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

    public void imprimirColumnas() {
        System.out.printf("%-4s | "
                + "%-10s | "
                + "%-15s | "
                + "%-15s | "
                + "%-10s | "
                + "%-10s | ",
                "ID",
                "MATRICULA",
                "MARCA",
                "MODELO",
                "MOTOR",
                "GASOLINA");
    }

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

        imprimirColumnas();
        System.out.printf("%-8s | "
                + "%-8s",
                "PUERTAS",
                "RUEDAS\n");

        for (Cars car : carros) {
            System.out.printf("%-4s| "
                    + "%-10s | "
                    + "%-15s | "
                    + "%-15s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-8d | "
                    + "%-8d | ",
                    car.getId(),
                    car.getMatricula(),
                    car.getMarca(),
                    car.getModelo(),
                    car.getMotor(),
                    car.getGasolina().toString(),
                    car.getPuertas(),
                    car.getRuedas());
        }
        System.out.println("\n\n");
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

            imprimirColumnas();
            System.out.printf("%-8s | "
                    + "%-8s",
                    "PUERTAS",
                    "RUEDAS\n");

            for (Cars mostrar : busqueda) {
                System.out.printf("%-4s| "
                        + "%-10s | "
                        + "%-15s | "
                        + "%-15s | "
                        + "%-10s | "
                        + "%-10s | "
                        + "%-8d | "
                        + "%-8d | ",
                        encontrado.getId(),
                        encontrado.getMatricula(),
                        encontrado.getMarca(),
                        encontrado.getModelo(),
                        encontrado.getMotor(),
                        encontrado.getGasolina().toString(),
                        encontrado.getPuertas(),
                        encontrado.getRuedas());
            }
            System.out.println("\n\n");
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

        System.out.printf("%-4s | "
                + "%-10s | "
                + "%-10s | "
                + "%-10s | "
                + "%-10s | "
                + "%-5s\n",
                "ID",
                "MATRICULA",
                "MARCA",
                "MOTOR",
                "GASOLINA",
                "REMOS");

        for (Boats boat : botes) {
            short tieneRemos = boat.getRemos();
            System.out.printf("%-4s | "
                    + "%-10s | "
                    + "%-15s | ",
                    boat.getId(),
                    boat.getMatricula(),
                    boat.getMarca());
            if (tieneRemos == 1) {
                System.out.printf("%-10s | "
                        + "%-10s | "
                        + "%-5s",
                        "COMUN",
                        boat.getGasolina(),
                        "NO");
            } else {
                System.out.printf("%-10s | "
                        + "%-10s | "
                        + "%-5s\n",
                        boat.getMotor(),
                        boat.getGasolina(),
                        "SI");
            }

        }
        System.out.println("\n\n");
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

            System.out.printf("%-4s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-5s\n",
                    "ID",
                    "MATRICULA",
                    "MARCA",
                    "MOTOR",
                    "GASOLINA",
                    "REMOS");

            for (Boats boat : busqueda) {
                short tieneRemos = boat.getRemos();
                System.out.printf("%-4s | "
                        + "%-10s | "
                        + "%-15s | ",
                        boat.getId(),
                        boat.getMatricula(),
                        boat.getMarca());
                if (tieneRemos == 1) {
                    System.out.printf("%-10s | "
                            + "%-10s | "
                            + "%-5s",
                            "COMUN",
                            boat.getGasolina(),
                            "NO");
                } else {
                    System.out.printf("%-10s | "
                            + "%-10s | "
                            + "%-5s\n",
                            boat.getMotor(),
                            boat.getGasolina(),
                            "SI");
                }

            }
            System.out.println("\n\n");
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

        System.out.printf("%-4s | "
                + "%-10s | "
                + "%-10s | "
                + "%-10s | "
                + "%-10s | "
                + "%-10s | "
                + "%-15s\n",
                "ID",
                "MATRICULA",
                "MARCA",
                "MODELO",
                "MOTOR",
                "GASOLINA",
                "PASAJEROS");

        for (Airplains airplain : aviones) {
            System.out.printf("%-4s| "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-10s |\n",
                    airplain.getId(),
                    airplain.getMatricula(),
                    airplain.getMarca(),
                    airplain.getModelo(),
                    airplain.getMotor(),
                    airplain.getGasolina().toString(),
                    airplain.getNumPasajeros());
        }
        System.out.println("\n\n");
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

            System.out.printf("%-4s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-15s\n",
                    "ID",
                    "MATRICULA",
                    "MARCA",
                    "MODELO",
                    "MOTOR",
                    "GASOLINA",
                    "PASAJEROS");
            for (Airplains mostrar : busqueda) {
                System.out.printf("%-4s| "
                        + "%-10s | "
                        + "%-10s | "
                        + "%-10s | "
                        + "%-10s | "
                        + "%-10s | "
                        + "%-10s |\n",
                        mostrar.getId(),
                        mostrar.getMatricula(),
                        mostrar.getMarca(),
                        mostrar.getModelo(),
                        mostrar.getMotor(),
                        mostrar.getGasolina().toString(),
                        mostrar.getNumPasajeros());
            }
            System.out.println("\n\n");
        } else {
            System.out.println("No se encontro el avion con ID: " + id);
        }
    }
}
