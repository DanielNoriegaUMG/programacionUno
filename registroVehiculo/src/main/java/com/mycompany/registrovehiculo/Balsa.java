/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrovehiculo;

import java.util.Scanner;

/**
 *
 * @author Sojuel
 */
public class Balsa extends Vehiculo {
    private boolean motor;
    private String impulso;
    private String gasolina;
    
    public Balsa(){
        motor = false;
        impulso = "";
        gasolina = "";
    }

    public Balsa(char tipo, int ID, String matricula, String marca, String modelo, String impulso, String gasolina) {
        super(tipo, ID, matricula, marca, modelo);
        this.impulso = impulso;
        this.gasolina = gasolina;
    }

    public void registroBalsa(char tipo) {
        registroVehiculo(tipo);
        String auxM;
        System.out.print("El bote utiliza motor (si/no): "); auxM = sc.nextLine();
        if(auxM.equalsIgnoreCase("si")){
            motor = true;
            boolean gas = true;
            while(gas){
                System.out.print("Gasolina, (disel,regular,super): ");
                String aux = sc.nextLine().toLowerCase();
                if(aux.equalsIgnoreCase("disel") || aux.equalsIgnoreCase("regular") || aux.equalsIgnoreCase("super")){
                    gasolina = aux;
                    gas = false;
                }else{
                    System.out.println("Ingrese un tipo correcto de gasolina");
                }
            }
        impulso = "Motor";
        }else{
            gasolina = "No usa";
            impulso = "Remos";
        }
        Balsa nuevoBalsa = new Balsa(tipo,getID(),getMatricula(),getMarca(),getModelo(),impulso,gasolina);
        guarVehiculoLista(nuevoBalsa);
        clonarLista();
    }
    
    public void infoBalsa(int i) {
        System.out.println("\nVehiculo No."+(i+1)+"\nID: "+nuevaLista[i].getID()+
        "\nMatricula: " +nuevaLista[i].getMatricula()+"\nMarca: "+nuevaLista[i].getMarca()+
        "\nModelo: "+nuevaLista[i].getModelo()+"\nImpulso: "+((Balsa)nuevaLista[i]).impulso+"\nGasolina: "+
        ((Balsa)nuevaLista[i]).gasolina);
    }
}