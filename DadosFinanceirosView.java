package teste1;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class DadosFinanceirosView {
    private static int instanciasDadosFinanceirosView = 0;
    private static DadosFinanceirosView janelaDadosFinanceirosView = null;
    
    private JFrame frame;

    private JPanel mainPanel;
    private JPanel registerPanel;
    private JPanel situacaoPanel;
    
    private JLabel labDadosFinanceiros;
    
    private JLabel labProfissao;
    private JTextField tfProfissao;
    
    private JLabel labRendaMedia;
    private JTextField tfRendaMedia;
    
    private JLabel labSituacao;
    private ButtonGroup btGroup;
    private JRadioButton roptLimpo;
    private JRadioButton roptNaoLimpo;
    
    private JButton btFinalizarCadastro;
    private JButton btCancelar;
    
    private boolean camposVerificados = true;
    
    private DadosFinanceiros dadosFinanceiros;
    private String situacao;
    
    // construtores
    private DadosFinanceirosView () {
        initComponents();
    }
    private DadosFinanceirosView (DadosFinanceiros dadosFinanceiros) {
        initComponents(dadosFinanceiros);
    }
    
    // inicializadores de variáveis de instância
    private void initComponents() {
        Font myFont1 = new Font("Arial", Font.BOLD, 30);
        Font myFont2 = new Font("Arial", Font.PLAIN, 20);
        
        this.labDadosFinanceiros = new JLabel("Dados Financeiros");
            labDadosFinanceiros.setFont(myFont1);
        
        this.labProfissao = new JLabel("Profissão");
            labProfissao.setFont(myFont2);
        this.tfProfissao = new JTextField();
            tfProfissao.setText("");

        this.labRendaMedia = new JLabel("Media Salarial");
            labRendaMedia.setFont(myFont2);
        this.tfRendaMedia = new JTextField();
        this.tfRendaMedia.setText("");

        this.labSituacao = new JLabel("Situacao SERASA");
            labSituacao.setFont(myFont2);
        this.roptLimpo = new JRadioButton("Limpo");
        this.roptNaoLimpo = new JRadioButton("Nao Limpo");

        this.btFinalizarCadastro = new JButton("Finalizar Cadastro");
        btFinalizarCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (roptLimpo.isSelected())
                    situacao = "Limpo.";
                else if (roptNaoLimpo.isSelected()) {
                    situacao = "Nao Limpo.";
                } else {
                    JOptionPane.showOptionDialog(
                           null
                         , "Selecione uma opcao para a Situacao no SERASA."
                         , "ALERTA"
                         , JOptionPane.PLAIN_MESSAGE
                         , JOptionPane.WARNING_MESSAGE                              
                         , null
                         , null
                         , "OK"
                        );
                    return;
                }
                camposVerificados = verificarCamposDados();
                if (camposVerificados) {
                    finalizar();
                    CadastroCliente.getJanela().finalizar("create");
                } else {
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
                frame.dispose();
            }
        });

        // Inicializa o ButtonGroup e adiciona os JRadioButtons
        this.btGroup = new ButtonGroup();
            btGroup.add(roptLimpo);
            btGroup.add(roptNaoLimpo);
    }
    private void initComponents(DadosFinanceiros dadosFinanceiros) {
        Font myFont1 = new Font("Arial", Font.BOLD, 30);
        Font myFont2 = new Font("Arial", Font.PLAIN, 20);
        
        this.labDadosFinanceiros = new JLabel("Dados Financeiros");
            labDadosFinanceiros.setFont(myFont1);
        
        this.labProfissao = new JLabel("Profissão");
            labProfissao.setFont(myFont2);
        this.tfProfissao = new JTextField();
            tfProfissao.setText(dadosFinanceiros.getProfissao());

        this.labRendaMedia = new JLabel("Media Salarial");
            labRendaMedia.setFont(myFont2);
        this.tfRendaMedia = new JTextField();
        this.tfRendaMedia.setText(dadosFinanceiros.getRendaMedia());

        this.labSituacao = new JLabel("Situacao SERASA");
            labSituacao.setFont(myFont2);
        this.roptLimpo = new JRadioButton("Limpo");
        this.roptNaoLimpo = new JRadioButton("Nao Limpo");

        this.btFinalizarCadastro = new JButton("Finalizar Cadastro");
        btFinalizarCadastro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (roptLimpo.isSelected())
                    situacao = "Limpo.";
                else if (roptNaoLimpo.isSelected()) {
                    situacao = "Nao Limpo.";
                } else {
                    JOptionPane.showOptionDialog(
                           null
                         , "Selecione uma opcao para a Situacao no SERASA."
                         , "ALERTA"
                         , JOptionPane.PLAIN_MESSAGE
                         , JOptionPane.WARNING_MESSAGE                              
                         , null
                         , null
                         , "OK"
                        );
                    return;
                }
                camposVerificados = verificarCamposDados();
                if (camposVerificados) {
                    finalizar();
                    CadastroCliente.getJanela().finalizar("update");
                } else {
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
                frame.dispose();
            }
        });

        // Inicializa o ButtonGroup e adiciona os JRadioButtons
        this.btGroup = new ButtonGroup();
            btGroup.add(roptLimpo);
            btGroup.add(roptNaoLimpo);
    }
    
    private boolean verificarCamposDados(){
        if (tfProfissao.getText().equals(""))
            return false;
        if (tfRendaMedia.getText().equals(""))
            return false;
        return true;
    }
    
    public static DadosFinanceirosView getJanela() {
        return janelaDadosFinanceirosView;
    }
    
    public void finalizar() {
        instanciasDadosFinanceirosView -= 1;
        janelaDadosFinanceirosView = null;
        this.dadosFinanceiros = new DadosFinanceiros(
                tfProfissao.getText(),
                tfRendaMedia.getText(),
                situacao);
        CadastroCliente.getJanela().setDadosFinanceiros(this.dadosFinanceiros);
        frame.dispose();
    }
    
    public void centerFrame() {
        Dimension currentScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((currentScreen.getWidth() / 2 - frame.getWidth()) / 2);
        int y = (int) ((currentScreen.getHeight() / 2 - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    //Essa sao aa principais funcoes da classe, que devem ser chamadas
    public static void criarJanelaDadosFinanceirosView () {
        if (instanciasDadosFinanceirosView == 0) {
            janelaDadosFinanceirosView = new DadosFinanceirosView();
            janelaDadosFinanceirosView.displayGUI();
            instanciasDadosFinanceirosView++;
        }
    }
    public static void criarJanelaDadosFinanceirosView (DadosFinanceiros dadosFinanceiros) {
        if (instanciasDadosFinanceirosView == 0) {
            janelaDadosFinanceirosView = new DadosFinanceirosView(dadosFinanceiros);
            janelaDadosFinanceirosView.displayGUI();
            instanciasDadosFinanceirosView++;
        }
    }
    
    public void displayGUI() {
        this.frame = new JFrame("Inicio");
        frame.setBounds(150, 0, 449, 800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // situacao panel
        situacaoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Ajuste para FlowLayout
        situacaoPanel.add(roptLimpo);
        situacaoPanel.add(roptNaoLimpo);
        
        // register panel
        registerPanel = new JPanel();
        registerPanel.setLayout(new GridLayout(6, 2, 3, 3));
        registerPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        registerPanel.add(labProfissao);
        registerPanel.add(tfProfissao);
        registerPanel.add(labRendaMedia);
        registerPanel.add(tfRendaMedia);
        registerPanel.add(labSituacao);
        
        registerPanel.add(situacaoPanel);

        // main panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        labDadosFinanceiros.setAlignmentX(Component.CENTER_ALIGNMENT);
        btFinalizarCadastro.setAlignmentX(Component.CENTER_ALIGNMENT);
        btCancelar.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(labDadosFinanceiros);
        mainPanel.add(registerPanel);
        mainPanel.add(btFinalizarCadastro);
        mainPanel.add(btCancelar);

        // final frame settings
        frame.setContentPane(mainPanel);
        frame.pack();
        centerFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    
    
    
    
}
