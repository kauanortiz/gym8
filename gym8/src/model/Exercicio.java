package model;

public class Exercicio {

	private String nome;
	private Integer repsMinimas;
	private Integer repsMaximas;
	private GrupoMuscular grupoMuscular;
	
	public Exercicio(String nome, Integer repsMinimas, Integer repsMaximas, GrupoMuscular grupoMuscular) {
		this.nome = nome;
		this.repsMinimas = repsMinimas;
		this.repsMaximas = repsMaximas;
		this.grupoMuscular = grupoMuscular;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.isBlank()) {
			throw new IllegalArgumentException("Nome do exercício inválido!");
		}
		this.nome = nome;
	}

	public Integer getRepsMinimas() {
		return repsMinimas;
	}

	public void setRepsMinimas(Integer repsMinimas) {
		if(repsMinimas < 0 || repsMaximas > 20) {
			throw new IllegalArgumentException("Quantidade inválida!");
		}
		this.repsMinimas = repsMinimas;
	}

	public Integer getRepsMaximas() {
		return repsMaximas;
	}

	public void setRepsMaximas(Integer repsMaximas) {
		if(repsMaximas < 0 || repsMaximas > 20) {
			throw new IllegalArgumentException("Quantidade inválida!");
		}
		this.repsMaximas = repsMaximas;
	}

	public GrupoMuscular getGrupoMuscular() {
		return grupoMuscular;
	}

	public void setGrupoMuscular(GrupoMuscular grupoMuscular) {
		this.grupoMuscular = grupoMuscular;
	}
	
}
