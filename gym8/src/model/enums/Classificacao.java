package model.enums;

public enum Classificacao {

	INICIANTE("Iniciante"),
	INTERMEDIARIO("Intermediário"),
	AVANCADO("Avançado");
	
	
	private String descricao;
	
	Classificacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString(){
		return this.descricao;
	}
}
