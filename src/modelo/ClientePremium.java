package modelo;

import java.math.BigDecimal;

public class ClientePremium extends Cliente {

    // Constructor
    public ClientePremium() {}
    public ClientePremium(String tipo, String email, String nombre, String domicilio, String nif) {
        super(tipo, email, nombre, domicilio, nif);
        super.setCuota(30);
        super.setDescuento(20);
    }



    @Override
    public boolean tipoDeCliente(String email) {
        // TODO
        return false;
    }

    @Override
    public double cuotaAnual() {
        return getCuota();
    }

    @Override
    public double descuentoGastosDeEnvio(double totalPedido) {
        return totalPedido - (totalPedido * 0.2);
    }

    @Override
    public String toString(){
        return 
                "Tipo:" + this.getTipo() + "," +
                "Nombre: " + this.getNombre() + "," +
                "Domicilio: " + this.getDomicilio() + "," +
                "NIF: " + this.getNIF() + "," +
                "Email: " + this.getEmail() + "," +
                "Cuota: " + this.getCuota() + "," +
                "Descuento en el envio: " + this.getDescuento() + "\n";
    }
}
