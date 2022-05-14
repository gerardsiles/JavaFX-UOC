package controlador;

public class PedidoNoExisteException extends RuntimeException {
    public PedidoNoExisteException(String s){
        super(s);
    }

}
