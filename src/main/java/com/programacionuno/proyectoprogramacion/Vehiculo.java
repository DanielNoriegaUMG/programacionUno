package com.programacionuno.proyectoprogramacion;

import java.util.Scanner;

/**
 *
 * @author Daniel Noriega
 */
public class Vehiculo {

    Scanner sc = new Scanner(System.in);
    private static int next = 1;
    protected static int temporal = next;
    protected int ID;
    private String gas;
    protected String motor;
    private String modelo;
    private String marca;
    private String tipo;
    private int ruedas;
    private int puertas;
<<<<<<< HEAD
    private String matricula;
    private boolean motorBote;
    private int[] indexLetras = new int[3];
    private int[] numeros = new int[3];
    protected Vehiculo[] listaVehiculos = new Vehiculo[10];
    private static Vehiculo[] nuevaLista;
=======
    private int numPasajeros;
    private boolean motorBote;
    int[] indexLetras = new int[3];
    int[] numeros = new int[3];
    private static Vehiculo[] listaVehiculos = new Vehiculo[10];
    protected static Vehiculo[] nuevaLista;
>>>>>>> a9fb2ad2021f0cf819fc7ac6f8c3a554018830b2

    public Vehiculo() {

    }

    public Vehiculo(String gas, String motor, String modelo, String marca, String tipo, int ruedas, int puertas, int pasajeros) {
        this.gas = gas;
        this.motor = motor;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
        this.ruedas = ruedas;
        this.puertas = puertas;
<<<<<<< HEAD
        unirMatricula(); //genera la matricula de forma automatica
=======
        this.numPasajeros = pasajeros;
        unirMatricula();
>>>>>>> a9fb2ad2021f0cf819fc7ac6f8c3a554018830b2
        ID = next;
        temporal--;
        next++;
    }

    public Vehiculo(boolean motor) { // ver si tiene motor el bote
        this.motorBote = motor;
    }
<<<<<<< HEAD
    
    public boolean isMotorBote() {
        return this.motorBote;
    }

    public void setMotorBote(boolean motor) {
        this.motorBote = motor;
    }
=======
>>>>>>> a9fb2ad2021f0cf819fc7ac6f8c3a554018830b2

    public void setGas(String gas) {
        this.gas = gas;
    }

    public String getGas() {
        return this.gas;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getRuedas() {
        return ruedas;
    }

    public void setRuedas(int ruedas) {
        this.ruedas = ruedas;
    }

    public int getPuertas() {
        return puertas;
    }
    
    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }
        
    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
    
<<<<<<< HEAD
=======
    // guardar el objeto nuevo dentro del array
>>>>>>> a9fb2ad2021f0cf819fc7ac6f8c3a554018830b2
    public void guardarListaVehiculo(Vehiculo nuevo) {
        listaVehiculos[temporal] = nuevo;
    }

<<<<<<< HEAD
=======
    // clona array de vehiculos para poder utilizarlo
>>>>>>> a9fb2ad2021f0cf819fc7ac6f8c3a554018830b2
    public void clonarLista() {
        nuevaLista = listaVehiculos.clone();
        temporal = next;
    }

    public int[] randomLetrasMatricula() {
        //Para generar index de letras random
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

    //imprime la matricula de la fase 1
    public void imprimirMatricula() {
        Letras[] letras = Letras.values();
        System.out.print("Matricula: " + getTipo() + "-");
        //imprimir letras
        for (int i = 0; i < 3; i++) {
            System.out.print(letras[indexLetras[i]]);

        }
        //imprimir numeros del 0 al 9
        for (int i = 0; i < 3; i++) {
            System.out.print(numeros[i]);
        }
    }

    // Une los arreglos de la matricula (randomLetras y randomNumeros)
    public void unirMatricula() {
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
        setMatricula(getTipo() + "-" + sb.toString());
    }

<<<<<<< HEAD
    public void guardarVehiculo(String tipo) {
        if (tipo == "P" || tipo == "TC" || tipo == "T" || tipo == "M" || tipo == "A") {
            System.out.print("Escriba el nombre del motor: ");
            setMotor(sc.nextLine());// motor ultimo modelo 3.2
            System.out.print("Modelo: ");
            setModelo(sc.nextLine());// 2010
            System.out.print("Marca: ");
            setMarca(sc.nextLine().toLowerCase());//KIA
            setTipo(tipo);
        }
    }

    public void mostrarListaVehiculos() {
        System.out.println("ID\t|" + "\tMATRICULA\t" + "|\tMARCA\t|" + "\tMODELO\t" + "|\tMOTOR\t|" + "\tGASOLINA\t" + "|\tRUEDAS\t |");
        for (Vehiculo lista : nuevaLista) {
            if (lista == null) { // Verificar si el objeto no es null
                System.out.println("---");
            } else {                
                System.out.print(lista.ID + "\t");
                System.out.print("\t" + lista.getMatricula() + "\t");
                System.out.print("\t" + lista.getMarca() + "\t");
                System.out.print("\t" + lista.getModelo() + "\t");
                System.out.print("\t" + lista.getMotor() + "\t");
                System.out.print("\t" + lista.getGas() + "\t");
                if (lista.getRuedas() == 0) {
                    System.out.print("\t" + "No tiene ruedas\t");
                } else {
                    System.out.print("\t\t" + lista.getRuedas() + "\t\t");
                }
            }
        }
    }
    
=======
    // Imprime el array de vehiculos de la fase 2
    public void mostrarListaVehiculos() {
        System.out.println("\nID  |" + "\tMATRICULA\t" + "|\t\tMARCA\t\t|" + "\t\tMODELO\t\t" + "|\tMOTOR\t\t|" + "\tGASOLINA\t"
                + "|\tRUEDAS\t\t|" + "\tPUERTAS\t\t" + "|\tPASAJEROS\t|");
    }

    /**
     * @param tipo recibe el tipo que sera el vehiculo
     * P = particular -> Carro
     * M = moto -> Moto
     * B =  bote -> Bote
     */
    public void guardarVehiculo(String tipo) {
        if (tipo == "P" || tipo == "M") {
            System.out.print("Escriba el nombre del motor: ");
            setMotor(sc.nextLine());// motor ultimo modelo 3.2
            System.out.print("Modelo: ");
            setModelo(sc.nextLine());// 2010
            System.out.print("Marca: ");
            setMarca(sc.nextLine().toUpperCase());//KIA
            setTipo(tipo);
        }
    }

>>>>>>> a9fb2ad2021f0cf819fc7ac6f8c3a554018830b2
    public void infoVehiculo() {
        System.out.println("Es un vehiculo");
    }
}
