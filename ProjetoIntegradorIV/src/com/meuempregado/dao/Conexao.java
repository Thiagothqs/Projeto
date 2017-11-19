package com.meuempregado.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoIntegradorIV");
	
	public static EntityManagerFactory getInstance() {
		return emf;
	}
}