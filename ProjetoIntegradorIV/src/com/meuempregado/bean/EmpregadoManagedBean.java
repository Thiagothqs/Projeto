package com.meuempregado.bean; 

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Status;
import com.meuempregado.service.EmpregadoService;

@ManagedBean(name="empregadoManagedBean")
@SessionScoped

public class EmpregadoManagedBean implements Serializable {
	private static final long serialVersionUID = 2556017393983871728L;
	
	private Empregado empregado;
	private List<Empregado> listEmpregado;
	private EmpregadoService serviceempregado;
	private Status status;
	
	public EmpregadoManagedBean() throws ClassNotFoundException, SQLException, IOException{
		status = new Status(0, "");
		serviceempregado = new EmpregadoService();
		empregado = new Empregado(0, "", "","", "","", "","", "","", "","", "","", "","",status,"","");
		listEmpregado = serviceempregado.listAll();
	}
	
	public void searchByCidadeAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Searching...");
		this.listEmpregado = serviceempregado.findEmpregadoByCidade(empregado.getCidade(), empregado.getEstado());
	}
	
	public String ListarTudo() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Searching...");
		this.listEmpregado = serviceempregado.listAll();
		
		return "index";
	}
	
	public String insertEmpregadoAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Saving...");
		serviceempregado.salvar(empregado);	
		this.listEmpregado = serviceempregado.listAll();
		
		return "index";
	}
	
	
	//////////////////////////////////////////
	
	/*
	
	public String searchByNameAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Searching...");
		this.listCustomer = service.findCustomerByName(customer.getName());
		
		return "index";
	}
	
	public String insertCustomerAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Saving...");
		service.insertCustomer(customer);
		
		this.listCustomer = service.listAll();
		
		return "index";
	}
	
	public String updateCustomerAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Updating...");
		service.updateCustomer(customer);
		this.listCustomer = service.listAll();
		
		return "index";
	}
	
	public String deleteCustomerAction() throws SQLException, ClassNotFoundException, IOException {
		System.out.println("Deleting...");
		service.deleteCustomer(customer);
		listCustomer = service.listAll();
		
		return "index";
	}
	

	*/
	
	/////////////////////////////////////////////
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
	
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
