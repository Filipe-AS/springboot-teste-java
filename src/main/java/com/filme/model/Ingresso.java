package com.filme.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ingresso {
	
	@Id
	private String cadeira;	
	private boolean status;
	
	@ManyToOne
	private Filme filme;
	
	public Filme getFilme() {
		return filme;
	}
	public void setFilme(Filme filme) {
		this.filme = filme;
	}
	public String getCadeira() {
		return cadeira;
	}
	public void setCadeira(String cadeira) {
		this.cadeira = cadeira;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
	
	

}
