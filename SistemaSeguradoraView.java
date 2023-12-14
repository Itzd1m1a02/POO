package teste1;

import java.awt.Color;
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

public class SistemaSeguradoraView {
    private static int instanciasSistemaSeguradoraView = 0;
    private static SistemaSeguradoraView janelaSistemaSeguradoraView = null;
    
    private JFrame frame;
    
    private JPanel mainPanel;
    private JPanel areaClientePanel;
    private JPanel mvcPanel;
    private JPanel promptPanel;
    private JPanel refreshLoginPanel;
    private JPanel bottomPanel;
    
    private JLabel labSistemaSeguradora;
    private JLabel labClienteCPF;
    private JTextField tfUsuario;
    
    //botoes MVC
    private JButton btCadastrar;
    private JButton btPesquisar;
    private JButton btAtualizar;
    private JButton btDeletar;
    
    private JButton btRefresh;
    private JButton btLogin;
    
    private JTextField tfPromptSistemaSeguradora;
    
    private JLabel labAtendente;
    private JLabel labUserInfo;
    private JButton btLogout;
    
    //construtor
    private SistemaSeguradoraView(String usuarioAtendente){
        initComponents(usuarioAtendente);
    }
    
    //inicializar componentes
    private void initComponents(String usuarioAtendente) {
        Font myFont1 = new Font("Arial", Font.BOLD, 30);
        Font myFont2 = new Font("Arial", Font.PLAIN, 20);
        
        this.labSistemaSeguradora = new JLabel ("Sistema Seguradora");
        labSistemaSeguradora.setFont(myFont1);
        
        this.labClienteCPF = new JLabel ("Cliente (CPF)");
        labClienteCPF.setFont(myFont2);
        
        this.tfUsuario = new JTextField();
        
        //botes mvc
        this.btCadastrar = new JButton("CADASTRAR");
        btCadastrar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (tfUsuario.getText().equals("")) 
                    campoUsuarioVazio();
                else {
                    CadastroCliente.criarJanelaCadastroCliente(tfUsuario.getText());
                }
            }
        });
        
        this.btPesquisar = new JButton("PESQUISAR");
        btPesquisar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (tfUsuario.getText().equals("")) 
                    campoUsuarioVazio ();
                else {
                    if ( read( tfUsuario.getText() ) )
                        tfPromptSistemaSeguradora.setText("Usuario encontrado!");
                    else
                        tfPromptSistemaSeguradora.setText("Usuario nao encontrado!");
                } 
            }
        });
        
        this.btAtualizar = new JButton("ATUALIZAR");
        btAtualizar.addActionListener(new ActionListener(){
            boolean usuarioEncontrado = false;
            
            public void actionPerformed(ActionEvent e){
                if (tfUsuario.getText().equals("")) 
                    campoUsuarioVazio ();
                else {
                    int i = -1;
                    for (Cliente cliente : SistemaSeguradora.getInstancia().getListaClientes() ) {
                        i++;
                        if (cliente.cpf.equals(tfUsuario.getText())) {
                            CadastroCliente.criarJanelaCadastroCliente(SistemaSeguradora.getInstancia().getListaClientes().get(i));
                            usuarioEncontrado = true;
                            tfPromptSistemaSeguradora.setText("Usuario encontrado!");
                            return;
                        }
                    }
                    if (!usuarioEncontrado) {
                        tfPromptSistemaSeguradora.setText("Usuario nao encontrado!");
                    }
                }
            }
        });
        
        this.btDeletar = new JButton("DELETAR");
        btDeletar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (tfUsuario.getText().equals("")) 
                    campoUsuarioVazio ();
                else {
                    if ( delete( tfUsuario.getText() ) )
                        tfPromptSistemaSeguradora.setText("Usuario deleteado!");
                    else
                        tfPromptSistemaSeguradora.setText("Usuario não pôde ser deleteado!");
                }
            }
        });
        
        //Prompt
        this.tfPromptSistemaSeguradora = new JTextField();
        tfPromptSistemaSeguradora.setEditable(false);
        tfPromptSistemaSeguradora.setBackground(Color.white);
        
        this.btRefresh = new JButton("REFRESH");
        btRefresh.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                tfUsuario.setText("");
                tfPromptSistemaSeguradora.setText("");
            }
        });
       
        this.btLogin = new JButton("LOGIN");
        btLogin.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                boolean usuarioEncontrado = false;
                
                if (tfUsuario.getText().equals("")) 
                    campoUsuarioVazio ();
                else if ( read( tfUsuario.getText() ) ) {
                    int i = -1;
                    for (Cliente cliente : SistemaSeguradora.getInstancia().getListaClientes() ) {
                        i++;
                        if (cliente.cpf.equals(tfUsuario.getText())) {
                            AreaCliente.abrirJanelaAreaCliente(cliente);
                            usuarioEncontrado = true;
                            tfPromptSistemaSeguradora.setText("Usuario encontrado!");
                            return;
                        }
                    }
                } else
                    tfPromptSistemaSeguradora.setText("Usuario nao encontrado!");
            }
        });
        
        this.labAtendente = new JLabel("Atendente");
        labAtendente.setFont(myFont2);
        
        this.labUserInfo = new JLabel(usuarioAtendente);
        
        this.btLogout = new JButton("LOGOUT");
        btLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sair();
            }
        });
    }//initComponents()

    //MVC
    public void create(Cliente cliente){
        SistemaSeguradoraControl ssControl = new SistemaSeguradoraControl();
        boolean situacaoCreate = ssControl.create(CadastroCliente.getJanela().getCliente());
        if (situacaoCreate)
            tfPromptSistemaSeguradora.setText("Usuario cadastrado!");
        else
            tfPromptSistemaSeguradora.setText("O usuario não pôde ser cadastrado!");
    }//create
    public boolean read(String cpf){
        return new SistemaSeguradoraControl().read(cpf);
    }//read
    public void update(Cliente cliente) {
        SistemaSeguradoraControl ssControl = new SistemaSeguradoraControl();
        boolean situacaoUpdate = ssControl.update(CadastroCliente.getJanela().getCliente());
        if (situacaoUpdate)
            tfPromptSistemaSeguradora.setText("Usuario cadastrado!");
        else
            tfPromptSistemaSeguradora.setText("O usuario não pôde ser cadastrado!");
    }//update
    public boolean delete(String cpf) {
        return new SistemaSeguradoraControl().delete(cpf);
    }//delete
    
    private void campoUsuarioVazio () {
        JOptionPane.showOptionDialog(
                           null
                         , "Digite um CPF para continuar."
                         , "ALERTA"
                         , JOptionPane.PLAIN_MESSAGE
                         , JOptionPane.WARNING_MESSAGE                              
                         , null
                         , null
                         , "OK"
                        );
    }
    
    //funcao principal
    public static void criarJanelaSistemaSeguradoraView (String usuarioAtendente) {
        if (instanciasSistemaSeguradoraView == 0) {
            instanciasSistemaSeguradoraView++;
            janelaSistemaSeguradoraView = new SistemaSeguradoraView(usuarioAtendente);
            janelaSistemaSeguradoraView.displayViewGUI();
        }
    }
    
    public void sair() {
        instanciasSistemaSeguradoraView -= 1;
        janelaSistemaSeguradoraView = null;
        if (CadastroCliente.getJanela() != null)
            CadastroCliente.getJanela().sair();
        frame.dispose();
    }
    
    public static SistemaSeguradoraView getJanela() {return janelaSistemaSeguradoraView;}
    
    public void centerFrame() {
        Dimension currentScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((currentScreen.getWidth()/2 - frame.getWidth()) / 2);
        int y = (int) ((currentScreen.getHeight()/2 - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    public void displayViewGUI () {
        frame = new JFrame("Inicio");
        frame.setBounds(150,0,449,800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //area cliente panel
        areaClientePanel = new JPanel();
        areaClientePanel.setLayout(new GridLayout(2,1,3,3));
        areaClientePanel.setBorder(BorderFactory.createEmptyBorder(25,25,0,25));
        areaClientePanel.add(labClienteCPF);
        areaClientePanel.add(tfUsuario);
        
        //mvcPanel
        mvcPanel = new JPanel();
        mvcPanel.setLayout(new GridLayout(2,2,7,3));
        mvcPanel.setBorder(BorderFactory.createEmptyBorder(0,25,10,25));
        mvcPanel.add(btCadastrar);
        mvcPanel.add(btPesquisar);
        mvcPanel.add(btAtualizar);
        mvcPanel.add(btDeletar);
        
        //promptPanel
        promptPanel = new JPanel();
        promptPanel.setLayout(new GridLayout(1,1,0,0));
        promptPanel.setBorder(BorderFactory.createEmptyBorder(10,25,10,25));
        promptPanel.add(tfPromptSistemaSeguradora);
        
        //refreshLoginPanel
        refreshLoginPanel = new JPanel();
        refreshLoginPanel.setLayout(new GridLayout(2,2,7,3));
        refreshLoginPanel.setBorder(BorderFactory.createEmptyBorder(10,150,0,150));
        refreshLoginPanel.add(btLogin);
        refreshLoginPanel.add(btRefresh);
        
        //bottom panel
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1,2,3,5));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(5,25,10,25));
        bottomPanel.add(labUserInfo);
        bottomPanel.add(btLogout);
        
        //main panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
            //add labSistemaSeguradora
            labSistemaSeguradora.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(labSistemaSeguradora);
        
            //add areaClientePanel
            mainPanel.add(areaClientePanel);
        
            //add mvcPanel
            mainPanel.add(mvcPanel);
            
            //add PromptPanel
            mainPanel.add(promptPanel);
            
            //add refreshLoginPanel
            mainPanel.add(refreshLoginPanel);
        
            //add lab Atendente
            labAtendente.setBorder(BorderFactory.createEmptyBorder(10,25,5,25));
            labAtendente.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(labAtendente);
        
            //add bottomPanel
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
