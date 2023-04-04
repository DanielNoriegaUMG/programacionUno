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
    private String motor;
    private String modelo;
    private String marca;
    private String tipo;
    private String tipoVehiculo;
    private int ruedas;
    private int puertas;
    private boolean motorBote;
    int[] indexLetras = new int[3];
    int[] numeros = new int[3];
    protected Vehiculo[] listaVehiculos = new Vehiculo[10];
    private static Vehiculo[] nuevaLista;

    public Vehiculo() {
//        this.ID = next;
//        next++;
//        this.modelo = "";
//        this.marca = "";
//        this.tipo = "";
//        this.motorBote = false;
    }

    public Vehiculo(String gas, String motor, String modelo, String marca, String tipo, int ruedas, int puertas) {
        this.gas = gas;
        this.motor = motor;
        this.modelo = modelo;
        this.marca = marca;
        this.tipo = tipo;
        this.ruedas = ruedas;
        this.puertas = puertas;
        ID = next;
        temporal--;
        next++;
    }

    public Vehiculo(boolean motor) { // ver si tiene motor el bote
        this.motorBote = motor;
    }

    public void guardarListaVehiculo(Vehiculo nuevo) {
        listaVehiculos[temporal] = nuevo;
    }

    public void clonarLista() {
        nuevaLista = listaVehiculos.clone();
        temporal = next;
    }

    public void mostrarListaVehiculos() {
        for (Vehiculo lista : nuevaLista) {
            if (lista == null) { // Verificar si el objeto no es null
                System.out.println("Vacio");
            } else {
                System.out.println("ID\t" + "|\tMARCA\t|" + "\tMODELO\t" + "|\tMOTOR\t|" + "\tGASOLINA\t" + "|\tRUEDAS\t|");
                System.out.print(lista.ID + "\t");
                System.out.print("\t" + lista.getMarca() + "\t");
                System.out.print("\t" + lista.getModelo() + "\t");
                System.out.print("\t" + lista.getMotor() + "\t");
                System.out.print("\t" + lista.getGas() + "\t");
                if (lista.getRuedas() == 0) {
                    System.out.print("\t" + "No tiene ruedas\t");
                } else {
                    System.out.println("\t" + lista.getRuedas() + "\t");
                }
            }
        }
    }

    public boolean isMotorBote() {
        return this.motorBote;
    }

    public void setMotorBote(boolean motor) {
        this.motorBote = motor;
    }

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

    public void imprimirMatricula() {
        Letras[] letras = Letras.values();
        System.out.print("Matricula: " + getTipo() + "-");
        //imprimir letras
//        for (int i = 0; i < 3; i++) {
//            System.out.print(letras[indexLetras[i]]);
//
//        }
//        //imprimir numeros del 0 al 9
//        for (int i = 0; i < 3; i++) {
//            System.out.print(numeros[i]);
//        }
//        System.out.println("\n");
    }
    
    public Object[] unirMatricula(){
        int[] indexLetras = randomLetrasMatricula();
        int[] numeros = randomNumerosMatricula();
        Object[] matriculas = new Object[indexLetras.length + numeros.length];
        // System.out.println("\n");

        // src = Arreglo de origen
        // srcPos = Posicion de inicio del parametro 1
        // dest = Arreglo de destino
        // destPos = Posiion de inicio del arreglo de parametro 3
        // length = Numero de elementos a copiar
        // arracopy(src, srcPos, dest, destPos, length)
        System.arraycopy(indexLetras, 0, matriculas, 0, indexLetras.length);
        System.arraycopy(numeros, 0, matriculas, indexLetras.length, numeros.length);
        return matriculas;
    }

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

    public void infoVehiculo() {
        System.out.println("Es un vehiculo");
    }
}
