package com.meuempregado.service;

import java.util.List;

import com.meuempregado.dao.RespostaDAO;
import com.meuempregado.model.Resposta;

public class RespostaService {
	
	
	RespostaDAO dao = new RespostaDAO();
	
	public List<Resposta> listAll() {
		/*try {
			return dao.listAll();
		} catch (SQLException e) {
			return null;
		}*/
		
		return dao.listAll();
	}

}
