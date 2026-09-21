package model.enums;

public enum GrupoMuscular {

	PEITO("Peito"),
	OMBRO("Ombro"),
	COSTAS("Costas"),
	BICEPS("Biceps"),
	TRICEPS("Triceps"),
	ABDOMEN("Abdomen"),
	QUADRICEPS("Quadriceps"),
	POSTERIOR("Posterior"),
	PANTURRILHA("Panturrilha");
	
	private String descricao;
	
	GrupoMuscular(String descricao) {
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
