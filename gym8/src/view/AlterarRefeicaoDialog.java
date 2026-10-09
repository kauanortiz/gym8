package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import model.alimentos.Refeicao;
import model.alimentos.Alimento;

public class AlterarRefeicaoDialog extends JDialog {

    private DefaultTableModel modeloAlimentos;
    private JTable tabelaAlimentos;
    private List<Alimento> listaAlimentos;
    private boolean salvo = false;

    public AlterarRefeicaoDialog(Refeicao refeicaoSelecionada) {
        setTitle("Alterar Refeição");
        setSize(400, 350);
        setLayout(null);
        setModal(true);
        setLocationRelativeTo(null);

        JLabel lblAlimentos = new JLabel("Alimentos da Refeição:");
        lblAlimentos.setBounds(20, 20, 200, 25);
        add(lblAlimentos);

        listaAlimentos = new ArrayList<>(refeicaoSelecionada.getAlimentos());

        modeloAlimentos = new DefaultTableModel(new Object[]{"Alimento", "Tipo/Calorias"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tabelaAlimentos = new JTable(modeloAlimentos);
        JScrollPane scroll = new JScrollPane(tabelaAlimentos);
        scroll.setBounds(20, 50, 340, 150);
        add(scroll);
        
        atualizarTabela();

        JButton btnEditarAlimento = new JButton("Editar Alimento");
        btnEditarAlimento.setBounds(20, 210, 150, 25);
        add(btnEditarAlimento);

        JButton btnSalvar = new JButton("Salvar Refeição");
        btnSalvar.setBounds(110, 260, 150, 30);
        add(btnSalvar);

        btnEditarAlimento.addActionListener(e -> {
            int linha = tabelaAlimentos.getSelectedRow();
            if(linha != -1) {
                Alimento alClicado = listaAlimentos.get(linha);
                
                AlterarAlimentoDialog dialogAl = new AlterarAlimentoDialog(alClicado);
                dialogAl.setVisible(true);
                
                if(dialogAl.isSalvo()) {
                    atualizarTabela();
                }
            }else{
                JOptionPane.showMessageDialog(this, "Selecione um alimento para editar.");
            }
        });

        btnSalvar.addActionListener(e -> {
            salvo = true;
            dispose();
        });
    }

    private void atualizarTabela() {
        modeloAlimentos.setRowCount(0);
        for(Alimento al : listaAlimentos) {
            modeloAlimentos.addRow(new Object[]{ al.getNome(), al.getTipoAlimento() });
        }
    }

    public boolean isSalvo(){
    	return salvo;
    }
}