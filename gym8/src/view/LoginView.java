package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class LoginView extends JPanel {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField cpfField;
    private JButton cadastrarButton;
    private JButton entrarButton;
    private JPasswordField senhaField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginView frame = new LoginView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public LoginView() {
        setLayout(null);
        setBounds(100, 100, 450, 330);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        JLabel tituloLabel = new JLabel("GYM8");
        tituloLabel.setBounds(185, 15, 80, 33);
        tituloLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        add(tituloLabel);
        
        JLabel cadastroLabel = new JLabel("Login");
        cadastroLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cadastroLabel.setBounds(200, 50, 50, 24);
        add(cadastroLabel);
        
        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cpfLabel.setBounds(70, 95, 46, 30);
        add(cpfLabel);
        
        cpfField = new JTextField();
        cpfField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cpfField.setBounds(120, 95, 230, 30);
        add(cpfField);
        cpfField.setColumns(10);
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        senhaLabel.setBounds(70, 145, 50, 30);
        add(senhaLabel);
        
        senhaField = new JPasswordField();
        senhaField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        senhaField.setBounds(120, 145, 230, 30);
        add(senhaField);
        
        entrarButton = new JButton("Entrar");
        entrarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        entrarButton.setBounds(120, 195, 230, 35);
        add(entrarButton);
        
        JLabel textoLabel = new JLabel("Ainda não é cadastrado?");
        textoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        textoLabel.setBounds(70, 255, 150, 30);
        add(textoLabel);
        
        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        cadastrarButton.setBounds(230, 255, 120, 30);
        add(cadastrarButton);
    }

    public JTextField getCpfField() {
        return cpfField;
    }

    public void setCpfField(JTextField cpfField) {
        this.cpfField = cpfField;
    }

    public JPasswordField getSenhaField() {
        return senhaField;
    }

    public void setSenhaField(JPasswordField senhaField) {
        this.senhaField = senhaField;
    }

    public JButton getCadastrarButton() {
        return cadastrarButton;
    }

    public JButton getEntrarButton() {
        return entrarButton;
    }
}