/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.manager.utils.GenerarMatriculas;
import com.programacion.db.Cars;
import com.programacionuno.proyectoprogramacion.Bote;
import com.programacionuno.proyectoprogramacion.Gasolina;
import java.math.BigDecimal;
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
        EntityManagerFactory emf = 
        Persistence.createEntityManagerFactory(
    "com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU"
        );
        
        EntityManager em = emf.createEntityManager();
        
        
        Scanner sc = new Scanner(System.in);
        Cars carro = new Cars();
        carro.setMarca("honda");
        carro.setMatricula("P-DEN108");
        carro.setModelo(BigInteger.valueOf(2020));
        carro.setMotor("v.8");
        carro.setPuertas(BigInteger.valueOf(4));
        carro.setRuedas(BigInteger.valueOf(4));
        carro.setGasolina("SUPER");

        try {
            em.getTransaction().begin();
            em.persist(carro);
            em.getTransaction().commit();
            System.out.println("Se ha creado el carro al fin...");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
        }

//        boolean validar = true; //condicion para iniciar el bucle
//        System.out.print("Escriba el nombre del motor: ");
//        carro.setMotor(sc.nextLine());// motor ultimo modelo 3.2
//        System.out.print("Marca: ");
//        carro.setMarca(sc.nextLine().toUpperCase());//KIA
//        System.out.print("Modelo: ");
//        carro.setModelo(sc.nextBigInteger());// 2010
//        sc.nextLine();
//
//        do {
//            System.out.println("Tipo que gasolina que utiliza");
//            System.out.println("(super, diesel, regular, especial): ");
//            carro.setGasolina(sc.nextLine().toUpperCase());
//            try {
//                Gasolina nombreGas = Gasolina.valueOf(carro.getGasolina());
//                validar = false; // salir del bucle
//            } catch (IllegalArgumentException e) {
//                System.out.println("El tipo de gasolina ingresado no existe");
//                System.out.println("Intente de nuevo...");
//            }
//        } while (validar);
//
//        System.out.println("Generando matricula");
//        System.out.println("Espere...");
//        try {
//            Thread.sleep(1000);
//            GenerarMatriculas crearMatricula = new GenerarMatriculas();
//            String matricula = crearMatricula.nuevaMatricula("P");
//            carro.setMatricula(matricula);
//            carro.setPuertas(BigInteger.valueOf(4));
//            carro.setRuedas(BigInteger.valueOf(4));
//            //System.out.println(carro);
//            try {
//                em.getTransaction().begin();
//                em.persist(carro);
//                em.getTransaction().commit();
//            } catch (Exception e) {
//                em.getTransaction().rollback();
//                e.printStackTrace();
//                throw new RuntimeException(e);
//            } finally {
//                if (em != null) {
//                    em.close();
//                }
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
    }

    public void guardarBalsa() {
        Bote bote = new Bote();
    }

    public void guardarAvion() {

    }
}
