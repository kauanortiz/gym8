package app;

import model.Usuario;

public class Sessao {

	private static Usuario usuarioLogado;
	
	public static void setUsuarioLogado(Usuario usuario) {
		usuarioLogado = usuario;
	}
	
	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	
	public static void encerrarSessao() {
		usuarioLogado = null;
	}
	
	public static boolean isLogado() {
		return usuarioLogado != null;
	}
	
}
