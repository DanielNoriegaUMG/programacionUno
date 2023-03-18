package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Carro extends Vehiculo {

    private int ruedas;
    private int puertas;

    public Carro() {
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

    public void guardar(String tipo) {
        boolean validar = true;
        guardarVehiculo(tipo); //perdir primeros datos si tiene motor
        
        do {
            System.out.println("Tipo que gasolina que utiliza");
            System.out.println("(super, diesel, regular, especial): ");
            setGas(sc.nextLine().toUpperCase());
            try {
                Gasolina nombreGas = Gasolina.valueOf(getGas());
                validar = false; // salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de gasolina ingresado no existe");
                System.out.println("Intente de nuevo...");
            }
        } while (validar);
        
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
        System.out.println("Motor: " + getMotor());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Marca: " + getMarca());
        System.out.println("Tipo de gasolina: " + nombreGas);
        System.out.println("Total de ruedas: " + getRuedas());
        imprimirMatricula();
    }

}
