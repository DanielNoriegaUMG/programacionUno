/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Usuario
 */
public class Hanoi {
    //procedimiento de torre de hanoi
    public void Hanoi(int numero, int inicio, int temp, int fin){
        if(numero == 1){
            System.out.println(inicio+" ---> "+fin);
        }
        else{
            Hanoi(numero -1, inicio,fin, temp);
            System.out.println(inicio+" ---> "+fin);
            Hanoi(numero -1, temp,inicio, fin);
        }
    }
}
