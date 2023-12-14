package teste1;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginSeguradora {
    private JFrame frame;//
    
    private JPanel mainPanel;//
    private JPanel registerPanel;
    
    private JLabel labLoginAtendente;
    private JLabel labUsuario;
    private JLabel labSenha;
    
    private JButton btLogin;
    private JButton btSair;
    
    private JTextField tfUsuario;
    private JTextField tfSenha;
    
    private String strUsuario;//
    private String strSenha;//
    
    public LoginSeguradora(){
        this.strUsuario = "admin";
        this.strSenha = "password";
        
        Font myFont1 = new Font("Arial", Font.BOLD, 30);
        this.labLoginAtendente = new JLabel ("Login Seguradora");
        labLoginAtendente.setFont(myFont1);
        
        Font myFont2 = new Font("Arial", Font.PLAIN, 20);
        this.labUsuario = new JLabel ("Usuario");
        labUsuario.setFont(myFont2);
        this.tfUsuario = new JTextField();
        //this.tfUsuario.setText("admin");
        
        this.labSenha = new JLabel ("Senha");
        labSenha.setFont(myFont2);
        this.tfSenha = new JTextField();
        //this.tfSenha.setText("password");
        
        this.btLogin = new JButton("LOGIN");
        btLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    if ( verificarLogin(tfUsuario.getText(),tfSenha.getText()) ) {
                        LoginAtendente.criarJanelaLoginAtendente(tfUsuario.getText());
                        tfUsuario.setText("");
                        tfSenha.setText("");
                    } else {
                        tfUsuario.setText("");
                        tfSenha.setText("");
                        throw new ExcessaoSenhaIncorreta();
                    }
                } catch (ExcessaoSenhaIncorreta exp) {
                    
                }
            }
        });
        
        this.btSair = new JButton("SAIR");
        btSair.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sair();
            }
        });
    }
    
    public boolean verificarLogin(String user, String senha){
        if (user.equals(strUsuario))
            if (senha.equals(strSenha))
                return true;
        return false;
    }
    
    public void sair() {
        if (LoginAtendente.getJanela() != null)
            LoginAtendente.getJanela().sair();
        frame.dispose();
    }
    
    public void centerFrame() {
        Dimension currentScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((currentScreen.getWidth()/2 - frame.getWidth()) / 2);
        int y = (int) ((currentScreen.getHeight()/2 - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    public void displayGUI () {
        frame = new JFrame("Inicio");
        frame.setBounds(150,0,449,800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //register panel
        registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(4,2,3,3));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        registerPanel.add(labUsuario);
        registerPanel.add(tfUsuario);
        registerPanel.add(labSenha);
        registerPanel.add(tfSenha);
        
        //main panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
        labLoginAtendente.setAlignmentX(Component.CENTER_ALIGNMENT);
        btLogin.setAlignmentX(Component.CENTER_ALIGNMENT);
        btSair.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        mainPanel.add(labLoginAtendente);
        mainPanel.add(registerPanel);
        mainPanel.add(btLogin);
        mainPanel.add(btSair);
        
        //final frame settings
        frame.setContentPane(mainPanel);
        frame.pack();
        centerFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void main(String[] args) {
        new LoginSeguradora().displayGUI();
    }
    
}
