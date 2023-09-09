/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package co.edu.uptc.controller;

import co.edu.uptc.model.Peon;
import co.edu.uptc.model.Pieza;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author MARLON
 */
public class ControllerTest {

    public ControllerTest() {
    }

    @Test
    public void testRealizarMovimiento() {
        System.out.println("realizarMovimiento");
        Pieza peon = new Peon(1, 1,true);
        Controller controlador = new Controller();
        controlador.getTablero().setPieza(1, 1, peon);
        String origen = "b2";
        String destino = "b3";
        boolean turno = true;

        boolean resultado = controlador.realizarMovimiento(origen, destino,turno);

        assertTrue(resultado);
        assertNull(controlador.getTablero().getPieza(1, 1));
        assertEquals(peon, controlador.getTablero().getPieza(2, 1));
        assertEquals(2, peon.getFila());
        assertEquals(1, peon.getColumna());
    }

    

}
