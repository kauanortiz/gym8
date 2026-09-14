package model.alimentos;

import java.util.HashSet;
import java.util.Set;

public class Refeicao {

	Set<Alimento> alimentos;
	public double caloriasTotais;

	public Refeicao() {
		this.alimentos = new HashSet<>();
	}

	public Set<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(Set<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public double getCaloriasTotais() {
		return caloriasTotais;
	}

	public void adicionarAlimento(Alimento alimento) {
		alimentos.add(alimento);
		
		this.caloriasTotais += alimento.getCalorias() * alimento.getQuantidade();
		
		System.out.println("Alimento adicionado com sucesso!\n");
	}
	
	public void removerAlimento(Alimento alimento) {
		if(alimentos.contains(alimento)) {
			alimentos.remove(alimento);
			
			this.caloriasTotais -= alimento.getCalorias() * alimento.getQuantidade();
			
			System.out.println("Alimento removido com sucesso!\n");
		}
		else {
			System.out.println("Alimento não encontrado!\n");
		}
		
	}
	
	public void alterarAlimento(Alimento alimento, String nome, Integer qntd, double calorias) {
		if(alimentos.contains(alimento)) {
			alimento.setNome(nome);
			alimento.setQuantidade(qntd);
			alimento.setCalorias(calorias);
		}
		else {
			System.out.println("Alimento não encontrado!\n");
		}
	}
	
}
