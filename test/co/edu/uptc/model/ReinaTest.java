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
public class ReinaTest {

    public ReinaTest() {
    }

    @Test
    public void testEsMovimientoValido() {
        System.out.println("esMovimientoValidoReina");
        Pieza[][] casillas = new Pieza[8][8];
        //inicializar las piezas en el tablero
        Reina reina = new Reina(2, 2, true);
        Peon peon = new Peon(1, 3, true);
        Peon peonEnemigo = new Peon(0, 0, false);

        //Inicializar las piezas en el tablero
        casillas[2][2] = reina;
        casillas[1][3] = peon;
        casillas[0][0] = peonEnemigo;

        //Movimientos validos diagonales
        assertTrue(reina.esMovimientoValido(casillas, 1, 1));
        assertTrue(reina.esMovimientoValido(casillas, 4, 0));
        assertTrue(reina.esMovimientoValido(casillas, 5, 5));
        //Movimiento validos hacia los lados, adelante y atras
        assertTrue(reina.esMovimientoValido(casillas, 0, 2));
        assertTrue(reina.esMovimientoValido(casillas, 2, 0));
        assertTrue(reina.esMovimientoValido(casillas, 2, 7));
        assertTrue(reina.esMovimientoValido(casillas, 5, 2));
        //Movimiento valido para capturar una pieza del equipo contrario
        assertTrue(reina.esMovimientoValido(casillas, 0, 0));
        //Movimiento invalido si intenta capturar una pieza de su mismo equipo
        assertFalse(reina.esMovimientoValido(casillas, 1, 3));
        //Movimiento invalido si hay una pieza de su mismo equipo en su destino
        assertFalse(reina.esMovimientoValido(casillas, 0, 4));

    }

    @Test
    public void testGetRepresentacion() {
        System.out.println("getRepresentacionReina");
        Reina reinaBlanca = new Reina(2, 3, true);
        assertEquals("Q", reinaBlanca.getRepresentacion());

        Reina reinaNegra = new Reina(7, 6, false);
        assertEquals("q", reinaNegra.getRepresentacion());
    }

}
