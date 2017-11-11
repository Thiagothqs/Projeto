package com.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.dao.EmpregadoDAO;
import com.meuempregado.model.Empregado;

public class EmpregadoService {
	
	EmpregadoDAO dao=new EmpregadoDAO();
	
	public List<Empregado> listAll() throws SQLException, ClassNotFoundException, IOException{
		List<Empregado> list = new ArrayList<Empregado>();
			
		list = dao.listAll();
		
		return list;
	}
	
	public void alterar (Empregado empregado) {
		try {
			dao.updateEmpregado(empregado);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Empregado> findEmpregadoByCidade(String cidade, String estado) throws SQLException, ClassNotFoundException, IOException{
		List<Empregado> list = new ArrayList<Empregado>();
		
		if(!cidade.isEmpty() && !estado.isEmpty()) {
			list = dao.findEmpregadoByEstadoCidade(estado, cidade);//cidade
		}
		else if(!estado.isEmpty() && cidade.isEmpty()) {
			list = dao.findEmpregadoByEstado(estado);
		}
		else if(!cidade.isEmpty() && estado.isEmpty()) {
			list = dao.findEmpregadoByCidade(cidade);
		}
		else {
			list = dao.listAll();
		}	
		
		return list;
	}
	
	public void salvar(Empregado empregado){
		try {
			dao.insertEmpregado(empregado);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
