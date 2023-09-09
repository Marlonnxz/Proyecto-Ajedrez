/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public class Caballo extends Pieza {

    public Caballo(int fila, int columna, boolean esBlanca) {
        super(fila, columna, esBlanca);
    }

    @Override
    public boolean esMovimientoValido(Pieza[][] casillas, int nuevaFila, int nuevaColumna) {
        int filaActual = getFila();
        int columnaActual = getColumna();
        int filaDelta = Math.abs(nuevaFila - filaActual);
        int columnaDelta = Math.abs(nuevaColumna - columnaActual);
        // Movimiento en "L" del caballo
        if ((filaDelta == 2 && columnaDelta == 1) || (filaDelta == 1 && columnaDelta == 2)) {
            
             // Verificar que la casilla a la que se desea mover el caballo esté vacía o contenga una ficha del equipo contrario
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
            return "C";
        } else {
            return "c";
        }
    }

}
