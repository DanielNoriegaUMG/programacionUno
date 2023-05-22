/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.manager.utils.GenerarMatriculas;
import com.programacion.JPA.CarsJpaController;
import com.programacion.db.Cars;
import com.programacionuno.proyectoprogramacion.Bote;
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
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        Cars carro = new Cars();
        CarsJpaController nuevoCarro = new CarsJpaController(emf);
        boolean validar = true; //condicion para iniciar el bucle
        String motor, marca, gas = null;
        BigInteger modelo;
        System.out.print("Escriba el nombre del motor: ");
        carro.setMotor(sc.nextLine());// motor ultimo modelo 3.2
        System.out.print("Marca: ");
        carro.setMarca(sc.nextLine().toUpperCase());//KIA
        System.out.print("Modelo: ");
        carro.setModelo(sc.nextBigInteger());// 2010
        sc.nextLine();
        motor = carro.getMotor();
        modelo = carro.getModelo();
        marca = carro.getMarca();

        do {
            System.out.println("Tipo que gasolina que utiliza");
            System.out.println("(super, diesel, regular, especial): ");
            carro.setGasolina(sc.nextLine().toUpperCase());
            try {
                Gasolina nombreGas = Gasolina.valueOf(carro.getGasolina());
                gas = carro.getGasolina().toLowerCase(); //pasar a minusculas para el array
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
            crearMatricula.nuevaMatricula("P");
            nuevoCarro.create(carro);
            System.out.println("Se registro el carro de forma exitosa!");
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    public void guardarBalsa() {
        Bote bote = new Bote();
    }

    public void guardarAvion() {

    }
}
