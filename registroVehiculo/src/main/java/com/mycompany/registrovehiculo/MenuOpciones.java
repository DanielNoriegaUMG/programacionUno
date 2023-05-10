/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.registrovehiculo;

/**
 *
 * @author Sojuel
 */
import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuOpciones {

    private int fase = 0;
    private char opcion;
    private boolean validar;

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public char getOpcion() {
        return opcion;
    }

    public void setOpcion(char opcion) {
        this.opcion = opcion;
    }

    Carro carro = new Carro();
    Balsa balsa = new Balsa();
    Avion avion = new Avion();
    Vehiculo vehiculo = new Vehiculo();

    public void menuFaceUno() {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n----- MENU FACE 1 -----");
            System.out.println("a) Ingresar un nuevo vehiculos");
            System.out.println("b) Mostrar datos del vehiculo");
            System.out.println("c) Crear una torre de Hanoi");
            System.out.println("d) Regresar al menu principal");
            System.out.print("Ingresa una opcion: ");
            //sc.nextLine();
            setOpcion(sc.next().charAt(0));
            opcionesFaseUno(Character.toLowerCase(getOpcion()));
        } while (validar);
    }

    // menu de opciones para facae uno
    public void opcionesFaseUno(char opcion) {
        switch (opcion) {
            case 'a':
                //Registra el tipo de vehiculo a ingresar
                tipoBehiculo();
                validar = true;
                break;
            case 'b':
                //Mostrar datos del ultimo vehiculo
                if (vehiculo.nuevaLista == null) {
                    System.out.println("\nNo hay vehiculos registrados");
                } else {
                    int p = (vehiculo.contador) - 1;
                    char tipo = vehiculo.nuevaLista[(p)].getTipo();
                    switch (tipo) {
                        case 'P':
                            carro.infoCarro(p);
                            break;
                        case 'B':
                            balsa.infoBalsa(p);
                            break;
                        case 'A':
                            avion.infoAvion(p);
                            break;
                        default:
                            System.out.println("Ocurrio un error inesperado ");
                            break;
                    }
                }
                validar = true;
                break;
            case 'c':
                TorreHanoi();
                validar = true;
                break;
            case 'd':
                // Regresar al Menu
                menuDeOpciones();
                validar = false;
                break;
            default:
                //si se ingreso una opocion invalida
                System.out.println("\nDeves Ingresar una Opcion Valida");
                validar = true;
        }
    }

    // metodo para ingresar vehiculos
    public void tipoBehiculo() {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n----- INGRESO DE VEHICULO -----");
            System.out.println("a) Carro");
            System.out.println("b) Balsa");
            System.out.println("c) Avion");
            System.out.println("d) Regresar al menu face 1");
            System.out.print("Ingresa una opcion: ");
            validar = true;
            if (vehiculo.getContador() < 10) {
                switch (Character.toLowerCase(sc.next().charAt(0))) {
                    case 'a':
                        carro.registroCarro('P');
                        break;
                    case 'b':
                        balsa.registroBalsa('B');
                        break;
                    case 'c':
                        avion.registroAvion('A');
                        break;
                    case 'd':
                        validar = false;
                        break;
                    default:
                        validar = true;
                        break;
                }
            } else {
                System.out.println("\n¡¡¡No puedes ingresar mas \"Vehiculos\"!!!");
                validar = false;
            }
        } while (validar);
    }

    // metodo de mobimientos para completar torre de hanoi
    public void TorreHanoi() {
        int numero = 0;
        Hanoi Torre = new Hanoi();
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("\n--------- Torre de Hanoi ---------\n");
                System.out.println("Debes ingresar al menos 3 aros");
                System.out.println("Ingrese el numero de aros: ");
                numero = sc.nextInt();
                if (numero < 3) {
                    System.out.println("El numero minimo de aros es de 3");
                }
            } catch (InputMismatchException e) {
                //sc.nextLine();
                System.out.println("Debes de ingresar un numero, intentalo de nuevo\n");
            }
        } while (numero < 3);
        Torre.Hanoi(numero, 1, 2, 3);
    }

    //codigo de segunda face-----------------------------------------------------------------------------
    public void menuFaceDos() {
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n----- MENU FACE 2 -----");
            System.out.println("a) Agregar Carro");
            System.out.println("b) Agregar Balsa");
            System.out.println("c) Agregar Avion");
            System.out.println("d) Ordenar Arreglo");
            System.out.println("e) Mostrar Arreglo");
            System.out.println("f) Buscar un Vehiculo");
            System.out.println("g) Regresar al menu principal");
            System.out.print("Ingresa una opcion: ");
            setOpcion(sc.next().charAt(0));
            opcionesFaseDos(Character.toLowerCase(getOpcion()));
        } while (validar);
    }

    // metodo menu de opciones para face 2
    public void opcionesFaseDos(char opcion) {
        if (opcion == 'a' || opcion == 'b' || opcion == 'c') {
            ingresoFaseDos(opcion);
        }
        switch (opcion) {
            case 'd':
                // Ordenar Arreglo
                ordenarArreglo();
                System.out.println("\n¡¡¡Arreglo Ordenado Exitosamente!!!");
                validar = true;
                break;
            case 'e':
                // Mostrar Todo el Arreglo
                if(vehiculo.getContador()==0){
                    System.out.println("\n¡¡¡Aun no hay Vehiculos Registrados!!!");
                }
                for (int i = 0; i < vehiculo.getContador(); i++) {
                    infoVehiculo(i);
                }
                validar = true;
                break;
            case 'f':
                // Buscar Vehiculo
                buscarVehiculo();
                validar = true;
                break;
            case 'g':
                // regresar al Menu
                menuDeOpciones();
                validar = false;
        }
    }

    // metodo para ingresar vehiculos segun opcion
    public void ingresoFaseDos(char opcion) {
        // valida que no se ingresen mas de 10 vehiculos
        if (vehiculo.getContador() < 10) {
            switch (opcion) {
                case 'a':
                    // Ingresar un Carro
                    carro.registroCarro('P');
                    validar = true;
                    break;
                case 'b':
                    // Ingresar una Balsa
                    balsa.registroBalsa('B');
                    validar = true;
                    break;
                case 'c':
                    // Ingresar un Avion
                    avion.registroAvion('A');
                    validar = true;
                    break;
            }
        } else {
            System.out.println("\n¡¡¡No puedes ingresar mas \"Vehiculos\"!!!");
        }
    }

    // ordena el arreglo de manera ascendente segun ID
    private void ordenarArreglo() {
        // itera a traves de Contador - 1
        for (int i = 0; i < vehiculo.getContador(); i++) {
            int masPequeño = i; // primer indice del resto del arreglo
            // itera para buscar el indice del elemento mas pequeño
            for (int indice = i + 1; indice < vehiculo.getContador(); indice++) {
                if (vehiculo.nuevaLista[indice].getID() < vehiculo.nuevaLista[masPequeño].getID()) {
                    masPequeño = indice;
                }
            }
            intercambiar(vehiculo.nuevaLista, i, masPequeño); //intercambia el elemento mas pequeño en la posicion
        }
    }

    // intercambia la posicion de los datos en el arreglo
    private static void intercambiar(Vehiculo[] datos, int primero, int segundo) {
        Vehiculo[] temporal = new Vehiculo[1];
        temporal[0] = datos[primero]; // almacenamiento primero en temporal
        datos[primero] = datos[segundo]; // sustituya primero con el segundo
        datos[segundo] = temporal[0]; // coloca temporal en segundo
    }

    // metodo para buscar vehiculo por ID
    private int busqueda(int clave) {
        for (int i = 0; i < vehiculo.getContador(); i++) {
            if (vehiculo.nuevaLista[i].getID() == clave) {
                return i;
            }
        }
        return -1;
    }

    // metodo para buscar vehiculo por matricula
    private int busquedaMatricula(String matricula) {
        for (int i = 0; i < vehiculo.getContador(); i++) {
            if (vehiculo.nuevaLista[i].getMatricula().equals(matricula)) {
                return i;
            }
        }
        return -1;
    }

    // Metodo para buscar un vehiculo
    public void buscarVehiculo() {
        Scanner sc = new Scanner(System.in);
        boolean validarB;
        int op = 0;
        // verifica que se ingrese un dato numerico
        do {
            try {
                System.out.println("\n1) Buscar Vehiculo por ID");
                System.out.println("2) Buscar Vehiculo por Matricula");
                System.out.print("Digite una Opcion: ");
                op = sc.nextInt();
                // valida que la opcioningresada sea 1 o 2
                if (op == 1 || op == 2) {
                    sc.nextLine();
                    validarB = false;
                } else {
                    System.out.println("Debes eligir 1 o 2");
                    sc.nextLine();
                    validarB = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Deves Ingresar un \"NUMERO\"");
                sc.nextLine();
                validarB = true;
            }
        } while (validarB);
        switch (op) {
            case 1:
                int clave = 0;
                // valida que se ingrese un dato numerico
                do {
                    try {
                        System.out.print("\nIngrese el ID de Vehiculo a Buscar: ");
                        clave = sc.nextInt();
                        validarB = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Deves Ingresar un \"NUMERO\"");
                        sc.nextLine();
                        validarB = true;
                    }
                } while (validarB);
                // posI = pocicion del vehiculo si existe en el arreglo
                int posI = busqueda(clave);
                if (posI > -1) {
                    // imprime la informacion del vehiculo encontrado
                    infoVehiculo(posI);
                } else {
                    System.out.println("\n¡¡¡Vehiculo no registrado!!!");
                }
                sc.nextLine();
                break;
            case 2:
                System.out.print("Ingrese la Matricula de Vehiculo a Buscar: ");
                // posM = pocicion del vehiculo si existe en el arreglo
                int posM = busquedaMatricula(sc.nextLine());
                if (posM > -1) {
                    // imprime la informacion del vehiculo encontrado
                    infoVehiculo(posM);
                } else {
                    System.out.println("\n¡¡¡Vehiculo no registrado!!!");
                }
                break;
        }
    }

    // Metodo para mostrar datos del arreglo de vehiculos
    public void infoVehiculo(int i) {
        char tipo = vehiculo.nuevaLista[i].getTipo();
        switch (tipo) {
            case 'P':
                carro.infoCarro(i);
                break;
            case 'B':
                balsa.infoBalsa(i);
                break;
            case 'A':
                avion.infoAvion(i);
                break;
        }
    }

    // Codigo que ejecuta el programa ------------------------------------------
    public void menuPrincipal() {
        validar = true;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("\n----- MENU DE OPCIONES -----");
                System.out.println("1) Fase 1 – Objetos y recursividad");
                System.out.println("2) Fase 2 - Arreglos");
                System.out.println("3) Fase 3");
                System.out.println("4) Salir del del programa");
                System.out.print("Ingresa una opcion: ");
                setFase(sc.nextInt());
                validar = false;
            } catch (InputMismatchException e) {
                System.out.println("Deves Ingresar un \"NUMERO\"");
                validar = true;
            } catch (Exception e) {
                System.out.print("Ocurrio un error inesperado...");
                validar = true;
            }
        } while (validar);
    }

    public void menuDeOpciones() {
        do {
            try {
                menuPrincipal();
                switch (getFase()) {
                    case 1:
                        menuFaceUno();
                        break;
                    case 2:
                        menuFaceDos();
                        break;
                    case 3:
                        System.out.println("\nProximamente...");
                        break;
                    case 4:
                        System.out.println("\nSaliendo del sistema....");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("\nHasta pronto!!!!");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("La opcion no exixte");
                        break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(MenuOpciones.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (getFase() != 4);
    }
}
