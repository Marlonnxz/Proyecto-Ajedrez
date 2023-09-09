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
public class CaballoTest {

    public CaballoTest() {
    }

    @Test
    public void testEsMovimientoValido() {
        System.out.println("esMovimientoValidoCaballo");
        Pieza[][] casillas = new Pieza[8][8];
        //inicializar el alfil en su posicion inicial
        Caballo caballo = new Caballo(2, 2, true);
        Peon peon = new Peon(0, 3, true);
        Peon peonEnemigo = new Peon(0, 1, false);
        // Colocar el caballo en la casilla (2, 2) para hacer las respectivas pruebas
        casillas[2][2] = caballo;
        //Colocar peon amigo en el posible movimiento del alfil
        casillas[0][3] = peon;
        //Colocar peon del otro equipo
        casillas[0][1] = peonEnemigo;

        //Movimientos validos
        assertTrue(caballo.esMovimientoValido(casillas, 1, 0));
        assertTrue(caballo.esMovimientoValido(casillas, 3, 0));
        assertTrue(caballo.esMovimientoValido(casillas, 1, 4));
        //Movimiento valido para capturar una pieza del equipo contrario
        assertTrue(caballo.esMovimientoValido(casillas, 0, 1));
        //Movimiento invalido si intenta capturar una pieza de su mismo equipo
        assertFalse(caballo.esMovimientoValido(casillas, 0, 3));

    }

    @Test
    public void testGetRepresentacion() {
        System.out.println("getRepresentacionCaballo");
        Caballo caballoBlanco = new Caballo(2, 3, true);
        assertEquals("C", caballoBlanco.getRepresentacion());

        Caballo caballoNegro = new Caballo(7, 6, false);
        assertEquals("c", caballoNegro.getRepresentacion());
    }

}
