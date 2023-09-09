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
public class AlfilTest {

    public AlfilTest() {
    }

    @Test
    public void testEsMovimientoValido() {
        System.out.println("esMovimientoValidoAlfil");
        Pieza[][] casillas = new Pieza[8][8];
        //inicializar el alfil en su posicion inicial
        Alfil alfil = new Alfil(2, 2, true);
        Peon peon = new Peon(1, 3, true);
        Peon peonEnemigo = new Peon(0, 0, false);
        // Colocar el alfil en la casilla (2, 2) para hacer las respectivas pruebas
        casillas[2][2] = alfil;
        //Colocar peon en el posible movimiento del alfil
        casillas[1][3] = peon;
        //Colocar peon del otro equipo
        casillas[0][0] = peonEnemigo;

        //Movimientos validos
        assertTrue(alfil.esMovimientoValido(casillas, 1, 1));
        assertTrue(alfil.esMovimientoValido(casillas, 3, 1));
        assertTrue(alfil.esMovimientoValido(casillas, 3, 3));
        //Movimiento valido para capturar una pieza del equipo contrario
        assertTrue(alfil.esMovimientoValido(casillas, 0, 0));
        //Movimiento invalido si intenta capturar una pieza de su mismo equipo
        assertFalse(alfil.esMovimientoValido(casillas, 1, 3));
        //Movimiento invalido si hay una pieza de su mismo equipo en su destino
        assertFalse(alfil.esMovimientoValido(casillas, 0, 4));

    }

    @Test
    public void testGetRepresentacion() {
        System.out.println("getRepresentacionAlfil");
        Alfil alfilBlanco = new Alfil(2, 3, true);
        //lo que espera, el valor actual
        assertEquals("A", alfilBlanco.getRepresentacion());

        Alfil alfilNegro = new Alfil(7, 6, false);
        assertEquals("a", alfilNegro.getRepresentacion());
    }
}
