/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.listaDoble;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Crear un programa que maneje el registro de los estudiantes, utilizando
 * listas doblemente enlazadas. Los estudiantes aprobados deben insertarse al
 * inicio y los reprobados por el final de la lista. Los datos requeridos por
 * cada estudiante son los siguientes: código, nombre, apellidos, correo y nota.
 * 
 * El programa debe permitir realizar las operaciones de:
 *
 * a) Agregar un estudiante
 * b) Buscar un estudiante por codigo
 * c) Eliminar un estudiante por codigo 
 * d) Total de estudiantes aprobados
 * e) Total de estudiante reprobados
 *
 * @author ajrego
 */
public class ListaDobleJavaFx extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/javaFx/vista/FXMLMain.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
