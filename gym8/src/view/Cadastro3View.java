package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;

public class Cadastro3View extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField ruaField;
    private JTextField cidadeField;
    private JButton voltarButton;
    private JButton finalizarButton;
    private JSpinner numeroSpinner;

    public Cadastro3View() {
        setLayout(null);
        setBounds(100, 100, 450, 400);

        JLabel tituloLabel = new JLabel("GYM8", SwingConstants.CENTER);
        tituloLabel.setBounds(0, 20, 450, 35);
        tituloLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(tituloLabel);

        JLabel enderecoLabel = new JLabel("Endereço", SwingConstants.CENTER);
        enderecoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        enderecoLabel.setBounds(0, 60, 450, 24);
        add(enderecoLabel);

        JLabel ruaLabel = new JLabel("Rua:");
        ruaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        ruaLabel.setBounds(60, 110, 80, 30);
        add(ruaLabel);

        ruaField = new JTextField();
        ruaField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        ruaField.setBounds(150, 110, 230, 30);
        add(ruaField);
        ruaField.setColumns(10);

        JLabel numeroLabel = new JLabel("Número:");
        numeroLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        numeroLabel.setBounds(60, 160, 80, 30);
        add(numeroLabel);

        SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(1, 1, 30000, 1);
        numeroSpinner = new JSpinner(modeloSpinner);
        numeroSpinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        numeroSpinner.setBounds(150, 160, 100, 30);
        add(numeroSpinner);

        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cidadeLabel.setBounds(60, 210, 80, 30);
        add(cidadeLabel);

        cidadeField = new JTextField();
        cidadeField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cidadeField.setBounds(150, 210, 230, 30);
        add(cidadeField);
        cidadeField.setColumns(10);
        
        voltarButton = new JButton("Voltar");
        voltarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        voltarButton.setBounds(50, 310, 110, 35);
        add(voltarButton);

        finalizarButton = new JButton("Finalizar");
        finalizarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        finalizarButton.setBounds(280, 310, 110, 35);
        add(finalizarButton);
    }

    public JButton getVoltarButton() {
        return voltarButton;
    }

    public JButton getFinalizarButton() {
        return finalizarButton;
    }

    public JTextField getRuaField() {
        return ruaField;
    }

    public JTextField getCidadeField() {
        return cidadeField;
    }

    public JSpinner getNumeroSpinner() {
        return numeroSpinner;
    }
}