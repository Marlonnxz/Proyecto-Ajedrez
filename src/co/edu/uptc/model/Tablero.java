/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;


/**
 *
 * @author MARLON
 */
public class Tablero {

    private Pieza[][] casillas;

    public Tablero() {
        casillas = new Pieza[8][8];
        // Inicializar el tablero con las piezas en su posición inicial
     
        casillas[0][0] = new Torre(0, 0, true);
        casillas[0][1] = new Caballo(0, 1, true);
        casillas[0][2] = new Alfil(0, 2, true);
        casillas[0][3] = new Reina(0, 3, true);
        casillas[0][4] = new Rey(0, 4, true);
        casillas[0][5] = new Alfil(0, 5, true);
        casillas[0][6] = new Caballo(0, 6, true);
        casillas[0][7] = new Torre(0, 7, true);
        casillas[1][0] = new Peon(1, 0, true);
        casillas[1][1] = new Peon(1, 1, true);
        casillas[1][2] = new Peon(1, 2, true);
        casillas[1][3] = new Peon(1, 3, true);
        casillas[1][4] = new Peon(1, 4, true);
        casillas[1][5] = new Peon(1, 5, true);
        casillas[1][6] = new Peon(1, 6, true);
        casillas[1][7] = new Peon(1, 7, true);
        // Inicializar las piezas vacías en el resto del tablero
        for (int fila = 2; fila < 6; fila++) {
            for (int columna = 0; columna < 8; columna++) {
                casillas[fila][columna] = null;
            }
        }
        // Inicializar las piezas negras en la posición inicial
        casillas[7][0] = new Torre(7, 0, false);
        casillas[7][1] = new Caballo(7, 1, false);
        casillas[7][2] = new Alfil(7, 2, false);
        casillas[7][3] = new Reina(7, 3, false);
        casillas[7][4] = new Rey(7, 4, false);
        casillas[7][5] = new Alfil(7, 5, false);
        casillas[7][6] = new Caballo(7, 6, false);
        casillas[7][7] = new Torre(7, 7, false);
        casillas[6][0] = new Peon(6, 0, false);
        casillas[6][1] = new Peon(6, 1, false);
        casillas[6][2] = new Peon(6, 2, false);
        casillas[6][3] = new Peon(6, 3, false);
        casillas[6][4] = new Peon(6, 4, false);
        casillas[6][5] = new Peon(6, 5, false);
        casillas[6][6] = new Peon(6, 6, false);
        casillas[6][7] = new Peon(6, 7, false);
    }


    public Pieza[][] getCasillas() {
        return casillas;
    }

    public void setCasillas(Pieza[][] casillas) {
        this.casillas = casillas;
    }

    
    public Pieza getPieza(int fila, int columna){
        return casillas[fila][columna];
    }
    
    public void setPieza(int fila, int columna,Pieza pieza){
        casillas[fila][columna] = pieza;
    }
    
    public  Pieza[][] getTablero(){
        return casillas;
    }

}
