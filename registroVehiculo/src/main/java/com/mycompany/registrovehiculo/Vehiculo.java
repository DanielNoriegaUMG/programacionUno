/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrovehiculo;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Sojuel
 */
public class Vehiculo extends Object {

    Scanner sc = new Scanner(System.in);
    protected static int contador = 1;
    private char tipo;
    private int ID;
    private String matricula;
    private String marca;
    private String modelo;
    protected static Vehiculo vehiculoLista[] = new Vehiculo[10];
    protected static Vehiculo[] nuevaLista;
    Matricula matri = new Matricula();

    public Vehiculo() {

    }

    public Vehiculo(char tipo, int ID, String matricula, String marca, String modelo) {
        this.tipo = tipo;
        this.ID = ID;
        this.matricula = matri.unirMatricula(tipo);
        this.marca = marca;
        this.modelo = modelo;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        Vehiculo.contador = contador;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void guarVehiculoLista(Vehiculo nuevo) {
        vehiculoLista[contador] = nuevo;
    }

    public void clonarLista() {
        nuevaLista = vehiculoLista.clone();
        contador = contador + 1;
    }
    
    public int buscarID(int id) {
        for(int i=0; i<getContador(); i++){
            if(nuevaLista[i].getID()== id){
                return i;
            }
        }
        return -1;
    }
    
    public void registroVehiculo(char tipo) {
        System.out.println("\nIngrese los siguientes datos\n");
        setTipo(tipo);
        boolean validar = true;
        do {
            try {
                System.out.print("ID: ");
                int tem=sc.nextInt();
                int pos=buscarID(tem);
                if(pos<0){
                    setID(tem);
                    validar = false; sc.nextLine();
                }else{
                    System.out.println("Otro vehiculo ocupa este ID");
                    validar = true; sc.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.print("Deves ingresar un \"Numero\"\n");
                sc.nextLine();
            }
        } while (validar);
        validar = true;
        do {
            System.out.print("Marca: ");
            setMarca(sc.nextLine());
            if (!getMarca().equals("")) {
                validar = false;
            }
        } while (validar);
        validar = true;
        do {
            System.out.print("Modelo: ");
            setModelo(sc.nextLine());
            if (!getModelo().equals("")) {
                validar = false;
            }
        } while (validar);
    }
}
