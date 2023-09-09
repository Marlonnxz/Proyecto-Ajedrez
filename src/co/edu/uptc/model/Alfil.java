/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public class Alfil extends Pieza {

    public Alfil(int fila, int columna, boolean esBlanca) {
        super(fila, columna, esBlanca);
    }

    @Override
    public boolean esMovimientoValido(Pieza[][] casillas, int nuevaFila, int nuevaColumna) {

        int filaActual = getFila();
        int columnaActual = getColumna();
        int filaDelta = Math.abs(nuevaFila - filaActual);
        int columnaDelta = Math.abs(nuevaColumna - columnaActual);

        // Movimiento en diagonal de cualquier cantidad de casillas
        if (filaDelta == columnaDelta) {
            // Verificar que la casilla a la que se desea mover el alfil esté vacía o contenga una ficha del equipo contrario
            if (casillas[nuevaFila][nuevaColumna] != null && casillas[nuevaFila][nuevaColumna].isEsBlanca() == isEsBlanca()) {
                return false;
            }
            // Verificar que no haya ninguna ficha en el camino del movimiento del alfil
            int fila, columna;
            if (filaActual < nuevaFila) {
                fila = filaActual + 1;
            } else {
                fila = filaActual - 1;
            }
            if (columnaActual < nuevaColumna) {
                columna = columnaActual + 1;
            } else {
                columna = columnaActual - 1;
            }
            while (fila != nuevaFila && columna != nuevaColumna) {
                if (casillas[fila][columna] != null) {
                    return false;
                }
                if (fila < nuevaFila) {
                    fila = fila + 1;
                } else {
                    fila = fila - 1;
                }
                if (columna < nuevaColumna) {
                    columna = columna + 1;
                } else {
                    columna = columna - 1;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    @Override
    public String getRepresentacion() {
        if (isEsBlanca()) {
            return "A";
        } else {
            return "a";
        }
    }

}
