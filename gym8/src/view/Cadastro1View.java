package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants; // Import necessário para centralizar os títulos
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
        setBounds(100, 100, 450, 400); 
        
        JLabel tituloLabel = new JLabel("GYM8", SwingConstants.CENTER);
        tituloLabel.setBounds(0, 20, 450, 35);
        tituloLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(tituloLabel);
        
        cadastroLabel = new JLabel("Cadastro", SwingConstants.CENTER);
        cadastroLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        cadastroLabel.setBounds(0, 60, 450, 24);
        add(cadastroLabel);
        
        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nomeLabel.setBounds(60, 110, 120, 30);
        add(nomeLabel);
        
        nomeField = new JTextField();
        nomeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nomeField.setBounds(190, 110, 200, 30);
        nomeField.setColumns(10);
        add(nomeField);
        
        JLabel cpfLabel = new JLabel("CPF:");
        cpfLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cpfLabel.setBounds(60, 160, 120, 30);
        add(cpfLabel);
        
        cpfField = new JTextField();
        cpfField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cpfField.setBounds(190, 160, 200, 30);
        cpfField.setColumns(10);
        add(cpfField);
        
        JLabel senhaLabel = new JLabel("Senha:");
        senhaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        senhaLabel.setBounds(60, 210, 120, 30);
        add(senhaLabel);
        
        senhaField = new JPasswordField();
        senhaField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        senhaField.setBounds(190, 210, 200, 30);
        add(senhaField);
        
        confirmacaoLabel = new JLabel("Confirme a senha:");
        confirmacaoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        confirmacaoLabel.setBounds(60, 260, 130, 30);
        add(confirmacaoLabel);
        
        confirmacaoField = new JPasswordField();
        confirmacaoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        confirmacaoField.setBounds(190, 260, 200, 30);
        add(confirmacaoField);
        
        proximoButton = new JButton("Próximo");
        proximoButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        proximoButton.setBounds(270, 320, 120, 35);
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