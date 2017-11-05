package com.meuempregado.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.model.Status;

public class StatusDAO extends GenericDAO{
	
	private PreparedStatement ps;
	private String LISTAR="SELECT * FROM tb_status;";
	
	public List<Status> listAll () throws SQLException, ClassNotFoundException, IOException {
		openConnection();
		
		ps = connect.prepareStatement(LISTAR);
		
		ResultSet rs = ps.executeQuery();
		List<Status> list = new ArrayList<Status>();
		
		while(rs.next()) {
			list.add(new Status(rs.getInt("id"), rs.getString("description")));
		}
		
		closeConnection();
		
		return list;
	}

}
