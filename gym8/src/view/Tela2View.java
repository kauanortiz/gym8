package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import model.enums.Classificacao;
import model.enums.Objetivo;
import model.enums.Sexo;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Tela2View extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton voltarButton;
	private JButton proximoButton;
	private JFormattedTextField dataNascimentoField;
	private JComboBox sexoComboBox;
	private JComboBox objetivoComboBox;
	private JComboBox classificacaoComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela2View frame = new Tela2View();
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
	public Tela2View() {
		setLayout(null);
		
		JLabel tituloLabel = new JLabel("GYM8 ");
		tituloLabel.setBounds(10, 10, 63, 33);
		tituloLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 20));
		add(tituloLabel);
		
		JLabel dataNascLabel = new JLabel("Data de nascimento:");
		dataNascLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		dataNascLabel.setBounds(75, 66, 141, 24);
		add(dataNascLabel);
		
		try {
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
            
            dataNascimentoField = new JFormattedTextField(mascaraData);
            dataNascimentoField.setBounds(214, 65, 141, 20);
            add(dataNascimentoField);
            
        } catch (ParseException e) {
            e.printStackTrace();
        }
		
		JLabel sexoLabel = new JLabel("Sexo:");
		sexoLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		sexoLabel.setBounds(75, 106, 36, 24);
		add(sexoLabel);
		
		sexoComboBox = new JComboBox<>(Sexo.values());
		sexoComboBox.setBounds(138, 104, 171, 22);
		add(sexoComboBox);
		sexoComboBox.setSelectedIndex(-1);
		
		JLabel objetivoLabel = new JLabel("Objetivo:");
		objetivoLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		objetivoLabel.setBounds(75, 152, 76, 24);
		add(objetivoLabel);
		
		objetivoComboBox = new JComboBox<>(Objetivo.values());
		objetivoComboBox.setBounds(138, 150, 151, 22);
		add(objetivoComboBox);
		objetivoComboBox.setSelectedIndex(-1);
		
		JLabel nivelLabel = new JLabel("Nível:");
		nivelLabel.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		nivelLabel.setBounds(75, 205, 46, 20);
		add(nivelLabel);
		
		classificacaoComboBox = new JComboBox<>(Classificacao.values());
		classificacaoComboBox.setBounds(119, 201, 171, 22);
		add(classificacaoComboBox);
		classificacaoComboBox.setSelectedIndex(-1);
		
		proximoButton = new JButton("Próximo");
		proximoButton.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		proximoButton.setBounds(351, 256, 89, 33);
		add(proximoButton);
		
		voltarButton = new JButton("Voltar");
		voltarButton.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		voltarButton.setBounds(10, 256, 89, 33);
		add(voltarButton);
	}

	public JButton getVoltarButton() {
		return voltarButton;
	}
	
	public JButton getProximoButton() {
        return proximoButton;
    }

	public JFormattedTextField getDataNascimentoField() {
		return dataNascimentoField;
	}
	
	public JComboBox<Sexo> getSexoComboBox() {
	    return sexoComboBox;
	}
	
	public JComboBox<Objetivo> getObjetivoComboBox() {
	    return objetivoComboBox;
	}
	
	public JComboBox<Objetivo> getClassificacaoComboBox() {
	    return classificacaoComboBox;
	}
}
