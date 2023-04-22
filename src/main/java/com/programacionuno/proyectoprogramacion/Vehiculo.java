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
    private String matricula;
    private int ruedas;
    private int puertas;
    private int numPasajeros;
    private boolean motorBote;
    private int[] indexLetras = new int[3];
    private int[] numeros = new int[3];
    protected static Vehiculo[] listaVehiculos = new Vehiculo[10];
    private static Vehiculo[] nuevaLista;

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
        unirMatricula(); //genera la matricula de forma automatica
        this.numPasajeros = pasajeros;
        ID = next;
        temporal--;
        next++;
    }
    
    public Vehiculo(boolean motor) { // ver si tiene motor el bote
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
    
    // guardar el objeto nuevo dentro del array
    public void guardarListaVehiculo(Vehiculo nuevo) {
        listaVehiculos[temporal] = nuevo;
    }

    // clona array de vehiculos para poder utilizarlo
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

    /**
     * @param tipo recibe el tipo que sera el vehiculo P = particular -> Carro M
     * = moto -> Moto B = bote -> Bote
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

    public void infoVehiculo() {
        System.out.println("Es un vehiculo");
    }

    public static class Registros {

        public static void imprimirColumnas() {
            System.out.printf("%-4s | "
                    + "%-10s | "
                    + "%-15s | "
                    + "%-15s | "
                    + "%-10s | "
                    + "%-10s | "
                    + "%-8s | "
                    + "%-8s | "
                    + "%-10s | "
                    + "%-5s\n",
                    "ID",
                    "MATRICULA",
                    "MARCA",
                    "MODELO",
                    "MOTOR",
                    "GASOLINA",
                    "RUEDAS",
                    "PUERTAS",
                    "PASAJEROS",
                    "REMOS");
        }

        public static void listaVehiculos() {
            imprimirColumnas();
            for (Vehiculo vehiculo : listaVehiculos) {
                if (vehiculo == null) {
                    System.out.println("---");
                } else {
                    System.out.printf("%-4d | " // ID
                            + "%-10s | " // matricula
                            + "%-15s | " // marca
                            + "%-15s | " // modelo
                            + "%-10s | " // motor
                            + "%-10s | " // gas
                            + "%-8d | " // ruedas
                            + "%-8d | " // puertas
                            + "%-10d | ", // pasajeros
                            vehiculo.ID,
                            vehiculo.getMatricula(),
                            vehiculo.getMarca(),
                            vehiculo.getModelo(),
                            vehiculo.getMotor(),
                            vehiculo.getGas(),
                            vehiculo.getRuedas(),
                            vehiculo.getPuertas(),
                            vehiculo.getNumPasajeros());

                    if (vehiculo instanceof Bote && ((Bote) vehiculo).getIsRemos()) {
                        System.out.printf("%-2s\n", "si");
                    } else {
                        System.out.printf("%-2s\n", "no");
                    }
                }
            }
        }

        public static void listaVehiculosDescendente() {
            imprimirColumnas();
            for (int i = nuevaLista.length - 1; i >= 0; i--) {
                if (nuevaLista[i] == null) {
                    System.out.println("---");
                } else {
                    System.out.printf("%-4d | "
                            + "%-10s | "
                            + "%-15s | "
                            + "%-15s | "
                            + "%-10s | "
                            + "%-10s | "
                            + "%-8d | "
                            + "%-8d | "
                            + "%-10d |",
                            nuevaLista[i].ID,
                            nuevaLista[i].getMatricula(),
                            nuevaLista[i].getMarca(),
                            nuevaLista[i].getModelo(),
                            nuevaLista[i].getMotor(),
                            nuevaLista[i].getGas(),
                            nuevaLista[i].getRuedas(),
                            nuevaLista[i].getPuertas(),
                            nuevaLista[i].getNumPasajeros());

                    if (nuevaLista[i] instanceof Bote && ((Bote) nuevaLista[i]).getIsRemos()) {
                        System.out.printf("%-2s\n", "si");
                    } else {
                        System.out.printf("%-2s\n", "no");
                    }
                }
            }
        }
    }
}
