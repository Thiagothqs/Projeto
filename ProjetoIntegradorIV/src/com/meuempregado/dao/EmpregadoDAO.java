package com.meuempregado.dao;

import java.io.IOException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Status;

public class EmpregadoDAO extends GenericDAO{
	
	PreparedStatement ps;	
	
	private String LISTAR_TODOS = "select tb_empregado.*,tb_status.id as id_status,tb_status.description from tb_empregado inner join tb_status on tb_empregado.statusId = tb_status.id;";
	private String PROCURAR_ESTADO = "select * from tb_empregado inner join tb_status on tb_empregado.statusId=tb_status.id where estado like ?;";
	private String PROCURAR_CIDADE = "select * from tb_empregado inner join tb_status on tb_empregado.statusId=tb_status.id WHERE cidade LIKE ?;";
	private String SALVAR_EMPREGADO = "insert into tb_empregado values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private String PROCURAR_ESTADO_CIDADE = "select * from tb_empregado inner join tb_status on tb_empregado.statusId=tb_status.id WHERE estado like ? and cidade like ?";
	private String ALTERAR_EMPREGADO = "update tb_empregado set nome = ?, data_nascimento = ?, cpf = ?, rg = ?, telefone_fixo = ?, telefone_celular = ?, cep = ?, endereco_rua = ?, endereco_numero = ?, complemento = ?, bairro = ?, cidade = ?, estado = ?, email = ?, senha = ?, statusId = ?, sexo = ?, descricao = ?, ativo = ? where id = ?;";
	
