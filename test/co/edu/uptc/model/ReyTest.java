/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package co.edu.uptc.model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MARLON
 */
public class ReyTest {

    public ReyTest() {
    }

    @Test
    public void testEsMovimientoValido() {
        System.out.println("esMovimientoValidoRey");
        Pieza[][] casillas = new Pieza[8][8];
        //inicializar las piezas en el tablero
        Rey rey = new Rey(2, 2, true);
        Peon peon = new Peon(1, 3, true);
        Peon peonEnemigo = new Peon(1, 2, false);

        //Inicializar las piezas en el tablero
        casillas[2][2] = rey;
        casillas[1][3] = peon;
        casillas[1][2] = peonEnemigo;

        //Movimientos validos diagonales
        assertTrue(rey.esMovimientoValido(casillas, 1, 1));
        assertTrue(rey.esMovimientoValido(casillas, 3, 1));
        assertTrue(rey.esMovimientoValido(casillas, 3, 3));
        //Movimiento validos hacia los lados, (adelante esta el peon enemigo), y atras
        assertTrue(rey.esMovimientoValido(casillas, 2, 1));
        assertTrue(rey.esMovimientoValido(casillas, 2, 3));
        assertTrue(rey.esMovimientoValido(casillas, 3, 2));
        //Movimiento valido para capturar una pieza del equipo contrario 
        assertTrue(rey.esMovimientoValido(casillas, 1, 2));
        //Movimiento invalido si intenta capturar una pieza de su mismo equipo
        assertFalse(rey.esMovimientoValido(casillas, 1, 3));
        //Movimiento invalido si intenta avanzar mas de una casiila en cualquier direccion
        assertFalse(rey.esMovimientoValido(casillas, 0, 0));
    }

    @Test
    public void testGetRepresentacion() {
        System.out.println("getRepresentacionRey");
        Rey reyBlanco = new Rey(2, 3, true);
        assertEquals("K", reyBlanco.getRepresentacion());

        Rey reyNegro = new Rey(7, 6, false);
        assertEquals("k", reyNegro.getRepresentacion());
    }

}
