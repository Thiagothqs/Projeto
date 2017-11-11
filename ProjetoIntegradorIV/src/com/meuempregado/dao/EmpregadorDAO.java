package com.meuempregado.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.model.Empregador;

public class EmpregadorDAO extends GenericDAO{
	PreparedStatement ps;
	
	private String SALVAR_EMPREGADO = "insert into tb_empregador values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private String ALTERAR_EMPREGADO = "update tb_empregador set nome = ?, rg = ?, cpf = ?, orgao_emissor = ?, telefone_celular = ?, telefone_fixo = ?, data_nascimento = ?, sexo = ?, email = ?, senha = ? where idEmpregador = ?;";
	private String LISTAR_TODOS = "select * from tb_empregador;";
	
	public void insertEmpregador(Empregador empregador) throws SQLException {
		openConnection();
		
		ps = connect.prepareStatement(SALVAR_EMPREGADO);
		ps.setString(1, empregador.getNome());
		ps.setString(2, empregador.getRg());
		ps.setString(3, empregador.getCpf());
		ps.setString(4, empregador.getOrgao_expedidor());
		ps.setString(5, empregador.getTelefone_celular());
		ps.setString(6, empregador.getTelefone_fixo());
		ps.setString(7, empregador.getData_nascimento());
		ps.setString(8, empregador.getSexo());
		ps.setString(9, empregador.getEmail());
		ps.setString(10, empregador.getSenha());
		
		ps.execute();
		
		closeConnection();
	}
	
	public void updateEmpregador(Empregador empregador) throws SQLException {
		openConnection();
		
		ps = connect.prepareStatement(ALTERAR_EMPREGADO);
		ps.setString(1, empregador.getNome());
		ps.setString(2, empregador.getRg());
		ps.setString(3, empregador.getCpf());
		ps.setString(4, empregador.getOrgao_expedidor());
		ps.setString(5, empregador.getTelefone_celular());
		ps.setString(6, empregador.getTelefone_fixo());
		ps.setString(7, empregador.getData_nascimento());
		ps.setString(8, empregador.getSexo());
		ps.setString(9, empregador.getEmail());
		ps.setString(10, empregador.getSenha());
		ps.setInt(11, empregador.getId());
		
		ps.execute();
		
		closeConnection();
	}
	
	public List<Empregador> listAll() throws SQLException{
		List<Empregador> listaEmpregador = new ArrayList<Empregador>();
		
		openConnection();
		
		ps = connect.prepareStatement(LISTAR_TODOS);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				Empregador empregador = new Empregador(rs.getInt("idEmpregador"), rs.getString("nome"), rs.getString("rg"), rs.getString("cpf"), rs.getString("orgao_emissor"), rs.getString("telefone_celular"), rs.getString("telefone_fixo"), rs.getString("data_nascimento"), rs.getString("sexo"), rs.getString("email"), rs.getString("senha"));
				listaEmpregador.add(empregador);
			}
		}
		
		closeConnection();
		
		return listaEmpregador;
	}

}
