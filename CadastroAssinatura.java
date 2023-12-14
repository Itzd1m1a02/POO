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

public class CadastroAssinatura {
    private static int qtdInstancias = 0;
    private static CadastroAssinatura instancia = null;
    
    private JFrame frame;
    private JPanel panel;
    private JPanel panelBt;
    private JPanel mainPanel;

    private JLabel labTitulo;
    private JLabel labNome;
    private JLabel labTipoCategoria;
    private JLabel labDadosTecnicos;
    private JLabel labDescricaoVisual;
    private JLabel labValorCusto;
    private JLabel labvalorAvaliado;

    private JButton btGerarID;
    private JButton btIrAssinatura;
    
    private JTextField tfGerarID;
    private JTextField tfNome;
    private JTextField tfTipoCategoria;
    private JTextField tfDadosTecnicos;
    private JTextField tfDescricaoVisual;
    private JTextField tfValorCusto;
    private JTextField tfValorAvaliado;

    private CadastroAssinatura () {
        initComponents();
    }
    
    //funcao principal
    public static void criarJanelaCadastroAssinatura () {
        if (qtdInstancias == 0) {
            qtdInstancias++;
            instancia = new CadastroAssinatura();
            instancia.displayGUI();
        }
    }
    
    public void sair() {
        qtdInstancias -= 1;
        instancia = null;
        if (CadastroAssinatura.getJanela() != null)
            CadastroAssinatura.getJanela().sair();
        frame.dispose();
    }
    
    public static CadastroAssinatura getJanela() {return instancia;}
    
    
    //centralizar janela
    public void centerFrame() {
        Dimension currentScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((currentScreen.getWidth()/2 - frame.getWidth()) / 2);
        int y = (int) ((currentScreen.getHeight()/2 - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    private void initComponents() {
        Font myFont = new Font("Arial", Font.PLAIN, 15);
        Font myFont2 = new Font("Arial", Font.BOLD, 24);

        this.labTitulo = new JLabel("Cadastrar objeto de valor");
        labTitulo.setFont(myFont2);
        labTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.btGerarID = new JButton("Gerar ID");
        btGerarID.setFont(myFont);

        this.tfGerarID = new JTextField();
        
        this.labNome = new JLabel("Nome");
        labNome.setFont(myFont);
        
        this.tfNome = new JTextField();
        
        this.labTipoCategoria = new JLabel("Tipo/Categoria");
        labTipoCategoria.setFont(myFont);
        
        this.tfTipoCategoria = new JTextField();
        
        this.labDadosTecnicos = new JLabel("Dados Tecnicos");
        labDadosTecnicos.setFont(myFont);
        
        this.tfDadosTecnicos = new JTextField();
        
        this.labDescricaoVisual = new JLabel("Descricao visual");
        labDescricaoVisual.setFont(myFont);
        
        this.tfDescricaoVisual = new JTextField();
        
        this.labValorCusto = new JLabel("Valor de Custo");
        labValorCusto.setFont(myFont);
        
        this.tfValorCusto = new JTextField();
        
        this.labvalorAvaliado = new JLabel("Valor avaliado");
        labvalorAvaliado.setFont(myFont);
        
        this.tfValorAvaliado = new JTextField();

        this.btIrAssinatura = new JButton("Ir para assinatura");
        btIrAssinatura.setFont(myFont);
        btIrAssinatura.setAlignmentX(Component.CENTER_ALIGNMENT);
        btIrAssinatura.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (verificarCamposCliente()) {
                    campoUsuarioVazio();
                } else {
                    
                }
            }
        });
        
    }
    
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
    
    private boolean verificarCamposCliente(){
        if (tfGerarID.getText().equals(""))
            return false;
        if (tfNome.getText().equals(""))
            return false;
        if (tfTipoCategoria.getText().equals(""))
            return false;
        if (tfDadosTecnicos.getText().equals(""))
            return false;
        if (tfDescricaoVisual.getText().equals(""))
            return false;
        if (tfValorCusto.getText().equals(""))
            return false;
        if (tfValorAvaliado.getText().equals(""))
            return false;
        return true;
    }
    
    private void displayGUI () {
        frame = new JFrame("Inicio");
        frame.setBounds(150,0,449,800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 3, 3));
        panel.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        
        mainPanel.add(labTitulo);

        panel.add(btGerarID);
        panel.add(tfGerarID);
        panel.add(labNome);
        panel.add(tfNome);
        panel.add(labTipoCategoria);
        panel.add(tfTipoCategoria);
        panel.add(labDadosTecnicos);
        panel.add(tfDadosTecnicos);
        panel.add(labDescricaoVisual);
        panel.add(tfDescricaoVisual);
        panel.add(labValorCusto);
        panel.add(tfValorCusto);
        panel.add(labvalorAvaliado);
        panel.add(tfValorAvaliado);
        
        mainPanel.add(panel);
        panelBt = new JPanel();
        panelBt.setLayout(new GridLayout(1, 1, 3, 3));
        panelBt.setBorder(BorderFactory.createEmptyBorder(0,150,10,150));
        panelBt.add(btIrAssinatura);
        
        mainPanel.add(panelBt);
        
        //final frame settings
        frame.setContentPane(mainPanel);
        frame.pack();
        centerFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
