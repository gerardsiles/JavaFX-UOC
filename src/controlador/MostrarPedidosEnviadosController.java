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
import modelo.Articulo;
import modelo.Cliente;
import modelo.Datos;
import modelo.Pedido;

/**
 *
 * @author gerar
 */
public class MostrarPedidosEnviadosController implements Initializable{
    private final Datos datos = new Datos();

    
    @FXML
    private TableColumn<Pedido, Integer> cantidad;

    @FXML
    private TableColumn<Pedido, Articulo> codArticulo;

    @FXML
    private TableColumn<Pedido, Cliente> emailCliente;

    @FXML
    private TableColumn<Pedido, Timestamp> fecha;

    @FXML
    private TableColumn<Pedido, Integer> numPedido;

    @FXML
    private TableColumn<Pedido, Boolean> procesado;

    @FXML
    private TableView<Pedido> tabla_pedidos_enviados;
    
    ObservableList<Pedido> listaPedidos;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       numPedido.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("numeroDePedido"));
       emailCliente.setCellValueFactory(new PropertyValueFactory<Pedido, Cliente>("cliente"));       
       codArticulo.setCellValueFactory(new PropertyValueFactory<Pedido, Articulo>("gastosDeEnvio"));
       cantidad.setCellValueFactory(new PropertyValueFactory<Pedido, Integer>("cantidad"));
       fecha.setCellValueFactory(new PropertyValueFactory<Pedido, Timestamp>("fecha"));
       procesado.setCellValueFactory(new PropertyValueFactory<Pedido, Boolean>("procesado"));

       
       listaPedidos = datos.recibirDatosPedidosEnviados();
       tabla_pedidos_enviados.setItems(listaPedidos);
    } 
}
