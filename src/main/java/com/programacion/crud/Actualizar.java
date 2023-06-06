/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.programacion.db.Airplains;
import com.programacion.db.AirplainsJpaController;
import com.programacion.db.Boats;
import com.programacion.db.BoatsJpaController;
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
        System.out.print("Digite el ID del carro a actualizar: ");
        BigDecimal findId = sc.nextBigDecimal();
        try {
            Cars carroActualizar = carJPA.findCars(findId);
            if (carroActualizar != null) {
                datosParaModificarCarro(carroActualizar, sc);
                carJPA.edit(carroActualizar);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
    
    public void actualizarBalsa() {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        BoatsJpaController boatsJPA = new BoatsJpaController(emf);
        System.out.print("Digite el ID de la balsa a actualizar: ");
        BigDecimal findId = sc.nextBigDecimal();
        try {
            Boats boteActualizar = boatsJPA.findBoats(findId);
            if (boteActualizar != null) {
                datosParaModificarBote(boteActualizar, sc);
                boatsJPA.edit(boteActualizar);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public void actualizarAvion() {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.programacionUno_proyectoProgramacion_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        AirplainsJpaController avionJPA = new AirplainsJpaController(emf);
        System.out.print("Digite el ID del avion a actualizar: ");
        BigDecimal findId = sc.nextBigDecimal();
        try {
            Airplains avionActualizar = avionJPA.findAirplains(findId);
            if (avionActualizar != null) {
                datosParaModificarAvion(avionActualizar, sc);
                avionJPA.edit(avionActualizar);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    public static void datosParaModificarCarro(Cars carroActualizar, Scanner sc) {
        nuevoMotorCarro(carroActualizar, sc);
        nuevaMarcaCarro(carroActualizar, sc);
        nuevoModeloCarro(carroActualizar, sc);
        nuevaGasolinaCarro(carroActualizar, sc);
    }
    
    public static void datosParaModificarBote(Boats boteActualizar, Scanner sc) {
        nuevaMarcaBote(boteActualizar, sc);
        nuevoMotorBote(boteActualizar, sc);
    }
    
    public static void datosParaModificarAvion(Airplains avionActualizar, Scanner sc) {
        nuevaMarcaAvion(avionActualizar, sc);
        nuevoMotorAvion(avionActualizar, sc);
        nuevaGasolinaAvion(avionActualizar, sc);
        nuevoModeloAvion(avionActualizar, sc);
        nuevoNumPasajeros(avionActualizar, sc);
    }
    
    public static void nuevoMotorCarro(Cars carroActualizar, Scanner sc) {
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
    
    public static void nuevoMotorAvion(Airplains avionActualizar, Scanner sc) {
        String modificar;
        boolean validar = true;
        do {
            System.out.println("¿Deseas modificar el motor?");
            System.out.print("si/no: ");
            modificar = sc.nextLine();
            if (modificar.equalsIgnoreCase("si")) {
                validar = false;
                System.out.print("Nuevo nombre del motor: ");
                avionActualizar.setMotor(sc.nextLine());
            } else if (modificar.equalsIgnoreCase("no")) {
                validar = false;
            } else {
                System.out.println("opcion no valida, intentalo de nuevo");
            }
        } while (validar);
    }
    
    public static void nuevoMotorBote(Boats boteActualizar, Scanner sc) {
        String modificar;
        String dejarMotor;
        boolean validar = true;
        do {
            System.out.println("Aun deseas que el bote tenga motor?");
            System.out.print("(si/no): ");
            dejarMotor = sc.nextLine();
            if (dejarMotor.equalsIgnoreCase("si")) {
                System.out.print("Nuevo nombre del motor: ");
                boteActualizar.setMotor(sc.nextLine());
                nuevaGasolinaBote(boteActualizar, sc);
                boteActualizar.setRemos((short) 0);
                validar = false;
            } else if (dejarMotor.equalsIgnoreCase("no")) {
                boteActualizar.setRemos((short) 1);
                validar = false;
            } else {
                System.out.println("Error de opcion, intentalo de nuevo...");
            }
            
        } while (validar);
    }
    
    public static void nuevaMarcaCarro(Cars carroActualizar, Scanner sc) {
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
    
    public static void nuevaMarcaAvion(Airplains avionActualizar, Scanner sc) {
        String modificar;
        boolean validar = true;
        do {
            System.out.println("¿Deseas modificar la marca?");
            System.out.print("si/no: ");
            modificar = sc.nextLine();
            if (modificar.equalsIgnoreCase("si")) {
                validar = false;
                System.out.print("Escribe el nuevo nombre de la marca: ");
                avionActualizar.setMarca(sc.nextLine());
            } else if (modificar.equalsIgnoreCase("no")) {
                validar = false;
            } else {
                System.out.println("opcion no valida, intentalo de nuevo");
            }
        } while (validar);
    }
    
    public static void nuevaMarcaBote(Boats boteActualizar, Scanner sc) {
        String modificar;
        boolean validar = true;
        do {
            System.out.println("¿Deseas modificar la marca?");
            System.out.print("si/no: ");
            modificar = sc.nextLine();
            if (modificar.equalsIgnoreCase("si")) {
                validar = false;
                System.out.print("Escribe el nuevo nombre de la marca: ");
                boteActualizar.setMarca(sc.nextLine());
            } else if (modificar.equalsIgnoreCase("no")) {
                validar = false;
            } else {
                System.out.println("opcion no valida, intentalo de nuevo");
            }
        } while (validar);
    }
    
    public static void nuevoModeloCarro(Cars carroActualizar, Scanner sc) {
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
    
    public static void nuevoModeloAvion(Airplains avionActualizar, Scanner sc) {
        String modificar;
        boolean validar = true;
        do {
            System.out.println("¿Deseas modificar el modelo?");
            System.out.print("si/no: ");
            modificar = sc.nextLine();
            if (modificar.equalsIgnoreCase("si")) {
                validar = false;
                System.out.print("Digita el nuevo modelo: ");
                avionActualizar.setModelo(sc.nextBigInteger());
            } else if (modificar.equalsIgnoreCase("no")) {
                validar = false;
            } else {
                System.out.println("opcion no valida, intentalo de nuevo");
            }
        } while (validar);
    }
    
    public static void nuevoNumPasajeros(Airplains avionActualizar, Scanner sc) {
        String modificar;
        boolean validar = true;
        do {
            System.out.println("¿Deseas modificar el numero de pasajeros?");
            System.out.print("si/no: ");
            modificar = sc.nextLine();
            if (modificar.equalsIgnoreCase("si")) {
                validar = false;
                System.out.print("Digita el nuevo numero de pasajeros: ");
                avionActualizar.setNumPasajeros(sc.nextBigInteger());
            } else if (modificar.equalsIgnoreCase("no")) {
                validar = false;
            } else {
                System.out.println("opcion no valida, intentalo de nuevo");
            }
        } while (validar);
    }
    
    public static void nuevaGasolinaCarro(Cars carroActualizar, Scanner sc) {
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
    
    public static void nuevaGasolinaAvion(Airplains avionActualizar, Scanner sc) {
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
                avionActualizar.setGasolina(sc.nextLine().toUpperCase());
                
                try {
                    Gasolina nombreGas = Gasolina.valueOf(avionActualizar.getGasolina());
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
    
    public static void nuevaGasolinaBote(Boats boteActualizar, Scanner sc) {
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
                boteActualizar.setGasolina(sc.nextLine().toUpperCase());
                
                try {
                    Gasolina nombreGas = Gasolina.valueOf(boteActualizar.getGasolina());
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
