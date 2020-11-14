package model.bean;

import java.sql.Blob;

public class Candidato {
	
	private Integer cod;
	private String name;
	private Integer num;
	private String chapa;
	private Blob imagem;
	
	public Candidato() {}

	public Candidato(Integer cod, String name, Integer num, String chapa, Blob imagem) {
		this.cod = cod;
		this.name = name;
		this.num = num;
		this.chapa = chapa;
		this.imagem = imagem;
	}

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	} 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getChapa() {
		return chapa;
	}

	public void setChapa(String chapa) {
		this.chapa = chapa;
	}

	public Blob getImagem() {
		return imagem;
	}

	public void setImagem(Blob imagem) {
		this.imagem = imagem;
	}
	
	
}
