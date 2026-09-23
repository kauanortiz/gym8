package app;

import view.GestorDeTelas;
import controller.GestorController;
import controller.TreinosController;
import repositories.UsuarioRepository;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {

            UsuarioRepository repo = new UsuarioRepository();
            
            GestorDeTelas view = new GestorDeTelas();
            
            GestorController controller = new GestorController(view, repo);
            
            TreinosController treinoController = new TreinosController(view.getTelaLobby().getAbaTreinos(), repo);
            
            view.setVisible(true);
        });
    }
}