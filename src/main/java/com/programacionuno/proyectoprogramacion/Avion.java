/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Avion extends Vehiculo{

    private int numPasajeros;
    
    public Avion(String modelo, String marca, String linea){
        super();
    }
    
    public Avion(){
        this.numPasajeros = 0;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }
    
    @Override
    public String infoVehiculo(){
        return "Es un avion";
    }

}
