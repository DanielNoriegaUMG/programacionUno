/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.programacionuno.proyectoprogramacion.Bote;
import com.programacionuno.proyectoprogramacion.Carro;
import com.programacionuno.proyectoprogramacion.Gasolina;
import java.util.Scanner;

/**
 *
 * @author Daniel Noriega UMG
 */
public class create {

    public void guardarCarro() {
        Scanner sc = new Scanner(System.in);
        Carro carro = new Carro();
        boolean validar = true; //condicion para iniciar el bucle
        String motor, modelo, marca, gas = null;
        System.out.print("Escriba el nombre del motor: ");
        carro.setMotor(sc.nextLine());// motor ultimo modelo 3.2
        System.out.print("Modelo: ");
        carro.setModelo(sc.nextLine());// 2010
        System.out.print("Marca: ");
        carro.setMarca(sc.nextLine().toUpperCase());//KIA
        motor = carro.getMotor();
        modelo = carro.getModelo();
        marca = carro.getMarca();

        do {
            System.out.println("Tipo que gasolina que utiliza");
            System.out.println("(super, diesel, regular, especial): ");
            carro.setGas(sc.nextLine().toUpperCase());
            try {
                Gasolina nombreGas = Gasolina.valueOf(carro.getGas());
                gas = carro.getGas().toLowerCase(); //pasar a minusculas para el array
                validar = false; // salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de gasolina ingresado no existe");
                System.out.println("Intente de nuevo...");
            }
        } while (validar);

        System.out.println("Generando matricula");
        System.out.println("Espere...");
        try {
            carro.unirMatricula();
            Thread.sleep(1000);
            System.out.println("Se registro el carro de forma exitosa!");
        } catch (Exception e) {
        }
    }

    public void guardarBalsa() {
        Bote bote = new Bote();
    }

    public void guardarAvion() {

    }
}
