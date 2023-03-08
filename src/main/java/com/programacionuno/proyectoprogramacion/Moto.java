package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Moto extends Vehiculo{
    
    private int ruedas;
    private int tipoGas;
    
    public Moto(){
        this.ruedas = 2;
    }
    
    public int getTipoGas() {
        return tipoGas;
    }

    public void setTipoGas(int tipoGas) {
        this.tipoGas = tipoGas;
    }

    public void guardarMoto(String tipo) {
        guardarVehiculo(tipo); //pedir primeros datos si tiene motor
        System.out.println("Tipo de gasolina que utiliza");
        setTipoGas(sc.nextInt());
        System.out.println("Generando matricula");
        System.out.println("Espere...");
        randomLetrasMatricula();
        randomNumerosMatricula();
        try {
            Thread.sleep(2000);
            System.out.println("Se registro la moto de forma exitosa!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public void infoVehiculo() {
        System.out.println("Es una moto...");
        imprimirMatricula();
    }
    
    
}
