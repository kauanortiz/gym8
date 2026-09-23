package app;

import view.GestorDeTelas;
import controller.GestorController;
import repositories.UsuarioRepository;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // 1. Instancia o repositório central
            UsuarioRepository repo = new UsuarioRepository();
            
            // 2. Instancia a View (Janela)
            GestorDeTelas view = new GestorDeTelas();
            
            // 3. Instancia o Controller ligando a View ao Repositório
            GestorController controller = new GestorController(view, repo);
            
            // 4. Mostra a interface ao utilizador
            view.setVisible(true);
        });
    }
}