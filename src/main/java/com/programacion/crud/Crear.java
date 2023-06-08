/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.manager.utils.GenerarMatriculas;
import com.programacion.db.Airplains;
import com.programacion.db.AirplainsJpaController;
import com.programacion.db.Boats;
import com.programacion.db.BoatsJpaController;
import com.programacion.db.Cars;
import com.programacion.db.CarsJpaController;
import com.programacionuno.proyectoprogramacion.Gasolina;
import java.math.BigInteger;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Noriega UMG
 */
public class Crear {

    public void guardarCarro() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        CarsJpaController carroJPA = new CarsJpaController(emf);

        Cars carro = new Cars();
        boolean validar = true; //condicion para iniciar el bucle
        System.out.print("Escriba el nombre del motor: ");
        carro.setMotor(sc.nextLine());// motor ultimo modelo 3.2
        System.out.print("Marca: ");
        carro.setMarca(sc.nextLine().toUpperCase());//KIA

        do {
            try {
                System.out.print("Modelo: ");
                carro.setModelo(sc.nextBigInteger());// 2010
                validar = false;
            } catch (NumberFormatException e) {
                System.out.println("El modelo del carro debe de ser en numeros");
                System.out.println("Intentalo nuevamente");
            }
        } while (validar);

        validar = true;
        do {
            System.out.println("Tipo que gasolina que utiliza");
            System.out.println("(super, diesel, regular, especial): ");
            carro.setGasolina(sc.nextLine().toUpperCase());
            try {
                Gasolina nombreGas = Gasolina.valueOf(carro.getGasolina());
                validar = false; // salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de gasolina ingresado no existe");
                System.out.println("Intente de nuevo...");
            }
        } while (validar);

        System.out.println("Generando matricula");
        System.out.println("Espere...");
        try {
            Thread.sleep(1000);
            GenerarMatriculas crearMatricula = new GenerarMatriculas();
            String matricula = crearMatricula.nuevaMatricula("P");
            carro.setMatricula(matricula);
            carro.setPuertas(BigInteger.valueOf(4));
            carro.setRuedas(BigInteger.valueOf(4));
            carroJPA.create(carro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarBalsa() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        BoatsJpaController balsaJPA = new BoatsJpaController(emf);
        Boats balsa = new Boats();

        String tieneMotor;
        System.out.println("¿El bote tiene motor?");
        System.out.print("(si/no): ");
        tieneMotor = sc.nextLine();
        if (tieneMotor.equalsIgnoreCase("si")) {
            String gas = null;
            boolean validar = true; //condicion para iniciar el bucle
            balsa.setRemos((short) 1);
            do {
                System.out.println("Tipo que gasolina que utiliza");
                System.out.println("(super, diesel, regular, especial): ");
                balsa.setGasolina(sc.nextLine().toUpperCase());
                try {
                    Gasolina nombreGas = Gasolina.valueOf(balsa.getGasolina());
                    gas = balsa.getGasolina().toLowerCase(); //pasar a minusculas para el array
                    validar = false; // salir del bucle
                } catch (IllegalArgumentException e) {
                    System.out.println("El tipo de gasolina ingresado no existe");
                    System.out.println("Intente de nuevo...");
                }
            } while (validar);

            try {
                System.out.print("\nEscribe la marca de la balsa: ");
                balsa.setMarca(sc.nextLine());
                System.out.println("Generando matricula");
                System.out.println("Espere...");
                GenerarMatriculas crearMatricula = new GenerarMatriculas();
                String matricula = crearMatricula.nuevaMatricula("B");
                balsa.setMatricula(matricula);
                balsaJPA.create(balsa);
                Thread.sleep(1000);
                System.out.println("Se registro el carro de forma exitosa!");
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else if (tieneMotor.equalsIgnoreCase("no")) {

            System.out.print("\nEscribe la marca de la balsa: ");
            balsa.setMarca(sc.nextLine());
            System.out.println("Generando matricula");
            System.out.println("Espere...");
            balsa.setRemos((short) 0);
            try {
                balsa.setMotor("SIN MOTOR");
                balsa.setGasolina("NO USA");
                GenerarMatriculas crearMatricula = new GenerarMatriculas();
                String matricula = crearMatricula.nuevaMatricula("B");
                balsa.setMatricula(matricula);
                balsaJPA.create(balsa);
                Thread.sleep(1000);
                System.out.println("Se registro la balsa de forma exitosa!");
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Error al ingresar opcion de motor, intentalo de nuevo");
        }
    }

    public void guardarAvion() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        Scanner sc = new Scanner(System.in);
        EntityManager em = emf.createEntityManager();
        AirplainsJpaController avionJPA = new AirplainsJpaController(emf);
        Airplains avion = new Airplains();
        boolean validar = true; //condicion para iniciar el bucle

        try {
            System.out.print("Ingrese la marca del avion: ");
            avion.setMarca(sc.nextLine().toUpperCase());
            System.out.println("Ingrese motor del avion: ");
            avion.setMotor(sc.nextLine().toUpperCase());
            System.out.print("Ingrese el modelo del avion: ");
            avion.setModelo(sc.nextBigInteger());
            sc.nextLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        do {
            System.out.println("Tipo que gasolina que utiliza");
            System.out.println("(super, diesel, regular, especial): ");
            avion.setGasolina(sc.nextLine().toUpperCase());
            try {
                Gasolina nombreGas = Gasolina.valueOf(avion.getGasolina());
                avion.getGasolina().toLowerCase(); //pasar a minusculas para el array
                validar = false; // salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de gasolina ingresado no existe");
                System.out.println("Intente de nuevo...");
            }
        } while (validar);

        try {
            System.out.println("Digita el numero de pasajeros del avion: ");
            avion.setNumPasajeros(sc.nextBigInteger());
        } catch (NumberFormatException e) {
            System.out.println("Debes de ingresar la cantidad de pasajeros en numeros...");
        } catch (Exception e) {
            System.out.println("Ocurrio un error al ingresar el numero de pasajeros...");
        }

        System.out.println("Generando matricula");
        System.out.println("Espere...");
        try {
            GenerarMatriculas crearMatricula = new GenerarMatriculas();
            String matricula = crearMatricula.nuevaMatricula("A");
            avion.setMatricula(matricula);
            avionJPA.create(avion);
            Thread.sleep(1000);
            System.out.println("Se registro el avion de forma exitosa!");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("La lista de Vehiculo ya esta llena...");
            System.out.println("No puedes seguir ingresando vehiculos :(");
        }
    }
}
