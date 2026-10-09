package controller;

import java.util.List;
import javax.swing.JOptionPane;

import app.GeolocalizacaoService;
import model.FiltroBusca;
import model.Usuario;
import model.enums.Classificacao;
import model.enums.Sexo;
import model.treinamento.Convite;
import repositories.UsuarioRepository;
import session.SessaoUsuario;
import view.AbaParceirosView;

public class ParceirosController {
    
    private AbaParceirosView view;
    private UsuarioRepository repository;

    public ParceirosController(AbaParceirosView view, UsuarioRepository repository) {
        this.view = view;
        this.repository = repository;
        iniciarControladoresDeNavegacao();
    }

    private void iniciarControladoresDeNavegacao() {
        view.getBuscarButton().addActionListener(e -> realizarBusca());
        view.getEnviarConviteButton().addActionListener(e -> enviarConvite());
    }

    private void realizarBusca() {
        Usuario usuarioLogado = SessaoUsuario.getUsuarioLogado();
        
        double raioMaximo = 5.0; 
        
        List<Usuario> resultados = repository.buscarParceirosProximos(usuarioLogado, raioMaximo);
        
        view.getTableModel().setRowCount(0);
        
        Classificacao filtroClassificacao = null;
        if(view.getClassificacaoCombo().getSelectedIndex() != -1) {
            filtroClassificacao = (Classificacao) view.getClassificacaoCombo().getSelectedItem();
        }
        
        Sexo filtroSexo = null;
        if(view.getSexoCombo().getSelectedIndex() != -1) {
            filtroSexo = (Sexo) view.getSexoCombo().getSelectedItem();
        }

        for(Usuario parceiro : resultados) {
            boolean match = true;
            
            if(filtroClassificacao != null && !filtroClassificacao.equals(parceiro.getClassificacao())) {
                match = false;
            }
            
            if(filtroSexo != null && !filtroSexo.equals(parceiro.getSexo())) {
                match = false;
            }

            if(match) {
                double distancia = repository.calcularDistancia(
                        usuarioLogado.getLatitude(), usuarioLogado.getLongitude(),
                        parceiro.getLatitude(), parceiro.getLongitude()
                );
                
                view.getTableModel().addRow(new Object[]{
                    parceiro.getNome(),
                    String.format("%.1f km", distancia),
                    parceiro.getClassificacao()
                });
            }
        }
    }

    private void enviarConvite() {
        int linhaSelecionada = view.getResultadosTable().getSelectedRow();
        
        if(linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(view, "Selecione um parceiro na tabela para enviar o convite!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String nomeDestinatario = (String) view.getTableModel().getValueAt(linhaSelecionada, 0);
        Usuario destinatario = repository.buscarPorNome(nomeDestinatario);
        Usuario remetente = SessaoUsuario.getUsuarioLogado();

        if(destinatario != null) {
            Convite convite = new Convite(remetente, destinatario);
            
            destinatario.receberConvite(convite);
            
            JOptionPane.showMessageDialog(view, "Convite enviado com sucesso para " + destinatario.getNome() + "!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(view, "Erro ao localizar o usuário.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}