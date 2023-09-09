/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package co.edu.uptc.view;

import co.edu.uptc.controller.Controller;
import java.util.Scanner;

/**
 *
 * @author MARLON
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main ajedrez = new Main();
        ajedrez.runGame();
    }

    public void runGame() {
        Controller myController = new Controller();
        Scanner scanner = new Scanner(System.in);
        boolean turno = true;
        System.out.println("Tablero inicial:");
        myController.mostrarTablero();

        while (true) {

            try {
                String jugador;
                if (turno) {
                    jugador = "blancas";
                } else {
                    jugador = "negras";
                }
                System.out.println("Turno de las " + jugador + ".");
                System.out.println("Ingresa la coordenada de origen (ejemplo: e2):");
                String origen = scanner.nextLine();
                System.out.println("Ingresa la coordenada de destino (ejemplo: e4):");
                String destino = scanner.nextLine();

                boolean movimientoExitoso = myController.realizarMovimiento(origen, destino,turno);
                if (movimientoExitoso) {
                    System.out.println("Movimiento realizado con éxito.");
                    System.out.println("Tablero después del movimiento:");
                    myController.mostrarTablero();
                    turno = !turno;
                }
               

            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
                System.out.println("Coordenadas inválidas. Inténtalo de nuevo.");
            }

        }
    }
}
