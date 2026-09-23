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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
        JLabel tituloLabel = new JLabel("GYM8 ");
        tituloLabel.setBounds(10, 11, 63, 33);
        tituloLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        add(tituloLabel);
        
        JLabel cadastroLabel = new JLabel("Login");
        cadastroLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
        cadastroLabel.setBounds(185, 52, 51, 24);
        add(cadastroLabel);
        
        JLabel cpfLabell = new JLabel("CPF:");
        cpfLabell.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        cpfLabell.setBounds(54, 85, 46, 24);
        add(cpfLabell);
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        senhaLabel.setBounds(54, 135, 46, 27);
        add(senhaLabel);
        
        cpfField = new JTextField();
        cpfField.setBounds(91, 84, 232, 20);
        add(cpfField);
        cpfField.setColumns(10);
        
        JLabel textoLabel = new JLabel("Ainda não é cadastrado?");
        textoLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        textoLabel.setBounds(54, 226, 169, 24);
        add(textoLabel);
        
        cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        cadastrarButton.setBounds(221, 217, 102, 33);
        add(cadastrarButton);
        
        entrarButton = new JButton("Entrar");
        entrarButton.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        entrarButton.setBounds(164, 166, 89, 33);
        add(entrarButton);
        
        senhaField = new JPasswordField();
        senhaField.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        senhaField.setBounds(103, 135, 220, 20);
        add(senhaField);

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
