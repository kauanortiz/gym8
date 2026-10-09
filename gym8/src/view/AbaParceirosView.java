package view;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import model.enums.Classificacao;
import model.enums.Sexo;

public class AbaParceirosView extends JPanel {

    private static final long serialVersionUID = 1L;
    private JComboBox<Classificacao> classificacaoCombo;
    private JComboBox<Sexo> sexoCombo;
    private JButton buscarButton;
    private JButton enviarConviteButton;
    private JTable resultadosTable;
    private DefaultTableModel tableModel;

    public AbaParceirosView() {
        setLayout(null);

        Font fonteLabel = new Font("Segoe UI", Font.PLAIN, 14);
        Font fonteCampo = new Font("Segoe UI", Font.PLAIN, 14);
        
        JLabel lblClassificacao = new JLabel("Classificação:");
        lblClassificacao.setFont(fonteLabel);
        lblClassificacao.setBounds(20, 20, 90, 30);
        add(lblClassificacao);

        classificacaoCombo = new JComboBox<>(Classificacao.values());
        classificacaoCombo.setFont(fonteCampo);
        classificacaoCombo.setBounds(110, 20, 120, 30);
        classificacaoCombo.setSelectedIndex(-1); 
        add(classificacaoCombo);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setFont(fonteLabel);
        lblSexo.setBounds(240, 20, 40, 30);
        add(lblSexo);

        sexoCombo = new JComboBox<>(Sexo.values());
        sexoCombo.setFont(fonteCampo);
        sexoCombo.setBounds(280, 20, 100, 30);
        sexoCombo.setSelectedIndex(-1);
        add(sexoCombo);

        buscarButton = new JButton("Buscar Parceiros");
        buscarButton.setFont(new Font("Segoe UI", Font.BOLD, 13));
        buscarButton.setBounds(390, 20, 140, 30);
        add(buscarButton);
        
        tableModel = new DefaultTableModel(new Object[]{"Nome", "Distância (km)", "Classificação"}, 0) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        resultadosTable = new JTable(tableModel);
        resultadosTable.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        resultadosTable.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        resultadosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(resultadosTable);
        scrollPane.setBounds(20, 70, 510, 250);
        add(scrollPane);
        
        enviarConviteButton = new JButton("Enviar Convite de Treino");
        enviarConviteButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        enviarConviteButton.setBounds(165, 340, 220, 35);
        add(enviarConviteButton);
    }

    
    public JComboBox<Classificacao> getClassificacaoCombo() {
        return classificacaoCombo;
    }
    
    public JComboBox<Sexo> getSexoCombo() {
        return sexoCombo;
    }
    
    public JButton getBuscarButton() {
        return buscarButton;
    }
    
    public JButton getEnviarConviteButton() {
        return enviarConviteButton;
    }
    
    public DefaultTableModel getTableModel() {
        return tableModel;
    }
    
    public JTable getResultadosTable() {
        return resultadosTable;
    }
}