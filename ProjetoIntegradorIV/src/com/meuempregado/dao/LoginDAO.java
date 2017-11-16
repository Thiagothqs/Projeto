package com.meuempregado.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;
import com.meuempregado.model.Status;

public class LoginDAO extends GenericDAO{
	PreparedStatement ps;
	
	private String LOGAR_EMPREGADO = "SELECT tb_empregado.*, tb_status.id as id_status, tb_status.description FROM TB_EMPREGADO inner join tb_status on tb_empregado.statusId=tb_status.id WHERE EMAIL = ? AND SENHA = ?;";
	private String LOGAR_EMPREGADOR = "SELECT * FROM TB_EMPREGADOR WHERE EMAIL = ? AND SENHA = ?";
	
	public List<Empregado> loginEmpregado(String email, String senha) throws SQLException {
		openConnection();
		
		List<Empregado> listaEmpregadoLogin = new ArrayList<Empregado>();
		
		ps = connect.prepareStatement(LOGAR_EMPREGADO);
		ps.setString(1, email);
		ps.setString(2, senha);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				Status status = new Status(rs.getInt("id_status"), rs.getString("description"));
				Empregado c = new Empregado(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nascimento"), rs.getString("cpf"), rs.getString("rg"), rs.getString("telefone_fixo"), rs.getString("telefone_celular"), rs.getString("cep"), rs.getString("endereco_rua"), rs.getString("endereco_numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("email"), rs.getString("senha"), status, rs.getString("sexo"), rs.getString("descricao"));
				
				listaEmpregadoLogin.add(c);
			}
		}
		
		closeConnection();
		
		return listaEmpregadoLogin;
	}
	
	public List<Empregador> loginEmpregador(String email, String senha) throws SQLException {
		openConnection();
		
		List<Empregador> listaEmpregadorLogin = new ArrayList<Empregador>();
		
		ps = connect.prepareStatement(LOGAR_EMPREGADOR);
		ps.setString(1, email);
		ps.setString(2, senha);
		
		ResultSet rs =  ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				Empregador e = new Empregador(rs.getInt("idEmpregador"), rs.getString("nome"),  rs.getString("rg"),  rs.getString("cpf"), rs.getString("orgao_emissor"), rs.getString("telefone_celular"), rs.getString("telefone_fixo"), rs.getString("data_nascimento"), rs.getString("sexo"), rs.getString("email"), rs.getString("senha"));
				listaEmpregadorLogin.add(e);
			}
		}
		
		closeConnection();
		
		return listaEmpregadorLogin;
	}
}
