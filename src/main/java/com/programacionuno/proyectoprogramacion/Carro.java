package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Carro extends Vehiculo {

    public Carro() {

    }

    public Carro(String gas, String motor, String modelo, String marca,
            String tipo, int ruedas, int puertas, int pasajeros) {
        super(gas, motor, modelo, marca, tipo, ruedas, puertas, pasajeros);
    }

    public void guardar(String tipo) {
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
                gas = getGas().toLowerCase(); //pasar a minusculas para el array
                validar = false; // salir del bucle
            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de gasolina ingresado no existe");
                System.out.println("Intente de nuevo...");
            }
        } while (validar);

        System.out.println("Generando matricula");
        System.out.println("Espere...");
        try {
            Carro nuevoCarro = new Carro(gas, motor, modelo, marca, tipo, 4, 4, 4);
            guardarListaVehiculo(nuevoCarro);
            clonarLista();
            Thread.sleep(1000);
            System.out.println("Se registro el carro de forma exitosa!");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("La lista de Vehiculo ya esta llena...");
            System.out.println("No puedes seguir ingresando vehiculos :(");
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
