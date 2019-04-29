package exercicio1.model.vo;

public class EnderecoVO {
	private String rua;
	private int cep;
	private String cidade;
	private String estado;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public EnderecoVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EnderecoVO(String rua, int cep, String cidade, String estado) {
		super();
		this.rua = rua;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}

}
