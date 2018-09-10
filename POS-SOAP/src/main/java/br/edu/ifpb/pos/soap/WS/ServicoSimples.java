/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.WS;

import br.edu.ifpb.pos.soap.entity.Cliente;
import br.edu.ifpb.pos.soap.repositorio.RepositorioIf;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author jose
 */
@Stateless
public class ServicoSimples<T> {
    @EJB
    private RepositorioIf<T> repositorio;
    
     void editar(T t){
         this.repositorio.editar(t);
     }

    public T buscarId(Class<T> tipo, long key){
       return this.repositorio.find(tipo, key);
    }

    void remove(T t){
         this.repositorio.remove(t);
    }

    void salvar(T t){
         this.repositorio.salvar(t);
    }

    List<T> buscarTodos(Class<T> tipo){
       return this.repositorio.todos(tipo);
    }
    
}
