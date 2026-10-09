package view;

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

    private JComboBox<Classificacao> classificacaoCombo;
    private JComboBox<Sexo> sexoCombo;
    private JButton buscarButton;
    private JButton enviarConviteButton;
    private JTable resultadosTable;
    private DefaultTableModel tableModel;

    public AbaParceirosView() {
        setLayout(null);

        JLabel lblClassificacao = new JLabel("Classificação:");
        lblClassificacao.setBounds(10, 15, 90, 20);
        add(lblClassificacao);

        classificacaoCombo = new JComboBox<>(Classificacao.values());
        classificacaoCombo.setBounds(100, 15, 120, 20);
        classificacaoCombo.setSelectedIndex(-1); 
        add(classificacaoCombo);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(230, 15, 50, 20);
        add(lblSexo);

        sexoCombo = new JComboBox<>(Sexo.values());
        sexoCombo.setBounds(270, 15, 100, 20);
        sexoCombo.setSelectedIndex(-1);
        add(sexoCombo);

        buscarButton = new JButton("Buscar Parceiros");
        buscarButton.setBounds(380, 15, 140, 20);
        add(buscarButton);

        tableModel = new DefaultTableModel(new Object[]{"Nome", "Distância (km)", "Classificação"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        resultadosTable = new JTable(tableModel);
        resultadosTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane scrollPane = new JScrollPane(resultadosTable);
        scrollPane.setBounds(10, 60, 510, 260);
        add(scrollPane);
        
        enviarConviteButton = new JButton("Enviar Convite de Treino");
        enviarConviteButton.setBounds(160, 330, 200, 30);
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