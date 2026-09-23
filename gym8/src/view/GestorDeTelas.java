package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class GestorDeTelas extends JFrame {
    
    private CardLayout gestorTelas;
    private JPanel painelCartas;
    
    // Instanciamos as telas como atributos para que o Controller possa aceder aos seus dados depois
    private LoginView telaLogin;
    private Cadastro1View tela1;
    private Cadastro2View tela2;
    private Cadastro3View tela3;
    private LobbyView telaLobby;

    public GestorDeTelas() {
        setTitle("gym8 - Cadastro de Utilizador");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gestorTelas = new CardLayout();
        painelCartas = new JPanel(gestorTelas);

        telaLogin = new LoginView();
        tela1 = new Cadastro1View();
        tela2 = new Cadastro2View();
        tela3 = new Cadastro3View();
        telaLobby = new LobbyView();

        painelCartas.add(telaLogin, "LOGIN");
        painelCartas.add(tela1, "PASSO_1");
        painelCartas.add(tela2, "PASSO_2");
        painelCartas.add(tela3, "PASSO_3");
        painelCartas.add(telaLobby, "LOBBY");

        add(painelCartas);
        gestorTelas.show(painelCartas, "LOGIN");
    }

    //Método que o Controller vai usar para mudar a carta (ecrã)
    public void mostrarEcra(String nomeEcra) {
        gestorTelas.show(painelCartas, nomeEcra);
    }

    public LoginView getTelaLogin() {
		return telaLogin;
	}

	//Getters para o Controller aceder às telas e aos seus botões
    public Cadastro1View getTela1(){
    	return tela1;
    }
    
    public Cadastro2View getTela2(){
    	return tela2;
    }
    
    public Cadastro3View getTela3(){
    	return tela3;
    }

	public LobbyView getTelaLobby() {
		return telaLobby;
	}
}