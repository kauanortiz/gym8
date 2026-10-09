package view;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;

import model.enums.TipoAlimento;

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
    private JComboBox<TipoAlimento> tipo1ComboBox;
    private JComboBox<TipoAlimento> tipo2ComboBox;
    private JComboBox<TipoAlimento> tipo3ComboBox;
    private JComboBox<TipoAlimento> tipo4ComboBox;
    private JButton salvarRefeicaoButton;
    private JButton limparCamposButton;
    private JButton cadastrarDietaButton;
    private JTextField caloriasField;
    private JTextField calorias2Field;
    private JTextField calorias3Field;
    private JTextField calorias4Field;

    public AbaDietaView() {
        setLayout(null);

        Font fonteLabel = new Font("Segoe UI", Font.PLAIN, 14);
        Font fonteCampo = new Font("Segoe UI", Font.PLAIN, 14);

        JLabel alimentoLabel = new JLabel("Alimento 1:");
        alimentoLabel.setFont(fonteLabel);
        alimentoLabel.setBounds(20, 20, 80, 30);
        add(alimentoLabel);
        
        alimentoField = new JTextField();
        alimentoField.setFont(fonteCampo);
        alimentoField.setBounds(110, 20, 180, 30);
        add(alimentoField);
        alimentoField.setColumns(10);
        
        JLabel tipoLabel = new JLabel("Tipo:");
        tipoLabel.setFont(fonteLabel);
        tipoLabel.setBounds(310, 20, 40, 30);
        add(tipoLabel);
        
        tipo1ComboBox = new JComboBox<>(TipoAlimento.values());
        tipo1ComboBox.setFont(fonteCampo);
        tipo1ComboBox.setBounds(360, 20, 140, 30);
        add(tipo1ComboBox);
        tipo1ComboBox.setSelectedIndex(-1);
        
        JLabel quantidadeLabel = new JLabel("Quantidade (em g):");
        quantidadeLabel.setFont(fonteLabel);
        quantidadeLabel.setBounds(20, 60, 130, 30);
        add(quantidadeLabel);
        
        quantidadeSpinner = new JSpinner();
        quantidadeSpinner.setFont(fonteCampo);
        quantidadeSpinner.setBounds(150, 60, 80, 30);
        add(quantidadeSpinner);
        
        JLabel caloriasLabel = new JLabel("Calorias:");
        caloriasLabel.setFont(fonteLabel);
        caloriasLabel.setBounds(290, 60, 60, 30);
        add(caloriasLabel);
        
        caloriasField = new JTextField();
        caloriasField.setFont(fonteCampo);
        caloriasField.setBounds(360, 60, 140, 30);
        add(caloriasField);
        caloriasField.setColumns(10);

        JLabel alimento2Label = new JLabel("Alimento 2:");
        alimento2Label.setFont(fonteLabel);
        alimento2Label.setBounds(20, 100, 80, 30);
        add(alimento2Label);
        
        alimento2Field = new JTextField();
        alimento2Field.setFont(fonteCampo);
        alimento2Field.setBounds(110, 100, 180, 30);
        add(alimento2Field);
        alimento2Field.setColumns(10);
        
        JLabel tipo2Label = new JLabel("Tipo:");
        tipo2Label.setFont(fonteLabel);
        tipo2Label.setBounds(310, 100, 40, 30);
        add(tipo2Label);
        
        tipo2ComboBox = new JComboBox<>(TipoAlimento.values());
        tipo2ComboBox.setFont(fonteCampo);
        tipo2ComboBox.setBounds(360, 100, 140, 30);
        add(tipo2ComboBox);
        tipo2ComboBox.setSelectedIndex(-1);
        
        JLabel quantidade2Label = new JLabel("Quantidade (em g):");
        quantidade2Label.setFont(fonteLabel);
        quantidade2Label.setBounds(20, 140, 130, 30);
        add(quantidade2Label);
        
        quantidade2Spinner = new JSpinner();
        quantidade2Spinner.setFont(fonteCampo);
        quantidade2Spinner.setBounds(150, 140, 80, 30);
        add(quantidade2Spinner);
        
        JLabel calorias2Label = new JLabel("Calorias:");
        calorias2Label.setFont(fonteLabel);
        calorias2Label.setBounds(290, 140, 60, 30);
        add(calorias2Label);
        
        calorias2Field = new JTextField();
        calorias2Field.setFont(fonteCampo);
        calorias2Field.setBounds(360, 140, 140, 30);
        add(calorias2Field);
        calorias2Field.setColumns(10);

        JLabel alimento3Label = new JLabel("Alimento 3:");
        alimento3Label.setFont(fonteLabel);
        alimento3Label.setBounds(20, 180, 80, 30);
        add(alimento3Label);
        
        alimento3Field = new JTextField();
        alimento3Field.setFont(fonteCampo);
        alimento3Field.setBounds(110, 180, 180, 30);
        add(alimento3Field);
        alimento3Field.setColumns(10);
        
        JLabel tipo3Label = new JLabel("Tipo:");
        tipo3Label.setFont(fonteLabel);
        tipo3Label.setBounds(310, 180, 40, 30);
        add(tipo3Label);
        
        tipo3ComboBox = new JComboBox<>(TipoAlimento.values());
        tipo3ComboBox.setFont(fonteCampo);
        tipo3ComboBox.setBounds(360, 180, 140, 30);
        add(tipo3ComboBox);
        tipo3ComboBox.setSelectedIndex(-1);
        
        JLabel quantidade3Label = new JLabel("Quantidade (em g):");
        quantidade3Label.setFont(fonteLabel);
        quantidade3Label.setBounds(20, 220, 130, 30);
        add(quantidade3Label);
        
        quantidade3Spinner = new JSpinner();
        quantidade3Spinner.setFont(fonteCampo);
        quantidade3Spinner.setBounds(150, 220, 80, 30);
        add(quantidade3Spinner);
        
        JLabel calorias3Label = new JLabel("Calorias:");
        calorias3Label.setFont(fonteLabel);
        calorias3Label.setBounds(290, 220, 60, 30);
        add(calorias3Label);
        
        calorias3Field = new JTextField();
        calorias3Field.setFont(fonteCampo);
        calorias3Field.setBounds(360, 220, 140, 30);
        add(calorias3Field);
        calorias3Field.setColumns(10);

        JLabel alimento4Label = new JLabel("Alimento 4:");
        alimento4Label.setFont(fonteLabel);
        alimento4Label.setBounds(20, 260, 80, 30);
        add(alimento4Label);
        
        alimento4Field = new JTextField();
        alimento4Field.setFont(fonteCampo);
        alimento4Field.setBounds(110, 260, 180, 30);
        add(alimento4Field);
        alimento4Field.setColumns(10);
        
        JLabel tipo4Label = new JLabel("Tipo:");
        tipo4Label.setFont(fonteLabel);
        tipo4Label.setBounds(310, 260, 40, 30);
        add(tipo4Label);
        
        tipo4ComboBox = new JComboBox<>(TipoAlimento.values());
        tipo4ComboBox.setFont(fonteCampo);
        tipo4ComboBox.setBounds(360, 260, 140, 30);
        add(tipo4ComboBox);
        tipo4ComboBox.setSelectedIndex(-1);
        
        JLabel quantidade4Label = new JLabel("Quantidade (em g):");
        quantidade4Label.setFont(fonteLabel);
        quantidade4Label.setBounds(20, 300, 130, 30);
        add(quantidade4Label);
        
        quantidade4Spinner = new JSpinner();
        quantidade4Spinner.setFont(fonteCampo);
        quantidade4Spinner.setBounds(150, 300, 80, 30);
        add(quantidade4Spinner);
        
        JLabel calorias4Label = new JLabel("Calorias:");
        calorias4Label.setFont(fonteLabel);
        calorias4Label.setBounds(290, 300, 60, 30);
        add(calorias4Label);
        
        calorias4Field = new JTextField();
        calorias4Field.setFont(fonteCampo);
        calorias4Field.setBounds(360, 300, 140, 30);
        add(calorias4Field);
        calorias4Field.setColumns(10);
        
        limparCamposButton = new JButton("Limpar campos");
        limparCamposButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        limparCamposButton.setBounds(20, 350, 150, 35);
        add(limparCamposButton);
        
        salvarRefeicaoButton = new JButton("Salvar refeição");
        salvarRefeicaoButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        salvarRefeicaoButton.setBounds(185, 350, 150, 35);
        add(salvarRefeicaoButton);
        
        cadastrarDietaButton = new JButton("Cadastrar dieta");
        cadastrarDietaButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        cadastrarDietaButton.setBounds(350, 350, 150, 35);
        add(cadastrarDietaButton);
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

    public JComboBox<TipoAlimento> getTipo1ComboBox() {
    	return tipo1ComboBox;
    }
    
    public JComboBox<TipoAlimento> getTipo2ComboBox() {
    	return tipo2ComboBox; 
    }
    
    public JComboBox<TipoAlimento> getTipo3ComboBox() {
    	return tipo3ComboBox;
    }
    
    public JComboBox<TipoAlimento> getTipo4ComboBox() {
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