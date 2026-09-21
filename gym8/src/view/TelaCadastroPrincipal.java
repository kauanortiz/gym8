package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;

public class TelaCadastroPrincipal extends JFrame {
    
    private CardLayout gestorTelas;
    private JPanel painelCartas;
    
    // Instanciamos as telas como atributos para que o Controller possa aceder aos seus dados depois
    private Tela1View tela1;
    private Tela2View tela2;
    private Tela3View tela3;

    public TelaCadastroPrincipal() {
        setTitle("gym8 - Cadastro de Utilizador");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        gestorTelas = new CardLayout();
        painelCartas = new JPanel(gestorTelas);

        tela1 = new Tela1View();
        tela2 = new Tela2View();
        tela3 = new Tela3View();

        painelCartas.add(tela1, "PASSO_1");
        painelCartas.add(tela2, "PASSO_2");
        painelCartas.add(tela3, "PASSO_3");

        add(painelCartas);
        gestorTelas.show(painelCartas, "PASSO_1");
    }

    // Método que o Controller vai usar para mudar a carta (ecrã)
    public void mostrarEcra(String nomeEcra) {
        gestorTelas.show(painelCartas, nomeEcra);
    }

    // Getters para o Controller aceder às telas e aos seus botões
    public Tela1View getTela1() { return tela1; }
    public Tela2View getTela2() { return tela2; }
    public Tela3View getTela3() { return tela3; }
}