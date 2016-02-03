/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vehiculocontrolremoto;

import java.util.Scanner;

/**
 *
 * @author luisa
 */
public class Vehiculo {
    
    private int px;  //Posicion del vehiculo en x
    private int py;  //Posicion del vehiculo en y
    private Tablero t; //Recibe el objeto tablero para calcular cuando sale del limite
    
    //Leer del teclado
    Scanner digitar = new Scanner(System.in);
    
    public Vehiculo(Tablero t){
        px=0;   //El vehiculo incia el programa en la posicion 0,0
        py=0;
        this.t=t;   //Se recibe el objeto tablero
    }

    //Encapsulamiento de los atributos de la posicion, no se pone set, pues solo el desplazamiento puede cambiar la posición
    public int getPx() {
        return px;
    }

    public int getPy() {
        return py;
    }

    
    //Metodo para el desplazamiento del carro
    public boolean desplazar(int desplazamiento, String direccion){
        /*Recibe las coordenas de desplazamiento y dependiendo de 
          la dirección calcula el desplazamiento teniendo en cuenta
          los limites del tablero.
          Si se sale de los limites retorna falso, de lo contrario 
          retorna verdadero
        */
        
        switch(direccion){
            case "N":
                if((this.py+desplazamiento) <= this.t.getN()){
                    this.py+=desplazamiento;
                }
                else{
                    return false;
                }
                break;
            case "S":
                if((this.py-desplazamiento) >= 0){
                    this.py-=desplazamiento;
                }
                else{
                    return false;
                }
                break;
            case "E":
                if((this.px+desplazamiento) <= this.t.getM()){
                    this.px+=desplazamiento;
                }
                else{
                    return false;
                }
                break;
            case "O":
                if((this.px-desplazamiento) <= 0){
                    this.px-=desplazamiento;
                }
                else{
                    return false;
                }
                break;
        }
        return true;
    }
    
    public void comoMover(){
        //Se dibuja el tablero una primera vez con la posicion inicial del carro
        t.dibujarTablero(this);
        System.out.println("");
        System.out.println("");
         //Esta variable va a controlar que se continue desplazando el carro mientras se este en parametros correctos
        boolean continuar = true;
        do{
            //Se lee el comando, que puede ser un solo desplazamiento o varios
            System.out.println("Digite el comando de desplazamiento: (Para terminar digite c)");
            String comando=digitar.next();
            //Se da la opcion del caracter c para terminar con el programa
            if(comando.equals("c")){
                continuar = false;
            }
            else{
                //Se divide la cadena recibida en los ;
                //Si hay un solo comando el arreglo queda de longitud 1 e igual se ejecuta una vez el desplazamiento
                String[] comandos=comando.split(";");
                for(int i=0;i<comandos.length;i++){
                    //El comandon individual se divide en pasos y direccion
                    String[] p = comandos[i].split(",");
                    //Se valida que el primer caracter sea el numero de pasos y el segundo la direccion, norte, sur, este u oeste
                    if(Util.esNumero(p[0]) && (p[1].equals("N") || p[1].equals("S") || p[1].equals("E") || p[1].equals("O"))){
                        //Se hace el desplazamiento, si retorna false es por que salio de los limites, lo cual termina el programa
                        if(this.desplazar(Integer.parseInt(p[0]), p[1])){
                            //Se informa del comando a desplazar
                            System.out.println("Comando: "+p[0]+", "+p[1]);
                            //Se informa de la posicion luego del desplazamiento
                            System.out.println("Posicion final: ("+this.py+","+this.px+").");
                            //Se dibuja de nuevo el tablero
                            t.dibujarTablero(this);
                        }
                        else{
                            //Si el desplazamiento retorno false se termina el programa y se informa al usuario
                            i=comandos.length;
                            continuar = false;
                            System.out.println("Se ha detenido el avance por salir de los límites");
                        }
                    }
                    else{
                        System.out.println("“Error en formato de comando”.");
                    }
                }
            }
        }while(continuar);
    }
}