	public List<Empregado> listAll() throws SQLException, ClassNotFoundException, IOException{
		List<Empregado> lista = new ArrayList<Empregado>();
		
		openConnection();
		
		ps = connect.prepareStatement(LISTAR_TODOS);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				
				Status status= new Status(rs.getInt("id_status"), rs.getString("description"));
				
				Empregado c =new Empregado(rs.getInt("id"),rs.getString("nome"),rs.getString("data_nascimento"),
						rs.getString("cpf"),rs.getString("rg"),rs.getString("telefone_fixo"),rs.getString("telefone_celular"),
						rs.getString("cep"),rs.getString("endereco_rua"),rs.getString("endereco_numero"),
						rs.getString("complemento"),rs.getString("bairro"),rs.getString("cidade"),rs.getString("estado"),
						rs.getString("email"),rs.getString("senha"),status,rs.getString("sexo"),rs.getString("descricao"));
				
				lista.add(c);
			}
		}
		
		closeConnection();
		
		return lista;
	}
	
	public List<Empregado> findEmpregadoByCidade(String cidade) throws ClassNotFoundException, SQLException, IOException{
		openConnection();
		
		List<Empregado> lista=new ArrayList<Empregado>();
		
		ps=connect.prepareStatement(PROCURAR_CIDADE);
	    ps.setString(1,"%"+cidade+"%");
	    
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()){
				
				Status status = new Status(rs.getInt("id_status"), rs.getString("description"));
				Empregado c = new Empregado(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nascimento"), rs.getString("cpf"), rs.getString("rg"), rs.getString("telefone_fixo"), rs.getString("telefone_celular"), rs.getString("cep"), rs.getString("endereco_rua"), rs.getString("endereco_numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("email"), rs.getString("senha"), status, rs.getString("sexo"), rs.getString("descricao"));
		
				lista.add(c);
				
			}
		}
			
		closeConnection();
		
		return lista;
		
	}
	
	public List<Empregado> findEmpregadoByEstado(String estado) throws ClassNotFoundException, SQLException, IOException{
		openConnection();
		
		List<Empregado> lista=new ArrayList<Empregado>();
		
		ps=connect.prepareStatement(PROCURAR_ESTADO);
	    ps.setString(1,"%"+estado+"%");
	    
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()){
				Status status = new Status(rs.getInt("id_status"), rs.getString("description"));
				Empregado c = new Empregado(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nascimento"), rs.getString("cpf"), rs.getString("rg"), rs.getString("telefone_fixo"), rs.getString("telefone_celular"), rs.getString("cep"), rs.getString("endereco_rua"), rs.getString("endereco_numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("email"), rs.getString("senha"), status, rs.getString("sexo"), rs.getString("descricao"));
					
				lista.add(c);
			}
		}
		
		closeConnection();
			
		return lista;
	}
	
	public List<Empregado> findEmpregadoByEstadoCidade(String estado, String cidade) throws ClassNotFoundException, SQLException, IOException{
		openConnection();
		
		List<Empregado> lista=new ArrayList<Empregado>();
		
		ps=connect.prepareStatement(PROCURAR_ESTADO_CIDADE);
	    ps.setString(1, estado);
	    ps.setString(2, "%"+cidade+"%");
	    
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()){
				Status status = new Status(rs.getInt("id_status"), rs.getString("description"));
				Empregado c = new Empregado(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nascimento"), rs.getString("cpf"), rs.getString("rg"), rs.getString("telefone_fixo"), rs.getString("telefone_celular"), rs.getString("cep"), rs.getString("endereco_rua"), rs.getString("endereco_numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("email"), rs.getString("senha"), status, rs.getString("sexo"), rs.getString("descricao"));
					
				lista.add(c);
			}
		}
		
		closeConnection();
			
		return lista;
	}
	
	public void updateEmpregado(Empregado empregado) throws SQLException {
		openConnection();
		
		ps = connect.prepareStatement(ALTERAR_EMPREGADO);
		ps.setString(1, empregado.getNome());
		ps.setString(2, empregado.getData_nascimento());
		ps.setString(3, empregado.getCpf());
		ps.setString(4, empregado.getRg());
		ps.setString(5, empregado.getTelefone_fixo());
		ps.setString(6, empregado.getTelefone_celular());
		ps.setString(7, empregado.getCep());
		ps.setString(8, empregado.getEndereco_rua());
		ps.setString(9, empregado.getEndereco_numero());
		ps.setString(10, empregado.getComplemento());
		ps.setString(11, empregado.getBairro());
		ps.setString(12, empregado.getCidade());
		ps.setString(13, empregado.getEstado());
		ps.setString(14, empregado.getEmail());
		ps.setString(15, empregado.getSenha());
		ps.setInt(16, empregado.getStatus().getId());
		ps.setString(17, empregado.getSexo());
		ps.setString(18, empregado.getDescricao());
		ps.setInt(19, 1);//atributo ativo do banco de dados
		ps.setInt(20, empregado.getId());
		
		ps.execute();
		
		closeConnection();
	}
	
	public void insertEmpregado(Empregado empregado) throws SQLException, ClassNotFoundException, IOException {
		
		openConnection();
		
		ps = connect.prepareStatement(SALVAR_EMPREGADO);
		ps.setString(1, empregado.getNome());
		ps.setString(2, empregado.getData_nascimento());
		ps.setString(3, empregado.getCpf());
		ps.setString(4, empregado.getRg());
		ps.setString(5, empregado.getTelefone_fixo());
		ps.setString(6, empregado.getTelefone_celular());
		ps.setString(7, empregado.getCep());
		ps.setString(8, empregado.getEndereco_rua());
		ps.setString(9, empregado.getEndereco_numero());
		ps.setString(10, empregado.getComplemento());
		ps.setString(11, empregado.getBairro());
		ps.setString(12, empregado.getCidade());
		ps.setString(13, empregado.getEstado());
		ps.setString(14, empregado.getEmail());
		ps.setString(15, empregado.getSenha());
		ps.setInt(16, empregado.getStatus().getId());
		ps.setString(17, empregado.getSexo());
		ps.setString(18, empregado.getDescricao());
		ps.setInt(19, 1);//atributo ativo do banco de dados
		
		ps.execute();
		
		closeConnection();
	}

}

