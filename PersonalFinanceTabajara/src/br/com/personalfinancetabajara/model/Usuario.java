package br.com.personalfinancetabajara.model;

public class Usuario {
	
	private long id_user;
	private String usuario;
	private String email;
	private String senha;
	private String nome;
	
	
	//Construtor
	public Usuario(long id_user, String usuario, String email, String senha, String nome) {
		super();
		this.id_user = id_user;
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}
	
	
	public Usuario(String usuario, String email, String senha, String nome) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
	}


	public Usuario() {
		// TODO Auto-generated constructor stub
	}
    //Get e set
	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	//toString
	@Override
	public String toString() {
		return "Usuario [id_user=" + id_user + ", usuario=" + usuario + ", email=" + email + ", senha=" + senha
				+ ", nome=" + nome + "]";
	}
	
	
	
	

}
