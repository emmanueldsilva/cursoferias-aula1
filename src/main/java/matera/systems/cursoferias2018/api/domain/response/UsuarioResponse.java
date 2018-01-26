package matera.systems.cursoferias2018.api.domain.response;

import java.util.UUID;

public class UsuarioResponse {
	
	private UUID id;

	private String nome;
	
	private String email;
	
	private String perfil;
	
	private String login;
	
	private String urlPhoto;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID uuid) {
		this.id = uuid;
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

}
