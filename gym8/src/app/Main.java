package app;

import model.Usuario;
import repositories.UsuarioRepository;

public class Main {

	public static void main(String[] args) {
		
		Usuario usr1 = new Usuario("Kauan", "11631772961");
		Usuario usr2 = new Usuario("Joao", "11631772962");
		Usuario usr3 = new Usuario("Pedro", "11631772963");
		
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
