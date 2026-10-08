package controller;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import model.Dieta;
import model.Usuario;
import model.alimentos.Alimento;
import model.alimentos.Refeicao;
import model.enums.TipoAlimento;
import repositories.UsuarioRepository;
import session.SessaoUsuario;
import view.AbaDietaView;

public class DietasController {

	private AbaDietaView view;
	private UsuarioRepository repository;
	private Refeicao refeicaoAtual = new Refeicao();
	private Dieta dieta = new Dieta();
	
	public DietasController(AbaDietaView view, UsuarioRepository repository) {
		this.view = view;
		this.repository = repository;
		
		iniciarControladoresDeNavegacao();
	} 
	
	private void iniciarControladoresDeNavegacao() {
		view.getLimparCamposButton().addActionListener(e -> {
			limparCampos();
		});
		
		view.getSalvarRefeicaoButton().addActionListener(e -> {
			cadastrar();
			limparCampos();
		});
		
		view.getCadastrarDietaButton().addActionListener(e -> {
			Usuario usrLogado = SessaoUsuario.getUsuarioLogado();
			
			if(usrLogado.getDieta() == null) {
				usrLogado.setDieta(dieta);
				JOptionPane.showMessageDialog(view, "Dieta salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			}
			else{
				JOptionPane.showMessageDialog(view, "O usuário já tem uma dieta cadastrada!", "Erro", JOptionPane.ERROR_MESSAGE);
			}
			
		});
		
		view.getLimparCamposButton().addActionListener(e -> {
			
		});
	}
	
	public void cadastrar() {
		refeicaoAtual = new Refeicao();
		
		//obrigatório
		if(!validarEAdicionar(view.getAlimentoField(), view.getQuantidadeSpinner(), view.getCaloriasField(), view.getTipo1ComboBox(), true, "Alimento 1")) return;
		
		//opcionais
		if(!validarEAdicionar(view.getAlimento2Field(), view.getQuantidade2Spinner(), view.getCalorias2Field(), view.getTipo2ComboBox(), false, "Alimento 2")) return;
		if(!validarEAdicionar(view.getAlimento3Field(), view.getQuantidade3Spinner(), view.getCalorias3Field(), view.getTipo3ComboBox(), false, "Alimento 3")) return;
		if(!validarEAdicionar(view.getAlimento4Field(), view.getQuantidade4Spinner(), view.getCalorias4Field(), view.getTipo4ComboBox(), false, "Alimento 4")) return;
		
		JOptionPane.showMessageDialog(view, "Refeição salva com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		
		this.dieta.adicionarRefeicao(refeicaoAtual);
	}
	
	private boolean validarEAdicionar(JTextField nomeField, JSpinner qtdSpinner, JTextField calField, JComboBox tipoCombo, boolean obrigatorio, String rotulo) {
		String nome = nomeField.getText().trim();
		String caloriasStr = calField.getText().trim();
		int quantidade = ((Number) qtdSpinner.getValue()).intValue();
		TipoAlimento tipo = (TipoAlimento) tipoCombo.getSelectedItem();
		
		boolean linhaVazia = nome.isEmpty() && caloriasStr.isEmpty() && tipo == null;
		
		if(linhaVazia) {
			if(obrigatorio) {
				JOptionPane.showMessageDialog(view, "O " + rotulo + " é obrigatório!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
			return true;
		}
		
		if(nome.isEmpty() || caloriasStr.isEmpty() || tipo == null) {
			JOptionPane.showMessageDialog(view, "Preencha todos os dados do " + rotulo + "!", "Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if(quantidade <= 0) {
			JOptionPane.showMessageDialog(view, "Quantidade inválida no " + rotulo + "!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		double calorias;
		try{
			calorias = Double.parseDouble(caloriasStr.replace(",", "."));
			
			if(calorias < 0) {
				JOptionPane.showMessageDialog(view, "As calorias do " + rotulo + " não podem ser negativas!", "Erro", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		}catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(view, "Digite um valor numérico válido para as calorias do " + rotulo + "!", "Erro", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		
		Alimento alimento = new Alimento(nome, calorias, quantidade, tipo);
		refeicaoAtual.adicionarAlimento(alimento);
		
		return true;
	}
	
	public void limparCampos() {
		view.getAlimentoField().setText("");
		view.getAlimento2Field().setText("");
		view.getAlimento3Field().setText("");
		view.getAlimento4Field().setText("");
		view.getCaloriasField().setText("");
		view.getCalorias2Field().setText("");
		view.getCalorias3Field().setText("");
		view.getCalorias4Field().setText("");
		view.getQuantidadeSpinner().setValue(1);
		view.getQuantidade2Spinner().setValue(1);
		view.getQuantidade3Spinner().setValue(1);
		view.getQuantidade4Spinner().setValue(1);
		view.getTipo1ComboBox().setSelectedIndex(-1);
		view.getTipo2ComboBox().setSelectedIndex(-1);
		view.getTipo3ComboBox().setSelectedIndex(-1);
		view.getTipo4ComboBox().setSelectedIndex(-1);
	}
}
