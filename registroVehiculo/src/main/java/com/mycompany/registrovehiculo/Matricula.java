package com.mycompany.registrovehiculo;


/**
 *
 * @author Sojuel
 */
public class Matricula {

    private int numeros;
    private char[] blocLetras = new char[3];
    private String resultado;

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void bloqueNumeros() {
        numeros = (111) + (int) (Math.random() * (888));
    }

    public void bloqueLetras() {
        char[] letras = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        for (int i = 0; i < 3; i++) {
            blocLetras[i] = letras[(int) (Math.random() * (26))];
        }
    }
    
    public int buscarMatricula(String Mat) {
        for(int i=0; i<Vehiculo.contador; i++){
            if(Vehiculo.nuevaLista[i].getMatricula().equals(Mat)){
                return i;
            }
        }
        return -1;
    }

    public String unirMatricula(char tipo) {
        boolean validar;
        do {
            bloqueNumeros();
            bloqueLetras();
            StringBuilder sb = new StringBuilder();
            sb.append(blocLetras);

            String tem = (tipo + "-" + numeros + sb.toString());
            int pos = buscarMatricula(tem);
            if (pos <0) {
                setResultado(tem);
                validar = false;
            } else {
                validar = true;
            }
        } while (validar);
        return getResultado();
    }
}