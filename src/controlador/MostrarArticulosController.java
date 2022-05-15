/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;
import modelo.Datos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Articulo;

/**
 *
 * @author gerar
 */
public class MostrarArticulosController  implements Initializable{
        private final Datos datos = new Datos();
// Mostrar cliente
    @FXML
    private TableView<Articulo> tabla_articulos;
    @FXML
    private TableColumn<Articulo, String> col_codigo;

    @FXML
    private TableColumn<Articulo, String> col_descripcion;

    @FXML
    private TableColumn<Articulo, Double> col_gastosEnvio;

    @FXML
    private TableColumn<Articulo, Double> col_pvp;

    @FXML
    private TableColumn<Articulo, Integer> col_tiempo;

    ObservableList<Articulo> listaArticulos;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       col_codigo.setCellValueFactory(new PropertyValueFactory<Articulo, String>("codigoProducto"));
       col_descripcion.setCellValueFactory(new PropertyValueFactory<Articulo, String>("descripcion"));       
       col_gastosEnvio.setCellValueFactory(new PropertyValueFactory<Articulo, Double>("gastosDeEnvio"));
       col_pvp.setCellValueFactory(new PropertyValueFactory<Articulo, Double>("pvp"));
       col_tiempo.setCellValueFactory(new PropertyValueFactory<Articulo, Integer>("tiempoDePreparacion"));

       
       listaArticulos = datos.listarArticulos();
       tabla_articulos.setItems(listaArticulos);
    }
    
}
