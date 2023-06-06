/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.programacion.crud;

import com.programacion.crud.Crear;
import com.programacionuno.proyectoprogramacion.MenuOpciones;
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

    public void opcionCrudCarro(int op) {
        switch (op) {
            case 1:
                Crear newCar = new Crear();
                newCar.guardarCarro();
                break;
            case 2:
                Leer lista = new Leer();
                lista.listarCarros();
                break;
            case 3:
                Leer buscar = new Leer();
                buscar.buscarCarro();
                break;
            case 4:
                Actualizar update = new Actualizar();
                update.ActualizarCarro();
                break;
            case 5:
                Eliminar delete = new Eliminar();
                delete.eliminarCarro();
                break;
            default:
                System.out.println("Opcion no valida...");
        }

    }

    public void opcionCrudBalsa(int op) {
        switch (op) {
            case 1:
                Crear nuevaBalsa = new Crear();
                nuevaBalsa.guardarBalsa();
                break;
            case 2:
                Leer lista = new Leer();
                lista.listarBalsas();
                break;
            case 3:
                Leer buscar = new Leer();
                buscar.buscarBalsa();
                break;
            case 4:
                Actualizar update = new Actualizar();
                update.actualizarBalsa();
                break;
            case 5:
                Eliminar delete = new Eliminar();
                delete.eliminarBalsa();
                break;
            default:
                System.out.println("Opcion no valida...");
        }
    }

    public void opcionCrudAvion(int op) {
        switch (op) {
            case 1:
                Crear nuevoAvion = new Crear();
                nuevoAvion.guardarAvion();
                break;
            case 2:
                Leer lista = new Leer();
                lista.listarAviones();
                break;
            case 3:
                Leer buscar = new Leer();
                buscar.buscarAvion();
                break;
            case 4:
                Actualizar update = new Actualizar();
                update.actualizarAvion();
                break;
            case 5:
                Eliminar delete = new Eliminar();
                delete.eliminarAvion();
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
                imprimirMetodosCRUD();
                accion = sc.nextInt();
                opcionCrudCarro(accion);
                break;
            case 'b':
                imprimirMetodosCRUD();
                accion = sc.nextInt();
                opcionCrudBalsa(accion);
                break;
            case 'c':
                imprimirMetodosCRUD();
                accion = sc.nextInt();
                opcionCrudAvion(accion);
                break;
            case 'd':
                MenuOpciones inicio = new MenuOpciones();
                inicio.menuPrincipal();
                break;
            default:
                System.out.println("Opcion invalida, intentalo de nuevo...");
        }
    }

    private void imprimirMetodosCRUD() {
        System.out.println("1. Crear");
        System.out.println("2. Mostrar todos");
        System.out.println("3. Buscar por ID");
        System.out.println("4. Editar");
        System.out.println("5. Eliminar");
        System.out.print("\nDigita tu opcion: ");
    }
}
