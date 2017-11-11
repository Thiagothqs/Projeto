package com.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.meuempregado.dao.RespostaDAO;
import com.meuempregado.model.Resposta;

public class RespostaService {
	
	
	RespostaDAO dao = new RespostaDAO();
	
	public List<Resposta> listAll() throws ClassNotFoundException, IOException{
		try {
			return dao.listAll();
		} catch (SQLException e) {
			return null;
		}
	}

}
