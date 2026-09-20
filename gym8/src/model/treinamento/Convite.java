package model.treinamento;

import java.time.LocalDateTime;

import model.Usuario;
import model.enums.Status;

public class Convite {

	private Usuario remetente;
	private Usuario destinatario;
	private LocalDateTime dataHorario;
	private Status status;
	
	public Convite(Usuario remetente, Usuario destinatario, LocalDateTime dataHorario) {
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.dataHorario = dataHorario;
		this.status = Status.PENDENTE;
	}

	public Usuario getRemetente() {
		return remetente;
	}

	public void setRemetente(Usuario remetente) {
		this.remetente = remetente;
	}

	public Usuario getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(Usuario destinatario) {
		this.destinatario = destinatario;
	}

	public LocalDateTime getDataHorario() {
		return dataHorario;
	}

	public void setDataHorario(LocalDateTime dataHorario) {
		this.dataHorario = dataHorario;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public void gerarResumo() {
		System.out.println("Convite de: " + remetente.getNome() +
				" | Data: " + dataHorario.toString() + 
				" | Status: " + status);
	}
}
