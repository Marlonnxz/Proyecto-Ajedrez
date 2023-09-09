/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.uptc.model;

/**
 *
 * @author MARLON
 */
public abstract class Pieza {

    private int fila;
    private int columna;
    private boolean esBlanca;

    public Pieza(int fila, int columna, boolean esBlanca) {
        this.fila = fila;
        this.columna = columna;
        this.esBlanca = esBlanca;
    }

    public abstract boolean esMovimientoValido(Pieza[][] casillas,int nuevaFila, int nuevaColumna);

    public abstract String getRepresentacion();

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public boolean isEsBlanca() {
        return esBlanca;
    }

    public void setEsBlanca(boolean esBlanca) {
        this.esBlanca = esBlanca;
    }

}
