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
public class TorreTest {

    public TorreTest() {
    }

    @Test
    public void testEsMovimientoValido() {
        System.out.println("esMovimientoValidoTorre");
        Pieza[][] casillas = new Pieza[8][8];
        //inicializar las piezas en el tablero
        Torre torre = new Torre(2, 2, true);
        Peon peon = new Peon(2, 4, true);
        Peon peonEnemigo = new Peon(1, 2, false);

        //Inicializar las piezas en el tablero
        casillas[2][2] = torre;
        casillas[2][4] = peon;
        casillas[1][2] = peonEnemigo;

        //Movimiento validos hacia los lados, (adelante esta el peon enemigo), y atras
        assertTrue(torre.esMovimientoValido(casillas, 2, 0));
        assertTrue(torre.esMovimientoValido(casillas, 2, 3));
        assertTrue(torre.esMovimientoValido(casillas, 5, 2));
        //Movimiento valido para capturar una pieza del equipo contrario 
        assertTrue(torre.esMovimientoValido(casillas, 1, 2));
        //Movimiento invalido si intenta capturar una pieza de su mismo equipo
        assertFalse(torre.esMovimientoValido(casillas, 2, 4));
        //Movimiento invalido si hay una pieza de su mismo equipo en su destino
        assertFalse(torre.esMovimientoValido(casillas, 2, 6));
    }

    @Test
    public void testGetRepresentacion() {
        System.out.println("getRepresentacionTorre");
        Torre torreBlanco = new Torre(2, 3, true);
        assertEquals("T", torreBlanco.getRepresentacion());

        Torre torreNegra = new Torre(7, 6, false);
        assertEquals("t", torreNegra.getRepresentacion());
    }

}
