package com.meuempregado.model;

public class Resposta {
	
	private Integer id;
	private String description;
	
	public Resposta(){
	
	}
	
	public Resposta(Integer id, String description) {
		super();
		this.id = id;
		this.description = description;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	


}
