package com.meuempregado.bean;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregador;
import com.meuempregado.service.EmpregadorService;

@ManagedBean(name="empregadorManagedBean")
@SessionScoped
public class EmpregadorManagedBean implements Serializable {
	private static final long serialVersionUID = 2371718073349808318L;
	
	private Empregador empregador;
	private List<Empregador> listEmpregador;
	private EmpregadorService serviceempregador;
	
	public EmpregadorManagedBean() throws ClassNotFoundException, SQLException, IOException{
		serviceempregador = new EmpregadorService();
		empregador = new Empregador(0, "", "", "", "", "", "", "", "", "", "");
		listEmpregador = serviceempregador.listAll();
	}
	
	public String ListarTudo() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Searching...");
		this.listEmpregador = serviceempregador.listAll();
		
		return "index";
	}
	
	public String insertEmpregadorAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Saving...");
		serviceempregador.salvar(empregador);	
		this.listEmpregador = serviceempregador.listAll();
		
		return "index";
	}
	
	public String updateEmpregadorAction(){
		serviceempregador.alterar(empregador);
		try {
			this.listEmpregador = serviceempregador.listAll();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			e.printStackTrace();
		}
		
		return "index";
	}

	public Empregador getEmpregador() {
		return empregador;
	}

	public void setEmpregador(Empregador empregador) {
		this.empregador = empregador;
	}

	public List<Empregador> getListEmpregador() {
		return listEmpregador;
	}

	public void setListEmpregador(List<Empregador> listEmpregador) {
		this.listEmpregador = listEmpregador;
	}

	public EmpregadorService getServiceempregador() {
		return serviceempregador;
	}

	public void setServiceempregador(EmpregadorService serviceempregador) {
		this.serviceempregador = serviceempregador;
	}
	
}

