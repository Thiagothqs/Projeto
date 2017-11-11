package com.meuempregado.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.model.Resposta;

public class RespostaDAO extends GenericDAO{
	
	private PreparedStatement ps;
	private String LISTAR="SELECT * FROM tb_resposta;";
	
	public List<Resposta> listAll () throws SQLException, ClassNotFoundException, IOException {
		openConnection();
		
		ps = connect.prepareStatement(LISTAR);
			
		ResultSet rs = ps.executeQuery();
		List<Resposta> list = new ArrayList<Resposta>();
		
		while(rs.next()) {
			list.add(new Resposta(rs.getInt("idResposta"), rs.getString("description")));
		}
		
		closeConnection();
		
		return list;
	}

}
