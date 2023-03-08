package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Avion extends Vehiculo {

    private int numPasajeros;
    
    public Avion(){
        this.numPasajeros = 0;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public void guardar(String tipo) {
        guardarVehiculo(tipo);
        System.out.println("Digite la capacidad maxima de pasajeros: ");
        setNumPasajeros(sc.nextInt());
        System.out.println("Generando matricula");
        System.out.println("Espere...");
        try {
            Thread.sleep(2000);
            System.out.println("Se registro el avion de forma exitosa!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public void infoVehiculo() {
        System.out.println("Es un avion");
    }

}
