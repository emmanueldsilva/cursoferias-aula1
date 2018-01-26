package matera.systems.cursoferias2018.api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;
import matera.systems.cursoferias2018.api.domain.entity.UsuarioRepositoryStub;
import matera.systems.cursoferias2018.api.domain.request.AtualizarUsuarioRequest;
import matera.systems.cursoferias2018.api.domain.request.CriarUsuarioRequest;
import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositoryStub usuarioRepository;
	
	public UUID criaUsuario(CriarUsuarioRequest request) {
		if (request == null) {
			throw new IllegalArgumentException("Requisição não pode ser nula");
		}
		
		UsuarioEntity entity = new UsuarioEntity(request.getNome(), 
												 request.getEmail(), 
												 request.getPerfil(), 
												 request.getLogin(), 
												 request.getUrlPhoto());
		
		return usuarioRepository.salvar(entity);
	}

	public Optional<UsuarioResponse> findBy(UUID idUsuario) {
		final Optional<UsuarioEntity> entity = Optional.ofNullable(usuarioRepository.findBy(idUsuario));
		if (entity.isPresent()) {
			return Optional.of(entity.get().toResponse());
		}
		
		return Optional.empty();
	}
	
	public void update(AtualizarUsuarioRequest request, UUID id) {
		if (request == null) {
			throw new IllegalArgumentException("Requisição não pode ser nula");
		}
		
		final UsuarioEntity usuarioEntity = usuarioRepository.findBy(id);
		if (usuarioEntity == null) {
			throw new IllegalArgumentException("Usuário não encontrado");
		}
		
		usuarioEntity.setNome(request.getNome());
		usuarioRepository.update(usuarioEntity);
	}
	
	public void delete(UUID id) {
		usuarioRepository.delete(id);
	}
	
	public List<UsuarioResponse> findAll() {
		final List<UsuarioResponse> responses = new ArrayList<>();
		for (UsuarioEntity usuarioEntity : usuarioRepository.findAll()) {
			responses.add(usuarioEntity.toResponse());
		}
		
		return responses;
	}
	
}
