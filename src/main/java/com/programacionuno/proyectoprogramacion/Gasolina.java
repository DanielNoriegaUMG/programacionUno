package com.programacionuno.proyectoprogramacion;

/**
 *
 * @author HP INTEL
 */
public enum Gasolina {
    SUPER(1), DIESEL(2), REGULAR(3), ESPECIAL(4);
    
    private int index;
    
    private Gasolina(int index){
        this.index = index;
    }
}
