package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class LobbyView extends JPanel {

    private JTabbedPane painelDeAbas;
    private JButton logoutButton;

    public LobbyView() {
        setLayout(new BorderLayout());

        painelDeAbas = new JTabbedPane();

        JPanel abaTreinos = new JPanel();
        abaTreinos.add(new JLabel("Área para cadastrar e ver treinos"));

        JPanel abaDietas = new JPanel();
        abaDietas.add(new JLabel("Área para gerir a alimentação"));

        JPanel abaParceiros = new JPanel();
        abaParceiros.add(new JLabel("Encontre parceiros de treino aqui"));

        JPanel abaPerfil = new JPanel();
        abaPerfil.add(new JLabel("Seus dados pessoais e configurações"));

        painelDeAbas.addTab("Treinos", abaTreinos);
        painelDeAbas.addTab("Dietas", abaDietas);
        painelDeAbas.addTab("Parceiros", abaParceiros);
        painelDeAbas.addTab("Perfil", abaPerfil);

        add(painelDeAbas, BorderLayout.CENTER);

        logoutButton = new JButton("Sair (Logout)");
        add(logoutButton, BorderLayout.SOUTH);
    }

    public JButton getBtnLogout() {
        return logoutButton;
    }
}