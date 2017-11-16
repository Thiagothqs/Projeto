package com.meuempregado.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.dao.ListarEmpregadosDAO;
import com.meuempregado.model.Empregado;

public class ListarEmpregadosService {
	LoginService serviceLogin = new LoginService();
	ListarEmpregadosDAO dao = new ListarEmpregadosDAO();
	
	public void contratar() {//Empregado empregado, Empregador empregador
		try {
			dao.contratar();//empregado, empregador
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Empregado> listarEmpregados() {
		List<Empregado> listaEmpregados = new ArrayList<Empregado>();
		
		try {
			listaEmpregados = dao.listarEmpregados();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listaEmpregados;
	}
}
