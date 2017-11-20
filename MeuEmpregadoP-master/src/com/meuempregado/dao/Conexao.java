package com.meuempregado.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Conexao {
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeuEmpregadoP");
	
	public static EntityManagerFactory getInstance() {
		return emf;
	}
}