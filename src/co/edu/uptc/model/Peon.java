/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public class Peon extends Pieza {

    public Peon(int fila, int columna, boolean esBlanca) {
        super(fila, columna, esBlanca);

    }

    @Override
    public boolean esMovimientoValido(Pieza[][] casillas, int nuevaFila, int nuevaColumna) {
        int filaActual = getFila();
        int columnaActual = getColumna();
        // Dirección de avance del peón dependiendo del color
        int direccion;
        if (isEsBlanca()) {
            direccion = 1;
        } else {
            direccion = -1;
        }

        // Movimiento vertical hacia adelante
        if (nuevaFila == filaActual + direccion && nuevaColumna == columnaActual) {
            if (casillas[nuevaFila][nuevaColumna] == null) {
                return true;
            }
        }

        // Movimiento de avance de dos casillas en el primer movimiento
        if (nuevaFila == filaActual + direccion * 2 && nuevaColumna == columnaActual
                && ((isEsBlanca() && filaActual == 1) || (!isEsBlanca() && filaActual == 6))) {
            if (casillas[nuevaFila][nuevaColumna] == null && casillas[nuevaFila - direccion][nuevaColumna] == null) {
                return true;
            }
        }

        // Captura diagonal de una pieza enemiga
        if (Math.abs(nuevaColumna - columnaActual) == 1 && nuevaFila == filaActual + direccion) {
            if (casillas[nuevaFila][nuevaColumna] != null && casillas[nuevaFila][nuevaColumna].isEsBlanca() != isEsBlanca()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getRepresentacion() {
        if (isEsBlanca()) {
            return "P";
        } else {
            return "p";
        }
    }

}
