package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import model.Usuario;
import model.Treino;
import model.alimentos.Alimento;
import model.alimentos.Refeicao;
import model.enums.GrupoMuscular;
import model.enums.Status;
import model.treinamento.Convite;
import session.SessaoUsuario;
import view.AbaDietaView;
import view.AbaPerfilView;
import view.AlterarRefeicaoDialog;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.treinamento.Exercicio;
import view.AlterarTreinoDialog;

public class PerfilController {

    private AbaPerfilView view;

    public PerfilController(AbaPerfilView view) {
        this.view = view;
        carregarDadosDoPerfil();
        iniciarControladoresDeNavegacao();
    }

    public void carregarDadosDoPerfil() {
        Usuario usuarioLogado = SessaoUsuario.getUsuarioLogado();

        if(usuarioLogado == null) return;

        view.getLblNomeValor().setText(usuarioLogado.getNome());
        view.getLblIdadeValor().setText(String.valueOf(usuarioLogado.getIdade()));

        view.getModeloTreinos().setRowCount(0);
        if(usuarioLogado.getTreinos() != null) {
            for(Treino t : usuarioLogado.getTreinos()) {
            	String gruposFormatados = t.getGruposMusculares().stream().map(GrupoMuscular::toString).collect(Collectors.joining(", "));
            	
                view.getModeloTreinos().addRow(new Object[]{
                	gruposFormatados,
                	t.getDia(),
                    t.getExercicios().size() + " exercícios"
                });
            }
        }

        view.getModeloDietas().setRowCount(0);
        if(usuarioLogado.getDieta() != null) {
            int cont = 1;
            for(Refeicao r : usuarioLogado.getDieta().getRefeicoes()) {
                view.getModeloDietas().addRow(new Object[]{
                    "Refeição " + cont,
                    r.getAlimentos().size() + " alimentos"
                });
                cont++;
            }
        }

        view.getModeloConvites().setRowCount(0);
        if(usuarioLogado.getConvitesRecebidos() != null) {
            for(Convite c : usuarioLogado.getConvitesRecebidos()) {
            	String textoStatus = (c.getStatus() != null) ? c.getStatus().getDescricao() : "PENDENTE";
            	
                view.getModeloConvites().addRow(new Object[]{
                    c.getRemetente().getNome(),
                    textoStatus
                });
            }
        }
    }

