package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author Daniel Noriega
 */
public class Bote extends Vehiculo{
    private boolean remos;
    
    public Bote(){
        this.remos = true;
    }
    
    public boolean getIsRemos(){
        return this.remos;
    }
    
    public void setIsRemos(boolean tiene){
        this.remos = tiene;
    }
    
    public void tieneMotor(String respuesta){
        if(respuesta.equalsIgnoreCase("si")){
            setMotorBote(true);
        }   
    }
    
    public void guardar(){
        System.out.println("¿El bote tiene motor?");
        tieneMotor(sc.nextLine().toLowerCase());
    }
    
    @Override
    public void infoVehiculo(){
        System.out.println("DATOS DEL BOTE");
        System.out.print("Remos: ");
        if(getIsRemos()){
            System.out.println("si");
        }else{
            System.out.println("no");
        }
       
        if(isMotorBote()){
            System.out.println("Motor: SI");
            System.out.println("Remos: NO");
        }else{
            System.out.println("Motor: NO");
            System.out.println("Remos: SI");
        }
    }
}
