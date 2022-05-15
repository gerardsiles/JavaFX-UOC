package controlador;

// importar modelo
import modelo.Articulo;
import modelo.Datos;
// importar vista


import modelo.Datos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Button;



public class Controlador  {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private final Datos datos = new Datos();

    @FXML
    private StackPane contentArea;
    @FXML
//    Agregar cliente
    private Label agregarClienteLabel;
    @FXML
    private Label agregarClienteLabelConfirmacion;
    @FXML
    private TextField email;
    @FXML
    private TextField cuota;
    @FXML
    private TextField descuento;
    @FXML
    private TextField domicilio;
    @FXML
    private TextField nif;
    @FXML
    private TextField nombre;
    @FXML
    private TextField tipoCliente;


//    agregar articulo 
    @FXML
    private Label agregarArticuloLabel;
    @FXML
    private Label agregarArticuloLabelConfirmacion;
    @FXML
    private TextField codigoProducto;
    @FXML
    private TextField descripcion;
    @FXML
    private TextField pvp;
    @FXML
    private TextField gastosEnvio;
    @FXML
    private TextField tiempoPreparacion;    
    
    // Agregar pedido

    @FXML
    private TextField codArticulo;

    @FXML
    private TextField cantidad;

    @FXML
    private TextField emailPedido;

    @FXML
    private Label pedidoErrorLabel;

    @FXML
    private Button submitButton;

    @FXML
    private Label pedidoSuccessLabel;
    
    // Borrar pedido
    
    @FXML
    private TextField codPedido;

    @FXML
    private Label pedidoBorrarErrorLabel;

