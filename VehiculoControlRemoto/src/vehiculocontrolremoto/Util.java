/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculocontrolremoto;

/**
 *
 * @author laura
 */
public class Util {
     //Funcion para validar que la entrada es un numero entero
    public static boolean esNumero(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException nfe){
		return false;
	}
}
}
