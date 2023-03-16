package com.programacionuno.proyectoprogramacion;

import java.util.Scanner;

/**
 *
 * @author Daniel Noriega
 */
public class Vehiculo extends Object {

    Scanner sc = new Scanner(System.in);
    private static int next = 1;
    private int ID;
    
    private String gas;
    private String motor;
    private String modelo;
    private String marca;
    private String tipo;
    private String tipoVehiculo;
    private boolean motorBote;
    int[] indexLetras = new int[3];
    int[] numeros = new int[3];
    
    public Vehiculo() {
        this.ID = next;
        this.modelo = "";
        this.marca = "";
        this.tipo = "";
        this.motorBote = false;
        next++;
    }
    
    public boolean isMotorBote(){
        return this.motorBote;
    }
    
    public void setMotorBote(boolean motor){
        this.motorBote = motor;
    }
    
    public void setGas(String gas){
        this.gas = gas;
    }
    
    public String getGas(){
        return this.gas;
    }
    
    public int getNext(){
        return next;
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

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int[] randomLetrasMatricula() {
        //Para generar index de letras random
        for (int i = 0; i < 3; i++) {
            //indice de una letra random->matricula
            int letrasRandom = (int) Math.floor(Math.random() * 25);
            this.indexLetras[i] = letrasRandom;
        }
        return indexLetras;
    }
    
    public int[] randomNumerosMatricula(){
        //Para generar una numeros random
        for (int i = 0; i < 3; i++) {
            int numerosRandom = (int) Math.floor(Math.random() * 9);//numeros para la matricula
            this.numeros[i] = numerosRandom;
        }
        return numeros;
    }

    public void imprimirMatricula() {
        Letras[] letras = Letras.values();
        System.out.print("Matricula: " + getTipo() + "-");
        //imprimir letras
        for (int i = 0; i < 3; i++) {
            System.out.print(letras[indexLetras[i]]);
            
        }
        //imprimir numeros del 0 al 9
        for (int i = 0; i < 3; i++) {
            System.out.print(numeros[i]);
        }
        System.out.println("\n");
    }

    public void guardarVehiculo(String tipo) {
        if (tipo == "P" || tipo == "TC" || tipo == "T" || tipo == "M" || tipo == "A") {
            System.out.print("Escriba el nombre del motor: ");
            setMotor(sc.nextLine());// motor ultimo modelo 3.2
            System.out.print("Modelo: ");
            setModelo(sc.nextLine());// 2010
            System.out.print("Marca: ");
            setMarca(sc.nextLine());//KIA
            setTipo(tipo);
        }
    }

    public void infoVehiculo() {
        System.out.println("Es un vehiculo");
    }
}