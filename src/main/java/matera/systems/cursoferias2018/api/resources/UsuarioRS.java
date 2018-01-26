package matera.systems.cursoferias2018.api.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import matera.systems.cursoferias2018.api.domain.request.AtualizarUsuarioRequest;
import matera.systems.cursoferias2018.api.domain.request.CriarUsuarioRequest;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;
import matera.systems.cursoferias2018.api.services.UsuarioService;

@RestController
public class UsuarioRS {

	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping(consumes = "application/json",
					path = "/usuarios")
	public ResponseEntity<Void> criaUsuario(@RequestBody CriarUsuarioRequest request) throws URISyntaxException {
		UUID novoUsuarioId;
		
		try {
			novoUsuarioId = usuarioService.criaUsuario(request);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.created(new URI("/usuarios/" + novoUsuarioId.toString())).build();
	}
	
	@GetMapping(path = "/usuarios/{id}")
	public ResponseEntity<UsuarioResponse> findById(@PathVariable(required = false) String id) {
		
		final Optional<UsuarioResponse> optional = usuarioService.findBy(UUID.fromString(id));
		
		if (optional.isPresent()) {
			return ResponseEntity.ok(optional.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping(path = "/usuarios")
	public ResponseEntity<List<UsuarioResponse>> findAll() {
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@PutMapping(path = "/usuarios/{id}",
			consumes = "application/json")
	public ResponseEntity<Void> update(@RequestBody AtualizarUsuarioRequest request, 
									   @PathVariable String id) {
		try {
			usuarioService.update(request, UUID.fromString(id)); 
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping(path = "/usuarios/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		try {
			usuarioService.delete(UUID.fromString(id)); 
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest().build();
		}
		
		return ResponseEntity.noContent().build();
	}
	
}
