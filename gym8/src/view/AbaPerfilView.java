package view;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;

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
    
    //treinos
    private JTextArea detalhesTreinoTextArea;
    private JButton btnRemoverTreino;
    private JButton btnAlterarTreino;
    
    //dietas
    private JTextArea detalhesDietaTextArea;
	private JButton btnRemoverDieta;
	private JButton btnAlterarDieta;

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
        
        JPanel panelTreinos = new JPanel();
        panelTreinos.setLayout(null);

        modeloTreinos = new DefaultTableModel(new Object[]{"Grupos musculares", "Dia", "Qtd. Exercícios"}, 0) {
	        @Override
	        public boolean isCellEditable(int row, int column) {
	            return false;
	        }
        };
        tabelaTreinos = new JTable(modeloTreinos);
        JScrollPane scrollTreinos = new JScrollPane(tabelaTreinos);
        scrollTreinos.setBounds(0, 0, 515, 120);
        panelTreinos.add(scrollTreinos);

        JLabel lblDetalhes = new JLabel("Detalhes do Treino Selecionado:");
        lblDetalhes.setBounds(10, 125, 200, 15);
        panelTreinos.add(lblDetalhes);

        detalhesTreinoTextArea = new JTextArea();
        detalhesTreinoTextArea.setEditable(false);
        JScrollPane scrollDetalhes = new JScrollPane(detalhesTreinoTextArea);
        scrollDetalhes.setBounds(10, 145, 340, 70);
        panelTreinos.add(scrollDetalhes);

        btnRemoverTreino = new JButton("Remover");
        btnRemoverTreino.setBounds(360, 145, 140, 25);
        panelTreinos.add(btnRemoverTreino);

        btnAlterarTreino = new JButton("Alterar (Aba Treinos)");
        btnAlterarTreino.setBounds(360, 180, 140, 25);
        panelTreinos.add(btnAlterarTreino);

        tabbedPane.addTab("Meus Treinos", panelTreinos);

        JPanel panelDietas = new JPanel();
        panelDietas.setLayout(null);

        // Tabela de Refeições
        modeloDietas = new DefaultTableModel(new Object[]{"Refeição", "Qtd. Alimentos"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaDietas = new JTable(modeloDietas);
        JScrollPane scrollDietas = new JScrollPane(tabelaDietas);
        scrollDietas.setBounds(0, 0, 515, 120);
        panelDietas.add(scrollDietas);

        // Área de Detalhes
        JLabel lblDetalhesDieta = new JLabel("Detalhes da Refeição Selecionada:");
        lblDetalhesDieta.setBounds(10, 125, 250, 15);
        panelDietas.add(lblDetalhesDieta);

        detalhesDietaTextArea = new JTextArea();
        detalhesDietaTextArea.setEditable(false);
        JScrollPane scrollDetalhesDieta = new JScrollPane(detalhesDietaTextArea);
        scrollDetalhesDieta.setBounds(10, 145, 340, 70);
        panelDietas.add(scrollDetalhesDieta);

        // Botões
        btnRemoverDieta = new JButton("Remover Refeição");
        btnRemoverDieta.setBounds(360, 145, 140, 25);
        panelDietas.add(btnRemoverDieta);

        btnAlterarDieta = new JButton("Alterar Refeição");
        btnAlterarDieta.setBounds(360, 180, 140, 25);
        panelDietas.add(btnAlterarDieta);

        // Adiciona tudo na Aba do Perfil
        tabbedPane.addTab("Minha Dieta", panelDietas);
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
    
    public JTable getTabelaTreinos() {
    	return tabelaTreinos;
    }
    
    public JTextArea getDetalhesTreinoTextArea() {
    	return detalhesTreinoTextArea;
    }
    
    public JButton getBtnRemoverTreino() {
    	return btnRemoverTreino;
    }
    
    public JButton getBtnAlterarTreino() {
    	return btnAlterarTreino;
    }

	public JTable getTabelaDietas() {
		return tabelaDietas;
	}

	public JTextArea getDetalhesDietaTextArea() {
		return detalhesDietaTextArea;
	}

	public JButton getBtnRemoverDieta() {
		return btnRemoverDieta;
	}

	public JButton getBtnAlterarDieta() {
		return btnAlterarDieta;
	}
}