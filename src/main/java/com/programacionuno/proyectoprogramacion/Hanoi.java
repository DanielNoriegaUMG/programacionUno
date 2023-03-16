package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Sojuel
 */
public class Hanoi {
    //procedimiento de torre de hanoi
    public void Hanoi(int numero, int inicio, int temporal, int fin){
        if(numero == 1){
            System.out.println("Torre: " + inicio + " ---> Torre: "+fin);
        }
        else{
            Hanoi(numero -1, inicio, fin, temporal);
            System.out.println("Torre " + inicio+" ---> Torre " + fin);
            Hanoi(numero -1, temporal,inicio, fin);
        }
    }
}
