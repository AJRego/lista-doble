/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.modelo;

/**
 * Clase con toda la informacion de un estudiante
 *
 * @author ajrego
 */
public class Estudiante {

    //Atributos de un estudiante
    private String codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private Double nota; //De 1.0 a 5.0

    /**
     * Constructor vacio
     */
    public Estudiante() {
    }

    //Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return codigo + "      "
                + nombre + "      "
                + apellido + "      "
                + correo + "      "
                + nota;
    }

}
