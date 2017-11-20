package com.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.dao.EmpregadorDAO;
import com.meuempregado.model.Empregador;

public class EmpregadorService {
	EmpregadorDAO dao=new EmpregadorDAO();
	
	public List<Empregador> listAll() throws SQLException, ClassNotFoundException, IOException{
		List<Empregador> listaEmpregador = new ArrayList<Empregador>();
			
		listaEmpregador = dao.listAll();
		
		return listaEmpregador;
	}
	
	public void alterar (Empregador empregador) {
		try {
			dao.updateEmpregador(empregador);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void salvar(Empregador empregador){
		try {
			dao.insertEmpregador(empregador);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
