package view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;

public class Cadastro3View extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField ruaField;
	private JTextField cidadeField;
	private JButton voltarButton;
    private JButton finalizarButton;
    private JSpinner numeroSpinner;

	public Cadastro3View() {
		setLayout(null);
		
		JLabel tituloLabel = new JLabel("GYM8 ");
		tituloLabel.setBounds(10, 10, 63, 33);
		tituloLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		add(tituloLabel);
		
		JLabel enderecoLabel = new JLabel("Endereço");
		enderecoLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 18));
		enderecoLabel.setBounds(177, 52, 84, 33);
		add(enderecoLabel);
		
		JLabel ruaLabel = new JLabel("Rua:");
		ruaLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		ruaLabel.setBounds(72, 92, 34, 24);
		add(ruaLabel);
		
		ruaField = new JTextField();
		ruaField.setBounds(104, 91, 198, 20);
		add(ruaField);
		ruaField.setColumns(10);
		
		JLabel numeroLabel = new JLabel("Número:");
		numeroLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		numeroLabel.setBounds(72, 137, 55, 24);
		add(numeroLabel);
		
		SpinnerNumberModel modeloSpinner = new SpinnerNumberModel(1, 1, 30000, 1);
		numeroSpinner = new JSpinner(modeloSpinner);
		numeroSpinner.setBounds(129, 136, 63, 20);
		add(numeroSpinner);
		
		JLabel cidadeLabel = new JLabel("Cidade:");
		cidadeLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		cidadeLabel.setBounds(72, 179, 55, 24);
		add(cidadeLabel);
		
		cidadeField = new JTextField();
		cidadeField.setBounds(127, 178, 175, 20);
		add(cidadeField);
		cidadeField.setColumns(10);
		
		voltarButton = new JButton("Voltar");
		voltarButton.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		voltarButton.setBounds(10, 256, 89, 33);
		add(voltarButton);
		
		finalizarButton = new JButton("Finalizar");
		finalizarButton.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		finalizarButton.setBounds(342, 256, 98, 33);
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
