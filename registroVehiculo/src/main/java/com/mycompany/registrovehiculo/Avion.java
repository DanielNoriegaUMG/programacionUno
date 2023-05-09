/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrovehiculo;

import java.util.InputMismatchException;

/**
 *
 * @author Sojuel
 */
public class Avion extends Vehiculo {
    private int numPasajeros;
    private int numMotores;
    private String gasolina;
    
    public Avion(){
        numPasajeros = 0;
        numMotores = 0;
        gasolina = "";
    }

    public Avion(char tipo, int ID, String matricula, String marca, String modelo,int numPasajeros, int numMotores, String gasolina) {
        super(tipo, ID, matricula, marca, modelo);
        this.numPasajeros = numPasajeros;
        this.numMotores = numMotores;
        this.gasolina = gasolina;
    }
    
    public void registroAvion(char tipo) {
        registroVehiculo(tipo);
        //variable validar
        boolean validar = true;
        // verifica que se ingrese un tipo correcto de dato
        // se repite el bucle hasta que se ingrese un tipo de dato correcto
        do{
            try{
                System.out.print("Numero de pasajeros: "); numPasajeros = sc.nextInt();
                validar = false;
            }catch(InputMismatchException e){
                System.out.print("Deves ingresar un \"Numero\"\n"); sc.nextLine();
            }
        }while(validar);
        validar = true;
        // verifica que se ingrese un tipo correcto de dato
        // se repite el bucle hasta que se ingrese un tipo de dato correcto
        do{
            try{
                System.out.print("Numero de motores: "); numMotores = sc.nextInt();
                validar = false;
            }catch(InputMismatchException e){
                System.out.print("Deves ingresar un \"Numero\"\n"); sc.nextLine();
            }
        }while(validar);
        boolean gas = true;
        // bucle para validar que se ingrese un tipo correcto de gasolina
        while(gas){
            System.out.print("Gasolina, (disel,regular,super): "); sc.nextLine();
            String aux = sc.nextLine().toLowerCase();
            if(aux.equalsIgnoreCase("disel") || aux.equalsIgnoreCase("regular") || aux.equalsIgnoreCase("super")){
                gasolina = aux;
                gas = false;
            }else{
                System.out.println("Ingrese un tipo correcto de gasolina");
            }
        }
        Avion nuevoAvion = new Avion(tipo,getID(),getMatricula(),getMarca(),getModelo(),numPasajeros,numMotores,gasolina);
        guarVehiculoLista(nuevoAvion);
        clonarLista();
    }
    
    public void infoAvion(int i) {
        System.out.println("\nVehiculo No."+(i+1)+"\nID: "+nuevaLista[i].getID()+
        "\nMatricula: " +nuevaLista[i].getMatricula()+"\nMarca: "+nuevaLista[i].getMarca()+
        "\nModelo: "+nuevaLista[i].getModelo()+"\nNumero de pasajeros: "+((Avion)Vehiculo.nuevaLista[i]).numPasajeros+"\nNumero de motoes: "+
        ((Avion)nuevaLista[i]).numMotores+"\nGasolina: "+((Avion)nuevaLista[i]).gasolina);
    }
}