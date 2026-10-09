package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Treino;
import model.treinamento.Exercicio;
import model.enums.DiasDaSemana;

public class AlterarTreinoDialog extends JDialog {

    private JTextField txtDuracao;
    private JComboBox<DiasDaSemana> comboDia;
    private JButton btnSalvar;
    private JButton btnEditarExercicio;
    private boolean dadosForamSalvos = false;
    
    private DefaultTableModel modeloExercicios;
    private JTable tabelaExercicios;
    private List<Exercicio> listaExercicios;

    public AlterarTreinoDialog(Treino treinoSelecionado) {
        setTitle("Alterar Treino");
        setSize(400, 400);
        setLayout(null);
        setModal(true); 
        setLocationRelativeTo(null); 

        JLabel lblDuracao = new JLabel("Duração (min):");
        lblDuracao.setBounds(20, 20, 100, 25);
        add(lblDuracao);

        txtDuracao = new JTextField(String.valueOf(treinoSelecionado.getDuracao()));
        txtDuracao.setBounds(120, 20, 100, 25);
        add(txtDuracao);

        JLabel lblDia = new JLabel("Dia da Semana:");
        lblDia.setBounds(20, 60, 100, 25);
        add(lblDia);

        comboDia = new JComboBox<>(DiasDaSemana.values());
        comboDia.setSelectedItem(treinoSelecionado.getDia());
        comboDia.setBounds(120, 60, 150, 25);
        add(comboDia);

        JLabel lblExercicios = new JLabel("Exercícios do Treino:");
        lblExercicios.setBounds(20, 100, 150, 25);
        add(lblExercicios);

        listaExercicios = new ArrayList<>(treinoSelecionado.getExercicios());

        modeloExercicios = new DefaultTableModel(new Object[]{"Exercício", "Repetições", "Grupo"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaExercicios = new JTable(modeloExercicios);
        JScrollPane scroll = new JScrollPane(tabelaExercicios);
        scroll.setBounds(20, 130, 340, 120);
        add(scroll);
        
        atualizarTabela();

        btnEditarExercicio = new JButton("Editar Exercício Selecionado");
        btnEditarExercicio.setBounds(20, 260, 200, 25);
        add(btnEditarExercicio);

        btnSalvar = new JButton("Salvar Tudo");
        btnSalvar.setBounds(110, 310, 150, 30);
        add(btnSalvar);

        btnEditarExercicio.addActionListener(e -> {
            int linha = tabelaExercicios.getSelectedRow();
            if(linha != -1) {
                Exercicio exClicado = listaExercicios.get(linha);
                
                AlterarExercicioDialog dialogEx = new AlterarExercicioDialog(exClicado);
                dialogEx.setVisible(true);
                
                if(dialogEx.isSalvo()) {
                    
                    listaExercicios.sort(Comparator.comparing(Exercicio::getNome));        
                    atualizarTabela();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Selecione um exercício na tabela para editar.");
            }
        });

        btnSalvar.addActionListener(e -> {
            try{
                treinoSelecionado.setDuracao(Integer.parseInt(txtDuracao.getText()));
                treinoSelecionado.setDia((DiasDaSemana) comboDia.getSelectedItem());
                
                treinoSelecionado.getGruposMusculares().clear();
                
                for(Exercicio ex : treinoSelecionado.getExercicios()) {
                    if(!treinoSelecionado.getGruposMusculares().contains(ex.getGrupoMuscular())) {
                        treinoSelecionado.getGruposMusculares().add(ex.getGrupoMuscular());
                    }
                }
                
                dadosForamSalvos = true;
                dispose(); 
            }catch(Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro nos dados do treino.");
            }
        });
    }

    private void atualizarTabela() {
        modeloExercicios.setRowCount(0);
        for(Exercicio ex : listaExercicios) {
            modeloExercicios.addRow(new Object[]{
                ex.getNome(),
                ex.getRepsMinimas() + " a " + ex.getRepsMaximas(),
                ex.getGrupoMuscular()
            });
        }
    }

    public boolean isDadosForamSalvos() {
        return dadosForamSalvos;
    }
}