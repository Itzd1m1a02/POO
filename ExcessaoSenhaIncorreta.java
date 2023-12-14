package teste1;

import javax.swing.JOptionPane;

public class ExcessaoSenhaIncorreta extends Exception {
    private String nome = "Minha Classe Personalizada para senha incorreta.";
    
    public ExcessaoSenhaIncorreta () {
         JOptionPane.showOptionDialog(
                           null
                         , "Usuario ou senha incorretos."
                         , "ALERTA"
                         , JOptionPane.PLAIN_MESSAGE
                         , JOptionPane.WARNING_MESSAGE                              
                         , null
                         , null
                         , "OK"
                        );
    }
}
