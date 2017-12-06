package com.meuempregado.service;

import java.util.List;

import com.meuempregado.dao.FactoryDao;
import com.meuempregado.model.Empregador;

public class EmpregadorService {

	public void cadastrar(Empregador e){
		FactoryDao.createGenericDao(Empregador.class).inserir(e);
	}
	public List<Empregador>listar(){
		return FactoryDao.createGenericDao(Empregador.class).listarTodos();
	}
	public void excluir(Empregador e){
		FactoryDao.createGenericDao(Empregador.class).excluir(e.getId());
	}
	public void atulizar(Empregador e){
		FactoryDao.createGenericDao(Empregador.class).alterar(e);
	}
	public Empregador buscarId(Integer id){
		return FactoryDao.createGenericDao(Empregador.class).buscarPorId(id);
	}
}
