/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Carro extends Vehiculo{
    
    private int ruedas;
    private int puertas;
    private String matricula;
    private String gas;
    
    public Carro(String modelo, String marca, String linea){
        super();
    }
    
    public Carro(){
        this.ruedas = 4;
        this.puertas = 4;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }
    
    @Override
    public String infoVehiculo(){
        return "Es un carro";
    }

}
