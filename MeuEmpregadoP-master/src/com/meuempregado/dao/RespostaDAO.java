package com.meuempregado.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.meuempregado.model.Resposta;
import com.meuempregado.dao.Conexao;

public class RespostaDAO {
	EntityManagerFactory emf = Conexao.getInstance();
	
	public List<Resposta> listAll () {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("FROM Resposta");
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}

}
