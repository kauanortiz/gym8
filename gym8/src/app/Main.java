package app;

import model.Exercicio;
import model.GrupoMuscular;
import model.Treino;
import model.Usuario;
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
		
		usrRepo.listarUsuarios();
		
		usrRepo.alterarCPF(usr3.getCpf(), "98765432100", usr3);
		usrRepo.alterarNome(usr1.getCpf(), usr1, "Kauanzap");
		
		usrRepo.listarUsuarios();
		
		usrRepo.consultar(usr1.getCpf(), usr1);
		
	}

}
