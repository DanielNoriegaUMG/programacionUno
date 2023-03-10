package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Moto extends Vehiculo {

    private int ruedas;
    private String gas;
    private int tipoGas;

    public Moto() {
        this.ruedas = 2;
    }

    public int getTipoGas() {
        return tipoGas;
    }

    public void setTipoGas(int tipoGas) {
        this.tipoGas = tipoGas;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }
    
    public int getRuedas(){
        return this.ruedas;
    }
    
    public void setRuedas(int ruedas){
        this.ruedas = ruedas;
    }

    public void guardarMoto(String tipo) {
        guardarVehiculo(tipo); //pedir primeros datos si tiene motor
        System.out.println("Tipo de gasolina que utiliza");
        System.out.println("(super, diesel, regular, especial): ");
        setGas(sc.nextLine().toUpperCase());
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
        Gasolina nombreGas = Gasolina.valueOf(getGas());
        System.out.println("DATOS DE LA MOTO");
        System.out.println("Motor: " +  getMotor());
        System.out.println("Modelo: " +  getModelo());
        System.out.println("Marca: " +  getMarca());
        System.out.println("Tipo de gasolina: " + nombreGas);
        System.out.println("Total de ruedas: " +  getRuedas());
        imprimirMatricula();
    }

}