    @FXML
    private Label pedidoBorrarSuccessLabel;


    
    @FXML
    protected void onMenuClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    public void onAgregarClienteClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../vista/agregar-cliente.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onAgregarArticuloClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../vista/agregar-articulo.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void onMostrarArticulosClick(ActionEvent actionEvent) {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("../vista/mostrar-articulos.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onMostrarClientesClick(ActionEvent actionEvent) {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("../vista/mostrar-clientes.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onStandardClick(ActionEvent actionEvent) {
        try {
        Parent root = FXMLLoader.load(getClass().getResource("../vista/mostrar-clientes-standard.fxml"));
        contentArea.getChildren().removeAll();
        contentArea.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void onPremiumClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../vista/mostrar-clientes-premium.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onPedidoClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../vista/agregar-pedido.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void onEliminarPedidoClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../vista/borrar-pedido.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onPedidosPendientesClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../vista/mostrar-pedidos-pendientes.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public void onPedidosEnviadosClick(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../vista/mostrar-pedidos-enviados.fxml"));
            contentArea.getChildren().removeAll();
            contentArea.getChildren().setAll(root);
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // MENU PRINCIPAL





    // GESTION DE ARTICULOS




    public void agregarArticulo(ActionEvent event) {
        boolean creado = false;
        List parametros = new ArrayList<>();

        
        if (codigoProducto.getText().isEmpty() || descripcion.getText().isEmpty()|| pvp.getText().isEmpty()
                || gastosEnvio.getText().isEmpty() || tiempoPreparacion.getText().isEmpty()){
            agregarArticuloLabel.setText("No pueden haber campos vacios");
            return;
        } else {
            parametros.add(codigoProducto.getText());
            parametros.add(descripcion.getText());
            parametros.add(pvp.getText());
            parametros.add(gastosEnvio.getText());
            parametros.add(tiempoPreparacion.getText());
        }
        
//        // enviar informacion a Datos si la informacion no esta vacia
        if (!parametros.isEmpty()) {
            // Comprobar si el articulo existe antes de crearlo
            if (!datos.articuloExiste(parametros.get(0).toString())){
                creado = datos.crearArticulo(parametros);
                agregarArticuloLabelConfirmacion.setText("Articulo creado");
            }
        }
//        vista.articuloCreado(creado);
    }

    public void mostrarArticulos() {
//        // Crear una array temporal para recibir articulos
//        List<Articulo> lista = new ArrayList<>();
//        // Llenar la array con los articulos
//        lista = modelo.listarArticulos();
//        // Llamar a la vista para mostrar los articulos
//        vista.printMostrarArticulos(lista);
    }
    // FIN GESTION DE ARTICULOS

    // GESTION DE CLIENTES




    public void agregarCliente(ActionEvent event) {
        boolean creado;
        boolean existe;
        List parametros = new ArrayList();
//        parametros = vista.printAgregarCliente();
        /* Comprobar que los campos no esten vacios */
        if((nombre.getText().isEmpty() || email.getText().isEmpty() || cuota.getText().isEmpty() || descuento.getText().isEmpty() || domicilio.getText().isEmpty()) || nif.getText().isEmpty()) {
            agregarClienteLabel.setText("No pueden haber campos vacios");
            return;
        } else {
            parametros.add(tipoCliente.getText());
            parametros.add(email.getText());
            parametros.add(nombre.getText());
            parametros.add(domicilio.getText());
            parametros.add(nif.getText());
            parametros.add(cuota.getText());
            parametros.add(descuento.getText());
        }

        if (!parametros.isEmpty()) {
            // comprobar si el cliente introducido ya existe
            existe = datos.clienteExiste(email.getText());
            if(!existe) {
                creado = datos.crearCliente(parametros);
                agregarClienteLabelConfirmacion.setText("Cliente creado con exito");
            }
        }

    }



    // metodo para mostrar los clientes
    public void mostrarClientes() {
//        List lista = modelo.recibirDatosClientes();
//        vista.printMostrarClientes(lista);
    }

    // metodo para mostrar clientes estandard
    public void mostrarClientesEstandard() {
//        List lista = modelo.recibirDatosClientesEstandard();
//        vista.printMostrarClientesEstandard(lista);
    }

    public void mostrarClientesPremium() {
//        List lista = modelo.recibirDatosClientesPremium();
//        vista.printMostrarClientesPremium(lista);
    }

    // FIN GESTION DE CLIENTES


    //  GESTION DE PEDIDOS


    // metodo para agregar un pedido
    public void agregarPedido() {
        pedidoErrorLabel.setText("");
        List parametros = new ArrayList<>();
        boolean pedidoCreado = false;

        if (cantidad.getText().isEmpty() || emailPedido.getText().isEmpty() || codArticulo.getText().isEmpty()){
            pedidoErrorLabel.setText("No pueden haber campos vacios");
        } else {            
            if (!datos.articuloExiste(codArticulo.getText())) {
                pedidoErrorLabel.setText("Este articulo no existe");
                return;
            }
                //  comprobar si el cliente existe
            if (!datos.clienteExiste(emailPedido.getText())) {
               pedidoErrorLabel.setText("Este cliente no existe");
                return;
            } 

            
            parametros.add(codArticulo.getText());
            parametros.add(emailPedido.getText());
            parametros.add(cantidad.getText());
            // Llamar al modelo para crear el pedido
            pedidoCreado = datos.crearDatosPedido(parametros);
            // informar a la vista si se ha creado el pedido
            if (pedidoCreado){
                pedidoSuccessLabel.setText("Pedido creado");
            }
        }
    }


    // metodo para eliminar un pedido
    public void borrarPedido(ActionEvent event) {
        pedidoBorrarErrorLabel.setText("");
        boolean pedidoEliminado;
        
//        // llamar al modelo para eliminar el pedido
        pedidoEliminado = datos.eliminarPedido(Integer.parseInt(codPedido.getText()));
//
//        // informar si el pedido se ha eliminado
        if(pedidoEliminado) {
            pedidoBorrarSuccessLabel.setText("Pedido borrado");
        } else {
            pedidoBorrarErrorLabel.setText("Ha ocurrido un error, vuelvelo a intentar");
        }

    }

    // metodo para mostrar los pedidos pendientes de envio
    public void mostrarPedidosPendientes() {
//        List lista = new ArrayList<>();
//        // llenar la lista con los pedidos pendientes
//        lista = modelo.recibirDatosPedidosPendientes();
//        // enviar la lista a vista
//        vista.printMostrarPedidosPendientes(lista);
    }

    // metodo para mostrar los pedidos enviados
    public void mostrarPedidosEnviados() {
//        List lista = new ArrayList<>();
//        // llenar la lista con los pedidos enviados
//        lista = modelo.recibirDatosPedidosEnviados();
//        // enviar la lista a vista para ser impresa
//        vista.printMostrarPedidosEnviados(lista);
    }

    // FIN GESTION DE PEDIDOS




}
