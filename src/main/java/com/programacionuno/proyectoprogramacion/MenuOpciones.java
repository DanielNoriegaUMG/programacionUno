package com.programacionuno.proyectoprogramacion;

import com.programacion.crud.submenuDB;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Daniel Noriega
 */
public class MenuOpciones{

    Scanner sc = new Scanner(System.in);

    // Creacion de objetos privados
    private final Vehiculo vehiculos = new Vehiculo();
    private final Carro carro = new Carro();
    private final Moto moto = new Moto();
    private final Bote bote = new Bote();

    private char opcion;
    private int fase;
    private boolean creado;
    private String tipoVehiculo;

    private void setFase(int opcion) {
        this.fase = opcion;
    }

    private int getFase() {
        return this.fase;
    }

    private void setCreado(boolean creado) {
        this.creado = creado;
    }

    private boolean isCreado() {
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

    public void subMenuFaseUno() {
        boolean validar = true;
        do {
            System.out.println("--------- Submenu --------");
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

    public void subMenuFaseDos() {
        System.out.println("\na. Agregar Carro");
        System.out.println("b. Agregar Moto");
        System.out.println("c. Agregar Bote");
        System.out.println("d. Ordernar arreglo");
        System.out.println("e. Mostrar arreglo");
        System.out.println("f. Regresar");
        System.out.print("\nSeleccione una opcion: ");
        setOpcion(sc.next().charAt(0));
        seleccionFaseDos(getOpcion());
    }

    // seleccionar opcion fase 2
    public void seleccionFaseDos(char opcion) {
        try {
            switch (opcion) {
                case 'a':
                    registroListaVehiculo(opcion); // Carro
                    break;
                case 'b':
                    registroListaVehiculo(opcion); // Moto
                    break;
                case 'c':
                    registroListaVehiculo(opcion); // Avion
                    break;
                case 'd':
                    Vehiculo.Registros.listaVehiculosDescendente();//Para ordenar arreglo
                    System.out.println("\n");
                    break;
                case 'e':
                    Vehiculo.Registros.listaVehiculos(); // mostrar array de vehiculos
                    break;
                case 'f':
                    menuPrincipal();
                    break;
                default:
                    System.out.println("La opcion no existe, intentalo de nuevo...");
            }
        } catch (NullPointerException e) {
            System.out.println("\nAun no has registrado ningun vehiculo\n");
        } catch(IndexOutOfBoundsException e){
            System.out.println("Vehiculo no encontrado...");
        } catch(Exception e){
            System.out.println("Ocurrio un error...");
            System.out.println(e.getMessage());
        }
    }

    public void registroListaVehiculo(char op) {
        try {
            switch (op) {
                case 'a':
                    ingresoDatos(1);
                    break;
                case 'b':
                    ingresoDatos(2);
                    break;
                case 'c':
                    ingresoDatos(3);
                    break;
                case 'd':
                    subMenuFaseUno();
                    break;
                default:
                    System.out.println("Error en menu de vehiculo");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    // Llamada principal
    public void menuPrincipal() {
        boolean salir = true;
        do {
            try {
                System.out.println("1. Primera Fase - Objetos y recursividad");
                System.out.println("2. Fase 2 - Arreglos");
                System.out.println("3. Fase 3 - Base de datos");
                System.out.println("4. Salir del sistema");
                System.out.print("Digite una opcion: ");
                setFase(sc.nextInt());
                switch (getFase()) {
                    case 1:
                        subMenuFaseUno();
                        break;
                    case 2:
                        subMenuFaseDos();
                        break;
                    case 3:
                        submenuDB submenu = new submenuDB();
                        submenu.seleccionar();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Me temo que la opcion no existe...");
                    //salir = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes ingresar un numero...");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (salir);
    }

    // seleccion para fase 1
    public void seleccion(char op) {
        try {
            switch (op) {
                case 'a':
                    System.out.println("Ingreso de datos");
                    System.out.println("a. Nuevo Carro");
                    System.out.println("b. Nueva Moto");
                    System.out.println("c. Nuevo Bote");
                    System.out.println("d. Regresar");
                    setOpcionVehiculo(sc.next().charAt(0));
                    break;
                case 'b':
                    mostrarInfo();
                    break;
                case 'c':
                    // Llamada de procedimiento TorreHanoi
                    TorreHanoi();
                    break;
                case 'd':
                    menuPrincipal();
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

    // opciones para regresar a X submenu
    public void regresarSubMenu() {
        String regresar;
        sc.nextLine();
        int menuFase = getFase();
        System.out.println("Deseas regresar al submenu?");
        System.out.print("(si/no): ");
        regresar = sc.nextLine();
        if(regresar.equalsIgnoreCase("si")){
            switch (menuFase) {
                case 1:
                    subMenuFaseUno();
                    break;
                case 2:
                    subMenuFaseDos();
                    break;
                default:
                    menuPrincipal();
            }
        }else if (regresar.equalsIgnoreCase("no")){
            menuPrincipal();
        }else{
            System.out.println("Error para seleccionar menu, intenta de nuevo...");
            regresarSubMenu();
        }
    }

    
    //mostrar informacion de vehiculo fase 1
    public void mostrarInfo() {
        try {
            if (isCreado()) {
                switch (getTipoVehiculo()) {
                    case "P":
                        carro.infoVehiculo();
                        break;
                    case "M":
                        moto.infoVehiculo();
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
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e .getMessage());
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
                regresarSubMenu();
                break;
            case 2:
                moto.guardarMoto("M");
                setCreado(true);
                setTipoVehiculo("M");
                regresarSubMenu();
                break;
            case 3:
                bote.guardar("B");
                setTipoVehiculo("B");
                setCreado(true);
                regresarSubMenu();
                break;
            default:
                throw new AssertionError("Opcion invalida...");
        }
    }

    public void setOpcionVehiculo(char op) {
        try {
            switch (op) {
                case 'a':
                    ingresoDatos(1); //carro
                    break;
                case 'b':
                    ingresoDatos(2); // moto
                    break;
                case 'c':
                    ingresoDatos(5); // bote
                    break;
                case 'f':
                    subMenuFaseUno();
                    break;
                default:
                    System.out.println("Error en menu de vehiculo");
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public void TorreHanoi() {
        int numero = 0;
        Hanoi Torre = new Hanoi();
        do {
            try {
                System.out.println("\n--------- Torre de Hanoi ---------\n");
                System.out.println("Debes ingresar al menos 3 aros");
                System.out.println("Ingrese el numero de aros: ");
                numero = sc.nextInt();
                if (numero < 3) {
                    System.out.println("El numero minimo de aros es de 3");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.println("Debes de ingresar un numero, intentalo de nuevo\n");
            }
        } while (numero < 3);
        Torre.Hanoi(numero, 1, 2, 3);
    }
}
