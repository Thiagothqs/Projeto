package com.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.meuempregado.dao.ListarEmpregadosDAO;
import com.meuempregado.dao.MensagemDAO;
import com.meuempregado.model.Mensagem;

public class MensagemService {
	
	MensagemDAO dao= new MensagemDAO();
	ListarEmpregadosDAO daoListarEmpregado = new ListarEmpregadosDAO();
	LoginService servicelogin = new LoginService();
	
	public List<Mensagem> listAll() throws SQLException, ClassNotFoundException, IOException{
		List<Mensagem> list = dao.listAll();
		List<Mensagem> listamensagem = new ArrayList<Mensagem>();
		
		for(Mensagem item: list) {
			if(item.getIdEmpregado() == servicelogin.getIdEmpregadologin()) {//==
				System.out.println(item.getIdEmpregado() +"MENSAGEM SERVICE"+servicelogin.getIdEmpregadologin());//servicelogin.getIdEmpregadologin()
				listamensagem.add(item);
			}
		}
		
		return listamensagem;
	}
	
	public void insertMensagem(Mensagem c) throws SQLException, ClassNotFoundException, IOException{
		c.setIdEmpregador(servicelogin.getIdEmpregadorlogin());
		System.out.println("Id Empregador (Mensagem Service) = "+servicelogin.getIdEmpregadorlogin());
		System.out.println("Id Empregado (Mensagem Service) = "+servicelogin.getIdEmpregadologin());
		dao.salvar(c);
	}
	
	
	public void deleteMensagem(Mensagem c) throws SQLException, ClassNotFoundException, IOException {
		dao.delete(c);
	}
	
	public void updateMensagem(Mensagem c) throws SQLException, ClassNotFoundException, IOException {
		dao.update(c);
		/*if(c.getResposta().getDescription().equals("SIM")) {
			daoListarEmpregado.contratar();//c.getIdEmpregado(), c.getIdEmpregador()
		}*/
	}

}
