package app;

import view.GestorDeTelas;
import controller.DietasController;
import controller.GestorController;
import controller.ParceirosController;
import controller.PerfilController;
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
            
            DietasController dietaController = new DietasController(view.getTelaLobby().getAbaDietas(), repo);
            
            ParceirosController parceiroController = new ParceirosController(view.getTelaLobby().getAbaParceiros(), repo);
            
            PerfilController perfilController = new PerfilController(view.getTelaLobby().getAbaPerfil());
            
            view.setVisible(true);
        });
    }
}