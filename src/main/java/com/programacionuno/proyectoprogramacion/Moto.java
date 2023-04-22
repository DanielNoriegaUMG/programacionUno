package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Moto extends Vehiculo {

    public Moto() {

    }

    public Moto(String gas, String motor, String modelo, String marca,
            String tipo, int ruedas, int puertas, int pasajeros) {
        super(gas, motor, modelo, marca, tipo, ruedas, puertas, pasajeros);
    }

    public void guardarMoto(String tipo) {
        boolean validar = true; //condicion para iniciar el bucle
        String motor, modelo, marca, gas = null;
        guardarVehiculo(tipo); //pedir primeros datos si tiene motor
        motor = getMotor();
        modelo = getModelo();
        marca = getMarca();
        do {
            System.out.println("Tipo que gasolina que utiliza");
            System.out.println("(super, diesel, regular, especial): ");
            setGas(sc.nextLine().toUpperCase());
            try {
                Gasolina nombreGas = Gasolina.valueOf(getGas());
                gas = getGas().toLowerCase();
                validar = false; // salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de gasolina ingresado no existe");
                System.out.println("Intente de nuevo...");
            }
        } while (validar);

        System.out.println("Generando matricula");
        System.out.println("Espere...");
        try {
            Moto nuevaMoto = new Moto(gas, motor, modelo, marca, tipo, 2, 0, 2);
            guardarListaVehiculo(nuevaMoto);
            clonarLista();
            Thread.sleep(2000);
            System.out.println("Se registro la moto de forma exitosa!");
        } catch (InterruptedException e) {
            System.out.println(e);
        } catch(NullPointerException e){
            System.out.println("La lista de Vehiculo ya esta llena...");
            System.out.println("No puedes seguir ingresando vehiculos :(");
        }
    }

    @Override
    public void infoVehiculo() {
        Gasolina nombreGas = Gasolina.valueOf(getGas());
        System.out.println("DATOS DE LA MOTO");
        System.out.println("Motor: " + getMotor());
        System.out.println("Modelo: " + getModelo());
        System.out.println("Marca: " + getMarca());
        System.out.println("Tipo de gasolina: " + nombreGas);
        System.out.println("Total de ruedas: " + getRuedas());
        imprimirMatricula();
    }

}
