package model.bean;

public class Instituicao {

	private Integer cod;
	private String endereco;
	private String telefone;
	private String campus;

	public Instituicao() {
	}

	public Instituicao(String endereco, String telefone, String campus) {
		this.endereco = endereco;
		this.telefone = telefone;
		this.campus = campus;
	}

	public Integer getCod() {
		return cod;
	}
	
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCampus() {
		return campus;
	}

	public void setCampus(String campus) {
		this.campus = campus;
	}

	@Override
	public String toString() {
		return "Instituicao [cod=" + cod + ", endereco=" + endereco + ", telefone=" + telefone + ", campus=" + campus
				+ "]";
	}
	
	
}
