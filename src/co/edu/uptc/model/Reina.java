/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public class Reina extends Pieza {

    public Reina(int fila, int columna, boolean esBlanca) {
        super(fila, columna, esBlanca);
    }

    @Override
    public boolean esMovimientoValido(Pieza[][] casillas, int nuevaFila, int nuevaColumna) {
        int filaActual = getFila();
        int columnaActual = getColumna();

        // Movimiento horizontal o vertical de cualquier cantidad de casillas
        if ((nuevaFila == filaActual || nuevaColumna == columnaActual)
                || (Math.abs(nuevaFila - filaActual) == Math.abs(nuevaColumna - columnaActual))) {

            int filaDelta = Integer.signum(nuevaFila - filaActual);
            int columnaDelta = Integer.signum(nuevaColumna - columnaActual);

            // Verificar que no haya piezas en su camino
            int fila = filaActual + filaDelta;
            int columna = columnaActual + columnaDelta;
            while (fila != nuevaFila || columna != nuevaColumna) {
                if (casillas[fila][columna] != null) {
                    return false;
                }
                fila += filaDelta;
                columna += columnaDelta;
            }

            // Verificar que la casilla de destino esté vacía o tenga una pieza del equipo contrario
            if (casillas[nuevaFila][nuevaColumna] == null || casillas[nuevaFila][nuevaColumna].isEsBlanca() != isEsBlanca()) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String getRepresentacion() {
        if (isEsBlanca()) {
            return "Q";
        } else {
            return "q";
        }
    }
}
