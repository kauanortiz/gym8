package model.enums;

public enum Sexo {

	MASCULINO("Masculino"),
	FEMININO("Feminino"),
	OUTRO("Outro"),
	PREFIRO_NAO_DIZER("Prefiro não dizer");
	
	private String descricao;

	Sexo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}
}
