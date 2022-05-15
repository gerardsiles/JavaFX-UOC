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
import modelo.Cliente;

/**
 *
 * @author gerar
 */
public class MostrarClientesController  implements Initializable{
        private final Datos datos = new Datos();
// Mostrar cliente
    @FXML
    private TableView<Cliente> tabla_clientes;
    @FXML
    private TableColumn<Cliente, String> col_tipoCliente;
    
    @FXML
    private TableColumn<Cliente, Integer> col_cuota;

    @FXML
    private TableColumn<Cliente, Integer> col_descuento;

    @FXML
    private TableColumn<Cliente, String> col_domicilio;

    @FXML
    private TableColumn<Cliente, String> col_email;

    @FXML
    private TableColumn<Cliente, String> col_nif;

    @FXML
    private TableColumn<Cliente, String> col_nombre;

    ObservableList<Cliente> listaClientes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       col_tipoCliente.setCellValueFactory(new PropertyValueFactory<Cliente, String>("tipo"));
       col_nombre.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nombre"));       
       col_nif.setCellValueFactory(new PropertyValueFactory<Cliente, String>("NIF"));
       col_email.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
       col_domicilio.setCellValueFactory(new PropertyValueFactory<Cliente, String>("domicilio"));
       col_descuento.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("descuento"));
       col_cuota.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("cuota"));

       
       listaClientes = datos.recibirDatosClientes();
       tabla_clientes.setItems(listaClientes);
    }
    
}
