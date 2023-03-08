package com.programacionuno.proyectoprogramacion;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Daniel Noriega
 */
public class MenuOpciones{
    
    Carro carro = new Carro();
    Moto moto = new Moto();
    Avion avion = new Avion();

    private char opcion;
    private boolean creado;
    private String tipoVehiculo;
    
    Scanner sc = new Scanner(System.in);

    public void setTipoVehiculo(String tipo){
        this.tipoVehiculo = tipo;
    }
    
    public String getTipoVehiculo(){
        return tipoVehiculo;
    }
    
    public char getOpcion() {
        return opcion;
    }
    
    public void setCreado(boolean creado){
        this.creado = creado;
    }
    
    public boolean getCreado(){
        return this.creado;
    }

    public void setOpcion(char opcion) {
        this.opcion = Character.toLowerCase(opcion);
    }

    public void menuPrincipal() {
        boolean validar = true;
        do {
            System.out.println("--------- Menu --------");
            System.out.println("\na. Ingresar datos de un vehiculo");
            System.out.println("b. Mostrar los datos de un vehiculo");
            System.out.println("c. Crear una torre de Hanoi");
            System.out.println("d. Regresar al menu principal");
            System.out.println("e. Salir del sistema");

            System.out.print("Ingrese una opcion: ");
            setOpcion(sc.next().charAt(0));
            seleccion(getOpcion());
            validar = false;
        } while (!validar);
    }

    public void seleccion(char op) {
        try {
            switch (op) {
                case 'a':
                    System.out.println("Ingreso de datos");
                    System.out.println("1. Nuevo Carro");
                    System.out.println("2. Nueva Moto");
                    System.out.println("3. Nuevo Avion");
                    System.out.println("4. Nuevo Tren");
                    System.out.println("5. Nuevo Bote");
                    setOpcionVehiculo(sc.nextInt());
                    break;
                case 'b':
                    //System.out.println("Mostrar datos");
                    mostrarInfo();
                    break;
                case 'c':
                    System.out.println("Torre de Hanoi");
                    break;
                case 'd':
                    System.out.println("Regresar al menu principal");
                    break;
                case 'e':
                    System.out.println("Saliendo");
                    System.exit(0);
                    break;
                default:
                    System.out.println("La opcion que ingresaste no existe...");
            }
        } catch (InputMismatchException e) {
            System.out.println("Debes de ingresar un numero");
        }

    }

    public void regresarSubMenu(char op) {
        String regresar;
        sc.nextLine();
        System.out.println("Deseas regresar al submenu?");
        System.out.print("(si/no): ");
        regresar = sc.nextLine();
        if (regresar.equalsIgnoreCase("si")) {
            setOpcion(op);
            seleccion(getOpcion());
        } else {
            menuPrincipal();
        }

    }

    public void mostrarInfo() {
        
        if (getCreado()) {
            switch (getTipoVehiculo()) {
                case "P":
                    carro.infoVehiculo();
                    break;
                case "M":
                    moto.infoVehiculo();
                    break;
                case "TC":
                    avion.infoVehiculo();
                    break;
                /*case "T":
                    Tren tren = new Tren();
                    tren.infoVehiculo();
                    break;
                case "B":
                    Bote bote = new Bote();
                    bote.infoVehiculo();
                    break;*/
                default:
                    throw new AssertionError();
            }
        }else{
            System.out.println("Aun no se ha registrado ningun vehiculo");
        }
    }

    public void ingresoDatos(int tipoVehiculo) {
        System.out.println("Ingrese los datos que se solicitan");
        switch (tipoVehiculo) {
            case 1:
                carro.guardar("P");
                setCreado(true);
                setTipoVehiculo("P");
                regresarSubMenu('a');
                break;
            case 2:
                moto.guardarMoto("M");
                regresarSubMenu('a');
                System.out.println("Mostrar datos");
                break;
            case 3:
                avion.guardar("A");
                regresarSubMenu('a');
                break;
            case 4:

                break;
            case 5:
                
                break;
            default:
                throw new AssertionError();
        }
    }

    public void setOpcionVehiculo(int op) {
        try {
            switch (op) {
                case 1:
                    ingresoDatos(1);
                    break;
                case 2:
                    ingresoDatos(2);
                    break;
                case 3:
                    ingresoDatos(3);
                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                /*default:
                    System.out.println("Error en menu de vehiculo");*/
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}
