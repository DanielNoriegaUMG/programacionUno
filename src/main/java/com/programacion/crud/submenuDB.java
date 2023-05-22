/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.programacion.crud.Crear;
import java.util.Scanner;

/**
 *
 * @author Daniel Noriega UMG
 */
public class submenuDB {

    public void seleccionar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba la letra de inciso para ingresar");
        MostrarSubMenu();
        seleccionSubMenu(sc.next().charAt(0));
    }

    public void MostrarSubMenu() {
        System.out.println("a: Trabajar con Carros");
        System.out.println("b: Trabajar con Balsas");
        System.out.println("c: Trabajar con Aviones");
        System.out.println("d: Regresar al menu principal");
        System.out.print("\nDigite la opcion: ");
    }

    public void seleccionSubMenu(char opcion) {
        switch (opcion) {
            case 'a':
                Crear newCar = new Crear();
                newCar.guardarCarro();
                break;
            case 'b':

                break;
            case 'c':

                break;
            case 'd':

                break;
            default:
                throw new AssertionError();
        }
    }
}
