/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrovehiculo;


/**
 *
 * @author Sojuel
 */
public class Carro extends Vehiculo {
    private String motor;
    private String gasolina;
    private int ruedas;
    
    public Carro(){
        
    }

    public Carro(char tipo, int ID, String matricula, String marca, String modelo,String motor, String gasolina, int ruedas) {
        super(tipo, ID, matricula, marca, modelo);
        this.motor = motor;
        this.gasolina = gasolina;
        this.ruedas = ruedas;
    }
    
    public void registroCarro(char tipo) {
        registroVehiculo(tipo);
        boolean validar = true;
        do{
            System.out.print("Motor: ");motor = sc.nextLine();
            if(!motor.equals("")){
                validar=false;
            }
        }while(validar);
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
        
        Carro nuevoCarro = new Carro(tipo,getID(),getMatricula(),getMarca(),getModelo(),motor,gasolina,4);
        guarVehiculoLista(nuevoCarro);
        clonarLista();
    }
    
    public void infoCarro(int i) {
        System.out.println("\nVehiculo No."+(i+1)+"\nID: "+nuevaLista[i].getID()+
        "\nMatricula: " +nuevaLista[i].getMatricula()+"\nMarca: "+Vehiculo.nuevaLista[i].getMarca()+
        "\nModelo: "+nuevaLista[i].getModelo()+"\nMotor: "+((Carro)nuevaLista[i]).motor+"\nGasolina: "+
        ((Carro)nuevaLista[i]).gasolina+"\nRuedas: "+((Carro)nuevaLista[i]).ruedas);

    }
}