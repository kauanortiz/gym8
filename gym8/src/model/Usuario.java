package model;

import java.util.ArrayList;
import java.util.List;

import model.enums.Objetivo;

public class Usuario {

	private String nome;
	private String cpf;
	private Integer idade;
	private Integer tempoTreino;
	private Objetivo objetivo;
	private List<Treino> treinos = new ArrayList<>();
	private Dieta dieta;
	
	public Usuario(String nome, String cpf, Integer idade, Integer tempoTreino, Objetivo objetivo, List<Treino> treinos, Dieta dieta) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.tempoTreino = tempoTreino;
		this.objetivo = objetivo;
		this.treinos = treinos;
	}

	public Usuario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if(cpf.length() < 11) {
			throw new IllegalArgumentException("CPF inválido!");
		}
		
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.isBlank()) {
			throw new IllegalArgumentException("Nome inválido!");
		}
		
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		if(idade < 18) {
			throw new IllegalArgumentException("Serviço disponível apenas para maiores de 18 anos!");
		}
		
		this.idade = idade;
	}

	public Integer getTempoTreino() {
		return tempoTreino;
	}

	public void setTempoTreino(Integer tempoTreino) {
		if(tempoTreino < 1) {
			throw new IllegalArgumentException("Tempo em meses precisa ser maior que 1!");
		}
		
		this.tempoTreino = tempoTreino;
	}

	public Objetivo getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivo objetivo) {
		this.objetivo = objetivo;
	}

	public List<Treino> getTreinos() {
		return treinos;
	}

	public void setTreinos(List<Treino> treinos) {
		this.treinos = treinos;
	}
	
	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		if(dieta != null) {
			this.dieta = dieta;
		}
		else {
			throw new IllegalArgumentException("Dieta inválida!");
		}
	}

	public void adicionarTreino(Treino treino) {
		treinos.add(treino);
		
		System.out.println("Treino adicionado!\n");
	}
	
	public void removerTreino(Treino treino) {
		if(treinos.contains(treino)) {
			treinos.remove(treino);
			
			System.out.println("Treino removido com sucesso!\n");
		}
		
		System.out.println("Treino não encontrado!\n");
	}
	
	public void gerarResumo() {
		System.out.println("Nome: " + getNome() + "\nCPF: " + getCpf());
		System.out.println("Idade: " + getIdade() + "\nTempo de treino (em meses): " + getTempoTreino());
		System.out.println("Objetivo: " + getObjetivo());
	}
	
}
