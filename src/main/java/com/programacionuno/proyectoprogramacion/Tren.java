package com.programacionuno.proyectoprogramacion;

import java.util.InputMismatchException;

/**
 *
 * @author Daniel Noriega
 */
public class Tren extends Vehiculo {

    private int ruedas;
    private int vagones;
    private int pasajerosVagon;
    private int totalPasajeros;
    private boolean electrico;
    private String tipoGas;
    private int totalRuedas;

    public Tren() {
        this.ruedas = 8;
        this.vagones = 1;
        this.pasajerosVagon = 0;
        this.electrico = true;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getVagones() {
        return vagones;
    }

    public void setVagones(int vagones) {
        this.vagones = vagones;
    }

    public int getPasajerosVagon() {
        return this.pasajerosVagon;
    }

    public void setPasajerosVagon(int pasajeros) {
        this.pasajerosVagon = pasajeros;
    }
    
    public void setTotalPasajeros(int pasajeros){
        this.totalPasajeros = pasajeros;
    }
    
    public int getTotalPasajeros(){
        this.totalPasajeros = getPasajerosVagon() * getVagones();
        return this.totalPasajeros;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    public void setGas(String gas) {
        this.tipoGas = gas;
    }

    public String getGas() {
        return this.tipoGas;
    }
    
    public void setTotalRuedas(int ruedasVagon){
        this.totalRuedas = ruedasVagon;
    }
    
    public int getTotalRuedas(){
        this.totalRuedas = getRuedas() * getVagones();
        return this.totalRuedas;
    }

    public void guardar(String tipo) {
        String respuesta;
        boolean valida = true;
        guardarVehiculo(tipo); //perdir primeros datos si tiene motor
        do {
            System.out.println("El tren es electrico?");
            System.out.print("(si/no): ");
            respuesta = sc.nextLine().toLowerCase();
            if (respuesta.equalsIgnoreCase("si")) {
                setElectrico(true);
                valida = false; //salir del bucle
            } else if (respuesta.equalsIgnoreCase("no")) {
                setElectrico(false);
                valida = false; //salir del bucle
            } else {
                System.out.println("Opcion invalida");
                System.out.println("Intentalo de nuevo...");
            }
        } while (valida);

        valida = true;
        do {
            System.out.println("Tipo que gasolina que utiliza");
            System.out.println("(super, diesel, regular, especial): ");
            setGas(sc.nextLine().toUpperCase());
            try {
                Gasolina nombreGas = Gasolina.valueOf(getGas());
                valida = false; // salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de gasolina ingresado no existe");
                System.out.println("Intente de nuevo...");
            }
        } while (valida);

        valida = true;
        do {
            try {
                System.out.print("Digite el numero de vagones del tren: ");
                setVagones(sc.nextInt());
                setTotalRuedas(getRuedas());
                valida = false; //salir del bucle
            } catch (InputMismatchException e) {
                System.out.println("El valor que ingreso no es un numero");
                System.out.println("Debe ingresar un numero");
                sc.next();
            }
        } while (valida);
        
        valida = true;
        do {
            try {
                System.out.print("Digite el numero de pasajeros (por vagon): ");
                setPasajerosVagon(sc.nextInt());
                valida = false;//salir del bucle
            } catch (InputMismatchException e) {
                System.out.println("El valor que ingreso no es un numero");
                System.out.println("Debe ingresar un numero");
                sc.next();
            }
        } while (valida);

        System.out.println("Generando matricula");
        System.out.println("Espere...");
        randomLetrasMatricula();
        randomNumerosMatricula();
        try {
            Thread.sleep(2000);
            System.out.println("Se registro el carro de forma exitosa!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public void infoVehiculo() {
        Gasolina nombreGas = Gasolina.valueOf(getGas());
        System.out.println("DATOS DEL TREN");
        System.out.println("Motor: " + getMotor());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Marca: " + getMarca());
        System.out.println("Total de vagones: " + getVagones());
        System.out.println("Ruedas por vagon: " + getRuedas());
        System.out.println("Total de ruedas: " + getTotalRuedas());
        System.out.println("Cantidad de pasajeros por vagon: " + getPasajerosVagon());
        System.out.println("Cantidad maxima de pasajeros: " + getTotalPasajeros());
        System.out.println("Tipo de gasolina: " + nombreGas);
        System.out.println("Total de ruedas: " + getRuedas());
        imprimirMatricula();
    }
}
