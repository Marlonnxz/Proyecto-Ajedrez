/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public class Torre extends Pieza {

    public Torre(int fila, int columna, boolean esBlanca) {
        super(fila, columna, esBlanca);
    }

    @Override
    public boolean esMovimientoValido(Pieza[][] casillas, int nuevaFila, int nuevaColumna) {
        int filaActual = getFila();
        int columnaActual = getColumna();

        // Movimiento horizontal o vertical de cualquier cantidad de casillas
        if (nuevaFila == filaActual || nuevaColumna == columnaActual) {
            int filaInicio, filaFin, columnaInicio, columnaFin;
            if (nuevaFila == filaActual) {
                // Movimiento horizontal
                columnaInicio = Math.min(columnaActual, nuevaColumna);
                columnaFin = Math.max(columnaActual, nuevaColumna);
                filaInicio = filaFin = filaActual;
            } else {
                // Movimiento vertical
                filaInicio = Math.min(filaActual, nuevaFila);
                filaFin = Math.max(filaActual, nuevaFila);
                columnaInicio = columnaFin = columnaActual;
            }

            // Verificar si hay alguna ficha del mismo equipo en el camino
            for (int fila = filaInicio; fila <= filaFin; fila++) {
                for (int columna = columnaInicio; columna <= columnaFin; columna++) {
                    // Ignorar la casilla de origen y destino
                    if (fila == filaActual && columna == columnaActual) {
                        continue;
                    }
                    if (fila == nuevaFila && columna == nuevaColumna) {
                        continue;
                    }
                    if (casillas[fila][columna] != null) {
                        // Si hay una ficha del mismo equipo en el camino, invalidar el movimiento
                        if (isEsBlanca()== casillas[fila][columna].isEsBlanca()) {
                            return false;
                        }
                    }
                }
            }

            // Verificar si hay una ficha del mismo equipo en la casilla de destino
            if (casillas[nuevaFila][nuevaColumna] != null) {
                if (isEsBlanca()== casillas[nuevaFila][nuevaColumna].isEsBlanca()) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    @Override
    public String getRepresentacion() {
        if (isEsBlanca()) {
            return "T";
        } else {
            return "t";
        }
    }

}
