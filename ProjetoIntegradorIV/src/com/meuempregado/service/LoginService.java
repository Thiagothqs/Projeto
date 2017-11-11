package com.meuempregado.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.meuempregado.dao.EmpregadoDAO;
import com.meuempregado.dao.EmpregadorDAO;
import com.meuempregado.dao.LoginDAO;
import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;

public class LoginService {
	LoginDAO dao = new LoginDAO();
	EmpregadoDAO daoEmpregado = new EmpregadoDAO();
	EmpregadorDAO daoEmpregador = new EmpregadorDAO();
	
	String retorno = "";
	
	public String login(String email, String senha, Empregado empregado, Empregador empregador) throws ClassNotFoundException, SQLException, IOException {
		List<Empregado> listaEmpregado = daoEmpregado.listAll();
		List<Empregador> listaEmpregador = daoEmpregador.listAll();
		
		for(int i=0;i<listaEmpregado.size();i++) {
			if(email.equals(listaEmpregado.get(i).getEmail())) {
				if(senha.equals(listaEmpregado.get(i).getSenha())) {
					dao.loginEmpregado(empregado);
					retorno = "index.xhtml";
				}
			}
		}
		
		for(int i=0;i<listaEmpregador.size();i++) {
			if(email.equals(listaEmpregador.get(i).getEmail())) {
				if(senha.equals(listaEmpregador.get(i).getSenha())) {
					dao.loginEmpregador(empregador);
					retorno = "indexEMPREGADOR.xhtml";
				}
			}
		}
		
		return retorno;
	}
}
