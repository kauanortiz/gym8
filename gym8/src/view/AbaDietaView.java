package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.enums.TipoAlimento;

import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class AbaDietaView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField alimentoField;
	private JTextField alimento2Field;
	private JTextField alimento3Field;
	private JTextField alimento4Field;
	private JSpinner quantidadeSpinner;
	private JSpinner quantidade2Spinner;
	private JSpinner quantidade3Spinner;
	private JSpinner quantidade4Spinner;
	private JComboBox tipo1ComboBox;
	private JComboBox tipo2ComboBox;
	private JComboBox tipo3ComboBox;
	private JComboBox tipo4ComboBox;
	private JButton salvarRefeicaoButton;
	private JButton limparCamposButton;
	private JButton cadastrarDietaButton;
	private JTextField caloriasField;
	private JTextField calorias2Field;
	private JTextField calorias3Field;
	private JTextField calorias4Field;

	public AbaDietaView() {
		setLayout(null);
		
		JLabel alimentoLabel = new JLabel("Alimento 1:");
		alimentoLabel.setBounds(10, 11, 72, 14);
		add(alimentoLabel);
		
		alimentoField = new JTextField();
		alimentoField.setBounds(81, 7, 187, 20);
		add(alimentoField);
		alimentoField.setColumns(10);
		
		JLabel quantidadeLabel = new JLabel("Quantidade (em g):");
		quantidadeLabel.setBounds(10, 36, 108, 14);
		add(quantidadeLabel);
		
		quantidadeSpinner = new JSpinner();
		quantidadeSpinner.setBounds(119, 33, 44, 20);
		add(quantidadeSpinner);
		
		JLabel caloriasLabel = new JLabel("Calorias:");
		caloriasLabel.setBounds(168, 38, 57, 14);
		add(caloriasLabel);
		
		JLabel alimento2Label = new JLabel("Alimento 2:");
		alimento2Label.setBounds(10, 65, 72, 14);
		add(alimento2Label);
		
		alimento2Field = new JTextField();
		alimento2Field.setBounds(81, 61, 187, 20);
		add(alimento2Field);
		alimento2Field.setColumns(10);
		
		JLabel quantidade2Label = new JLabel("Quantidade (em g):");
		quantidade2Label.setBounds(10, 90, 108, 14);
		add(quantidade2Label);
		
		quantidade2Spinner = new JSpinner();
		quantidade2Spinner.setBounds(119, 87, 44, 20);
		add(quantidade2Spinner);
		
		JLabel calorias2Label = new JLabel("Calorias:");
		calorias2Label.setBounds(168, 90, 57, 14);
		add(calorias2Label);
		
		tipo1ComboBox = new JComboBox<>(TipoAlimento.values());
		tipo1ComboBox.setBounds(318, 7, 122, 22);
		add(tipo1ComboBox);
		tipo1ComboBox.setSelectedIndex(-1);
		
		JLabel tipoLabel = new JLabel("Tipo:");
		tipoLabel.setBounds(283, 11, 35, 14);
		add(tipoLabel);
		
		JLabel tipo2Label = new JLabel("Tipo:");
		tipo2Label.setBounds(283, 65, 35, 14);
		add(tipo2Label);
		
		tipo2ComboBox = new JComboBox<>(TipoAlimento.values());
		tipo2ComboBox.setBounds(318, 61, 122, 22);
		add(tipo2ComboBox);
		tipo2ComboBox.setSelectedIndex(-1);
		
		JLabel alimento3Label = new JLabel("Alimento 3:");
		alimento3Label.setBounds(10, 122, 72, 14);
		add(alimento3Label);
		
		alimento3Field = new JTextField();
		alimento3Field.setBounds(81, 118, 187, 20);
		add(alimento3Field);
		alimento3Field.setColumns(10);
		
		JLabel quantidade3Label = new JLabel("Quantidade (em g):");
		quantidade3Label.setBounds(10, 147, 108, 14);
		add(quantidade3Label);
		
		quantidade3Spinner = new JSpinner();
		quantidade3Spinner.setBounds(119, 144, 44, 20);
		add(quantidade3Spinner);
		
		JLabel calorias3Label = new JLabel("Calorias:");
		calorias3Label.setBounds(168, 149, 57, 14);
		add(calorias3Label);
		
		JLabel tipo3Label = new JLabel("Tipo:");
		tipo3Label.setBounds(283, 122, 35, 14);
		add(tipo3Label);
		
		tipo3ComboBox = new JComboBox<>(TipoAlimento.values());
		tipo3ComboBox.setBounds(318, 118, 122, 22);
		add(tipo3ComboBox);
		tipo3ComboBox.setSelectedIndex(-1);
		
		JLabel alimento4Label = new JLabel("Alimento 4:");
		alimento4Label.setBounds(10, 180, 72, 14);
		add(alimento4Label);
		
		alimento4Field = new JTextField();
		alimento4Field.setBounds(81, 176, 187, 20);
		add(alimento4Field);
		alimento4Field.setColumns(10);
		
		JLabel tipo4Label = new JLabel("Tipo:");
		tipo4Label.setBounds(283, 180, 35, 14);
		add(tipo4Label);
		
		tipo4ComboBox = new JComboBox<>(TipoAlimento.values());
		tipo4ComboBox.setBounds(318, 176, 122, 22);
		add(tipo4ComboBox);
		tipo4ComboBox.setSelectedIndex(-1);
		
		JLabel quantidade4Label = new JLabel("Quantidade (em g):");
		quantidade4Label.setBounds(10, 205, 108, 14);
		add(quantidade4Label);
		
		quantidade4Spinner = new JSpinner();
		quantidade4Spinner.setBounds(119, 202, 44, 20);
		add(quantidade4Spinner);
		
		JLabel calorias4Label = new JLabel("Calorias:");
		calorias4Label.setBounds(168, 207, 57, 14);
		add(calorias4Label);
		
		salvarRefeicaoButton = new JButton("Salvar refeição");
		salvarRefeicaoButton.setBounds(10, 244, 143, 28);
		add(salvarRefeicaoButton);
		
		limparCamposButton = new JButton("Limpar campos");
		limparCamposButton.setBounds(154, 244, 143, 28);
		add(limparCamposButton);
		
		cadastrarDietaButton = new JButton("Cadastrar dieta");
		cadastrarDietaButton.setBounds(297, 244, 143, 28);
		add(cadastrarDietaButton);
		
		caloriasField = new JTextField();
		caloriasField.setBounds(216, 33, 52, 20);
		add(caloriasField);
		caloriasField.setColumns(10);
		
		calorias2Field = new JTextField();
		calorias2Field.setColumns(10);
		calorias2Field.setBounds(216, 87, 52, 20);
		add(calorias2Field);
		
		calorias3Field = new JTextField();
		calorias3Field.setColumns(10);
		calorias3Field.setBounds(216, 144, 52, 20);
		add(calorias3Field);
		
		calorias4Field = new JTextField();
		calorias4Field.setColumns(10);
		calorias4Field.setBounds(216, 202, 52, 20);
		add(calorias4Field);
	}

	public JTextField getAlimentoField() {
		return alimentoField;
	}

	public JTextField getAlimento2Field() {
		return alimento2Field;
	}

	public JTextField getAlimento3Field() {
		return alimento3Field;
	}

	public JTextField getAlimento4Field() {
		return alimento4Field;
	}

	public JSpinner getQuantidadeSpinner() {
		return quantidadeSpinner;
	}

	public JSpinner getQuantidade2Spinner() {
		return quantidade2Spinner;
	}

	public JSpinner getQuantidade3Spinner() {
		return quantidade3Spinner;
	}

	public JSpinner getQuantidade4Spinner() {
		return quantidade4Spinner;
	}
	
	public JTextField getCaloriasField() {
		return caloriasField;
	}

	public JTextField getCalorias2Field() {
		return calorias2Field;
	}

	public JTextField getCalorias3Field() {
		return calorias3Field;
	}

	public JTextField getCalorias4Field() {
		return calorias4Field;
	}

	public JComboBox getTipo1ComboBox() {
		return tipo1ComboBox;
	}

	public JComboBox getTipo2ComboBox() {
		return tipo2ComboBox;
	}

	public JComboBox getTipo3ComboBox() {
		return tipo3ComboBox;
	}

	public JComboBox getTipo4ComboBox() {
		return tipo4ComboBox;
	}

	public JButton getSalvarRefeicaoButton() {
		return salvarRefeicaoButton;
	}

	public JButton getLimparCamposButton() {
		return limparCamposButton;
	}

	public JButton getCadastrarDietaButton() {
		return cadastrarDietaButton;
	}
}
