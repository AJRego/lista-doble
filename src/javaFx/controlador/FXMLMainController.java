/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaFx.controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javaFx.modelo.Estudiante;
import javaFx.modelo.ListaEstudiante;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ajrego
 */
public class FXMLMainController implements Initializable {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombres;

    @FXML
    private TextField txtApellidos;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNota;

    @FXML
    private TextArea txtListaEstudiantes;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnAprobados;

    @FXML
    private Button btnReprobados;

    @FXML
    private Button btnLimpiar;

    //Instanciamos la lista de estudiante
    private final ListaEstudiante listaEstudiante = new ListaEstudiante();

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    void handleButtonAction(ActionEvent event) {
        /* Evento que escucha las acciones de los botones */

        if (event.getSource() == btnAgregar) {
            /* Accion cuando se presiona el boton agregar */
            Estudiante estudianteAgregado = new Estudiante();
            estudianteAgregado.setCodigo(txtCodigo.getText());
            estudianteAgregado.setNombre(txtNombres.getText());
            estudianteAgregado.setApellido(txtApellidos.getText());
            estudianteAgregado.setCorreo(txtCorreo.getText());
            estudianteAgregado.setNota(Double.parseDouble(txtNota.getText()));

            if (!listaEstudiante.existeCodigo(estudianteAgregado)) {
                /* Si el codigo del estudiante no existe se agrega a la lista */
                listaEstudiante.agregarEstudiante(estudianteAgregado);
                txtListaEstudiantes.setText(listaEstudiante.getEstudiantes());
                limpiar();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("AGREGAR ESTUDIANTE - LISTA DOBLE");
                alerta.setHeaderText("Error agregando.");
                alerta.setContentText("El codigo " + estudianteAgregado.getCodigo() + " ya existe.");
                alerta.showAndWait();
            }
        }

        if (event.getSource() == btnBuscar) {
            /* Accion cuando se presiona el boton buscar */
            String codigo = txtCodigo.getText();
            Estudiante estudianteBuscado = listaEstudiante.getEstudiantePorCodigo(codigo);

            if (estudianteBuscado != null) {
                /* Si el estudiante buscado no es nulo se muestra en el text area */
                txtListaEstudiantes.setText(estudianteBuscado.toString());
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("BUSCAR ESTUDIANTE - LISTA DOBLE");
                alerta.setHeaderText("Error buscando.");
                alerta.setContentText("El codigo no existe.");
                alerta.showAndWait();
            }
        }

        if (event.getSource() == btnLimpiar) {
            /* Accion cuando se presiona el boton limpiar */
            limpiar();
        }

        if (event.getSource() == btnEliminar) {
            /* Accion cuando se presiona el boton eliminar */
            String codigo = txtCodigo.getText();
            Estudiante estudianteEliminar = new Estudiante();
            estudianteEliminar.setCodigo(codigo);
            if (listaEstudiante.existeCodigo(estudianteEliminar)) {
                /* Si el codigo del estudiante a eliminar existe, se elimina de la lista */
                Estudiante estudianteEliminado = listaEstudiante.eliminarEstudiantePorCodigo(codigo);
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("ELIMINAR ESTUDIANTE - LISTA DOBLE");
                alerta.setHeaderText("Estudiante eliminado: ");
                alerta.setContentText(estudianteEliminado.toString());
                alerta.showAndWait();
                limpiar();
            } else {
                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("ELIMINAR ESTUDIANTE - LISTA DOBLE");
                alerta.setHeaderText("Error eliminando.");
                alerta.setContentText("El codigo " + estudianteEliminar.getCodigo() + " no existe.");
                alerta.showAndWait();
            }
        }

        if (event.getSource() == btnAprobados) {
            /* Accion cuando se presiona el boton aprobados */
            txtListaEstudiantes.setText(listaEstudiante.getAprobados());
        }

        if (event.getSource() == btnReprobados) {
            /* Accion cuando se presiona el boton reprobados */
            txtListaEstudiantes.setText(listaEstudiante.getReprobados());
        }
    }

    /**
     * Limpiar todos los campos y resetear el text area de la lista de
     * estudiantes
     */
    private void limpiar() {
        txtCodigo.setText("");
        txtNombres.setText("");
        txtApellidos.setText("");
        txtCorreo.setText("");
        txtNota.setText("");
        txtListaEstudiantes.setText(listaEstudiante.getEstudiantes());
    }
}
