package teste1;

public class SistemaSeguradoraControl {
    
    
    public boolean create(Cliente cliente){
        //SistemaSeguradoraModel ssModel = new SistemaSeguradoraModel();
        //boolean situacaoModel = ssModel.create(cliente);
        //return situacaoModel;
        return new SistemaSeguradoraModel().create(cliente);
    }
    
    public boolean read(String cpf){
        //SistemaSeguradoraModel ssModel = new SistemaSeguradoraModel();
        //boolean situacaoModel = ssModel.read(cpf);
        //return situacaoModel;
        return new SistemaSeguradoraModel().read(cpf);
    }
    
    public boolean update(Cliente cliente){
        return new SistemaSeguradoraModel().update(cliente);
    }
    
    public boolean delete(String cpf){
        return new SistemaSeguradoraModel().delete(cpf);
    }
}
