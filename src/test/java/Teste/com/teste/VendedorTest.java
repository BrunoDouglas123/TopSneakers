package Teste.com.teste;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import Teste.com.teste.Model.Vendedor;
import Teste.com.teste.Repository.VendedorRepository;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class VendedorTest {

	@Autowired
	private VendedorRepository usuarioRepository;
	
	@Test
	public void SearchUser () {
		Vendedor usuario1 = new Vendedor
		(1L, "Bruno", null );
		Vendedor usuario2 = new Vendedor
		(1L, "Karol", null);
		List<Vendedor> usuarios = new ArrayList<>();
		usuarios.add(usuario1);
		usuarios.add(usuario2);
	}
	
	@Test
	public void CreateUser () {
		Vendedor usuario = new Vendedor
		(1L, "Bruno", null);
		usuarioRepository.save(usuario);
		assertNotNull(usuario);
	}
	
	@Test
	public void DeleteUser () {
		Vendedor usuario = new Vendedor
		(1L, "Bruno", null);
		usuarioRepository.save(usuario);
		Long id = usuario.getId();
		boolean presente1 = usuarioRepository
		.findById(id).isPresent();
		usuarioRepository.deleteById(id);
		boolean presente2 = usuarioRepository
		.findById(id).isPresent();
		assertTrue(presente1);
		assertFalse(presente2);
	}
	
	@Test
	public void UpdateUser () {
		String nome = "Karol";
		Vendedor Vendedor = new Vendedor
		(1L, "Bruno", null);
		usuarioRepository.save(Vendedor);
		Vendedor user = usuarioRepository
		.findById(1L).get();
		user.setNome(nome);
		Vendedor use = usuarioRepository
		.save(user);
		assertEquals(use.getNome(),nome);
	}
	
}
