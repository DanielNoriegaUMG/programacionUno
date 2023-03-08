package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Carro extends Vehiculo {

    private int ruedas;
    private int puertas;
    private String gas;
    private Gasolina tipoGas;

    public Carro(){
        this.ruedas = 4;
        this.puertas = 4;
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

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }

    public void guardar(String tipo) {
        guardarVehiculo(tipo); //perdir primeros datos si tiene motor
        System.out.println("Tipo de gasolina que utiliza");
        System.out.println("(super, diesel, regular, especial): ");
        setGas(sc.nextLine().toUpperCase());
        System.out.println("Generando matricula");
        System.out.println("Espere...");
        randomLetrasMatricula();
        randomNumerosMatricula();
        try {
            Thread.sleep(2000);
            System.out.println("Se registro el carro de forma exitosa!");
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    @Override
    public void infoVehiculo() {
        Gasolina nombreGas = Gasolina.valueOf(getGas());
        System.out.println("DATOS DEL CARRO");
        System.out.println("Motor: " +  getMotor());
        System.out.println("Modelo: " +  getModelo());
        System.out.println("Marca: " +  getMarca());
        System.out.println("Tipo de gasolina: ");
        System.out.println("Tipo de gasolina: " + nombreGas);
        imprimirMatricula();
    }

}