    private void iniciarControladoresDeNavegacao() {
    	view.getTabelaConvites().getSelectionModel().addListSelectionListener(e -> {
    	    if (!e.getValueIsAdjusting()) {
    	        mostrarDetalhesDoRemetente();
    	    }
    	});

    	view.getBtnAceitarConvite().addActionListener(e -> {
    	    int linha = view.getTabelaConvites().getSelectedRow();
    	    if(linha != -1) {
    	        Usuario usuario = SessaoUsuario.getUsuarioLogado();
    	        Convite convite = usuario.getConvitesRecebidos().get(linha);
    	        
    	        convite.setStatus(Status.ACEITO);
    	        
    	        JOptionPane.showMessageDialog(view, "Convite aceito!");
    	        carregarDadosDoPerfil();
    	        view.getModeloDetalhesRemetente().setRowCount(0);
    	    }else {
    	        JOptionPane.showMessageDialog(view, "Selecione um convite primeiro.");
    	    }
    	});

    	view.getBtnRecusarConvite().addActionListener(e -> {
    	    int linha = view.getTabelaConvites().getSelectedRow();
    	    if(linha != -1) {
    	        Usuario usuario = SessaoUsuario.getUsuarioLogado();
    	        usuario.getConvitesRecebidos().remove(linha);
    	        
    	        JOptionPane.showMessageDialog(view, "Convite recusado.");
    	        carregarDadosDoPerfil();
    	        view.getModeloDetalhesRemetente().setRowCount(0);
    	    }else {
    	        JOptionPane.showMessageDialog(view, "Selecione um convite primeiro.");
    	    }
    	});
    	
        view.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                carregarDadosDoPerfil();
            }
        });
        
        view.getTabelaTreinos().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    mostrarDetalhesDoTreino();
                }
            }
        });

        view.getBtnRemoverTreino().addActionListener(e -> {
            int linha = view.getTabelaTreinos().getSelectedRow();
            
            if(linha != -1) {
                int confirm = JOptionPane.showConfirmDialog(view, "Deseja realmente excluir este treino?", "Excluir Treino", JOptionPane.YES_NO_OPTION);
                
                if(confirm == JOptionPane.YES_OPTION) {
                    Usuario usuarioLogado = SessaoUsuario.getUsuarioLogado();
                    usuarioLogado.getTreinos().remove(linha);
                    
                    JOptionPane.showMessageDialog(view, "Treino removido com sucesso!");
                    carregarDadosDoPerfil();
                    view.getDetalhesTreinoTextArea().setText("");
                }
            }else{
                JOptionPane.showMessageDialog(view, "Selecione um treino na tabela para remover.");
            }
        });

        view.getBtnAlterarTreino().addActionListener(e -> {
            int linhaSelecionada = view.getTabelaTreinos().getSelectedRow();
            
            if(linhaSelecionada != -1) {
                Usuario usuario = SessaoUsuario.getUsuarioLogado();
                Treino treinoSelecionado = usuario.getTreinos().get(linhaSelecionada);
                
                AlterarTreinoDialog popupDialog = new AlterarTreinoDialog(treinoSelecionado);
                popupDialog.setVisible(true);
                
                if(popupDialog.isDadosForamSalvos()) {
                    JOptionPane.showMessageDialog(view, "Treino atualizado com sucesso!");
                    
                    carregarDadosDoPerfil();
                    mostrarDetalhesDoTreino(); 
                }
                
            }else{
                JOptionPane.showMessageDialog(view, "Selecione um treino na tabela para alterar.", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        view.getTabelaDietas().getSelectionModel().addListSelectionListener(e -> {
            if(!e.getValueIsAdjusting()) {
                int linha = view.getTabelaDietas().getSelectedRow();
                if(linha != -1) {
                    Usuario usuario = SessaoUsuario.getUsuarioLogado();
                    Refeicao refeicao = usuario.getDieta().getRefeicoes().get(linha);
                    
                    StringBuilder texto = new StringBuilder();
                    texto.append("Refeição ").append(linha + 1).append("\n");
                    texto.append("----------------------------\n");
                    
                    for(Alimento al : refeicao.getAlimentos()) {
                        texto.append(" - ").append(al.getNome()).append("\n");
                    }
                    view.getDetalhesDietaTextArea().setText(texto.toString());
                }
            }
        });

        view.getBtnRemoverDieta().addActionListener(e -> {
            int linha = view.getTabelaDietas().getSelectedRow();
            if(linha != -1) {
                int confirm = JOptionPane.showConfirmDialog(view, "Deseja excluir esta refeição?", "Excluir", JOptionPane.YES_NO_OPTION);
                if(confirm == JOptionPane.YES_OPTION) {
                    Usuario usuarioLogado = SessaoUsuario.getUsuarioLogado();
                    usuarioLogado.getDieta().getRefeicoes().remove(linha);
                    JOptionPane.showMessageDialog(view, "Refeição removida!");
                    carregarDadosDoPerfil();
                    view.getDetalhesDietaTextArea().setText("");
                }
            }
        });

        view.getBtnAlterarDieta().addActionListener(e -> {
            int linha = view.getTabelaDietas().getSelectedRow();
            if(linha != -1) {
                Usuario usuario = SessaoUsuario.getUsuarioLogado();
                Refeicao refeicaoSelecionada = usuario.getDieta().getRefeicoes().get(linha);
                
                AlterarRefeicaoDialog popup = new AlterarRefeicaoDialog(refeicaoSelecionada);
                popup.setVisible(true);
                
                if(popup.isSalvo()) {
                    carregarDadosDoPerfil();
                }
            }
        });
    }
    
    private void mostrarDetalhesDoTreino() {
        int linhaSelecionada = view.getTabelaTreinos().getSelectedRow();
        
        if(linhaSelecionada != -1) {
            Usuario usuario = SessaoUsuario.getUsuarioLogado();
            
            Treino treino = usuario.getTreinos().get(linhaSelecionada);
            
            StringBuilder texto = new StringBuilder();
            texto.append("----------------------------\n");
            texto.append("EXERCÍCIOS:\n");
            
            if(treino.getExercicios() != null) {
                for(Exercicio e : treino.getExercicios()) {
                    texto.append(" - ").append(e.getNome())
                         .append(" (").append(e.getRepsMinimas()).append(" a ").append(e.getRepsMaximas()).append(" reps)\n");
                }
            }
            
            view.getDetalhesTreinoTextArea().setText(texto.toString());
            view.getDetalhesTreinoTextArea().setCaretPosition(0);
        }
    }
    
    private void mostrarDetalhesDoRemetente() {
        int linhaSelecionada = view.getTabelaConvites().getSelectedRow();
        
        DefaultTableModel modeloDetalhes = view.getModeloDetalhesRemetente();
        modeloDetalhes.setRowCount(0);
        
        if (linhaSelecionada != -1) {
            Usuario usuarioLogado = SessaoUsuario.getUsuarioLogado();
            
            Convite convite = usuarioLogado.getConvitesRecebidos().get(linhaSelecionada);
            Usuario remetente = convite.getRemetente();
            
            modeloDetalhes.addRow(new Object[]{"Nome", remetente.getNome()});
            modeloDetalhes.addRow(new Object[]{"Idade", remetente.getIdade() + " anos"});
            
            if(remetente.getSexo() != null) {
                modeloDetalhes.addRow(new Object[]{"Sexo", remetente.getSexo().toString()});
            }
            if(remetente.getClassificacao() != null) {
                modeloDetalhes.addRow(new Object[]{"Classificação", remetente.getClassificacao().toString()});
            }

        }
    }
}