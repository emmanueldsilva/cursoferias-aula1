package matera.systems.cursoferias2018.api.domain.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import matera.systems.cursoferias2018.api.domain.repository.UsuarioRepository;

@Profile("stub")
@Component
public class UsuarioRepositoryStub implements UsuarioRepository {

	private static Map<UUID, UsuarioEntity> usuarios = new HashMap<>();
	
	public static final UUID USUARIO_1 = UUID.fromString("3480ed0e-2c8d-4a69-a8ed-7a2f136c4c20");
	public static final UUID USUARIO_2 = UUID.fromString("bc51c8bb-bad3-47e4-af0c-7f467148f23f");
	public static final UUID USUARIO_3 = UUID.fromString("369d8a35-e1df-4afc-9e0e-146b44f27d6d");
	
    static {
    	{
    		UUID id = UUID.fromString("bc51c8bb-bad3-47e4-af0c-7f467148f23d");
    		UsuarioEntity entity = new UsuarioEntity(id, "Paulo Almeida", "paulo.almeida@matera.com", "ADMINISTRADOR", "rochapaulo", "https://s.gravatar.com/avatar/27b57f4f9580f95c4cbe78bb6d3ec893?s=80");
    		
    		usuarios.put(id, entity);
    	}
    	
        {
            UsuarioEntity entity = new UsuarioEntity();
            entity.setId(USUARIO_1);
            entity.setEmail("usuario_1@domain.com");
            entity.setLogin("usuario_1");
            entity.setNome("Usuario Um");
            entity.setPerfil("USUARIO");
            entity.setUrlPhoto("http://bucket/usuario/1/perfil.png");
            usuarios.put(USUARIO_1, entity);
        }

        {
            UsuarioEntity entity = new UsuarioEntity();
            entity.setId(USUARIO_2);
            entity.setEmail("usuario_2@domain.com");
            entity.setLogin("usuario_2");
            entity.setNome("Usuario Dois");
            entity.setPerfil("ADMINISTRADOR");
            entity.setUrlPhoto("http://bucket/usuario/2/perfil.png");
            usuarios.put(USUARIO_2, entity);
        }

        {
            UsuarioEntity entity = new UsuarioEntity();
            entity.setId(USUARIO_3);
            entity.setEmail("usuario_3@domain.com");
            entity.setLogin("usuario_3");
            entity.setNome("Usuario Tres");
            entity.setPerfil("USUARIO");
            entity.setUrlPhoto("http://bucket/usuario/3/perfil.png");
            usuarios.put(USUARIO_3, entity);
        }
    }
	
	@Override
	public UUID salvar(UsuarioEntity entity) {
		usuarios.put(entity.getId(), entity);
		return entity.getId();
	}

	@Override
	public UsuarioEntity findBy(UUID idUsuario) {
		return usuarios.getOrDefault(idUsuario, null);
	}
	
	@Override
	public Collection<UsuarioEntity> findAll() {
		return usuarios.values();
	}
	
	@Override
	public void update(UsuarioEntity entity) {
		usuarios.put(entity.getId(), entity);
	}

	@Override
	public void delete(UUID id) {
		findBy(id);
	}

}
