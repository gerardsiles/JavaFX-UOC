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


public class Controlador  {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private final Datos datos = new Datos();

    @FXML
    private StackPane contentArea;
    @FXML
    private Label agregarClienteLabel;
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
    private TextField codigoProducto;
    @FXML
    private TextField descripcion;
    @FXML
    private TextField pvp;
    @FXML
    private TextField gastosEnvio;
    @FXML
    private TextField tiempoPreparacion;    
    
    
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
    }

    public void onPremiumClick(ActionEvent actionEvent) {
    }

    public void onPedidosClick(ActionEvent actionEvent) {
        
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
                agregarArticuloLabel.setText("Articulo creado");
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
//        if(nombre.getText().isBlank() || email.getText().isBlank() || cuota.getText().isBlank() ||
//           descuento.getText().isBlank() || domicilio.getText().isBlank() || nif.getText().isBlank()){
//            agregarClienteLabel.setText("No pueden haber campos vacios");
//            return;
        if (nombre.getText().isEmpty()){
            agregarClienteLabel.setText("No pueden haber campos vacios");
            return;
        } else {
            parametros.add(tipoCliente.getText());
            parametros.add(email.getText());
            parametros.add(cuota.getText());
            parametros.add(descuento.getText());
            parametros.add(domicilio.getText());
            parametros.add(nif.getText());
            parametros.add(nombre.getText());
            System.out.println(parametros);
        }

        if (!parametros.isEmpty()) {
            // comprobar si el cliente introducido ya existe
            existe = datos.clienteExiste(email.getText());
            if(!existe) {
                creado = datos.crearCliente(parametros);
                agregarClienteLabel.setText("Cliente creado con exito");
                agregarClienteLabel.setText("Articulo creado");
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
    public void agregarPedido() throws Exception {
//        List parametros = new ArrayList<>();
//        boolean pedidoCreado = false;
//        String codigoArticulo = "";
//        String emailCliente = "";
//        int cantidad = 0;
//
//        // recibir el codigo del articulo
//        try {
//            codigoArticulo = vista.printAgregarPedido();
//            // comprobar si el articulo existe
//            if (!modelo.articuloExiste(codigoArticulo)) {
//                // lanzar error si el articulo no existe
//                throw new ArticuloNoExisteException("Este articulo no existe");
//            } else {
//                parametros.add(codigoArticulo);
//            }
//        } catch (ArticuloNoExisteException ex) { // manejar la excepcion
//            ex.printStackTrace();
//        }
//
//        // recibir el email del cliente
//        try {
//            emailCliente = vista.printGetClientePedido();
//            // comprobar si el cliente existe
//            if (!modelo.clienteExiste(emailCliente)) {
//                // lanzar error si el cliente no existe
//                throw new ClienteNoExisteException("Este cliente no existe");
//            } else {
//                parametros.add(emailCliente);
//            }
//        } catch (ClienteNoExisteException ex) {
//            ex.printStackTrace();
//        }
//
//        // recibir la cantidad
//        cantidad = vista.printGetCantidadPedido();
//        parametros.add(cantidad);
//
//
//        // Llamar al modelo para crear el pedido
//        pedidoCreado = modelo.crearDatosPedido(parametros);
//
//        // informar a la vista si se ha creado el pedido
//        vista.pedidoCreado(pedidoCreado);
    }


    // metodo para eliminar un pedido
    public void eliminarPedido() throws Exception {
//        int numPedido;
//        boolean pedidoEliminado;
//
//        // recibir el número del pedido a ser borrado
//        numPedido = vista.printEliminarPedido();
//
//        // llamar al modelo para eliminar el pedido
//        pedidoEliminado = modelo.eliminarPedido(numPedido);
//
//        // informar si el pedido se ha eliminado
//        vista.pedidoEliminado(pedidoEliminado);

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
