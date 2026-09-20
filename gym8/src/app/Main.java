package app;

import java.util.List;

import model.Dieta;
import model.Treino;
import model.Usuario;
import model.alimentos.Alimento;
import model.alimentos.Carboidrato;
import model.alimentos.Proteina;
import model.alimentos.Refeicao;
import model.alimentos.Salada;
import model.enums.GrupoMuscular;
import model.enums.Sexo;
import model.treinamento.Exercicio;
import repositories.UsuarioRepository;

public class Main {

	public static void main(String[] args) {
		
		UsuarioRepository repo = new UsuarioRepository();
		
		String enderecoUsr1 = "Avenida Paulista, 1000, São Paulo";
		String enderecoUsr2 = "Avenida Paulista, 1500, São Paulo";
		String enderecoUsr3 = "Copacabana, Rio de Janeiro";
		
		System.out.println("Buscando coordenadas...");
		double[] coordUsr1 = GeolocalizacaoService.buscarCoordenadas(enderecoUsr1);
		double[] coordUsr2 = GeolocalizacaoService.buscarCoordenadas(enderecoUsr2);
		double[] coordUsr3 = GeolocalizacaoService.buscarCoordenadas(enderecoUsr3);
		
		if(coordUsr1 != null & coordUsr2 != null && coordUsr3 != null) {
			Usuario usr1 = new Usuario("Kauan", coordUsr1[0], coordUsr1[1]);
			Usuario usr2 = new Usuario("João", coordUsr2[0], coordUsr2[1]);
			Usuario usr3 = new Usuario("Pedro", coordUsr3[0], coordUsr3[1]);
			
			usr1.setCpf("11631772961");
			usr2.setCpf("11631772962");
			usr3.setCpf("11631772963");
			
			usr1.setSexo(Sexo.MASCULINO);
			usr2.setSexo(Sexo.MASCULINO);
			usr3.setSexo(Sexo.MASCULINO);
			
			repo.adicionar(usr1.getCpf(), usr1);
			repo.adicionar(usr2.getCpf(), usr2);
			repo.adicionar(usr3.getCpf(), usr3);
			
			List<Usuario> parceiros = repo.buscarPorSexo(usr1, Sexo.FEMININO);
			
			
			System.out.println("Parceiros encontrados do sexo " + usr1.getSexo() + ":");
			for(Usuario u : parceiros) {
				System.out.println("- " + u.getNome());
			}
			
			if(parceiros.isEmpty()) {
				System.out.println("Nenhum parceiro encontrado.");
			}
		}
		else {
			System.out.println("Nenhum parceiro encontrado.");
		}
	}
}
