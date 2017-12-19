package br.usjt.arqdesis.model;

public class Mercadoria {
	
	private int codigo;
	private String tipo;
	private String descricao;
	private double preco;
	
	
	public Mercadoria() {
		// TODO Auto-generated constructor stub
	}
	
	public Mercadoria(int codigo, String tipo, String descricao, double preco) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
		this.descricao = descricao;
		this.preco = preco;
	}
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}

}
