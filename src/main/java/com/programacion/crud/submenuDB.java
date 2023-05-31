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

    public void opcionCrud(int op) {
        switch (op) {
            case 1:
                Crear newCar = new Crear();
                newCar.guardarCarro();
                break;
            case 2:
                Read lista = new Read();
                lista.listarCarros();
                break;
            case 3:
                Read buscar = new Read();
                buscar.buscarCarro();
                break;
            case 4:
                Update update = new Update();
                update.ActualizarCarro();
                break;
            case 5:

                break;
            default:
                System.out.println("Opcion no valida...");
        }

    }

    public void seleccionSubMenu(char opcion) {
        Scanner sc = new Scanner(System.in);
        int accion;
        switch (opcion) {
            case 'a':
                System.out.println("1. Crear");
                System.out.println("2. Mostrar todos");
                System.out.println("3. Buscar por ID");
                System.out.println("4. Editar");
                System.out.println("5. Eliminar");
                System.out.print("\nDigita tu opcion: ");
                accion = sc.nextInt();
                opcionCrud(accion);
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
