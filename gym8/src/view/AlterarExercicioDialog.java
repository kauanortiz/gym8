package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;

import model.treinamento.Exercicio;
import model.enums.GrupoMuscular;

public class AlterarExercicioDialog extends JDialog {

    private JTextField txtNome;
    private JSpinner spinRepsMin;
    private JSpinner spinRepsMax;
    private JComboBox<GrupoMuscular> comboGrupo;
    private boolean salvo = false;

    public AlterarExercicioDialog(Exercicio exercicio) {
        setTitle("Editar Exercício");
        setSize(300, 250);
        setLayout(null);
        setModal(true);
        setLocationRelativeTo(null);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setBounds(20, 20, 60, 25);
        add(lblNome);

        txtNome = new JTextField(exercicio.getNome());
        txtNome.setBounds(90, 20, 170, 25);
        add(txtNome);

        JLabel lblRepsMin = new JLabel("Reps Mín:");
        lblRepsMin.setBounds(20, 60, 70, 25);
        add(lblRepsMin);

        spinRepsMin = new JSpinner(new SpinnerNumberModel(exercicio.getRepsMinimas().intValue(), 1, 100, 1));
        spinRepsMin.setBounds(90, 60, 50, 25);
        add(spinRepsMin);

        JLabel lblRepsMax = new JLabel("Reps Máx:");
        lblRepsMax.setBounds(150, 60, 70, 25);
        add(lblRepsMax);

        spinRepsMax = new JSpinner(new SpinnerNumberModel(exercicio.getRepsMaximas().intValue(), 1, 100, 1));
        spinRepsMax.setBounds(210, 60, 50, 25);
        add(spinRepsMax);

        JLabel lblGrupo = new JLabel("Grupo:");
        lblGrupo.setBounds(20, 100, 60, 25);
        add(lblGrupo);

        comboGrupo = new JComboBox<>(GrupoMuscular.values());
        comboGrupo.setSelectedItem(exercicio.getGrupoMuscular());
        comboGrupo.setBounds(90, 100, 170, 25);
        add(comboGrupo);

        JButton btnSalvar = new JButton("Salvar Exercício");
        btnSalvar.setBounds(60, 150, 150, 30);
        add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            int min = (int) spinRepsMin.getValue();
            int max = (int) spinRepsMax.getValue();

            if(min > max) {
                JOptionPane.showMessageDialog(this, "Repetição mínima não pode ser maior que a máxima!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            exercicio.setNome(txtNome.getText());
            exercicio.setRepsMinimas(min);
            exercicio.setRepsMaximas(max);
            exercicio.setGrupoMuscular((GrupoMuscular) comboGrupo.getSelectedItem());
            
            salvo = true;
            dispose();
        });
    }

    public boolean isSalvo() {
        return salvo;
    }
}