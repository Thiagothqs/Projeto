package com.meuempregado.bean;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.service.EmpregadoService;

@ManagedBean(name="empregadoManagedBean")
@SessionScoped


public class EmpregadoManagedBean {
	
	//Teste
	
	private Empregado empregado;
	private List<Empregado> listEmpregado;
	private EmpregadoService serviceempregado;
	
	public EmpregadoManagedBean() throws ClassNotFoundException, SQLException, IOException{
		
		serviceempregado = new EmpregadoService();
		empregado = new Empregado();
		
		listEmpregado = serviceempregado.listar();
		
	}
	
	public String searchByCidadeAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Searching...");
		this.listEmpregado = serviceempregado.findEmpregadoByCidade(empregado.getCidade());
		
		return "indexEMPREGADOR";
	}
	
	public String ListarTudo() throws SQLException, ClassNotFoundException, IOException{
		
		this.listEmpregado = serviceempregado.listar();
		
		return "indexEMPREGADOR";
	}
	
	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado Empregado) {
		this.empregado = Empregado;
	}

	public List<Empregado> getListEmpregado() {
		return listEmpregado;
	}

	public void setListEmpregado(List<Empregado> listEmpregado) {
		this.listEmpregado = listEmpregado;
	}
}
