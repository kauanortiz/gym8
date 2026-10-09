package view;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import javax.swing.SwingConstants;

import model.enums.Classificacao;
import model.enums.Objetivo;
import model.enums.Sexo;

import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Cadastro2View extends JPanel {

    private static final long serialVersionUID = 1L;
    private JButton voltarButton;
    private JButton proximoButton;
    private JFormattedTextField dataNascimentoField;
    private JComboBox<Sexo> sexoComboBox;
    private JComboBox<Objetivo> objetivoComboBox;
    private JComboBox<Classificacao> classificacaoComboBox;

    public Cadastro2View() {
        setLayout(null);
        setBounds(100, 100, 450, 400);
        
        JLabel tituloLabel = new JLabel("GYM8", SwingConstants.CENTER);
        tituloLabel.setBounds(0, 20, 450, 35);
        tituloLabel.setFont(new Font("Segoe UI", Font.BOLD, 26));
        add(tituloLabel);
        
        JLabel dataNascLabel = new JLabel("Data de nascimento:");
        dataNascLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        dataNascLabel.setBounds(50, 90, 150, 30);
        add(dataNascLabel);
        
        try{
            MaskFormatter mascaraData = new MaskFormatter("##/##/####");
            mascaraData.setPlaceholderCharacter('_');
            
            dataNascimentoField = new JFormattedTextField(mascaraData);
            dataNascimentoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            dataNascimentoField.setBounds(210, 90, 180, 30);
            add(dataNascimentoField);
            
        }catch (ParseException e) {
            e.printStackTrace();
        }
        
        JLabel sexoLabel = new JLabel("Sexo:");
        sexoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        sexoLabel.setBounds(50, 140, 150, 30);
        add(sexoLabel);
        
        sexoComboBox = new JComboBox<>(Sexo.values());
        sexoComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        sexoComboBox.setBounds(210, 140, 180, 30);
        sexoComboBox.setSelectedIndex(-1);
        add(sexoComboBox);
        
        JLabel objetivoLabel = new JLabel("Objetivo:");
        objetivoLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        objetivoLabel.setBounds(50, 190, 150, 30);
        add(objetivoLabel);
        
        objetivoComboBox = new JComboBox<>(Objetivo.values());
        objetivoComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        objetivoComboBox.setBounds(210, 190, 180, 30);
        objetivoComboBox.setSelectedIndex(-1);
        add(objetivoComboBox);
        
        JLabel nivelLabel = new JLabel("Nível:");
        nivelLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nivelLabel.setBounds(50, 240, 150, 30);
        add(nivelLabel);
        
        classificacaoComboBox = new JComboBox<>(Classificacao.values());
        classificacaoComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        classificacaoComboBox.setBounds(210, 240, 180, 30);
        classificacaoComboBox.setSelectedIndex(-1);
        add(classificacaoComboBox);

        voltarButton = new JButton("Voltar");
        voltarButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        voltarButton.setBounds(50, 310, 110, 35);
        add(voltarButton);

        proximoButton = new JButton("Próximo");
        proximoButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        proximoButton.setBounds(280, 310, 110, 35);
        add(proximoButton);
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
    
    public JComboBox<Classificacao> getClassificacaoComboBox() {
        return classificacaoComboBox;
    }
}