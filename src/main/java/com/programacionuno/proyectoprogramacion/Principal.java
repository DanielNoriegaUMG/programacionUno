/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.programacionuno.proyectoprogramacion;

import java.util.Scanner;

/**
 *
 * @author Daniel Noriega
 */
public class Principal {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        //String opcion = " ";
        
        MenuOpciones menu = new MenuOpciones();
        
        System.out.println("--------- Menu --------");
        System.out.println("\na. Ingresar datos de un vehiculo");
        System.out.println("b. mostrar los datos de un vehiculo");
        System.out.println("c. Crear una torre de Hanoi");
        System.out.println("d. Regresar al menu principal");
        System.out.println("e. Salir del sistema");
        
        System.out.print("Ingrese una opcion: ");
        menu.setOpcion(sc.next().charAt(0));
        menu.seleccion();
    }
}
