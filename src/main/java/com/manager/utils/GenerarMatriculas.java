/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.manager.utils;

import com.programacion.db.Cars;
import com.programacionuno.proyectoprogramacion.Letras;

/**
 *
 * @author Daniel Noriega UMG
 */
public class GenerarMatriculas {
    private int[] indexLetras = new int[3];
    private int[] numeros = new int[3];

    //Para generar index de letras random
    public int[] randomLetrasMatricula() {
        for (int i = 0; i < 3; i++) {
            //indice de una letra random->matricula
            int letrasRandom = (int) Math.floor(Math.random() * 25);
            this.indexLetras[i] = letrasRandom;
        }
        return indexLetras;
    }

    public int[] randomNumerosMatricula() {
        //Para generar una numeros random
        for (int i = 0; i < 3; i++) {
            int numerosRandom = (int) Math.floor(Math.random() * 9);//numeros para la matricula
            this.numeros[i] = numerosRandom;
        }
        return numeros;
    }
    
    public String nuevaMatricula(String tipo) {
        int[] indexLetras = randomLetrasMatricula();
        int[] numeros = randomNumerosMatricula();
        Object[] matriculas = new Object[indexLetras.length + numeros.length];

        // Copiar letras
        for (int i = 0; i < indexLetras.length; i++) {
            matriculas[i] = Letras.values()[indexLetras[i]];
        }

        // Copiar números
        for (int i = 0; i < numeros.length; i++) {
            matriculas[i + indexLetras.length] = numeros[i];
        }

        // Concatenar los elementos en un solo String
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matriculas.length; i++) {
            sb.append(matriculas[i]);
        }
        return tipo + "-" + sb.toString();
    }
}
