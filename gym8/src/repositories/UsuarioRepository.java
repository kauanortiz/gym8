package repositories;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import model.Treino;
import model.Usuario;
import model.alimentos.Alimento;
import model.alimentos.Refeicao;
import model.enums.Classificacao;
import model.enums.GrupoMuscular;
import model.enums.Sexo;

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
	
	public List<Usuario> buscarParceirosProximos(Usuario usuarioBuscador, double raioMax){
		
		//.values() pega os usuários e ignora as chaves do map
		return this.usuarios.values().stream().filter(u -> !u.getCpf().equals(usuarioBuscador.getCpf()))
				
				.filter(u -> calcularDistancia(usuarioBuscador.getLatitude(), usuarioBuscador.getLongitude(),
				u.getLatitude(), u.getLongitude()) <= raioMax).collect(Collectors.toList()); //retorna a lista final
	}
	
	private double calcularDistancia(double lat1, double lon1, double lat2, double lon2) {
		final int RAIO_TERRA = 6371;
		
		double latDistance = Math.toRadians(lat2 - lat1);
		double lonDistance = Math.toRadians(lon2 - lon1);
		
		//Fórmula de Haversine
		double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
				+ Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
				* Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		
		return RAIO_TERRA * c;
	}
	
	public List<Usuario> buscarPorSexo(Usuario usuarioBuscador, Sexo sexo){
		return this.usuarios.values().stream()
			.filter(u -> u.getSexo() == sexo)
			.toList();
	}
	
	public List<Usuario> buscarPorClassificacao(Usuario usuarioBuscador, Classificacao classificacao){
		return this.usuarios.values().stream()
			.filter(u -> u.getClassificacao() == classificacao)
			.toList();
	}
	
	public List<Usuario> buscarPorTreino(Usuario usuarioBuscador, GrupoMuscular grupoMuscular){		
		DayOfWeek hoje = LocalDate.now().getDayOfWeek();
		
		return this.usuarios.values().stream()
			.filter(u -> !u.getCpf().equals(usuarioBuscador.getCpf()))
			.filter(u -> u.getTreinos() != null && u.getTreinos().stream()
			.anyMatch(treino -> treino.getDiaDaSemana().equals(hoje) &&
					treino.getGruposMusculares().contains(grupoMuscular)))
					.collect(Collectors.toList());
	}
	
}
