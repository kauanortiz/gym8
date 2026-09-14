package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.enums.GrupoMuscular;
import model.treinamento.Exercicio;

public class Treino {

	private Integer duracao;
	private Set<Exercicio> exercicios = new HashSet<>();
	private List<GrupoMuscular> gruposMusculares = new ArrayList<>();
	
	public Treino(Integer duracaoMedia, Set<Exercicio> exercicios) {
		this.duracao = duracaoMedia;
		this.exercicios = exercicios;
	}

	public Treino() {
	}

	public Set<Exercicio> getExercicios() {
		return exercicios;
	}

	public void setExercicios(Set<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
	
	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public List<GrupoMuscular> getGruposMusculares() {
		return gruposMusculares;
	}

	public void setGruposMusculares(List<GrupoMuscular> gruposMusculares) {
		this.gruposMusculares = gruposMusculares;
	}
	
	public void adicionarGrupoMuscular(GrupoMuscular grupoMuscular) {
		gruposMusculares.add(grupoMuscular);
		
		System.out.println("Grupo muscular adicionado com sucesso!\n");
	}
	
	public void removerGrupoMuscular(GrupoMuscular grupoMuscular) {
		if(gruposMusculares.contains(grupoMuscular)) {
			gruposMusculares.remove(grupoMuscular);
			
			System.out.println("Grupo muscular removido com sucesso!\n");
		}
		else {
			System.out.println("Grupo muscular não encontrado!\n");
		}
		
	}

	public void adicionar(Exercicio exercicio) {
			exercicios.add(exercicio);
			
			System.out.println("Exercício adicionado com sucesso!\n");
	}
	
	public void remover(Exercicio exercicio) {
		if(exercicios.contains(exercicio)) {
			exercicios.remove(exercicio);
			
			System.out.println("Exercício removido com sucesso!\n");
		}
		else {
			System.out.println("Exercício não encontrado!\n");
		}
	}
	
	public void alterar(Exercicio exercicio, String nome, Integer repsMinimas, Integer repsMaximas, GrupoMuscular grupoMuscular) {
		if(exercicios.contains(exercicio)) {
			exercicio.setNome(nome);
			exercicio.setRepsMinimas(repsMinimas);
			exercicio.setRepsMaximas(repsMaximas);
			exercicio.setGrupoMuscular(grupoMuscular);
		}else {
			System.out.println("Exercício não encontrado!\n");
		}
	}
	
	public void gerarResumo() {
		for(Exercicio e: exercicios) {
			System.out.println(e.getNome() + "\n" + 
					e.getRepsMinimas() + " - " + e.getRepsMaximas() + " repetições\n" + "Grupo muscular: " + e.getGrupoMuscular());
			System.out.println("\n");
		}
	}

}
