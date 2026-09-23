package controller;

import view.GestorDeTelas;
import repositories.UsuarioRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import app.GeolocalizacaoService;
import model.Usuario;
import model.enums.Classificacao;
import model.enums.Objetivo;
import model.enums.Sexo;

public class GestorController {
    
    private GestorDeTelas view;
    private UsuarioRepository repository;

    public GestorController(GestorDeTelas view, UsuarioRepository repository) {
        this.view = view;
        this.repository = repository;
        
        iniciarControladoresDeNavegacao();
    }

    private void iniciarControladoresDeNavegacao() {
    	view.getTelaLogin().getCadastrarButton().addActionListener(e -> {
    		view.mostrarEcra("PASSO_1");
    	});
    	
    	view.getTelaLogin().getEntrarButton().addActionListener(e -> {
    		String cpf = view.getTelaLogin().getCpfField().getText();
    		String senha = new String(view.getTelaLogin().getSenhaField().getPassword());
    		int index = 0;
    		
    		for(Usuario u : repository.getUsuarios().values()) {
    			if(u.getCpf().equals(cpf)){
    				index = 1;
    				
    				if(senha == u.getSenha()) {
    					JOptionPane.showMessageDialog(
    	    	                view,"Acesso liberado!");
    					view.mostrarEcra("LOBBY");
    				}
    				else {
    					JOptionPane.showMessageDialog(
    	    	                view,"Senha incorreta!");
    					return;
    				}
    			}
    		}
    		
    		if(index == 0) {
    			JOptionPane.showMessageDialog(
    	                view,"CPF não cadastrado!");
    		}
    		
    	});
    	
    	view.getTela1().getProximoButton().addActionListener(e -> {
    	    
    	    String nome = view.getTela1().getNomeField().getText();
    	    String cpf = view.getTela1().getCpfField().getText();
    	    String senha = new String(view.getTela1().getSenhaField().getPassword());
    	    
        	if(nome.isBlank()){
    	        JOptionPane.showMessageDialog(
    	                view,
    	                "Informe o nome do usuário.",
    	                "Nome inválido",
    	                JOptionPane.ERROR_MESSAGE
    	            );
    	        return;
        	}
        	
        	if(cpf.matches(".*[a-zA-Z].*")){
        	    JOptionPane.showMessageDialog(view, "Erro: O CPF não pode conter letras!");
        	    return;
        	}
        	
        	if(cpf.length() != 11) {
        		JOptionPane.showMessageDialog(view, "Erro: CPF inválido!");
        	    return;
        	}
        	
        	for(Usuario u: repository.getUsuarios().values()) {
        		if(u.getCpf().equals(cpf)) {
        			JOptionPane.showMessageDialog(
        	                view,"CPF já cadastrado!");
        			return;
        		}
        	}
    	    
    	    if(senha.length() <= 8){
        	    JOptionPane.showMessageDialog(view, "A senha deve ter mais de 8 caracteres!");
        	    return;
        	}
    	    
        	if(!senha.matches(".*[a-z].*")){
        	    JOptionPane.showMessageDialog(view, "A senha deve conter pelo menos uma letra minúscula!");
        	    return;
        	}

        	if(!senha.matches(".*[A-Z].*")){
        	    JOptionPane.showMessageDialog(view, "A senha deve conter pelo menos uma letra maiúscula!");
        	    return;
        	}

        	if(!senha.matches(".*[0-9].*")){
        	    JOptionPane.showMessageDialog(view, "A senha deve conter pelo menos um número!");
        	    return;
        	}
        	
    	    view.mostrarEcra("PASSO_2");
    	});

        view.getTela2().getVoltarButton().addActionListener(e -> view.mostrarEcra("PASSO_1"));
        
        view.getTela2().getProximoButton().addActionListener(e ->{ 
        	
        	Integer idade;
        	String dataTexto = view.getTela2().getDataNascimentoField().getText();
        	Sexo sexo = (Sexo) view.getTela2().getSexoComboBox().getSelectedItem();
        	Objetivo objetivo = (Objetivo) view.getTela2().getObjetivoComboBox().getSelectedItem();
        	Classificacao classificacao = (Classificacao) view.getTela2().getClassificacaoComboBox().getSelectedItem();
        	
        	String dataLimpa = dataTexto.replace("/", "").replace("_", "").trim();
        	
        	if(dataLimpa.isEmpty()){
        	    JOptionPane.showMessageDialog(view, "Por favor, preencha a data de nascimento.");
        	    return;
        	}
        	
        	try{
        	    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        	    
        	    LocalDate dataNascimento = LocalDate.parse(dataTexto, formatador);
        	    LocalDate hoje = LocalDate.now();
        	    
        	    idade = Period.between(dataNascimento, hoje).getYears();
        	    
        	    if(idade < 18){
        	        JOptionPane.showMessageDialog(view, "O cadastro só é permitido para maiores de 18 anos. (Idade calculada: " + idade + " anos)");
        	        return;
        	    }

        	}catch(DateTimeParseException f){
        	    //captura o erro caso o utilizador digite algo como "99/99/9999"
        	    JOptionPane.showMessageDialog(view, "Data inválida! Digite uma data de nascimento real.");
        	    return;
        	}
        	
        	if(sexo == null) {
        		JOptionPane.showMessageDialog(view, "Por favor, selecione o sexo para continuar!");
        	    return;
        	}
        	
        	if(objetivo == null) {
        		JOptionPane.showMessageDialog(view, "Por favor, selecione um objetivo para continuar!");
        	    return;
        	}
        	
        	if(classificacao == null) {
        		JOptionPane.showMessageDialog(view, "Por favor, selecione um nível para continuar!");
        	    return;
        	}
        	
        	view.mostrarEcra("PASSO_3");
        	});

        view.getTela3().getVoltarButton().addActionListener(e -> view.mostrarEcra("PASSO_2"));
        
        view.getTela3().getFinalizarButton().addActionListener(e -> {       	
        	String rua = view.getTela3().getRuaField().getText();
        	Integer numero = ((Number)view.getTela3().getNumeroSpinner().getValue()).intValue();
        	String cidade = view.getTela3().getCidadeField().getText();
        	
        	if(rua.isBlank()){
    	        JOptionPane.showMessageDialog(
    	                view,
    	                "Informe o nome da rua.",
    	                "Rua inválida",
    	                JOptionPane.ERROR_MESSAGE
    	            );
    	        return;
        	}
        	
        	if(numero < 1){
    	        JOptionPane.showMessageDialog(
    	                view,
    	                "Informe o número da casa",
    	                "Número inválido",
    	                JOptionPane.ERROR_MESSAGE
    	            );
    	        return;
        	}
        	
        	if(cidade.isBlank()){
    	        JOptionPane.showMessageDialog(
    	                view,
    	                "Informe o nome da cidade.",
    	                "Cidade inválida",
    	                JOptionPane.ERROR_MESSAGE
    	            );
    	        return;
        	}
        	
        	cadastrar();       	
            finalizarCadastro();
        });
        
        view.getTelaLobby().getBtnLogout().addActionListener(e ->{
        	view.getTela1().getCpfField().setText("");
        	view.getTela1().getSenhaField().setText("");
        	view.mostrarEcra("LOGIN");
        });
    }

