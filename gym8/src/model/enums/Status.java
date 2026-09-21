package model.enums;

public enum Status {

	PENDENTE("Pendente"),
	ACEITO("Aceito"),
	RECUSADO("Recusado");
	
	private String descricao;
	
	Status(String descricao) {
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
