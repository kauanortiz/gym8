package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import model.enums.DiasDaSemana;
import model.enums.GrupoMuscular;

import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class AbaTreinosView extends JPanel {

    private JTextField nomeTreinoField;
    private JButton salvarTreinoButton;
    private JLabel repsMinLabel;
    private JButton limparButton;
    private JButton adicionarButton;
    private JSpinner repsMinSpinner;
    private JSpinner repsMaxSpinner;
    private JSpinner seriesSpinner;
    private JComboBox diaComboBox;
    private JComboBox grupoComboBox;

    public AbaTreinosView() {
        setLayout(null);

        JLabel exercicioLabel = new JLabel("Nome do exercício:");
        exercicioLabel.setBounds(20, 31, 150, 25);
        add(exercicioLabel);

        nomeTreinoField = new JTextField();
        nomeTreinoField.setBounds(156, 31, 203, 25);
        add(nomeTreinoField);

        salvarTreinoButton = new JButton("Salvar Treino");
        salvarTreinoButton.setBounds(308, 259, 134, 30);
        add(salvarTreinoButton);
        
        repsMinLabel = new JLabel("Repetições mínimas:");
        repsMinLabel.setBounds(20, 67, 157, 14);
        add(repsMinLabel);
        
        SpinnerNumberModel modeloSpinner1 = new SpinnerNumberModel(1, 1, 20, 1);
        repsMinSpinner = new JSpinner(modeloSpinner1);
        repsMinSpinner.setBounds(156, 64, 44, 20);
        add(repsMinSpinner);
        
        JLabel repsMaxLabel = new JLabel("Repetições máximas:");
        repsMaxLabel.setBounds(20, 94, 157, 14);
        add(repsMaxLabel);
        
        SpinnerNumberModel modeloSpinner2 = new SpinnerNumberModel(1, 1, 20, 1);
        repsMaxSpinner = new JSpinner(modeloSpinner2);
        repsMaxSpinner.setBounds(156, 91, 44, 20);
        add(repsMaxSpinner);
        
        JLabel seriesLabel = new JLabel("Total de séries:");
        seriesLabel.setBounds(20, 122, 150, 14);
        add(seriesLabel);
        
        SpinnerNumberModel modeloSpinner3 = new SpinnerNumberModel(1, 1, 20, 1);
        seriesSpinner = new JSpinner(modeloSpinner3);
        seriesSpinner.setBounds(156, 119, 44, 20);
        add(seriesSpinner);
        
        JLabel grupoMuscularLabel = new JLabel("Grupo muscular:");
        grupoMuscularLabel.setBounds(20, 156, 94, 14);
        add(grupoMuscularLabel);
        
        grupoComboBox = new JComboBox<>(GrupoMuscular.values());
        grupoComboBox.setBounds(156, 152, 150, 22);
        add(grupoComboBox);
        grupoComboBox.setSelectedIndex(-1);
        
        adicionarButton = new JButton("Adicionar exercício");
        adicionarButton.setBounds(150, 259, 150, 30);
        add(adicionarButton);
        
        limparButton = new JButton("Limpar campos");
        limparButton.setBounds(10, 259, 134, 30);
        add(limparButton);
        
        JLabel diaLabel = new JLabel("Dia do treino:");
        diaLabel.setBounds(20, 193, 80, 14);
        add(diaLabel);
        
        diaComboBox = new JComboBox<>(DiasDaSemana.values());
        diaComboBox.setBounds(156, 189, 150, 22);
        add(diaComboBox);
        diaComboBox.setSelectedIndex(-1);
    }

    public JTextField getNomeTreinoField(){
    	return nomeTreinoField;
    }
    
    public JButton getSalvarTreinoButton(){
    	return salvarTreinoButton;
    }
    
    public JButton getAdicionarButton(){
    	return adicionarButton;
    }
    
    public JButton getLimparButton(){
    	return limparButton;
    }

	public JSpinner getRepsMinSpinner() {
		return repsMinSpinner;
	}

	public JSpinner getRepsMaxSpinner() {
		return repsMaxSpinner;
	}

	public JSpinner getSeriesSpinner() {
		return seriesSpinner;
	}

	public JComboBox getDiaComboBox() {
		return diaComboBox;
	}

	public JComboBox getGrupoComboBox() {
		return grupoComboBox;
	}
}