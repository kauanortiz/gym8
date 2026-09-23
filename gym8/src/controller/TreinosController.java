package controller;

import javax.swing.JOptionPane;

import model.enums.DiasDaSemana;
import model.enums.GrupoMuscular;
import repositories.UsuarioRepository;
import session.SessaoUsuario;
import view.AbaTreinosView;
import model.treinamento.Exercicio;
import model.Treino;
import model.Usuario;

public class TreinosController {

	private AbaTreinosView view;
	private UsuarioRepository repository;
	private Treino treinoAtual = new Treino();
	
	public TreinosController(AbaTreinosView view, UsuarioRepository repository) {
		this.view = view;
		this.repository = repository;
		
		iniciarControladoresDeNavegacao();
	}
	
	private void iniciarControladoresDeNavegacao() {
		view.getLimparButton().addActionListener(e -> {
			view.getNomeTreinoField().setText("");
			view.getRepsMinSpinner().setValue(1);
			view.getRepsMaxSpinner().setValue(1);
			view.getSeriesSpinner().setValue(1);
			view.getGrupoComboBox().setSelectedIndex(-1);
		});
		
		view.getAdicionarButton().addActionListener(e -> {
			cadastrar();
		});
		
		view.getSalvarTreinoButton().addActionListener(e -> {
			Usuario usrLogado = SessaoUsuario.getUsuarioLogado();
			DiasDaSemana dia = (DiasDaSemana) view.getDiaComboBox().getSelectedItem();
			
			if(usrLogado.temTreinoNoDia(dia)) {
				JOptionPane.showMessageDialog(view, "Já existe um treino para este dia!");
			    return;
			}
			this.treinoAtual.setDia(dia);
			
			usrLogado.adicionarTreino(this.treinoAtual);
			JOptionPane.showMessageDialog(view, "Treino guardado com sucesso!");
			
			this.treinoAtual = new Treino(); 

			view.getDiaComboBox().setSelectedIndex(-1);
		});
	}
	
	public void cadastrar() {
		String nome = view.getNomeTreinoField().getText();
		Integer repsMin = ((Number)view.getRepsMinSpinner().getValue()).intValue();
		Integer repsMax = ((Number)view.getRepsMaxSpinner().getValue()).intValue();
		Integer series = ((Number)view.getSeriesSpinner().getValue()).intValue();
		GrupoMuscular grupoMuscular = (GrupoMuscular)view.getGrupoComboBox().getSelectedItem();
		DiasDaSemana dia = (DiasDaSemana)view.getDiaComboBox().getSelectedItem();
		
		if(nome.isBlank()) {
			JOptionPane.showMessageDialog(
	                view,
	                "Informe o nome do exercício.",
	                "Nome inválido",
	                JOptionPane.ERROR_MESSAGE
	            );
	        return;
		}
		
		if(grupoMuscular == null) {
    		JOptionPane.showMessageDialog(view, "Por favor, selecione o grupo muscular para continuar!");
    	    return;
		}
		
		if(dia == null) {
    		JOptionPane.showMessageDialog(view, "Por favor, selecione o dia do treino para continuar!");
    	    return;
		}
		
		Exercicio exercicio = new Exercicio(nome, repsMin, repsMax, series, grupoMuscular);
		this.treinoAtual.adicionar(exercicio);
		
		view.getNomeTreinoField().setText("");
	    view.getGrupoComboBox().setSelectedIndex(-1);
	    view.getRepsMinSpinner().setValue(1);
	    view.getRepsMaxSpinner().setValue(1);
	    view.getSeriesSpinner().setValue(1);
	    
	    JOptionPane.showMessageDialog(view, "Exercício '" + nome + "' adicionado ao treino de " + dia + "!");
	}
	
}
