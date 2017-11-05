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
	
	private String LISTAR_TODOS = "select * from tb_empregado inner join tb_status on tb_empregado.statusId=tb_status.id;";
	private String PROCURAR_ESTADO = "select * from tb_empregado inner join tb_status on tb_empregado.statusId=tb_status.id where estado like ?;";
	private String PROCURAR_CIDADE = "select * from tb_empregado inner join tb_status on tb_empregado.statusId=tb_status.id WHERE cidade LIKE ?;";
	private String SALVAR_EMPREGADO = "insert into tb_empregado values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	private String PROCURAR_ESTADO_CIDADE = "select * from tb_empregado inner join tb_status on tb_empregado.statusId=tb_status.id WHERE estado like ? and cidade like ?";
	
	/* private String LISTAR_TODOS = "SELECT * FROM tb_empregado";
	 * private String PROCURAR_NOME = "SELECT cs.id, cs.nome, cs.data_nascimento,cs.cpf,cs.rg"
			+ ",cs.telefone_fixo,cs.telefone_celular,cs.cep,cs.endereco_rua,cs.endereco_numero,cs.complemento"
			+ ",cs.bairro,cs.cidade,cs.estado,cs.email,cs.senha,cs.sexo,cs.descricao,ct.id,ct.description FROM tb_empregado cs"
			+ ",tb_status ct WHERE cs.cidade LIKE ? AND cs.idstatus= ct.id";*/
	
	public List<Empregado> listAll() throws SQLException, ClassNotFoundException, IOException{
		List<Empregado> lista = new ArrayList<Empregado>();
		
		openConnection();
		
		ps = connect.prepareStatement(LISTAR_TODOS);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()) {
				
				Status status= new Status(rs.getInt("id"), rs.getString("description"));
				
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
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public List<Empregado> findEmpregadoByCidade(String cidade) throws ClassNotFoundException, SQLException, IOException{
		openConnection();
		
		List<Empregado> lista=new ArrayList<Empregado>();
		
		ps=connect.prepareStatement(PROCURAR_CIDADE);
	    ps.setString(1,"%"+cidade+"%");
	    
		ResultSet rs = ps.executeQuery();
		
		if(rs != null) {
			while(rs.next()){
				
				Status status = new Status(rs.getInt("id"), rs.getString("description"));
				Empregado c = new Empregado(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nascimento"), rs.getString("cpf"), rs.getString("rg"), rs.getString("telefone_fixo"), rs.getString("telefone_celular"), rs.getString("cep"), rs.getString("endereco_rua"), rs.getString("endereco_numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("email"), rs.getString("senha"), status, rs.getString("sexo"), rs.getString("descricao"));
				
				/* Empregado c=new Empregado();
				 * 
				 * c.setId(rs.getInt("cs.id"));
				c.setNome(rs.getString("cs.nome"));
				c.setData_nascimento(rs.getString("cs.data_nascimento"));
				c.setCpf(rs.getString("cs.cpf"));
				c.setRg(rs.getString("cs.rg"));
				c.setTelefone_fixo(rs.getString("cs.telefone_fixo"));
				c.setTelefone_celular(rs.getString("cs.telefone_celular"));
				c.setCep(rs.getString("cs.cep"));
				c.setEndereco_rua(rs.getString("cs.endereco_rua"));
				c.setEndereco_numero(rs.getString("cs.endereco_numero"));
				c.setComplemento(rs.getString("cs.complemento"));
				c.setBairro(rs.getString("cs.bairro"));
				c.setCidade(rs.getString("cs.cidade"));
				c.setEstado(rs.getString("cs.estado"));
				c.setEmail(rs.getString("cs.email"));
				c.setSenha(rs.getString("cs.senha"));
				c.setNome(rs.getString("cs.nome"));
				c.setStatus(new Status(rs.getInt("ct.id"), rs.getString("ct.description")));
				c.setSexo(rs.getString("cs.sexo"));
				c.setDescricao(rs.getString("cs.descricao"));*/
		
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
				Status status = new Status(rs.getInt("id"), rs.getString("description"));
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
				Status status = new Status(rs.getInt("id"), rs.getString("description"));
				Empregado c = new Empregado(rs.getInt("id"), rs.getString("nome"), rs.getString("data_nascimento"), rs.getString("cpf"), rs.getString("rg"), rs.getString("telefone_fixo"), rs.getString("telefone_celular"), rs.getString("cep"), rs.getString("endereco_rua"), rs.getString("endereco_numero"), rs.getString("complemento"), rs.getString("bairro"), rs.getString("cidade"), rs.getString("estado"), rs.getString("email"), rs.getString("senha"), status, rs.getString("sexo"), rs.getString("descricao"));
					
				lista.add(c);
			}
		}
		
		closeConnection();
			
		return lista;
	}
	
	public void salvar(Empregado empregado) throws SQLException, ClassNotFoundException, IOException {
		
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

