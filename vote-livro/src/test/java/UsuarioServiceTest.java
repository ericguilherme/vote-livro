import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.vote.livro.dao.UsuarioDao;
import br.com.vote.livro.model.Usuario;
import br.com.vote.livro.model.Votacao;
import br.com.vote.livro.service.UsuarioService;

@RunWith(MockitoJUnitRunner.class)
public class UsuarioServiceTest {

	private UsuarioService usuarioService;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Mock
	private UsuarioDao usuarioDao;
	
	@Before
	public void seUp(){
		usuarioService = new UsuarioService();
		usuarioService.setUsuarioDao(usuarioDao);
	}

	@Test
	public void deveSalvarUsuario(){
		Usuario usuario = criaUsuario(1);
		
		doReturn(usuario).when(usuarioDao).salvar(usuario);
		usuarioService.salvar(usuario);
		
		verify(usuarioDao).salvar(usuario);
		
	}
	
	@Test
	public void deveListarVotacaoDeUmDeterminadoUsuario(){
		Usuario usuario = criaUsuario(2);
		
		List<Usuario> usuarios = usuarioService.listarVotacao(usuario);
		doReturn(usuarios).when(usuarioDao).listarVotacao(usuario);
		
		verify(usuarioDao).listarVotacao(usuario);

	}
	
	@Test
	public void deveValidarLogin() throws Exception{
		Usuario usuario = criaUsuario(3);
		
		exception.expect(Exception.class);
		exception.expectMessage("Login or Password invalid, try again!");
		usuarioService.validaLogin(usuario.getEmail(), usuario.getSenha());
	}
	
	public Usuario criaUsuario(int usuarioKey){
		Usuario usuario = new Usuario();
		Votacao votacao = new Votacao(123);
		usuario.setUsuarioKey(usuarioKey);
		usuario.setNome("Eric Guilherme");
		usuario.setEmail("guilherme@gmail.com");
		usuario.setVotacaoKey(votacao);
		
		return usuario;
		
	}
}
