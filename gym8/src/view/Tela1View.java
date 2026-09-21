package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Tela1View extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField nomeField;
    private JTextField cpfField;
    private JPasswordField senhaField;
    private JLabel cadastroLabel;
    private JButton proximoButton;

    public Tela1View() {
        setLayout(null);
        
        JLabel tituloLabel = new JLabel("GYM8 ");
        tituloLabel.setBounds(10, 11, 63, 33);
        tituloLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
        add(tituloLabel); // Adiciona diretamente ao painel principal
        
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
        cpfLabel.setBounds(50, 147, 46, 24);
        add(cpfLabel);
        
        cpfField = new JTextField();
        cpfField.setBounds(86, 146, 208, 20);
        cpfField.setColumns(10);
        add(cpfField);
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        senhaLabel.setBounds(50, 203, 46, 20);
        add(senhaLabel);
        
        senhaField = new JPasswordField();
        senhaField.setBounds(106, 200, 208, 20);
        add(senhaField);
        
        cadastroLabel = new JLabel("Cadastro");
        cadastroLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
        cadastroLabel.setBounds(177, 52, 81, 24);
        add(cadastroLabel);
        
        proximoButton = new JButton("Próximo");
        proximoButton.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
        proximoButton.setBounds(345, 256, 95, 33);
        add(proximoButton);
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

	public void setSenhaField(JPasswordField senhaField) {
		this.senhaField = senhaField;
	}

	public JLabel getCadastroLabel() {
		return cadastroLabel;
	}

	public void setCadastroLabel(JLabel cadastroLabel) {
		this.cadastroLabel = cadastroLabel;
	}
    
}