package com.meuempregado.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;
import com.meuempregado.service.LoginService;

@ManagedBean(name = "loginManagedBean")
@SessionScoped
public class LoginManagedBean implements Serializable {
	private static final long serialVersionUID = 4024239853460771489L;
	
	private Empregado empregado;
	private Empregador empregador;
	private LoginService service;
	private String email;
	private String senha;
	
	String retorna = "";
	
	public LoginManagedBean() {
		empregador = new Empregador(0, "", "", "", "", "", "", "", "", "", "");
		empregado = new Empregado(0, "", "","", "","", "","", "","", "","", "","", "","","","");
		service = new LoginService();
	}
	
	public String logar() throws ClassNotFoundException, SQLException, IOException {
		retorna = service.login(email, senha);//, empregado, empregador
		
		return retorna;
	}
	
	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

	public Empregador getEmpregador() {
		return empregador;
	}

	public void setEmpregador(Empregador empregador) {
		this.empregador = empregador;
	}

	public LoginService getService() {
		return service;
	}

	public void setService(LoginService service) {
		this.service = service;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
