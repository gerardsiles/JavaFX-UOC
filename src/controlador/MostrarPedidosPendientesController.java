/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.net.URL;
import java.security.Timestamp;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Pedido;
import modelo.Datos;

/**
 *
 * @author gerar
 */
public class MostrarPedidosPendientesController implements Initializable {
    private final Datos datos = new Datos();

    
    @FXML
    private TableColumn<Pedido, Integer> cantidad;

    @FXML
    private TableColumn<Pedido, String> codArticulo;

    @FXML
    private TableColumn<Pedido, String> emailCliente;

    @FXML
    private TableColumn<Pedido, Timestamp> fecha;

    @FXML
    private TableColumn<Pedido, Integer> numPedido;

    @FXML
    private TableColumn<Pedido, Boolean> procesado;

    @FXML
    private TableView<Pedido> tabla_pedidos_pendientes;
    
    ObservableList<Pedido> listaPedidos;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       numPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("numeroDePedido"));
       emailCliente.setCellValueFactory(new PropertyValueFactory<Pedido, String>("cliente"));       
       codArticulo.setCellValueFactory(new PropertyValueFactory<Pedido, String>("gastosDeEnvio"));
       cantidad.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("cantidad"));
       fecha.setCellValueFactory(new PropertyValueFactory<Pedido, Timestamp>("fecha"));
       procesado.setCellValueFactory(new PropertyValueFactory<Pedido, Boolean>("procesado"));

       
       listaPedidos = datos.recibirDatosPedidosPendientes();
       tabla_pedidos_pendientes.setItems(listaPedidos);
    }
    
}


