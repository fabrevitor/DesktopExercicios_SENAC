package exercicio4.model.vo;

import exercicio2_3.model.vo.NivelVO;

public class UsuarioVO{
	private int id;
	private String nome;
	private String email;
	private String senha;
	private NivelVO nivel;
	
	public UsuarioVO(String nome, String email, String senha, NivelVO nivel) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.nivel = nivel;
	}
	public UsuarioVO() {
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
	public NivelVO getNivel() {
		return nivel;
	}
	public void setNivel(NivelVO nivel) {
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return "ID: " + id + "\nNome: " + nome + 
				"\nEmail: " + email + 
				"\nSenha: " + senha + 
				 nivel.toString();
	}
}
