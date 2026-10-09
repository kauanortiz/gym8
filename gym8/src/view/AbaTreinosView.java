package view;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

import model.enums.DiasDaSemana;
import model.enums.GrupoMuscular;

public class AbaTreinosView extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField nomeTreinoField;
    private JButton salvarTreinoButton;
    private JLabel repsMinLabel;
    private JButton limparButton;
    private JButton adicionarButton;
    private JSpinner repsMinSpinner;
    private JSpinner repsMaxSpinner;
    private JSpinner seriesSpinner;
    private JComboBox<DiasDaSemana> diaComboBox;
    private JComboBox<GrupoMuscular> grupoComboBox;

    public AbaTreinosView() {
        setLayout(null);
        
        JLabel exercicioLabel = new JLabel("Nome do exercício:");
        exercicioLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        exercicioLabel.setBounds(50, 30, 150, 30);
        add(exercicioLabel);

        nomeTreinoField = new JTextField();
        nomeTreinoField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        nomeTreinoField.setBounds(200, 30, 230, 30);
        add(nomeTreinoField);
        
        JLabel repsMinLabel = new JLabel("Repetições mínimas:");
        repsMinLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        repsMinLabel.setBounds(50, 75, 150, 30);
        add(repsMinLabel);
        
        SpinnerNumberModel modeloSpinner1 = new SpinnerNumberModel(1, 1, 20, 1);
        repsMinSpinner = new JSpinner(modeloSpinner1);
        repsMinSpinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        repsMinSpinner.setBounds(200, 75, 70, 30);
        add(repsMinSpinner);
        
        JLabel repsMaxLabel = new JLabel("Repetições máximas:");
        repsMaxLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        repsMaxLabel.setBounds(50, 120, 150, 30);
        add(repsMaxLabel);
        
        SpinnerNumberModel modeloSpinner2 = new SpinnerNumberModel(1, 1, 20, 1);
        repsMaxSpinner = new JSpinner(modeloSpinner2);
        repsMaxSpinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        repsMaxSpinner.setBounds(200, 120, 70, 30);
        add(repsMaxSpinner);
        
        JLabel seriesLabel = new JLabel("Total de séries:");
        seriesLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        seriesLabel.setBounds(50, 165, 150, 30);
        add(seriesLabel);
        
        SpinnerNumberModel modeloSpinner3 = new SpinnerNumberModel(1, 1, 20, 1);
        seriesSpinner = new JSpinner(modeloSpinner3);
        seriesSpinner.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        seriesSpinner.setBounds(200, 165, 70, 30);
        add(seriesSpinner);
        
        JLabel grupoMuscularLabel = new JLabel("Grupo muscular:");
        grupoMuscularLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        grupoMuscularLabel.setBounds(50, 210, 150, 30);
        add(grupoMuscularLabel);
        
        grupoComboBox = new JComboBox<>(GrupoMuscular.values());
        grupoComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        grupoComboBox.setBounds(200, 210, 230, 30);
        add(grupoComboBox);
        grupoComboBox.setSelectedIndex(-1);
        
        JLabel diaLabel = new JLabel("Dia do treino:");
        diaLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        diaLabel.setBounds(50, 255, 150, 30);
        add(diaLabel);
        
        diaComboBox = new JComboBox<>(DiasDaSemana.values());
        diaComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        diaComboBox.setBounds(200, 255, 230, 30);
        add(diaComboBox);
        diaComboBox.setSelectedIndex(-1); 
        
        limparButton = new JButton("Limpar campos");
        limparButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        limparButton.setBounds(30, 320, 130, 35);
        add(limparButton);

        adicionarButton = new JButton("Adicionar exercício");
        adicionarButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        adicionarButton.setBounds(170, 320, 160, 35);
        add(adicionarButton);

        salvarTreinoButton = new JButton("Salvar Treino");
        salvarTreinoButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        salvarTreinoButton.setBounds(340, 320, 130, 35);
        add(salvarTreinoButton);
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

    public JComboBox<DiasDaSemana> getDiaComboBox() {
        return diaComboBox;
    }

    public JComboBox<GrupoMuscular> getGrupoComboBox() {
        return grupoComboBox;
    }
}