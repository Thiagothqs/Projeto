package com.meuempregado.bean;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Empregado;
import com.meuempregado.model.Mensagem;
import com.meuempregado.model.Resposta;
import com.meuempregado.service.MensagemService;

@ManagedBean(name="mensagemManagedBean")
@SessionScoped
public class MensagemManagedBean {
	
	private Mensagem Mensagem;
	private List<Mensagem> listMensagem;
	private MensagemService service;
	//private Set<Resposta> resposta;
	private Resposta resposta;
	private Empregado empregado;
	
	public MensagemManagedBean() throws ClassNotFoundException, SQLException, IOException{	
		service = new MensagemService();
		//resposta = new HashSet<Resposta>();
		resposta = new Resposta(0, "");
		Mensagem = new Mensagem();//0,"", "", "",resposta,"","","","", 0f ,"", 0, 0
		listMensagem = service.listAll();
	}
	
	///////////////////////////insert
	public String insertMensagemAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Saving...");
		Mensagem.setIdEmpregado(empregado.getId());
		service.insertMensagem(Mensagem);	
		this.listMensagem = service.listAll();
		
		return "indexEMPREGADOR";
	}
	
	//////////////////////////delete
	public String deleteMensagemAction() throws SQLException, ClassNotFoundException, IOException {
		System.out.println("Deleting...");
		service.deleteMensagem(Mensagem);
		listMensagem = service.listAll();
		
		return "indexEMPREGADOR";
	}

	///////update
	public String updateMensagemAction() throws SQLException, ClassNotFoundException, IOException{
		System.out.println("Updating...");
		service.updateMensagem(Mensagem);
		this.listMensagem = service.listAll();
		
		return "listamensagemEMPREGADO";	
	}

	////////////////////////////////////////
	public Mensagem getMensagem() {
		return Mensagem;
	}

	public void setMensagem(Mensagem Mensagem) {
		this.Mensagem = Mensagem;
	}

	public List<Mensagem> getListMensagem() {
		return listMensagem;
	}

	public void setListMensagem(List<Mensagem> listMensagem) {
		this.listMensagem = listMensagem;
	}
	
	public Resposta getResposta() {
		return resposta;
	}

	public void setResposta(Resposta Resposta) {
		this.resposta = Resposta;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}

}
