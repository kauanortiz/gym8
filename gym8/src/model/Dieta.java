package model;

import java.util.ArrayList;
import java.util.List;

import model.alimentos.Alimento;
import model.alimentos.Refeicao;

public class Dieta {

	private List<Refeicao> refeicoes;

	public Dieta() {
		this.refeicoes = new ArrayList<>();
	}
	
	public List<Refeicao> getRefeicoes() {
		return refeicoes;
	}

	public void setRefeicoes(List<Refeicao> refeicoes) {
		this.refeicoes = refeicoes;
	}

	public void adicionarRefeicao(Refeicao refeicao) {
		refeicoes.add(refeicao);
		
		System.out.println("Refeição adicionada com sucesso!\n");
	}
	
	public void removerRefeicao(Refeicao refeicao) {
			if(refeicoes.contains(refeicao)) {
				refeicoes.remove(refeicao);
				
				System.out.println("Refeição removida com sucesso!\n");
			}
			else {
				System.out.println("Refeição não encontrada!\n");
			}
			
	}
	
	public void alterarRefeicao(Refeicao refeicao, Alimento alimento, String nome, Integer qntd, double calorias) {
		refeicao.alterarAlimento(alimento, nome, qntd, calorias);
	}
	
	public void listarRefeicoes() {		
		int i = 1;		
		
		for(Refeicao r : refeicoes) {
			System.out.println("Refeição " + i + ":");
					
			if(r.getAlimentos() != null && !r.getAlimentos().isEmpty()) {
						r.listarAlimentos();	
			}
			else {
				System.out.println(" - Nenhum alimento cadastrado.");
			}
					
			System.out.println("Calorias totais: " + r.getCaloriasTotais());
					
			System.out.println();
			i++;
		}
	}
	
}
