package br.com.vote.livro.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import br.com.vote.livro.model.Livro;

@Repository
public class LivroDao {
	
	private EntityManager manager;

	public void salvar(Livro livro) {
		manager.persist(livro);
	}
	
	public void adiciona(Livro livro) {
		
	}
	
	

}