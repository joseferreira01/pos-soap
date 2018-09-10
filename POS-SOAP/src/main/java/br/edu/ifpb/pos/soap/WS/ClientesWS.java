/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.WS;

import br.edu.ifpb.pos.soap.entity.Cliente;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @author jose
 */
@WebService
@Stateless
public class ClientesWS {

    @EJB
    private ServicoSimples<Cliente> servico;

    /**
     * Operação de Web service
     */
    public void salvar(Cliente livro) {
        this.servico.salvar(livro);
    }

    public void atualizar(Cliente livro) {
        this.servico.editar(livro);
    }

    public void deleta(Cliente livro) {
        this.servico.remove(livro);
    }

    @WebResult(name = "livros")
    public Cliente[] todos() {
        return this.servico
                .buscarTodos(Cliente.class)
                .toArray(new Cliente[]{}
                );
    }
    @WebResult(name = "livro")
    public Cliente buscaId( 
            @WebParam(name = "id") long id) {
        return this.servico.buscarId(Cliente.class,id);
      
                      
                
    }

}
