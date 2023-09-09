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
public class PeonTest {

    public PeonTest() {
    }

    @Test
    public void testEsMovimientoValido() {
        System.out.println("esMovimientoValidoPeon");
        Pieza[][] casillas = new Pieza[8][8];
        //inicializar el alfil en su posicion inicial
        Peon peon = new Peon(1, 2, true);
        Peon peonAliado = new Peon(2, 3, true);
        Peon peonAliado2 = new Peon(1, 3, true);
        Peon peonEnemigo = new Peon(2, 1, false);

        // Asignacion de piezas en el tablero
        casillas[1][2] = peon;
        casillas[2][3] = peonAliado;
        casillas[2][1] = peonEnemigo;
        casillas[1][3] = peonAliado2;

        //Movimiento valido hacia adelante una casilla
        assertTrue(peon.esMovimientoValido(casillas, 2, 2));
        //Movimiento valido de dos casillas en el primer movimiento
        assertTrue(peon.esMovimientoValido(casillas, 3, 2));
        //Movimiento valido para capturar una pieza del equipo contrario
        assertTrue(peon.esMovimientoValido(casillas, 2, 1));
        //movimiento invalido si son mas  dos casillas el primer movimiento
        assertFalse(peon.esMovimientoValido(casillas, 4, 2));
        //Movimiento invalido si intenta capturar una pieza de su mismo equipo
        assertFalse(peon.esMovimientoValido(casillas, 2, 3));
        //Movimiento invalido si hay una pieza de su mismo equipo en su destino
        assertFalse(peonAliado2.esMovimientoValido(casillas, 3, 3));

    }

    @Test
    public void testGetRepresentacion() {
        System.out.println("getRepresentacionPeon");
        Peon peonBlanco = new Peon(2, 3, true);
        assertEquals("P", peonBlanco.getRepresentacion());

        Peon peonNegro = new Peon(7, 6, false);
        assertEquals("p", peonNegro.getRepresentacion());
    }

}
