package view;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class LobbyView extends JPanel {

    private JTabbedPane painelDeAbas;
    private JButton logoutButton;
    private AbaTreinosView abaTreinos;
    private AbaDietaView abaDietas;
    private AbaParceirosView abaParceiros;
    private AbaPerfilView abaPerfil;

    public LobbyView() {
        setLayout(new BorderLayout());

        painelDeAbas = new JTabbedPane();

        abaTreinos = new AbaTreinosView();

        abaDietas = new AbaDietaView();

        abaParceiros = new AbaParceirosView();

        abaPerfil = new AbaPerfilView();
        abaPerfil.add(new JLabel("Seus dados pessoais e configurações"));

        painelDeAbas.addTab("Treinos", abaTreinos);
        painelDeAbas.addTab("Dietas", abaDietas);
        painelDeAbas.addTab("Parceiros", abaParceiros);
        painelDeAbas.addTab("Perfil", abaPerfil);

        add(painelDeAbas, BorderLayout.CENTER);

        logoutButton = new JButton("Sair (Logout)");
        add(logoutButton, BorderLayout.SOUTH);
    }

    public JButton getLogoutButton() {
        return logoutButton;
    }

	public AbaTreinosView getAbaTreinos() {
		return abaTreinos;
	}
	
	public AbaDietaView getAbaDietas() {
		return abaDietas;
	}

	public AbaParceirosView getAbaParceiros() {
		return abaParceiros;
	}

	public AbaPerfilView getAbaPerfil() {
		return abaPerfil;
	}
	
	public JTabbedPane getPainelDeAbas() {
		return this.painelDeAbas;
	}
}