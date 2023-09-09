/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.controller;

import co.edu.uptc.model.Pieza;
import co.edu.uptc.model.Tablero;

public class Controller {

    private Tablero tablero;

    public Controller() {
        this.tablero = new Tablero();
    }

    public boolean realizarMovimiento(String origen, String destino, boolean turno) {
        try {
            //el -1 es para que comience a contar desde 0 en lugar de 1
            int origenFila = Integer.parseInt(origen.substring(1, 2)) - 1;
            /*
            el siguiente metodo resta el valor de 'a' que es 97 en el sistema ASCII
            con el valor de la letra que esta pidiendo en la posicion 0 por ejm 'b' vale 98, lo cual seria la
            columna 1 , y asi susecivamente
             */
            int origenColumna = (int) (origen.toLowerCase().charAt(0) - 'a');
            int destinoFila = Integer.parseInt(destino.substring(1, 2)) - 1;
            int destinoColumna = (int) (destino.toLowerCase().charAt(0) - 'a');

            Pieza piezaOrigen = tablero.getPieza(origenFila, origenColumna);
            if (piezaOrigen == null) {
                System.out.println("No hay una pieza en la casilla de origen.");
                return false;
            } else if (piezaOrigen.isEsBlanca() != turno) {
                System.out.println("La pieza seleccionada no corresponde al color del turno");
                return false;
            } else if (!piezaOrigen.esMovimientoValido(tablero.getCasillas(), destinoFila, destinoColumna)) {
                System.out.println("Movimiento inválido para la pieza seleccionada.");
                return false;
            } else {
                tablero.setPieza(origenFila, origenColumna, null);
                tablero.setPieza(destinoFila, destinoColumna, piezaOrigen);
                piezaOrigen.setFila(destinoFila);
                piezaOrigen.setColumna(destinoColumna);
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("El movimiento ingresado esta fuera del tablero");
            return false;
        }
    }

    public void mostrarTablero() {
        System.out.println("   A  B  C  D  E  F  G  H");
        for (int fila = 0; fila < 8; fila++) {
            System.out.print((fila + 1) + " ");
            for (int columna = 0; columna < 8; columna++) {
                Pieza pieza = tablero.getCasillas()[fila][columna];
                if (pieza == null) {
                    System.out.print("|  ");
                } else {
                    System.out.print("|" + pieza.getRepresentacion() + " ");
                }
            }
            System.out.println("| " + (fila + 1));
        }
        System.out.println("   A  B  C  D  E  F  G  H");
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

}
