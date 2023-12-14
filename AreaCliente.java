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

public class AreaCliente {
    private static int qtdInstanciasAreaCliente = 0;
    private static AreaCliente instanciaJanelaAreaCliente = null;
    
    private Cliente cliente;
    
    //Componentes Graficos
    private JFrame frame;
    
    private JPanel mainPanel;
    private JPanel areaClientePanel;
    private JPanel areaBtLogout;
    
    private JLabel labAreaCliente;
    
    private JLabel labCadastrarObj;
    private JButton btNovo;
    
    private JLabel labInterromper;
    private JButton btIrInt;
    
    private JLabel labVerTodosContratos;
    private JButton btIrVer;
    
    private JButton btLogout;
    
    Font myFont1 = new Font("Arial", Font.BOLD, 30);
    Font myFont2 = new Font("Arial", Font.PLAIN, 20);
    
    //construtor
    private AreaCliente (Cliente cliente) {
        initComponents(cliente);
    }
    
    //inicializar componentes
    private void initComponents(Cliente cliente)  {
        this.labAreaCliente = new JLabel("Area do Cliente");
        labAreaCliente.setFont(myFont1);
        
        this.labCadastrarObj = new JLabel("Cadastrar Novo Objeto");
        labCadastrarObj.setFont(myFont2);
        
        this.btNovo = new JButton("NOVO");
        /*btNovo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                instanciaJanelaAreaCliente.cliente = cliente;
            }
        });*/
        
        this.labInterromper = new JLabel("Interromper Contrato");
        labInterromper.setFont(myFont2);
        
        this.btIrInt = new JButton("IR");
        /*btIrInt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });*/
        
        this.labVerTodosContratos = new JLabel("Ver Todos os Contratos");
        labVerTodosContratos.setFont(myFont2);
        
        this.btIrVer = new JButton("IR");
        /*btIrVer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
            }
        });*/
    
        this.btLogout = new JButton("LOGOUT");
        btLogout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                sair();
            }
        });
    
    }
    
    //funcao principal
    public static void abrirJanelaAreaCliente (Cliente cliente) {
        if (qtdInstanciasAreaCliente == 0) {
            qtdInstanciasAreaCliente++;
            instanciaJanelaAreaCliente = new AreaCliente(cliente);
            instanciaJanelaAreaCliente.displayAreaClienteGUI();
        }
    }
    
    public void sair() {
        qtdInstanciasAreaCliente = 0;
        instanciaJanelaAreaCliente = null;
        
        frame.dispose();
    }
    
    public static AreaCliente getJanela() {return instanciaJanelaAreaCliente;}

    public void centerFrame() {
        Dimension currentScreen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((currentScreen.getWidth()/2 - frame.getWidth()) / 2);
        int y = (int) ((currentScreen.getHeight()/2 - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    private void displayAreaClienteGUI () {
        frame = new JFrame("Inicio");
        frame.setBounds(150,0,449,800);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        //area cliente panel
        areaClientePanel = new JPanel();
        areaClientePanel.setLayout(new GridLayout(3,2,30,10));
        areaClientePanel.setBorder(BorderFactory.createEmptyBorder(10,25,0,25));
        areaClientePanel.add(labCadastrarObj);
        areaClientePanel.add(btNovo);
        areaClientePanel.add(labInterromper);
        areaClientePanel.add(btIrInt);
        areaClientePanel.add(labVerTodosContratos);
        areaClientePanel.add(btIrVer);
        
        //area bt logout
        areaBtLogout = new JPanel();
        areaBtLogout.setLayout(new GridLayout(3,2,30,10));
        areaBtLogout.setBorder(BorderFactory.createEmptyBorder(0,150,0,150));
        areaBtLogout.add(btLogout);
        
        //main panel
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        
            //add labAreaCliente
            labAreaCliente.setAlignmentX(Component.CENTER_ALIGNMENT);
            mainPanel.add(labAreaCliente);
        
            //add area cliente panel
            mainPanel.add(areaClientePanel);
            
            //add area bt logout
            mainPanel.add(areaBtLogout);
        //final frame settings
            frame.setContentPane(mainPanel);
            frame.pack();
            centerFrame();
            frame.setVisible(true);
            frame.setResizable(false);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

}
