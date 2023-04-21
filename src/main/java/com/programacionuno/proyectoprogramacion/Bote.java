package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Bote extends Vehiculo {

    private boolean motorBote;
    private boolean remos;

    public Bote() {
        this.remos = true;
    }

    public Bote(String gas, String motor, String modelo, String marca,
            String tipo, int ruedas, int puertas, int pasajeros, boolean remos) {
        super(gas, motor, modelo, marca, tipo, ruedas, puertas, pasajeros);
        this.remos = remos;
    }

    public boolean getIsRemos() {
        return this.remos;
    }

    public void setIsRemos(boolean tiene) {
        this.remos = tiene;
    }

    public boolean getMotorBote() {
        return this.motorBote;
    }

    public void setMotorBote(boolean motor) {
        this.motorBote = motor;
    }

    public void tieneMotor(String respuesta) {
        if (respuesta.equalsIgnoreCase("si")) {
            setMotorBote(true);
        } else {
            setMotorBote(false);
            this.remos = false;
        }
    }

    public void guardar(String tipo) {
        System.out.println("¿El bote tiene motor?");
        System.out.print("(si/no): ");
        tieneMotor(sc.nextLine().toLowerCase());
        if (getMotorBote()) {
            String gas = null;
            boolean validar = true; //condicion para iniciar el bucle
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

            try {
                System.out.println("Generando matricula");
                System.out.println("Espere...");
                Bote nuevoBote = new Bote(gas, "comun", "comun", "unica", tipo, 0, 0, 5, false);
                guardarListaVehiculo(nuevoBote);
                clonarLista();
                Thread.sleep(1000);
                System.out.println("Se registro el carro de forma exitosa!");
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        } else {
            System.out.println("Generando matricula");
            System.out.println("Espere...");
            try {
                Bote nuevoBote = new Bote("no usa", "sin motor", "comun", "comun", tipo, 0, 0, 3, true);
                guardarListaVehiculo(nuevoBote);
                clonarLista();
                Thread.sleep(1000);
                System.out.println("Se registro el carro de forma exitosa!");
            } catch (InterruptedException e) {
                System.out.println(e);
            } catch(NullPointerException e){
            System.out.println("La lista de Vehiculo ya esta llena...");
            System.out.println("No puedes seguir ingresando vehiculos :(");
        }
        }
    }

    @Override
    public void mostrarListaVehiculos() {
        System.out.println("\nID  |\tMATRICULA\t|\t\tMARCA\t\t|\t\tMODELO\t\t"
                + "|\tMOTOR\t\t|" + "\tGASOLINA\t" + "|\tRUEDAS\t\t|"
                + "\tPUERTAS\t\t|\tPASAJEROS\t|\tREMOS\t");
        for (Vehiculo lista : nuevaLista) {
            if (lista == null) { // Verificar si el objeto no es null
                System.out.println("---");
            } else {
                System.out.print(lista.ID + "\t");
                System.out.print("  " + lista.getMatricula() + "\t");
                System.out.print("\t    " + lista.getMarca() + "\t");
                System.out.print("\t\t     " + lista.getModelo() + "\t");
                System.out.print("\t\t" + lista.getMotor() + "\t");
                System.out.print("\t     " + lista.getGas() + "\t");
                System.out.print("\t\t" + lista.getRuedas() + "\t");
                System.out.print("\t\t" + lista.getPuertas() + "\t");
                System.out.print("\t\t" + lista.getNumPasajeros() + "\t");
                if (getIsRemos()) {
                    System.out.print("\t no\n");
                } else {
                    System.out.println("\t si\n");
                }
            }
        }
    }

    @Override
    public void infoVehiculo() {
        System.out.println("DATOS DEL BOTE");
        System.out.print("Remos: ");
        if (getIsRemos()) {
            System.out.println("si");
        } else {
            System.out.println("no");
        }

        if (getMotorBote()) {
            System.out.println("Motor: SI");
            System.out.println("Remos: NO");
        } else {
            System.out.println("Motor: NO");
            System.out.println("Remos: SI");
        }
    }
}
