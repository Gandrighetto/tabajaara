package br.com.personalfinancetabajara.model;

import java.util.Date;

public class Gastos extends EntidadeBase {

	private String descricao;
	private double valor;
	private Date data;
	
	//Construtor
	public Gastos(String descricao, double valor, Date data) {
		super();
		this.descricao = descricao;
		this.valor = valor;
		this.data = data;
	}

	
	
	//Get e set
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
	
	
	
	
}
