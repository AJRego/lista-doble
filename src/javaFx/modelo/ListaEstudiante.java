/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.modelo;

/**
 * Lista doblemente enlazada de un estudiante
 *
 * @author ajrego
 */
public class ListaEstudiante {

    private NodoGenerico<Estudiante> primero;
    private NodoGenerico<Estudiante> ultimo;

    /**
     * Constructor vacio que inicializa los nodos en null
     */
    public ListaEstudiante() {
        primero = ultimo = null;
    }

    /**
     * Si el primer nodo es igual a null, quiere decir que no apunta a nada, por
     * lo que deducimos que la lista esta vacia
     *
     * @return True si lo esta, de lo contrario False
     */
    public boolean estaVacio() {
        return primero == null;
    }

    /**
     * Un estudiante aprueba cuando su nota es mayor o igual a 3.0
     *
     * @param estudiante A evaluar
     * @return True si aprobo, de lo contrario False
     */
    public boolean estaAprobado(Estudiante estudiante) {
        return estudiante.getNota() >= 3;
    }

    /**
     * Validar si el estudiante agregado aprobo, se agrega al inicio si
     * aprobo o al final si reprobo
     *
     * @param estudiante Agregado
     */
    public void agregarEstudiante(Estudiante estudiante) {

        if (estaAprobado(estudiante)) {
            agregarInicio(estudiante);
        } else {
            agregarFinal(estudiante);
        }
    }

    /**
     * Agregar un estudiante al inicio de la lista, si esta vacia quiere decir
     * que ese nodo es el primero y el ultimo
     *
     * @param estudiante Agregado
     */
    private void agregarInicio(Estudiante estudiante) {
        NodoGenerico<Estudiante> agregado = new NodoGenerico<>(estudiante, null, null);

        if (estaVacio()) {
            primero = agregado;
            ultimo = agregado;
        } else {
            agregado.setSiguiente(primero);
            primero.setAnterior(agregado);
            primero = agregado;
            primero.setAnterior(null);
        }
    }

    /**
     * Agregar un estudiante al final de la lista, si esta vacia entonces usamos
     * el metodo de agregar al inicio
     *
     * @param estudiante Agregado
     */
    private void agregarFinal(Estudiante estudiante) {

        if (estaVacio()) {
            agregarInicio(estudiante);
        } else {
            NodoGenerico<Estudiante> agregado = new NodoGenerico<>(estudiante, null, ultimo);
            ultimo.setSiguiente(agregado);
            ultimo = agregado;
            ultimo.setSiguiente(null);
        }
    }

    /**
     * Obtener un estudiante de la lista por el codigo
     *
     * @param codigo Del estudiante buscado
     * @return El estudiante buscado o null si no se encontro nada
     */
    public Estudiante getEstudiantePorCodigo(String codigo) {
        NodoGenerico<Estudiante> temporal = primero;

        while (temporal != null) {

            if (codigo.equals(temporal.getDato().getCodigo())) {
                return temporal.getDato();
            } else {
                temporal = temporal.getSiguiente();
            }
        }
        return null;
    }

    /**
     * Eliminar un estudiante de la lista por su codigo
     *
     * @param codigo Del estudiante a eliminar
     * @return El estudiante eliminado
     */
    public Estudiante eliminarEstudiantePorCodigo(String codigo) {
        Estudiante eliminar = null;

        if (primero.getDato().getCodigo().equals(codigo)) {
            eliminar = eliminarPrimero();
        } else if (ultimo.getDato().getCodigo().equals(codigo)) {
            eliminar = eliminarUltimo();
        } else {
            // En caso de que el codigo a eliminar no coincida con el primero o
            // el ultimo, lo buscamos en toda la lista usando 3 nodos auxilares, 
            // para tener una referencia al nodo anterior y siguiente del buscado
            NodoGenerico<Estudiante> anterior = primero;
            NodoGenerico<Estudiante> temporal = primero.getSiguiente();
            NodoGenerico<Estudiante> siguiente = temporal.getSiguiente();

            while (temporal != null) {

                if (temporal.getDato().getCodigo().equals(codigo)) {
                    eliminar = temporal.getDato();
                    siguiente = temporal.getSiguiente();
                    break;
                } else {
                    anterior = anterior.getSiguiente();
                    temporal = temporal.getSiguiente();
                }
            }
            anterior.setSiguiente(siguiente);
            siguiente.setAnterior(anterior);
        }
        return eliminar;
    }

    /**
     * Eliminar el primer estudiante de la lista
     *
     * @return Estudiante eliminado
     */
    private Estudiante eliminarPrimero() {
        NodoGenerico<Estudiante> eliminar = primero;
        primero = primero.getSiguiente();
        return eliminar.getDato();
    }

    /**
     * Eliminar el ultimo estudiante de la lista
     *
     * @return Estudiante eliminado
     */
    private Estudiante eliminarUltimo() {
        NodoGenerico<Estudiante> eliminar = ultimo;
        ultimo = ultimo.getAnterior();
        ultimo.setSiguiente(null);
        return eliminar.getDato();
    }

    /**
     * Comprobar si el codigo del estudiante existe en la lista
     *
     * @param estudiante A buscar, usando el codigo
     * @return True si existe, de lo contrario False
     */
    public boolean existeCodigo(Estudiante estudiante) {
        NodoGenerico<Estudiante> temporal = primero;

        while (temporal != null) {

            if (estudiante.getCodigo().equals(temporal.getDato().getCodigo())) {
                return true;
            } else {
                temporal = temporal.getSiguiente();
            }
        }
        return false;
    }

    /**
     * Obtener todos los estudiantes de la lista
     *
     * @return Cadena con toda la lista de estudiantes
     */
    public String getEstudiantes() {
        String estudiantes = "Lista doble Estudiantes:\n";
        NodoGenerico<Estudiante> temporal = primero;

        while (temporal != null) {

            estudiantes += temporal.getDato().toString() + "\n";
            temporal = temporal.getSiguiente();
        }
        return estudiantes;
    }

    /**
     * Obtener todos los estudiantes aprobados de la lista
     *
     * @return Cadena con todo los estudiantes aprobados
     */
    public String getAprobados() {
        String aprobados = "Aprobados:\n";
        NodoGenerico<Estudiante> temporal = primero;

        while (temporal != null) {

            if (estaAprobado(temporal.getDato())) {
                aprobados += temporal.getDato().toString() + "\n";
            }
            temporal = temporal.getSiguiente();
        }
        return aprobados;
    }

    /**
     * Obtener todos los estudiantes reprobados de la lista
     *
     * @return Cadena con todo los estudiantes reprobados
     */
    public String getReprobados() {
        String reprobados = "Reprobados:\n";
        NodoGenerico<Estudiante> temporal = primero;

        while (temporal != null) {

            if (!estaAprobado(temporal.getDato())) {
                reprobados += temporal.getDato().toString() + "\n";
            }
            temporal = temporal.getSiguiente();
        }
        return reprobados;
    }
}
