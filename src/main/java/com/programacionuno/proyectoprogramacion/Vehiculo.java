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
    private boolean remos;
    private String motor;
    private String modelo;
    private String marca;
    private String linea;
    private String tipo;
    int[] indexLetras = new int[3];
    int[] numeros = new int[3];
    
    public Vehiculo() {
        this.ID = next;
        this.modelo = "";
        this.marca = "";
        this.linea = "";
        this.tipo = "";
        next++;
    }
    
    public int getNext(){
        return next;
    }
    
    public boolean getIsRemos(){
        return this.remos;
    }
    
    public void setIsRemos(boolean tiene){
        this.remos = tiene;
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
            int letrasRandom = (int) Math.floor(Math.random() * 27);//indice de una letra random->matricula
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
        
        if(tipo == "B"){
            String respuesta;
            System.out.println("¿El bote tiene remos?");
            System.out.print("(si/no): ");
            respuesta = sc.nextLine();
            
            if(respuesta.equalsIgnoreCase("si"))
                setIsRemos(true);
            else 
                setIsRemos(false);
            setTipo(tipo);
        }
    }

    public void infoVehiculo() {
        System.out.println("Es un vehiculo");
    }
}
