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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginAtendente {
    private static int instanciasLoginAtendente = 0;
    private static LoginAtendente janelaLoginAtendente = null;
    
    private JFrame frame;
    
    private JPanel mainPanel;
    private JPanel registerPanel;
    private JPanel bottomPanel;
    
    private JLabel labLoginAtendente;
    private JLabel labUsuario;
    private JLabel labSenha;
    
    private JButton btLogin;
    
    private JTextField tfUsuario;
    private JTextField tfSenha;
    
    private JLabel labSeguradora;
    private JLabel labUserInfo;
    private JButton btLogout;
    
    private String strUsuario;
    private String strSenha;
    
    private LoginAtendente(String usuarioSeguradora){
        initComponents(usuarioSeguradora);
    }
    
    public static void criarJanelaLoginAtendente (String usuarioSeguradora) {
        if (instanciasLoginAtendente == 0) {
            instanciasLoginAtendente++;
            janelaLoginAtendente = new LoginAtendente(usuarioSeguradora);
            janelaLoginAtendente.displayGUI();
        }
    }
    
    public void sair() {
        instanciasLoginAtendente -= 1;
        janelaLoginAtendente = null;
        SistemaSeguradora.sair();
        frame.dispose();
    }
    
    public static LoginAtendente getJanela() {
        return janelaLoginAtendente;
    }
    
    private void initComponents(String usuarioSeguradora) {
        this.strUsuario = "Tadao";
        this.strSenha = "japa";
        
        Font myFont1 = new Font("Arial", Font.BOLD, 30);
        this.labLoginAtendente = new JLabel ("Login Atendente");
        labLoginAtendente.setFont(myFont1);
        
        Font myFont2 = new Font("Arial", Font.PLAIN, 20);
        this.labUsuario = new JLabel ("Usuario");
        labUsuario.setFont(myFont2);
        this.tfUsuario = new JTextField();
        //this.tfUsuario.setText("Tadao");
        
        this.labSenha = new JLabel ("Senha");
        labSenha.setFont(myFont2);
        this.tfSenha = new JTextField();
        //this.tfSenha.setText("japa");
        
        this.btLogin = new JButton("LOGIN");
        btLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    if ( verificarLogin(tfUsuario.getText(),tfSenha.getText()) ) {
                        SistemaSeguradora.criarInstanciaSistemaSeguradora(tfUsuario.getText());
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
        
        this.labSeguradora = new JLabel("Seguradora");
        labSeguradora.setFont(myFont2);
        
        this.labUserInfo = new JLabel(usuarioSeguradora);
        
        this.btLogout = new JButton("LOGOUT");
        btLogout.addActionListener(new ActionListener(){
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
    
    public void centerFrame() {
        Dimension currentScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((currentScreen.getWidth()/2 - frame.getWidth()) / 2);
        int y = (int) ((currentScreen.getHeight()/2 - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    public void displayGUI () {
        frame = new JFrame("Inicio");
        frame.setBounds(150,0,449,800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //register panel
        registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(4,1,3,3));
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
        
        mainPanel.add(labLoginAtendente);
        mainPanel.add(registerPanel);
        mainPanel.add(btLogin);
        
        labSeguradora.setBorder(BorderFactory.createEmptyBorder(25,0,0,25));
        labSeguradora.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(labSeguradora);
        
        //bottom panel
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2,3,5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(3,25,25,25));
        bottomPanel.add(labUserInfo);
        bottomPanel.add(btLogout);
        
        mainPanel.add(bottomPanel);
        
        //final frame settings
        frame.setContentPane(mainPanel);
        frame.pack();
        centerFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
