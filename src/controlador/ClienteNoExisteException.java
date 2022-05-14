package controlador;

public class ClienteNoExisteException extends RuntimeException{

    public ClienteNoExisteException(String s){
        super(s);
    }

}
