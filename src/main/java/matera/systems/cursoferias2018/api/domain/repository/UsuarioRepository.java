package matera.systems.cursoferias2018.api.domain.repository;

import java.util.Collection;
import java.util.UUID;

import matera.systems.cursoferias2018.api.domain.entity.UsuarioEntity;

public interface UsuarioRepository {

	public UUID salvar(UsuarioEntity entity);
	
	public UsuarioEntity findBy(UUID id);
	
	public Collection<UsuarioEntity> findAll();
	
	public void update(UsuarioEntity entity);
	
	public void delete(UUID id);
	
}
