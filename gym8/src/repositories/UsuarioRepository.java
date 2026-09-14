package repositories;

import java.util.HashMap;
import java.util.Map;

import model.Treino;
import model.Usuario;
import model.alimentos.Alimento;
import model.alimentos.Refeicao;
import model.enums.GrupoMuscular;

public class UsuarioRepository {

	private Map<String, Usuario> usuarios = new HashMap<>();
	
	public void adicionar(String cpf, Usuario usr) {
		usuarios.put(cpf, usr);
		
		System.out.println("Usuário cadastrado com sucesso!\n");
	}
	
	public void alterarCPF(String cpfAntigo, String cpfNovo, Usuario usr) {		
		if(usuarios.containsKey(cpfAntigo)) {
			usuarios.put(cpfNovo, usr);
			
			usuarios.remove(cpfAntigo);
			
			System.out.println("Usuário alterado com sucesso!\n");
			
		}else {
			System.out.println("Usuário não encontrado!\n");
		}
		
	}
	
	public void alterarNome(String cpf, Usuario usr, String nomeNovo) {		
		if(usuarios.containsKey(cpf)) {	
			usuarios.remove(usr.getNome());
			
			usr.setNome(nomeNovo);
			
			usuarios.put(cpf, usr);
					
			System.out.println("Usuário alterado com sucesso!\n");
			
		}else {
			System.out.println("Usuário não encontrado!\n");
		}
		
	}
	
	public void excluir(String cpf) {
		if(usuarios.containsKey(cpf)) {
			usuarios.remove(cpf);
			
			System.out.println("Usuário removido com sucesso!\n");
			
		}else {
			System.out.println("Usuário não encontrado!\n");
		}
	}
	
	public void consultar(String cpf, Usuario usr) {
		
		//bloco de informações básicas
		if(usuarios.containsKey(cpf)) {
			usr.gerarResumo();
			
			//bloco para informações detalhadas sobre o treino
			if(usr.getTreinos() != null) {
				System.out.println("-------------------------------\nTreinos do usuário:\n");
				
				for(Treino t : usr.getTreinos()) {
					System.out.println("Duração média: " + t.getDuracao() + " minutos");
					
					for(GrupoMuscular gm : t.getGruposMusculares()) {
						System.out.println("Grupo(s) muscular(es): " + gm);
					}
					
					System.out.println("\nExercícios:");
					t.gerarResumo();
					System.out.println("-------------------------------");
				}
			}
			else {
				System.out.println("Nenhum treino cadastrado para esse usuário!");
			}
			
			//bloco para informações detalhadas sobre a dieta
			if(usr.getDieta() != null) {
				System.out.println("-------------------------------\nDieta do usuário:\n");
				
				usr.getDieta().listarRefeicoes();
				System.out.println("-------------------------------");
			}
			else {
				System.out.println("Nenhuma dieta cadastrada para este usuário!");
			}
		}
		else {
			System.out.println("Usuário não encontrado!");
		}
	}
	
	public void listarUsuarios() {
		usuarios.forEach((cpf, Usuario) ->{
			System.out.println("Nome: " + Usuario.getNome() + " | CPF: " + cpf);
		});
		
		System.out.println("\n");
	}
	
}
