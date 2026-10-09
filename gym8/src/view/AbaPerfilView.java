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

    private static final long serialVersionUID = 1L;
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
    
    //convites
    private DefaultTableModel modeloDetalhesRemetente;
    private JTable tabelaDetalhesRemetente;

    public AbaPerfilView() {
        setLayout(null);
        
        JLabel lblTitulo = new JLabel("Meu Perfil");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblTitulo.setBounds(20, 15, 150, 30);
        add(lblTitulo);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblNome.setBounds(20, 60, 50, 20);
        add(lblNome);

        lblNomeValor = new JLabel("-");
        lblNomeValor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblNomeValor.setBounds(70, 60, 250, 20);
        add(lblNomeValor);

        JLabel lblIdade = new JLabel("Idade:");
        lblIdade.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblIdade.setBounds(20, 85, 50, 20);
        add(lblIdade);

        lblIdadeValor = new JLabel("-");
        lblIdadeValor.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblIdadeValor.setBounds(70, 85, 100, 20);
        add(lblIdadeValor);
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabbedPane.setBounds(20, 125, 510, 255);
        add(tabbedPane);
        
        JPanel panelTreinos = new JPanel();
        panelTreinos.setLayout(null);

        modeloTreinos = new DefaultTableModel(new Object[]{"Grupos musculares", "Dia", "Qtd. Exercícios"}, 0) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaTreinos = new JTable(modeloTreinos);
        tabelaTreinos.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabelaTreinos.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        
        JScrollPane scrollTreinos = new JScrollPane(tabelaTreinos);
        scrollTreinos.setBounds(10, 10, 485, 100);
        panelTreinos.add(scrollTreinos);

        JLabel lblDetalhes = new JLabel("Detalhes do Treino Selecionado:");
        lblDetalhes.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblDetalhes.setBounds(10, 120, 250, 20);
        panelTreinos.add(lblDetalhes);

        detalhesTreinoTextArea = new JTextArea();
        detalhesTreinoTextArea.setEditable(false);
        detalhesTreinoTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        
        JScrollPane scrollDetalhes = new JScrollPane(detalhesTreinoTextArea);
        scrollDetalhes.setBounds(10, 145, 320, 70);
        panelTreinos.add(scrollDetalhes);

        btnRemoverTreino = new JButton("Remover");
        btnRemoverTreino.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnRemoverTreino.setBounds(345, 145, 150, 30);
        panelTreinos.add(btnRemoverTreino);

        btnAlterarTreino = new JButton("Alterar Treino");
        btnAlterarTreino.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnAlterarTreino.setBounds(345, 185, 150, 30);
        panelTreinos.add(btnAlterarTreino);

        tabbedPane.addTab("Meus Treinos", panelTreinos);

        JPanel panelDietas = new JPanel();
        panelDietas.setLayout(null);

        modeloDietas = new DefaultTableModel(new Object[]{"Refeição", "Qtd. Alimentos"}, 0) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaDietas = new JTable(modeloDietas);
        tabelaDietas.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabelaDietas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        
        JScrollPane scrollDietas = new JScrollPane(tabelaDietas);
        scrollDietas.setBounds(10, 10, 485, 100);
        panelDietas.add(scrollDietas);

        JLabel lblDetalhesDieta = new JLabel("Detalhes da Refeição Selecionada:");
        lblDetalhesDieta.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblDetalhesDieta.setBounds(10, 120, 250, 20);
        panelDietas.add(lblDetalhesDieta);

        detalhesDietaTextArea = new JTextArea();
        detalhesDietaTextArea.setEditable(false);
        detalhesDietaTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        
        JScrollPane scrollDetalhesDieta = new JScrollPane(detalhesDietaTextArea);
        scrollDetalhesDieta.setBounds(10, 145, 320, 70);
        panelDietas.add(scrollDetalhesDieta);

        btnRemoverDieta = new JButton("Remover Refeição");
        btnRemoverDieta.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnRemoverDieta.setBounds(345, 145, 150, 30);
        panelDietas.add(btnRemoverDieta);

        btnAlterarDieta = new JButton("Alterar Refeição");
        btnAlterarDieta.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnAlterarDieta.setBounds(345, 185, 150, 30);
        panelDietas.add(btnAlterarDieta);

        tabbedPane.addTab("Minha Dieta", panelDietas);
        
        JPanel panelConvites = new JPanel();
        panelConvites.setLayout(null);

        modeloConvites = new DefaultTableModel(new Object[]{"Remetente", "Status"}, 0) {
            private static final long serialVersionUID = 1L;
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaConvites = new JTable(modeloConvites);
        tabelaConvites.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabelaConvites.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        
        JScrollPane scrollConvites = new JScrollPane(tabelaConvites);
        scrollConvites.setBounds(10, 10, 485, 100);
        panelConvites.add(scrollConvites);

        JLabel lblDetalhesConvite = new JLabel("Informações do Remetente:");
        lblDetalhesConvite.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblDetalhesConvite.setBounds(10, 120, 200, 20);
        panelConvites.add(lblDetalhesConvite);

        modeloDetalhesRemetente = new DefaultTableModel(new Object[]{"Atributo", "Valor"}, 0) {
            private static final long serialVersionUID = 1L;
            @Override public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaDetalhesRemetente = new JTable(modeloDetalhesRemetente);
        tabelaDetalhesRemetente.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        tabelaDetalhesRemetente.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 13));
        
        JScrollPane scrollDetalhesConvite = new JScrollPane(tabelaDetalhesRemetente);
        scrollDetalhesConvite.setBounds(10, 145, 320, 70);
        panelConvites.add(scrollDetalhesConvite);

        btnAceitarConvite = new JButton("Aceitar Convite");
        btnAceitarConvite.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnAceitarConvite.setBounds(345, 145, 150, 30);
        panelConvites.add(btnAceitarConvite);

        btnRecusarConvite = new JButton("Recusar Convite");
        btnRecusarConvite.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnRecusarConvite.setBounds(345, 185, 150, 30);
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
    
    public DefaultTableModel getModeloDetalhesRemetente() {
    	return modeloDetalhesRemetente;
    }
    
    public JTable getTabelaDetalhesRemetente() {
    	return tabelaDetalhesRemetente;
    }
}