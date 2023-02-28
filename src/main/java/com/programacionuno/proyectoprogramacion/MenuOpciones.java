/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class MenuOpciones extends Object {

    private char opcion;

    public MenuOpciones() {

    }

//    public MenuOpciones(String opcion) {
//        this.opcion = opcion;
//    }

    public char getOpcion() {
        return opcion;
    }

    public void setOpcion(char opcion) {
        this.opcion = Character.toLowerCase(opcion);
    }
    
    public void seleccion() {
        switch (this.opcion){
            case 'a':
                System.out.println("Ingreso de datos");
                break;
            case 'b':
                System.out.println("Mostrar datos");
                break;
            case 'c':
                System.out.println("Torre de Hanoi");
                break;
            case 'd':
                System.out.println("Regresar al menu principal");
                break;
            case 'e':
                System.out.println("Saliendo");
                System.exit(1);
                break;
            default:
                System.out.println("Error de opcion");
        }
    }

}
