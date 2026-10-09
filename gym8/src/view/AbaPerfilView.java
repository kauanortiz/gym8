package view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AbaPerfilView extends JPanel {

    private JLabel lblNomeValor;
    private JLabel lblIdadeValor;
    
    private DefaultTableModel modeloTreinos;
    private DefaultTableModel modeloDietas;
    private DefaultTableModel modeloConvites;
    
    private JTable tabelaTreinos;
    private JTable tabelaDietas;
    private JTable tabelaConvites;
    
    private JButton btnAceitarConvite;
    private JButton btnRecusarConvite;

    public AbaPerfilView() {
        setLayout(null);

        JLabel lblTitulo = new JLabel("Meu Perfil");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
        lblTitulo.setBounds(10, 11, 150, 20);
        add(lblTitulo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(10, 42, 46, 14);
        add(lblNome);

        lblNomeValor = new JLabel("-");
        lblNomeValor.setBounds(60, 42, 250, 14);
        add(lblNomeValor);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setBounds(10, 67, 46, 14);
        add(lblIdade);

        lblIdadeValor = new JLabel("-");
        lblIdadeValor.setBounds(60, 67, 100, 14);
        add(lblIdadeValor);

        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 100, 520, 250);
        add(tabbedPane);

        modeloTreinos = new DefaultTableModel(new Object[]{"Grupos musculares", "Dia", "Qtd. Exercícios"}, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
        };
        tabelaTreinos = new JTable(modeloTreinos);
        tabbedPane.addTab("Meus Treinos", new JScrollPane(tabelaTreinos));

        modeloDietas = new DefaultTableModel(new Object[]{"Refeição", "Qtd. Alimentos"}, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
        };
        tabelaDietas = new JTable(modeloDietas);
        tabbedPane.addTab("Minha Dieta", new JScrollPane(tabelaDietas));

        JPanel panelConvites = new JPanel();
        panelConvites.setLayout(null);
        
        modeloConvites = new DefaultTableModel(new Object[]{"Remetente", "Status"}, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
        };
        tabelaConvites = new JTable(modeloConvites);
        JScrollPane scrollConvites = new JScrollPane(tabelaConvites);
        scrollConvites.setBounds(0, 0, 515, 180);
        panelConvites.add(scrollConvites);
        
        btnAceitarConvite = new JButton("Aceitar");
        btnAceitarConvite.setBounds(10, 188, 100, 23);
        panelConvites.add(btnAceitarConvite);
        
        btnRecusarConvite = new JButton("Recusar");
        btnRecusarConvite.setBounds(120, 188, 100, 23);
        panelConvites.add(btnRecusarConvite);

        tabbedPane.addTab("Convites Recebidos", panelConvites);
    }

    public JLabel getLblNomeValor() {
    	return lblNomeValor;
    }
    
    public JLabel getLblIdadeValor() {
    	return lblIdadeValor;
    }
    
    public DefaultTableModel getModeloTreinos() {
    	return modeloTreinos;
    }
    
    public DefaultTableModel getModeloDietas() {
    	return modeloDietas;
    }
    
    public DefaultTableModel getModeloConvites() {
    	return modeloConvites;
    }
    
    public JTable getTabelaConvites() {
    	return tabelaConvites;
    }
    
    public JButton getBtnAceitarConvite() {
    	return btnAceitarConvite;
    }
    
    public JButton getBtnRecusarConvite() {
    	return btnRecusarConvite;
    }
}