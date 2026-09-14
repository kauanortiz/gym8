package app;

import model.Dieta;
import model.Treino;
import model.Usuario;
import model.alimentos.Alimento;
import model.alimentos.Carboidrato;
import model.alimentos.Proteina;
import model.alimentos.Refeicao;
import model.alimentos.Salada;
import model.enums.GrupoMuscular;
import model.treinamento.Exercicio;
import repositories.UsuarioRepository;

public class Main {

	public static void main(String[] args) {
		
		Usuario usr1 = new Usuario("Kauan", "11631772961");
		Usuario usr2 = new Usuario("Joao", "11631772962");
		Usuario usr3 = new Usuario("Pedro", "11631772963");
		
		Treino t1 = new Treino();
		t1.setDuracao(90);
		t1.adicionarGrupoMuscular(GrupoMuscular.COSTAS);
		t1.adicionarGrupoMuscular(GrupoMuscular.BICEPS);
		
		Exercicio e1 = new Exercicio("Remada cavalo", 8, 12, GrupoMuscular.COSTAS);
		Exercicio e2 = new Exercicio("Pulley frente", 8, 12, GrupoMuscular.COSTAS);
		Exercicio e3 = new Exercicio("Puxada fechada", 8, 12, GrupoMuscular.COSTAS);
		Exercicio e4 = new Exercicio("Remada upper back", 8, 12, GrupoMuscular.COSTAS);
		Exercicio e5 = new Exercicio("Barra fixa", 8, 12, GrupoMuscular.COSTAS);
		Exercicio e6 = new Exercicio("Rosca direta", 8, 12, GrupoMuscular.BICEPS);
		Exercicio e7 = new Exercicio("Rosca martelo", 8, 12, GrupoMuscular.BICEPS);
		
		t1.adicionar(e1);
		t1.adicionar(e2);
		t1.adicionar(e3);
		t1.adicionar(e4);
		t1.adicionar(e5);
		t1.adicionar(e6);
		t1.adicionar(e7);
		
		usr1.adicionarTreino(t1);
		
		UsuarioRepository usrRepo = new UsuarioRepository();
		
		usrRepo.adicionar(usr1.getCpf(), usr1);
		usrRepo.adicionar(usr2.getCpf(), usr2);
		usrRepo.adicionar(usr3.getCpf(), usr3);

		Alimento a1 = new Carboidrato("Arroz", 1.3, 150);
		Alimento a2 = new Proteina("Carne", 1.8, 150);
		Alimento a3 = new Salada("Alface", 0.15, 150);
		
		Refeicao r1 = new Refeicao();
		r1.adicionarAlimento(a1);
		r1.adicionarAlimento(a2);
		r1.adicionarAlimento(a3);
		
		Alimento a4 = new Carboidrato("Arroz", 1.3, 100);
		Alimento a5 = new Proteina("Carne", 1.8, 200);
		Alimento a6 = new Salada("Alface", 0.15, 100);
		
		Refeicao r2 = new Refeicao();
		r2.adicionarAlimento(a4);
		r2.adicionarAlimento(a5);
		r2.adicionarAlimento(a6);
		
		Dieta d1 = new Dieta();
		d1.adicionarRefeicao(r1);
		d1.adicionarRefeicao(r2);
		
		usr1.setDieta(d1);
		
		usrRepo.consultar(usr1.getCpf(), usr1);
		
	}

}
