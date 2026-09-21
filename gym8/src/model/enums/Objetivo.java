package model.enums;

public enum Objetivo {

	GANHO_DE_MASSA("Ganho de massa"),
	EMAGRECIMENTO("Emagrecimento"),
	MANUTENCAO("Manutenção"),
	FUNCIONAL("Funcional");

	private String descricao;
	
	Objetivo(String descricao) {
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
