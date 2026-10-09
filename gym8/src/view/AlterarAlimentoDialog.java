package view;

import javax.swing.*;
import model.alimentos.Alimento;
import model.enums.TipoAlimento;

public class AlterarAlimentoDialog extends JDialog {

    private JTextField txtNome;
    private JComboBox<TipoAlimento> comboTipo;
    private boolean salvo = false;

    public AlterarAlimentoDialog(Alimento alimento) {
        setTitle("Editar Alimento");
        setSize(300, 200);
        setLayout(null);
        setModal(true);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 60, 25);
        add(lblNome);

        txtNome = new JTextField(alimento.getNome());
        txtNome.setBounds(80, 20, 180, 25);
        add(txtNome);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setBounds(20, 60, 60, 25);
        add(lblTipo);

        comboTipo = new JComboBox<>(TipoAlimento.values());
        comboTipo.setSelectedItem(alimento.getTipoAlimento());
        comboTipo.setBounds(80, 60, 180, 25);
        add(comboTipo);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(80, 110, 120, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            alimento.setNome(txtNome.getText());
            alimento.setTipoAlimento((TipoAlimento) comboTipo.getSelectedItem());
            
            salvo = true;
            dispose();
        });
    }

    public boolean isSalvo() {
    	return salvo;
    }
}