package com.meuempregado.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.meuempregado.model.Empregador;
import com.meuempregado.util.ConnectDao;

public class EmpregadorDAO {
	EntityManagerFactory emf = ConnectDao.getInstance();
	
	public void insertEmpregador(Empregador empregador) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(empregador);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateEmpregador(Empregador empregador) throws SQLException {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(empregador);
		
		em.getTransaction().commit();
		em.close();

	}
	
	public List<Empregador> listAll() {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("FROM Empregador");
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}

}
