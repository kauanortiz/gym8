package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Cadastro1View extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField nomeField;
    private JTextField cpfField;
    private JPasswordField senhaField;
    private JLabel cadastroLabel;
    private JButton proximoButton;
    private JLabel confirmacaoLabel;
    private JPasswordField confirmacaoField;

    public Cadastro1View() {
        setLayout(null);
        
        JLabel tituloLabel = new JLabel("GYM8 ");
        tituloLabel.setBounds(10, 11, 63, 33);
        tituloLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        add(tituloLabel);
        
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        nomeLabel.setBounds(54, 92, 42, 24);
        add(nomeLabel);
        
        nomeField = new JTextField();
        nomeField.setBounds(106, 91, 208, 20);
        nomeField.setColumns(10);
        add(nomeField);
        
        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        cpfLabel.setBounds(54, 127, 46, 24);
        add(cpfLabel);
        
        cpfField = new JTextField();
        cpfField.setBounds(106, 126, 208, 20);
        cpfField.setColumns(10);
        add(cpfField);
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        senhaLabel.setBounds(54, 162, 46, 20);
        add(senhaLabel);
        
        senhaField = new JPasswordField();
        senhaField.setBounds(106, 159, 208, 20);
        add(senhaField);
        
        cadastroLabel = new JLabel("Cadastro");
        cadastroLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
        cadastroLabel.setBounds(177, 52, 81, 24);
        add(cadastroLabel);
        
        proximoButton = new JButton("Próximo");
        proximoButton.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        proximoButton.setBounds(345, 256, 95, 33);
        add(proximoButton);
        
        confirmacaoLabel = new JLabel("Confirme a senha:");
        confirmacaoLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        confirmacaoLabel.setBounds(54, 193, 124, 24);
        add(confirmacaoLabel);
        
        confirmacaoField = new JPasswordField();
        confirmacaoField.setBounds(177, 192, 208, 20);
        add(confirmacaoField);
    }
    
    public JButton getProximoButton() {
        return proximoButton;
    }
    
	public void setProximoButton(JButton proximoButton) {
		this.proximoButton = proximoButton;
	}

	public JTextField getNomeField() {
		return nomeField;
	}

	public void setNomeField(JTextField nomeField) {
		this.nomeField = nomeField;
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

	public JPasswordField getConfirmacaoField() {
		return confirmacaoField;
	}

	public JLabel getCadastroLabel() {
		return cadastroLabel;
	}

	public void setCadastroLabel(JLabel cadastroLabel) {
		this.cadastroLabel = cadastroLabel;
	}
    
}