package modelo;




public class ClienteEstandard extends Cliente {

    // Contructor
    public ClienteEstandard() {}
    public ClienteEstandard(String tipo, String email, String nombre, String domicilio, String nif) {
        super(tipo, email, nombre, domicilio, nif);
        super.setCuota(0);
        super.setDescuento(0);
    }



    public boolean tipoDeCliente(String email) {
        boolean encontrado = false;
        // retornar objeto return OnlineStore.getClientes().stream().filter(cliente -> email.equals(cliente.getEmail())).findFirst().orElse(null);
//        for (Cliente cliente : ListaClientes.getClientes()) {
//            if (cliente instanceof ClienteEstandard) {
//                if (cliente.getEmail().equals(email)) {
//                    encontrado = true;
//                }
//            }
//
//        }
        return encontrado;
    }


    public double cuotaAnual() {
        return 0;
    }


    public double descuentoGastosDeEnvio(double totalPedido) {
        return 0;
    }

    @Override
    public String toString(){
        return 
                "Tipo: " + this.getTipo() + "," +
                "Nombre: " + this.getNombre() + "," +
                "Domicilio: " + this.getDomicilio() + "," +
                "NIF: " + this.getNIF() + "," +
                "Email: " + this.getEmail() + "," +
                "Cuota: " + this.getCuota() + "," +
                "Descuento en el envio: " + this.getDescuento() + "\n" ;
    }
}
