/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.modelo;

/**
 * Clase nodo generico
 *
 * @author ajrego
 */
public class NodoGenerico<T> {

    private T dato;
    private NodoGenerico<T> siguiente;
    private NodoGenerico<T> anterior;

    /**
     * Constructor con parametros que recibe el dato generico y sus apuntadores
     * al nodo siguiente y el nodo anterior
     *
     * @param dato
     * @param siguiente
     * @param anterior
     */
    public NodoGenerico(T dato, NodoGenerico<T> siguiente, NodoGenerico<T> anterior) {
        this.dato = dato;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    //Getters y Setters
    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoGenerico<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoGenerico<T> siguiente) {
        this.siguiente = siguiente;
    }

    public NodoGenerico<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoGenerico<T> anterior) {
        this.anterior = anterior;
    }

}
