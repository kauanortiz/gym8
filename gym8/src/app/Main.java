package app;

import view.TelaCadastroPrincipal;
import controller.CadastroController;
import repositories.UsuarioRepository;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Instancia o repositório central
            UsuarioRepository repo = new UsuarioRepository();
            
            // 2. Instancia a View (Janela)
            TelaCadastroPrincipal tela = new TelaCadastroPrincipal();
            
            // 3. Instancia o Controller ligando a View ao Repositório
            CadastroController controller = new CadastroController(tela, repo);
            
            // 4. Mostra a interface ao utilizador
            tela.setVisible(true);
        });
    }
}