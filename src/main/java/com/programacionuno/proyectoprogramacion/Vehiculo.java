/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Vehiculo extends Object{
    private static int next = 1;
    private int ID;
    private boolean ruedas;
    private boolean puertas;
    private boolean motor;
    private String modelo;
    private String marca;
    private String linea;
    
    
    public Vehiculo(){
        this.ID = next;
        this.ruedas = true;
        this.puertas = true;
        this.motor = true;
        this.modelo = "";
        this.marca = "";
        this.linea = "";
        next++;
    }

    public boolean isRuedas() {
        return ruedas;
    }

    public void setRuedas(boolean ruedas) {
        this.ruedas = ruedas;
    }

    public boolean isPuertas() {
        return puertas;
    }

    public void setPuertas(boolean puertas) {
        this.puertas = puertas;
    }

    public boolean isMotor() {
        return motor;
    }

    public void setMotor(boolean motor) {
        this.motor = motor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String infoVehiculo(){
        return "Es un vehiculo...";
    }
}
