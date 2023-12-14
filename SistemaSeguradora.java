package teste1;

import java.util.ArrayList;

public class SistemaSeguradora {
    private static int qtdInstanciasSistemaSeguradora = 0;
    private static SistemaSeguradora instanciaSistemaSeguradora = null;
    
    private ArrayList<Cliente> listaClientes;

    public ArrayList<Cliente> getListaClientes() {return listaClientes;}
    
    private SistemaSeguradora(){
        this.listaClientes = new ArrayList<>();
    }
    
    //funcao principal
    public static void criarInstanciaSistemaSeguradora (String usuarioAtendente) {
        if (qtdInstanciasSistemaSeguradora == 0) {
            qtdInstanciasSistemaSeguradora++;
            instanciaSistemaSeguradora = new SistemaSeguradora();
            SistemaSeguradoraView.criarJanelaSistemaSeguradoraView (usuarioAtendente);
        }
    }
    
    public static void sair() {
        qtdInstanciasSistemaSeguradora -= 1;
        instanciaSistemaSeguradora = null;
        if (SistemaSeguradoraView.getJanela() != null)
            SistemaSeguradoraView.getJanela().sair();
    }
    
    public static SistemaSeguradora getInstancia() {return instanciaSistemaSeguradora;}
    
}