    private void finalizarCadastro() {
        
        JOptionPane.showMessageDialog(view, "Utilizador registrado com sucesso no Repositório!");
        view.mostrarEcra("LOBBY");
    }
    
    public void cadastrar() {
    	String nome = view.getTela1().getNomeField().getText();
    	String cpf = view.getTela1().getCpfField().getText();
    	String senha = new String(view.getTela1().getSenhaField().getPassword());
    	
    	Integer idade;
    	String dataTexto = view.getTela2().getDataNascimentoField().getText();
    	Sexo sexo = (Sexo) view.getTela2().getSexoComboBox().getSelectedItem();
    	Objetivo objetivo = (Objetivo) view.getTela2().getObjetivoComboBox().getSelectedItem();
    	Classificacao classificacao = (Classificacao) view.getTela2().getClassificacaoComboBox().getSelectedItem();
    	
    	String rua = view.getTela3().getRuaField().getText();
    	Integer numero = ((Number)view.getTela3().getNumeroSpinner().getValue()).intValue();
    	String cidade = view.getTela3().getCidadeField().getText();
    	String enderecoFormatado;
    	
    	if(nome.isBlank()){
	        JOptionPane.showMessageDialog(
	                view,
	                "Informe o nome do usuário.",
	                "Nome inválido",
	                JOptionPane.ERROR_MESSAGE
	            );
	        return;
    	}
    	
    	if(cpf.matches(".*[a-zA-Z].*")){
    	    JOptionPane.showMessageDialog(view, "Erro: O CPF não pode conter letras!");
    	    return;
    	}
    	
    	if(cpf.length() != 11) {
    		JOptionPane.showMessageDialog(view, "Erro: CPF inválido!");
    	    return;
    	}
    	
    	for(Usuario u: repository.getUsuarios().values()) {
    		if(u.getCpf().equals(cpf)) {
    			JOptionPane.showMessageDialog(
    	                view,"CPF já cadastrado!");
    			return;
    		}
    	}
    	
    	if(senha.length() <= 8){
    	    JOptionPane.showMessageDialog(view, "A senha deve ter mais de 8 caracteres!");
    	    return;
    	}
    	
    	if(!senha.matches(".*[a-z].*")){
    	    JOptionPane.showMessageDialog(view, "A senha deve conter pelo menos uma letra minúscula!");
    	    return;
    	}

    	if(!senha.matches(".*[A-Z].*")){
    	    JOptionPane.showMessageDialog(view, "A senha deve conter pelo menos uma letra maiúscula!");
    	    return;
    	}

    	if(!senha.matches(".*[0-9].*")){
    	    JOptionPane.showMessageDialog(view, "A senha deve conter pelo menos um número!");
    	    return;
    	}
    	
    	//verificação de idade começa aqui
    	String dataLimpa = dataTexto.replace("/", "").replace("_", "").trim();
    	
    	if(dataLimpa.isEmpty()){
    	    JOptionPane.showMessageDialog(view, "Por favor, preencha a data de nascimento.");
    	    return;
    	}
    	
    	try{
    	    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	    
    	    LocalDate dataNascimento = LocalDate.parse(dataTexto, formatador);
    	    LocalDate hoje = LocalDate.now();
    	    
    	    idade = Period.between(dataNascimento, hoje).getYears();
    	    
    	    if(idade < 18){
    	        JOptionPane.showMessageDialog(view, "O cadastro só é permitido para maiores de 18 anos. (Idade calculada: " + idade + " anos)");
    	        return;
    	    }

    	}catch(DateTimeParseException e){
    	    //captura o erro caso o utilizador digite algo como "99/99/9999"
    	    JOptionPane.showMessageDialog(view, "Data inválida! Digite uma data de nascimento real.");
    	    return;
    	}
    	
    	if(sexo == null) {
    		JOptionPane.showMessageDialog(view, "Por favor, selecione o sexo para continuar!");
    	    return;
    	}
    	
    	if(objetivo == null) {
    		JOptionPane.showMessageDialog(view, "Por favor, selecione um objetivo para continuar!");
    	    return;
    	}
    	
    	if(classificacao == null) {
    		JOptionPane.showMessageDialog(view, "Por favor, selecione um nível para continuar!");
    	    return;
    	}
    	
    	if(rua.isBlank()){
	        JOptionPane.showMessageDialog(
	                view,
	                "Informe o nome da rua.",
	                "Rua inválida",
	                JOptionPane.ERROR_MESSAGE
	            );
	        return;
    	}
    	
    	if(numero < 1){
	        JOptionPane.showMessageDialog(
	                view,
	                "Informe o número da casa",
	                "Número inválido",
	                JOptionPane.ERROR_MESSAGE
	            );
	        return;
    	}
    	
    	if(cidade.isBlank()){
	        JOptionPane.showMessageDialog(
	                view,
	                "Informe o nome da cidade.",
	                "Cidade inválida",
	                JOptionPane.ERROR_MESSAGE
	            );
	        return;
    	}
    	
    	enderecoFormatado = rua + ", " +  numero + ", " + cidade;

    	double[] coordenadas = GeolocalizacaoService.buscarCoordenadas(enderecoFormatado);
    	
    	Usuario novoUsuario = new Usuario(nome, cpf, idade, classificacao, objetivo, sexo, coordenadas[0], coordenadas[1], senha);
    	repository.adicionar(cpf, novoUsuario);
    	
    }
}