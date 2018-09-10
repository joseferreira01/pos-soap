/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.controle;


import br.edu.ifpb.pos.soap.WS.ClientesWS;
import br.edu.ifpb.pos.soap.WS.ServicoSimples;
import br.edu.ifpb.pos.soap.entity.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author jose
 */
@Named
@RequestScoped
public class ClienteControlador implements Serializable{

    @Inject
    private ClientesWS cs;
    private Cliente contato;
    private boolean editando = false;
    private boolean notEditando = true;
    private String encontrecontato;
    @Inject
    private Mensagem mensagem;
    private List<Cliente> allFirstLettersAsc;

    @PostConstruct
    public void init() { 
      
        this.contato = new Cliente();
    }

    public String salvar() {

        try {
            cs.salvar(contato);
            mensagem.addMessage("Contato salvo com sucesso");
            limparContato();
        } catch (Exception e) {
              mensagem.addMessage("Erro ao salvar verifique os dados e tente novamente");
        }
        return null;
    }

    public void editar(Cliente c) {
        this.contato = c;
        this.editando = true;
        this.notEditando = false;
    }

    public String cancelar() {
        this.editando = false;
        this.notEditando = true;
        limparContato();
        return null;
    }
    
    public void filtro(AjaxBehaviorEvent event){
        this.allFirstLettersAsc = allFirstLettersAsc.stream()
                .filter(c -> c.getNome()
                .toLowerCase()
                .startsWith(encontrecontato.toLowerCase()))
                .collect(Collectors.toList());
       
    }

    public void atualizar() {
        try {
             cs.atualizar(contato);
        limparContato();
              mensagem.addMessage("Contato atualizado");
        } catch (Exception e) {
              mensagem.addMessage("Erro ao atualizar tente novamente");
        }
       
    }

    public void remover(Cliente contato) {
        try {
            
             this.cs.deleta(contato);
               mensagem.addMessage("contato removido");
        } catch (Exception e) {
              mensagem.addMessage("Erro ao remover contato");
        }
       
    }

    public boolean isEditando() {
        return editando;
    }

    public Cliente getContato() {
        return contato;
    }

    public void setContato(Cliente contato) {
        this.contato = contato;
    }

   

    public String getEncontrecontato() {
        return encontrecontato;
    }

    public void setEncontrecontato(String encontrecontato) {
        this.encontrecontato = encontrecontato;
    }

    public boolean isNotEditando() {
        return notEditando;
    }

    private void limparContato() {
        this.contato = new Cliente();
    }

}
