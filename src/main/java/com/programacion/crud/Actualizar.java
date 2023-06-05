/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.programacion.db.CarsJpaController;
import com.programacion.db.Cars;
import com.programacionuno.proyectoprogramacion.Gasolina;
import java.math.BigDecimal;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Daniel Noriega UMG
 */
public class Actualizar {

    public void ActualizarCarro() {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        CarsJpaController carJPA = new CarsJpaController(emf);
//        Cars update = new Cars();
        System.out.print("Digite el ID del carro a actualizar: ");
        BigDecimal findId = sc.nextBigDecimal();
        try{
            Cars carroActualizar = carJPA.findCars(findId);
            if(carroActualizar != null){
                datosParaModificar(carroActualizar, sc);
                carJPA.edit(carroActualizar);
            }     
        }catch(Exception e){
            throw new RuntimeException(e);
        }

    }
    
    public void actualizarBalsa(){
        
    }
    
    public void actualizarAvion(){
        
    }

    public static void datosParaModificar(Cars carroActualizar, Scanner sc) {
        nuevoMotor(carroActualizar, sc);
        nuevaMarca(carroActualizar, sc);
        nuevoModelo(carroActualizar, sc);
        nuevaGasolina(carroActualizar, sc);
    }

    public static void nuevoMotor(Cars carroActualizar, Scanner sc) {
        String modificar;
        boolean validar = true;
        do {
            System.out.println("¿Deseas modificar el motor?");
            System.out.print("si/no: ");
            modificar = sc.nextLine();
            if (modificar.equalsIgnoreCase("si")) {
                validar = false;
                System.out.print("Nuevo nombre del motor: ");
                carroActualizar.setMotor(sc.nextLine());
            } else if (modificar.equalsIgnoreCase("no")) {
                validar = false;
            } else {
                System.out.println("opcion no valida, intentalo de nuevo");
            }
        } while (validar);

    }

    public static void nuevaMarca(Cars carroActualizar, Scanner sc) {
        String modificar;
        boolean validar = true;
        do {
            System.out.println("¿Deseas modificar la marca?");
            System.out.print("si/no: ");
            modificar = sc.nextLine();
            if (modificar.equalsIgnoreCase("si")) {
                validar = false;
                System.out.print("Escribe el nuevo nombre de la marca: ");
                carroActualizar.setMarca(sc.nextLine());
            } else if (modificar.equalsIgnoreCase("no")) {
                validar = false;
            } else {
                System.out.println("opcion no valida, intentalo de nuevo");
            }
        } while (validar);
    }

    public static void nuevoModelo(Cars carroActualizar, Scanner sc) {
        String modificar;
        boolean validar = true;
        do {
            System.out.println("¿Deseas modificar el modelo?");
            System.out.print("si/no: ");
            modificar = sc.nextLine();
            if (modificar.equalsIgnoreCase("si")) {
                validar = false;
                System.out.print("Escribe el nuevo nombre del modelo: ");
                carroActualizar.setModelo(sc.nextBigInteger());
            } else if (modificar.equalsIgnoreCase("no")) {
                validar = false;
            } else {
                System.out.println("opcion no valida, intentalo de nuevo");
            }
        } while (validar);
    }

    public static void nuevaGasolina(Cars carroActualizar, Scanner sc) {
        String modificar;
        boolean validar = true;
        do {
            System.out.println("¿Deseas modificar el tipo de gasolina?");
            System.out.print("si/no: ");
            modificar = sc.nextLine();
            if (modificar.equalsIgnoreCase("si")) {
                validar = false;
                System.out.println("Escribe el nuevo tipo de gasolina: ");
                System.out.print("(super, diesel, regular, especial): ");
                carroActualizar.setGasolina(sc.nextLine().toUpperCase());

                try {
                    Gasolina nombreGas = Gasolina.valueOf(carroActualizar.getGasolina());
                    validar = false; // salir del bucle
                } catch (IllegalArgumentException e) {
                    System.out.println("El tipo de gasolina ingresado no existe");
                    System.out.println("Intente de nuevo...");
                }

            } else if (modificar.equalsIgnoreCase("no")) {
                validar = false;
            } else {
                System.out.println("opcion no valida, intentalo de nuevo");
            }
        } while (validar);
    }
}
