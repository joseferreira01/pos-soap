/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.pos.soap.repositorio;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jose
 */
@Stateless
public class Repositorio<T> implements RepositorioIf<T> {
    @PersistenceContext(unitName = "POS-SOAP_PU")
    private EntityManager em;
    @Override
    public void salvar(T t){
        em.persist(t);
    }
    @Override
    public void editar(T t){
        em.merge(t);
    }
    @Override
    public T find(Class<T> tipo,long key){
        
        return em.find(tipo, key);
    }
    @Override
    public void remove(T t){
        
        em.remove(t);
    }
    @Override
    public List<T> todos(Class<T> tipo){
      return em.createQuery("t FROM "+tipo.getSimpleName()+" t", tipo).getResultList();
    }
    
    
}
