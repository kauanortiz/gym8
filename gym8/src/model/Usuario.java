package model;

import java.util.ArrayList;
import java.util.List;

import model.enums.Classificacao;
import model.enums.Objetivo;
import model.enums.Sexo;
import model.treinamento.Convite;

public class Usuario {

	private String nome;
	private String cpf;
	private Integer idade;
	private Classificacao classificacao;
	private Objetivo objetivo;
	private Sexo sexo;
	private List<Treino> treinos = new ArrayList<>();
	private List<Convite> convitesRecebidos = new ArrayList<>();
	private Dieta dieta;
	private double latitude;
	private double longitude;
	private String senha;
	
	
	public Usuario(String nome, String cpf, Integer idade, Integer tempoTreino, Classificacao classificacao, Objetivo objetivo, Sexo sexo, Dieta dieta, double latitude, double longitude, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.classificacao = classificacao;
		this.objetivo = objetivo;
		this.latitude = latitude;
		this.longitude = longitude;
		this.sexo = sexo;
		this.senha = senha;
	}

	public Usuario(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
	
	//construtor para teste dos filtros de localização
	public Usuario(String nome, double latitude, double longitude) {
		this.nome = nome;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public List<Convite> getConvitesRecebidos() {
		return convitesRecebidos;
	}

	public void setConvitesRecebidos(List<Convite> convitesRecebidos) {
		this.convitesRecebidos = convitesRecebidos;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void receberConvite(Convite convite) {
		this.convitesRecebidos.add(convite);
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
		System.out.println("Idade: " + getIdade() + "\nClassificação: " + getClassificacao());
		System.out.println("Objetivo: " + getObjetivo());
	}
	
}
