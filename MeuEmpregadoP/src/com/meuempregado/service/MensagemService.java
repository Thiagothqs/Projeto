package com.meuempregado.service;

import java.util.List;

import com.meuempregado.dao.FactoryDao;
import com.meuempregado.model.Mensagem;



public class MensagemService {
	
	public void cadastrar(Mensagem m){
		FactoryDao.createGenericDao(Mensagem.class).inserir(m);
	}
	public List<Mensagem>listar(){
		return FactoryDao.createGenericDao(Mensagem.class).listarTodos();
	}
	public void excluir(Mensagem m){
		FactoryDao.createGenericDao(Mensagem.class).excluir(m.getIdMensagem());
	}
	public void atulizar(Mensagem m){
		FactoryDao.createGenericDao(Mensagem.class).alterar(m);
	}

}
