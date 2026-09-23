package model.enums;

public enum DiasDaSemana {

	DOMINGO("Domingo"),
	SEGUNDA("Segunda-feira"),
	TERCA("Terça-feira"),
	QUARTA("Quarta-feira"),
	QUINTA("Quinta-feira"),
	SEXTA("Sexta-feira"),
	SABADO("Sábado");	
	
	private String descricao;
	
	DiasDaSemana(String descricao) {
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
