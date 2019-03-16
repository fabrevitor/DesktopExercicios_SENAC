package exercicio2.model.vo;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private int nivel;
	
	public Usuario(int id, String nome, String email, String senha, int nivel) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nivel = nivel;
	}
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return "ID: " + id + "\nNome: " + nome + 
				"\nEmail: " + email + 
				"\nSenha: " + senha + 
				"\nNivel: " + nivel;
	}
	
}
