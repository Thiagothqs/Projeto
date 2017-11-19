package com.meuempregado.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import com.meuempregado.model.Mensagem;
import com.meuempregado.model.Resposta;

public class MensagemDAO {
	EntityManagerFactory emf = Conexao.getInstance();
	
	public void salvar(Mensagem c) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(c);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Mensagem> listAll() {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Query q = em.createQuery("SELECT m FROM Mensagem m JOIN m.resposta r");//select m from Mensagem m join Resposta r on m.idresposta = r.idResposta
		
		em.getTransaction().commit();
		//em.close();
		
		return q.getResultList();
	}
	
	public void delete(Mensagem c) throws SQLException, ClassNotFoundException, IOException {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(c);
		
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(Mensagem c) throws SQLException, ClassNotFoundException, IOException{
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.merge(c);
		
		em.getTransaction().commit();
		em.close();
	}
	
}
