package teste1;

import java.util.Date;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CadastroCliente {
    private static int instanciasCadastroCliente = 0;
    private static CadastroCliente instanciaJanelaCadastroCliente = null;
    
    //Variaveis da instancia do cliente
    private Cliente cliente;
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private String numTelefone;
    private DadosFinanceiros dadosFinanceiros;

    public Cliente getCliente() {
        Cliente clienteTemp = this.cliente;
        sair();
        return clienteTemp;
    }
    public DadosFinanceiros getDadosFinanceiros() {return dadosFinanceiros;}
    public void setDadosFinanceiros(DadosFinanceiros dadosFinanceiros) {this.dadosFinanceiros = dadosFinanceiros;}
    
    private boolean camposVerificados = true;
    
    //Componentes graficos
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel registerPanel;
    private JPanel buttonsPanel;
    
    private JLabel labCadastroCliente;
    
    private JLabel labCPF;
    private JLabel labNome;
    private JLabel labDataNascimento;
    private JLabel labEmail;
    private JLabel labNumeroContato;
    
    private JTextField tfCPF;
    private JTextField tfNome;
    private JTextField tfDataNascimento;
    private JTextField tfEmail;
    private JTextField tfNumeroContato;
    
    private JLabel labDadosFinanceiros;
    private JButton btContinuar;
    
    private JButton btCancelar;
    
    //Construtores
    private CadastroCliente (String cpf) {
        this.cpf = cpf;
        initComponents(this.cpf);
    }
    private CadastroCliente (Cliente cliente) {
        this.cliente = cliente;
        this.cpf = cliente.cpf;
        this.nome = cliente.getNome();
        this.dataNascimento = cliente.getDataNascimento();
        this.email = cliente.getEmail();
        this.numTelefone = cliente.getNumTelefone();
        initComponents(cliente);
    }
    
    //funcoes principais
    public static void criarJanelaCadastroCliente(String cpf) {
        if (instanciasCadastroCliente == 0) {
            instanciasCadastroCliente++;
            instanciaJanelaCadastroCliente = new CadastroCliente(cpf);
            instanciaJanelaCadastroCliente.displayGUI();
        }
    }
    public static void criarJanelaCadastroCliente(Cliente cliente) {
        if (instanciasCadastroCliente == 0) {
            instanciasCadastroCliente++;
            instanciaJanelaCadastroCliente = new CadastroCliente(cliente);
            instanciaJanelaCadastroCliente.displayGUI();
        }
    }
    
    public static CadastroCliente getJanela() {return instanciaJanelaCadastroCliente;}
    
    //iniciadores dos componentes graficos
    private void initComponents(String cpf){
        Font myFont1 = new Font("Arial", Font.BOLD, 30);
        Font myFont2 = new Font("Arial", Font.PLAIN, 20);
        
        this.labCadastroCliente = new JLabel("Cadastro Cliente");
        labCadastroCliente.setFont(myFont1);
        
        this.labCPF = new JLabel("CPF");
        labCPF.setFont(myFont2);
        this.tfCPF = new JTextField();
        tfCPF.setText(cpf);
        tfCPF.setEditable(false);

        this.labNome = new JLabel("Nome");
        labNome.setFont(myFont2);
        this.tfNome = new JTextField();
        
        this.labDataNascimento = new JLabel("Data de Nasc.");
        labDataNascimento.setFont(myFont2);
        this.tfDataNascimento = new JTextField();
        
        this.labEmail = new JLabel("Email");
        labEmail.setFont(myFont2);
        this.tfEmail = new JTextField();
        
        this.labNumeroContato = new JLabel("nº p/ Contato");
        labNumeroContato.setFont(myFont2);
        this.tfNumeroContato = new JTextField();
        
        this.labDadosFinanceiros = new JLabel("Dados Financeiros");
        labNumeroContato.setFont(myFont2);
        this.btContinuar = new JButton("Continuar");
        btContinuar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                camposVerificados = verificarCamposCliente();
                if (camposVerificados) {
                    nome = tfNome.getText();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    dataNascimento = LocalDate.parse(tfDataNascimento.getText(), formato);
                    email = tfNome.getText();
                    numTelefone = tfNome.getText();
                    dadosFinanceiros = new DadosFinanceiros();
                    DadosFinanceirosView.criarJanelaDadosFinanceirosView();
                }
                else {
                    JOptionPane.showOptionDialog(
                           null
                         , "Preencha todos os campos para prosseguir."
                         , "ALERTA"
                         , JOptionPane.PLAIN_MESSAGE
                         , JOptionPane.WARNING_MESSAGE                              
                         , null
                         , null
                         , "OK"
                        );
                }
            }
        });
        
        this.btCancelar = new JButton("CANCELAR");
        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }
    
    private void initComponents(Cliente cliente){
        Font myFont1 = new Font("Arial", Font.BOLD, 30);
        Font myFont2 = new Font("Arial", Font.PLAIN, 20);
        
        this.labCadastroCliente = new JLabel("Cadastro Cliente");
        labCadastroCliente.setFont(myFont1);
        
        this.labCPF = new JLabel("CPF");
        labCPF.setFont(myFont2);
        this.tfCPF = new JTextField();
        tfCPF.setText(cliente.cpf);
        tfCPF.setEditable(false);

        this.labNome = new JLabel("Nome");
        labNome.setFont(myFont2);
        this.tfNome = new JTextField();
        tfNome.setText(cliente.getNome());
        
        this.labDataNascimento = new JLabel("Data de Nasc.");
        labDataNascimento.setFont(myFont2);
        this.tfDataNascimento = new JTextField();
        tfDataNascimento.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(this.dataNascimento));
        
        this.labEmail = new JLabel("Email");
        labEmail.setFont(myFont2);
        this.tfEmail = new JTextField();
        tfEmail.setText(cliente.getEmail());
        
        this.labNumeroContato = new JLabel("nº p/ Contato");
        labNumeroContato.setFont(myFont2);
        this.tfNumeroContato = new JTextField();
        tfNumeroContato.setText(cliente.getNumTelefone());
        
        this.labDadosFinanceiros = new JLabel("Dados Financeiros");
        labNumeroContato.setFont(myFont2);
        
        this.btContinuar = new JButton("Continuar");
        btContinuar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                camposVerificados = verificarCamposCliente();
                if (camposVerificados) {
                    nome = tfNome.getText();
                    DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    dataNascimento = LocalDate.parse(tfDataNascimento.getText(), formato);
                    email = tfNome.getText();
                    numTelefone = tfNome.getText();
                    dadosFinanceiros = new DadosFinanceiros(
                            cliente.getDadosFinanceiros().getProfissao(),
                            cliente.getDadosFinanceiros().getRendaMedia(),
                            cliente.getDadosFinanceiros().getSituacaoSerasa());
                    DadosFinanceirosView.criarJanelaDadosFinanceirosView(dadosFinanceiros);
                }
                else {
                    JOptionPane.showOptionDialog(
                           null
                         , "Preencha todos os campos para prosseguir."
                         , "ALERTA"
                         , JOptionPane.PLAIN_MESSAGE
                         , JOptionPane.WARNING_MESSAGE                              
                         , null
                         , null
                         , "OK"
                        );
                }
            }
        });
        
        this.btCancelar = new JButton("CANCELAR");
        btCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sair();
            }
        });
    }
    
    private boolean verificarCamposCliente(){
        if (tfCPF.getText().equals(""))
            return false;
        if (tfNome.getText().equals(""))
            return false;
        if (tfDataNascimento.getText().equals(""))
            return false;
        if (tfEmail.getText().equals(""))
            return false;
        if (tfNumeroContato.getText().equals(""))
            return false;
        return true;
    }
    
    public void finalizar(String modo) {
        this.cliente = new Cliente(cpf);
        cliente.setNome(this.nome);
        cliente.setDataNascimento(this.dataNascimento);
        cliente.setEmail(this.email);
        cliente.setNumTelefone(this.numTelefone);
        cliente.setDadosFinanceiros(this.dadosFinanceiros);
        if (modo.equals("create"))
            SistemaSeguradoraView.getJanela().create(this.cliente);
        else if (modo.equals("update"))
            SistemaSeguradoraView.getJanela().update(this.cliente);
        sair();
    }
    
    public void sair() {
        instanciasCadastroCliente = 0;
        instanciaJanelaCadastroCliente = null;
        frame.dispose();
    }

    public void centerFrame() {
        Dimension currentScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((currentScreen.getWidth()/2 - frame.getWidth()) / 2);
        int y = (int) ((currentScreen.getHeight()/2 - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    private void displayGUI() {
        frame = new JFrame("Inicio");
        frame.setBounds(150, 0, 449, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    
        // register panel
        registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(7, 2, 3, 3)); // Ajustado o número de linhas para acomodar todos os campos
        registerPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        
        registerPanel.add(labCPF);
        registerPanel.add(tfCPF);
        
        registerPanel.add(labNome);
        registerPanel.add(tfNome);
        
        registerPanel.add(labDataNascimento);
        registerPanel.add(tfDataNascimento);
        
        registerPanel.add(labEmail);
        registerPanel.add(tfEmail);
        
        registerPanel.add(labNumeroContato);
        registerPanel.add(tfNumeroContato);
    
        registerPanel.add(labDadosFinanceiros);
        registerPanel.add(btContinuar);
        
        //buttonsPanel
        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(2, 1, 0, 10)); // Ajustado o número de linhas para acomodar todos os campos
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 25, 25, 25));
        
        // main panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        labCadastroCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
        btContinuar.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(labCadastroCliente);
        mainPanel.add(registerPanel);
        mainPanel.add(buttonsPanel);

        // final frame settings
        frame.setContentPane(mainPanel);
        frame.pack();
        centerFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
