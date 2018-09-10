/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.repositorio;

import java.util.List;

/**
 *
 * @author jose
 */
public interface RepositorioIf<T> {

    void editar(T t);

    T find(Class<T> tipo, long key);

    void remove(T t);

    void salvar(T t);

    List<T> todos(Class<T> tipo);
    
}
