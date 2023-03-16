package com.programacionuno.proyectoprogramacion;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Daniel Noriega
 */
public class MenuOpciones {

    Carro carro = new Carro();
    Moto moto = new Moto();
    Avion avion = new Avion();
    Tren tren = new Tren();
    Bote bote = new Bote();

    private char opcion;
    private boolean creado;
    private String tipoVehiculo;
    

    Scanner sc = new Scanner(System.in);

    private void setCreado(boolean creado){
        this.creado = creado;
    }
    
    private boolean isCreado(){
        return this.creado;
    }
    
    public void setTipoVehiculo(String tipo) {
        this.tipoVehiculo = tipo;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public char getOpcion() {
        return opcion;
    }

    public boolean getCreado() {
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
                    mostrarInfo();
                    break;
                case 'c':
                    // Llamada de procedimiento TorreHanoi
                    TorreHanoi();
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

        try {
            if(isCreado()) {
                switch (getTipoVehiculo()) {
                    case "P":
                        carro.infoVehiculo();
                        break;
                    case "M":
                        moto.infoVehiculo();
                        break;
                    case "A":
                        avion.infoVehiculo();
                        break;
                    case "T":
                        tren.infoVehiculo();
                        break;
                    case "B":
                        bote.infoVehiculo();
                        break;
                    default:
                        System.out.println("El tipo de vehiculo no existe...");
                }
            } else {
                System.out.println("Aun no se ha registrado ningun vehiculo");
            }
        } catch (AssertionError e) {
            System.out.println("El tipo de vehiculo no esta dentro de la lista...");
        } catch(Exception e){
            //System.out.println("Ocurrio un error: " + e .getMessage());
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void ingresoDatos(int tipoVehiculo) {
        System.out.println("Ingrese los datos que se solicitan");
        sc.nextLine();
        switch (tipoVehiculo) {
            case 1:
                carro.guardar("P");
                setCreado(true);
                setTipoVehiculo("P");
                regresarSubMenu('a');
                break;
            case 2:
                moto.guardarMoto("M");
                setCreado(true);
                setTipoVehiculo("M");
                regresarSubMenu('a');
                break;
            case 3:
                avion.guardar("A");
                setCreado(true);
                setTipoVehiculo("A");
                regresarSubMenu('a');
                break;
            case 4:
                tren.guardar("T");
                setCreado(true);
                setTipoVehiculo("T");
                regresarSubMenu('a');
                break;
            case 5:
                bote.guardar();
                setTipoVehiculo("B");
                setCreado(true);
                break;
            default:
                throw new AssertionError("Opcion invalida...");
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
                    ingresoDatos(4);
                    break;
                case 5:
                    ingresoDatos(5);
                    break;
                default:
                    System.out.println("Error en menu de vehiculo");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
    
    public void TorreHanoi() {
        int numero=0;
        Hanoi Torre = new Hanoi();
        do{
            try{
                System.out.println("\n--------- Torre de Hanoi ---------\n");
                System.out.println("Debes ingresar al menos 3 aros");
                System.out.println("Ingrese el numero de aros: ");
                numero = sc.nextInt();
                if(numero < 3){
                    System.out.println("El numero minimo de aros es de 3");
                }
            }catch (InputMismatchException e) {
//                System.err.println("\nException: " + e);
                sc.nextLine();
                System.out.println("Debes de ingresar un numero, intentalo de nuevo\n");
            }
        }while(numero<3);
        Torre.Hanoi(numero, 1, 2, 3);
    }
}
