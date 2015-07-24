package br.com.vote.livro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vote.livro.dao.UsuarioDao;
import br.com.vote.livro.model.Usuario;

@Service
public class UsuarioService {

	@Autowired
	UsuarioDao usuarioDao;
	
	public Usuario salvar(String nome, String email) {
		return usuarioDao.salvar(nome, email); 
	}

}
