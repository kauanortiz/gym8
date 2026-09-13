package repositories;

import java.util.HashMap;
import java.util.Map;

import model.Usuario;

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
		if(usuarios.containsKey(cpf)) {
			System.out.println("Nome: " + usr.getNome() + "\nCPF: " + cpf);
			System.out.println("Idade: " + usr.getIdade() + "\nTempo de treino (em meses): " + usr.getTempoTreino());
			System.out.println("Objetivo: " + usr.getObjetivo() + "\nModelo de treino atual: " + usr.getModeloTreino());
		}
	}
	
	public void listarUsuarios() {
		usuarios.forEach((cpf, Usuario) ->{
			System.out.println("Nome: " + Usuario.getNome() + " | CPF: " + cpf);
		});
		
		System.out.println("\n");
	}
	
}
