package model.alimentos;

import model.enums.TipoAlimento;

public class Alimento {

	private String nome;
	private double calorias;
	private Integer quantidade;
	private TipoAlimento tipoAlimento;
	
	public Alimento(String nome, double calorias, Integer quantidade, TipoAlimento tipoAlimento) {
		this.nome = nome;
		this.calorias = calorias;
		this.quantidade = quantidade;
		this.tipoAlimento = tipoAlimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(nome.isBlank()) {
			throw new IllegalArgumentException("Nome inválido!");
		}
		else {
			this.nome = nome;
		}
	}

	public double getCalorias() {
		return calorias;
	}

	public void setCalorias(double calorias) {
		if(calorias < 1) {
			throw new IllegalArgumentException("Valor inválido!");
		}
		else {
			this.calorias = calorias;
		}
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		if(quantidade < 1) {
			throw new IllegalArgumentException("Valor inválido!");
		}
		else {
			this.quantidade = quantidade;
		}
	}

	public TipoAlimento getTipoAlimento() {
		return tipoAlimento;
	}

	public void setTipoAlimento(TipoAlimento tipoAlimento) {
		this.tipoAlimento = tipoAlimento;
	}

	public double calcularCalorias(double calorias, Integer quantidade) {
		return calorias * quantidade;
	}
	
}
