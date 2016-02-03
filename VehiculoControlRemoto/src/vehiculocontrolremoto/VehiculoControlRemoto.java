/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculocontrolremoto;

/**
 *
 * @author luisa
 */
public class VehiculoControlRemoto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Para leer del teclado
        
        
        //Se crea el tablero
        Tablero t = new Tablero();
        //Se crea el vehiculo y se le pasa el tablero para calcular el movimiento y los margenes
        Vehiculo v = new Vehiculo(t);
        
        v.comoMover();
    }
    
  
}
