/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrovehiculo;

/**
 *
 * @author Usuario
 */
public class Hanoi {
    //procedimiento de torre de hanoi
    public void Hanoi(int numero, int inicio, int temporal, int fin){
        if(numero == 1){
            System.out.println("Columna " + inicio + " ---> Columna "+fin);
        }
        else{
            Hanoi(numero -1, inicio, fin, temporal);
            System.out.println("Columna " + inicio+" ---> Columna " + fin);
            Hanoi(numero -1, temporal,inicio, fin);
        }
    }
}
