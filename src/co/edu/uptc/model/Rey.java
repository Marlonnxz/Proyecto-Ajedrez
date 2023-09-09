/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public class Rey extends Pieza {

    public Rey(int fila, int columna, boolean esBlanca) {
        super(fila, columna, esBlanca);
    }

    @Override
    public boolean esMovimientoValido(Pieza[][] casillas, int nuevaFila, int nuevaColumna) {
        int filaActual = getFila();
        int columnaActual = getColumna();

        // Movimiento horizontal o vertical de una casilla
        if ((Math.abs(nuevaFila - filaActual) == 1 && nuevaColumna == columnaActual) || (Math.abs(nuevaColumna - columnaActual) == 1 && nuevaFila == filaActual)) {
            // Verificar que la casilla a la que se desea mover el rey esté vacía o contenga una ficha del equipo contrario.
            if (casillas[nuevaFila][nuevaColumna] != null && casillas[nuevaFila][nuevaColumna].isEsBlanca() == isEsBlanca()) {
                return false;
            }
            return true;
        }

        // Movimiento diagonal de una casilla
        if (Math.abs(nuevaFila - filaActual) == 1 && Math.abs(nuevaColumna - columnaActual) == 1) {
            // Verificar que la casilla a la que se desea mover el rey esté vacía o contenga una ficha del equipo contrario.
            if (casillas[nuevaFila][nuevaColumna] != null && casillas[nuevaFila][nuevaColumna].isEsBlanca() == isEsBlanca()) {
                return false;
            }
            return true;
        }

        return false;
    }

    @Override
    public String getRepresentacion() {
        if (isEsBlanca()) {
            return "K";
        } else {
            return "k";
        }
    }

}
