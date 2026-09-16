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
import model.treinamento.Exercicio;
import repositories.UsuarioRepository;

public class Main {

	public static void main(String[] args) {
		
		UsuarioRepository repo = new UsuarioRepository();
		
		Usuario usr1 = new Usuario("Kauan", -23.5505, -46.6333);
		Usuario usr2 = new Usuario("João", -23.5615, -46.6560);
		Usuario usr3 = new Usuario("Pedro", -22.9068, -43.1729);
		
		usr1.setCpf("11631772961");
		usr2.setCpf("11631772962");
		usr3.setCpf("11631772963");
		
		repo.adicionar(usr1.getCpf(), usr1);
		repo.adicionar(usr2.getCpf(), usr2);
		repo.adicionar(usr3.getCpf(), usr3);
		
		List<Usuario> parceiros = repo.buscarParceirosProximos(usr1, 5.0);
		
		System.out.println("Parceiros encontrados próximos ao " + usr1.getNome() + ":");
		for(Usuario u : parceiros) {
			System.out.println("- " + u.getNome());
		}
		
	}

}
