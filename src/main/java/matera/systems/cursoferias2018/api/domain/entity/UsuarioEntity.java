package matera.systems.cursoferias2018.api.domain.entity;

import java.util.UUID;

import matera.systems.cursoferias2018.api.domain.response.UsuarioResponse;

public class UsuarioEntity {
	
	private UUID id = UUID.randomUUID();
	
	private String nome;
	
	private String email;
	
	private String perfil;
	
	private String login;
	
	private String urlPhoto;
	
	public UsuarioEntity() { }
	
	public UsuarioEntity(UUID id, String nome, String email, String perfil, String login, String urlPhoto) {
		this(nome, email, perfil, login, urlPhoto);
		
		this.id = id;
	}
	
	public UsuarioEntity(String nome, String email, String perfil, String login, String urlPhoto) {
		this();
		this.nome = nome;
		this.email = email;
		this.perfil = perfil;
		this.login = login;
		this.urlPhoto = urlPhoto;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	
	public UsuarioResponse toResponse() {
		final UsuarioResponse usuarioResponse = new UsuarioResponse();
		usuarioResponse.setId(getId());
		usuarioResponse.setNome(getNome());
		usuarioResponse.setLogin(getLogin());
		usuarioResponse.setEmail(getEmail());
		usuarioResponse.setPerfil(getPerfil());
		usuarioResponse.setUrlPhoto(getUrlPhoto());
		
		return usuarioResponse;
	}
	
}
