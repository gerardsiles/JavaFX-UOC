package controlador;

public class ArticuloNoExisteException extends RuntimeException {

    public ArticuloNoExisteException(String s){
        super(s);
    }
}
