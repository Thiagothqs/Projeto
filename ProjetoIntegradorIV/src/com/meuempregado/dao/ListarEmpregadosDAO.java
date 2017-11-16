package com.meuempregado.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Status;
import com.meuempregado.service.LoginService;

public class ListarEmpregadosDAO extends GenericDAO {
	PreparedStatement ps;
	LoginService service = new LoginService();
	
	private String CONTRATAR_EMPREGADO = "insert into tb_contratarfuncionario values(?, ?);";
	private String LISTAR_EMPREGADOS= "select tb_empregado.*, tb_empregador.idEmpregador from tb_empregado inner join tb_contratarfuncionario on tb_empregado.id=tb_contratarfuncionario.idEmpregado inner join tb_empregador on tb_contratarfuncionario.idEmpregador=tb_empregador.idEmpregador where tb_empregador.idEmpregador = ?;";
	
	public void contratar() throws SQLException {//Empregado empregado, Empregador empregador
		openConnection();
		
		ps = connect.prepareStatement(CONTRATAR_EMPREGADO);
		ps.setInt(1, service.getIdEmpregadologin());
		ps.setInt(2, service.getIdEmpregadorlogin());
		
		System.out.println("Id Empregado = "+service.getIdEmpregadologin());
		System.out.println("Id Empregador = ");
		
		ps.execute();
		
		closeConnection();
	}
	
	public List<Empregado> listarEmpregados() throws SQLException {
		openConnection();
		
		List<Empregado> listaEmpregado = new ArrayList<Empregado>();
		
		ps = connect.prepareStatement(LISTAR_EMPREGADOS);
		ps.setInt(1, service.getIdEmpregadorlogin());
		
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				Status status = new Status(rs.getInt("id_status"), rs.getString("description"));
				Empregado c = new Empregado(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nascimento"), rs.getString("cpf"), rs.getString("rg"), rs.getString("telefone_fixo"), rs.getString("telefone_celular"), rs.getString("cep"), rs.getString("endereco_rua"), rs.getString("endereco_numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("email"), rs.getString("senha"), status, rs.getString("sexo"), rs.getString("descricao"));
			
				listaEmpregado.add(c);
			}
		}
		
		closeConnection();
		
		return listaEmpregado;
	}
}
