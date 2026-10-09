package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.stream.Collectors;

import javax.swing.JOptionPane;
import model.Usuario;
import model.Treino;
import model.alimentos.Refeicao;
import model.enums.GrupoMuscular;
import model.treinamento.Convite;
import session.SessaoUsuario;
import view.AbaPerfilView;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
                view.getModeloConvites().addRow(new Object[]{
                    c.getRemetente().getNome(),
                    c.getStatus().toString()
                });
            }
        }
    }

    private void iniciarControladoresDeNavegacao() {
        view.getBtnAceitarConvite().addActionListener(e -> {
            int linha = view.getTabelaConvites().getSelectedRow();
            if(linha != -1) {
                Usuario usuario = SessaoUsuario.getUsuarioLogado();
                Convite conviteSelecionado = usuario.getConvitesRecebidos().get(linha);
                
                // Crie o método aceitar() na sua classe Convite se não existir
                // conviteSelecionado.aceitar(); 
                
                JOptionPane.showMessageDialog(view, "Convite aceito!");
                carregarDadosDoPerfil();
            }else{
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
                for(Exercicio ex : treino.getExercicios()) {
                    texto.append(" - ").append(ex.getNome())
                         .append(" (").append(ex.getRepsMinimas()).append(" a ").append(ex.getRepsMaximas()).append(" reps)\n");
                }
            }
            
            view.getDetalhesTreinoTextArea().setText(texto.toString());
            view.getDetalhesTreinoTextArea().setCaretPosition(0);
        }
    }
}