package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Avion extends Vehiculo {

    private int numPasajeros;
    private int ruedas;
    private String gas;

    public Avion() {
        this.numPasajeros = 0;
        this.ruedas = 3;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public void setRuedas(int ruedas){
        this.ruedas = ruedas;
    }
    
    public int getRuedas(){
        return this.ruedas;
    }
    
    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public void guardar(String tipo) {
        guardarVehiculo(tipo);
        boolean valido = true;
        do {
            System.out.println("Tipo que gasolina que utiliza");
            System.out.println("(super, diesel, regular, especial): ");
            setGas(sc.nextLine().toUpperCase());
            try {
                Gasolina nombreGas = Gasolina.valueOf(getGas());
                valido = false;
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de gasolina ingresado no existe");
                System.out.println("Intente de nuevo...");
            }
        } while (valido);
        System.out.println("Digite la capacidad maxima de pasajeros: ");
        setNumPasajeros(sc.nextInt());
        System.out.println("Generando matricula");
        System.out.println("Espere...");
        randomLetrasMatricula();
        randomNumerosMatricula();
        try {
            Thread.sleep(2000);
            System.out.println("Se registro el avion de forma exitosa!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public void infoVehiculo() {
        Gasolina nombreGas = Gasolina.valueOf(getGas());
        System.out.println("DATOS DEL AVION");
        System.out.println("Motor: " + getMotor());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Marca: " + getMarca());
        System.out.println("Cantidad maxima de pasajeros: " + getNumPasajeros());
        System.out.println("Tipo de gasolina: " + nombreGas);
        System.out.println("Total de ruedas: " + getRuedas());
        imprimirMatricula();
    }

}
