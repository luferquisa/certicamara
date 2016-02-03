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
public class Tablero {
    
    private int m;   //Columnas del tablero
    private int n;   //Filas del tablero
    
    public Tablero(){
        //Para leer del teclado
        Scanner digitar = new Scanner(System.in);
        
        //Se leen las dimensiones que el usuario quiere para el tablero
        System.out.println("Digite un valor para n (filas):");
        this.n = digitar.nextInt();
        System.out.println("Digite un valor para m (columnas):");
        this.m = digitar.nextInt();
    }

    //Encapsulamiento de los atributos del tamano del tablero, no se pone set, pues solo en el constructor se define el tamaño
    public int getM() {
        return m;
    }


    public int getN() {
        return n;
    }

   
    
    //Metodo para dibujar el tablero en la consola
    public void dibujarTablero(Vehiculo v){
        /*
            El tablero es una matriz de nxm, se inicia en la posicion 0,0 y se termina en la posicion n,m
            Por lo tanto la matriz tiene n + 1 filas y m + 1 columnas.
            El vehiculo se recibe para dibujarlo en la posicion adecuada
        */
        int i = m*4+4;  //Cada casilla tiene 4 caracteres - de ancho
        //Se inicia a dibujar cada fila desde la parte de arriba, pensando que la parte 
        //inferior izquierda es la posición 0,0
        for(int j=n; j>=0; j--){
            //Se escriben todos los caracteres calculados para las celdas a dibujar
            for(int k=0; k<i; k++){
                System.out.print("-");
            }
            //Luego de tener la parte superior de cada fila se genera un salto de linea para separar las celdas
            System.out.println("");
            for(int k=0; k<=m; k++){
                //Por cada celda se dibuja un pipe para separla
                System.out.print("|");
                //Se compara la posicion del vehiculo, si concuerda se dibuja, sino se ponen espacios
                if(v.getPy() == j && v.getPx() == k){
                    System.out.print("o o");
                }
                else{
                    System.out.print("   ");
                }
            }
            //La fila se cierra con un  ultimo pipe
            System.out.println("|");
        }
        //La matriz se cierra con una ultima linea de -
        for(int k=0; k<i; k++){
                System.out.print("-");
        }
        System.out.println("");
    }
}

