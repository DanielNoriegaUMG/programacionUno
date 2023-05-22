/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Avion  extends Vehiculo{
    private int numMotores;

    public Avion(){
        
    }

    public Avion (String gas, String modelo, String motor, String marca, String tipo, int ruedas, int puertas, int numPasajeros){
        super(gas, motor, modelo, marca, tipo, ruedas, puertas, numPasajeros);
    }
    
    public void guardar(String tipo) {
        boolean validar = true; //condicion para iniciar el bucle
        String motor, modelo, marca, gas = null;
        int numPasajeros = 0 ;
        guardarVehiculo(tipo); //pedir primeros datos si tiene motor
        motor = getMotor();
        modelo = getModelo();
        marca = getMarca();

        do {
            System.out.println("Tipo que gasolina que utiliza");
            System.out.println("(super, diesel, regular, especial): ");
            setGas(sc.nextLine().toUpperCase());
            try {
                Gasolina nombreGas = Gasolina.valueOf(getGas());
                gas = getGas().toLowerCase(); //pasar a minusculas para el array
                validar = false; // salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de gasolina ingresado no existe");
                System.out.println("Intente de nuevo...");
            }
        } while (validar);
        
        try{
            System.out.print("\nDigite el numero maximo de pasajeros para el avion: ");
            numPasajeros = sc.nextInt();
        }catch(NumberFormatException e){
            System.out.println("Debe de ingresar un numero de pasajeros...");
        }

        System.out.println("Generando matricula");
        System.out.println("Espere...");
        try {
            Avion nuevoAvion = new Avion(gas, modelo, motor, marca, tipo, 3, 2, numPasajeros);
            guardarListaVehiculo(nuevoAvion);
            clonarLista();
            Thread.sleep(1000);
            System.out.println("Se registro el carro de forma exitosa!");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("La lista de Vehiculo ya esta llena...");
            System.out.println("No puedes seguir ingresando vehiculos :(");
        }
    }
    
}
