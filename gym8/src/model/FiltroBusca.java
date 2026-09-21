package model;

import model.enums.Classificacao;
import model.enums.GrupoMuscular;
import model.enums.Sexo;

public class FiltroBusca {

	private double raioMaxKm = 5.0;
	private Sexo sexoDesejado = null;
	private Classificacao classificacaoDesejada = null;
	private GrupoMuscular grupoDesejado = null;
	
	public FiltroBusca() {
		
	}

	public double getRaioMaxKm() {
		return raioMaxKm;
	}

	public void setRaioMaxKm(double raioMaxKm) {
		this.raioMaxKm = raioMaxKm;
	}

	public Sexo getSexoDesejado() {
		return sexoDesejado;
	}

	public void setSexoDesejado(Sexo sexoDesejado) {
		this.sexoDesejado = sexoDesejado;
	}

	public Classificacao getClassificacaoDesejada() {
		return classificacaoDesejada;
	}

	public void setClassificacaoDesejada(Classificacao classificacaoDesejada) {
		this.classificacaoDesejada = classificacaoDesejada;
	}

	public GrupoMuscular getGrupoDesejado() {
		return grupoDesejado;
	}

	public void setGrupoDesejado(GrupoMuscular grupoDesejado) {
		this.grupoDesejado = grupoDesejado;
	}
	
}
