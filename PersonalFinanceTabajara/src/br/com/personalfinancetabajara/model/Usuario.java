package br.com.personalfinancetabajara.model;

public class Usuario extends EntidadeBase {
	
	
	private String usuario;
	private String email;
	private String senha;
	private String nome;
	
	
	//Construtor
	public Usuario(long id_user, String usuario, String email, String senha, String nome) {
		super();
		setId(id_user);
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

	@Override
	public boolean equals(Object obj) {
		
		
		Usuario other = (Usuario) obj;
		if (other.getUsuario().equals(this.getUsuario())) {
			return true;
			
			
			
		}
		
		
		return false;
	}
	
	
	
	
	
	//toString
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", email=" + email + ", senha=" + senha
				+ ", nome=" + nome + "]";
	}
	
	
	
	

}
