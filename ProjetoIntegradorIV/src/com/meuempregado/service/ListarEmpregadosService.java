package com.meuempregado.service;

import java.util.List;

import com.meuempregado.dao.ListarEmpregadosDAO;
import com.meuempregado.model.Empregado;

public class ListarEmpregadosService {
	LoginService serviceLogin = new LoginService();
	ListarEmpregadosDAO dao = new ListarEmpregadosDAO();
	
	public List<Empregado> listarEmpregados() {
		return dao.listarEmpregados();
	}
}
