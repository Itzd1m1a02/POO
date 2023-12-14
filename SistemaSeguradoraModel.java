package teste1;

public class SistemaSeguradoraModel {
    
    public boolean create(Cliente cliente){
        SistemaSeguradora.getInstancia().getListaClientes().add(cliente);
        return true;
    }
    public boolean read(String cpf){
        for (Cliente cliente : SistemaSeguradora.getInstancia().getListaClientes() ) {
            if (cliente.cpf.equals(cpf))
                return true;
        }
        return false;
    }
    public boolean update(Cliente cliente){
        int i = -1;
        for (Cliente clienteEx : SistemaSeguradora.getInstancia().getListaClientes() ) {
            i++;
            if (clienteEx.cpf.equals(cliente.cpf)) {
                SistemaSeguradora.getInstancia().getListaClientes().set(i, cliente);
                return true;
            }
        }
        return false;
    }
    public boolean delete(String cpf){
        int i = -1;
        for (Cliente cliente : SistemaSeguradora.getInstancia().getListaClientes() ) {
            i++;
            if (cliente.cpf.equals(cpf)) {
                SistemaSeguradora.getInstancia().getListaClientes().remove(i);
                return true;
            }
        }
        return false;
    }
}
