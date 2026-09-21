package app;

import java.util.List;

import model.Dieta;
import model.Treino;
import model.Usuario;
import model.alimentos.Alimento;
import model.alimentos.Carboidrato;
import model.alimentos.Proteina;
import model.alimentos.Refeicao;
import model.alimentos.Salada;
import model.enums.GrupoMuscular;
import model.enums.Sexo;
import model.treinamento.Exercicio;
import repositories.UsuarioRepository;

public class Main {

	public static void main(String[] args) {
		
UsuarioRepository repo = new UsuarioRepository();
        
        Usuario usr1 = new Usuario("Kauan", "111");
        Usuario usr2 = new Usuario("João", "222");
        
        usr1.setSenha("senha123");
        usr2.setSenha("senha456");
        
        repo.adicionar(usr1.getCpf(), usr1);
        repo.adicionar(usr2.getCpf(), usr2);

        System.out.println("--- Tentando Logar ---");
        Usuario tentativa1 = repo.autenticar("111", "senha123");
        
        if (tentativa1 != null) {
            Sessao.setUsuarioLogado(tentativa1);
            System.out.println("Bem-vindo(a), " + Sessao.getUsuarioLogado().getNome() + "!");
        }

        Sessao.encerrarSessao();
        System.out.println("\nUsuário deslogado. Status logado: " + Sessao.isLogado());

        System.out.println("\n--- Tentando Logar ---");
        Usuario tentativa2 = repo.autenticar("222", "senha456");
        
        if (tentativa2 != null) {
            Sessao.setUsuarioLogado(tentativa2);
            System.out.println("Bem-vindo(a), " + Sessao.getUsuarioLogado().getNome() + "!");
        }
    }
}
