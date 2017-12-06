package com.meuempregado.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.Mensagem;
import com.meuempregado.service.MensagemService;

@ManagedBean(name="mensagemManagedBean")
@SessionScoped


public class MensagemManagedBean implements Serializable {
	private static final long serialVersionUID = 7997258218435606996L;
	
	private Mensagem Mensagem;
	private List<Mensagem> listMensagem;
	private MensagemService service;
	
	
	public MensagemManagedBean(){
		service = new MensagemService();
		
		Mensagem = new Mensagem();
		
		listMensagem = service.listar();
		
		
	}
	
	
	///////////////////////////insert
	public String insertMensagemAction(){
		if(Mensagem.getOfereceSeguro()&&Mensagem.getIdContratoSeguro()==null){
			System.out.println("Contrato...");
			return "contratoPacoteSeguro";
		}else{
			System.out.println("Saving...");
			
			service.cadastrar(Mensagem);
			
			Mensagem = new Mensagem();
			
			this.listMensagem = service.listar();
			
			return "indexEMPREGADOR";
		}
	}
	
	
	
	//////////////////////////delete
	
	public String deleteMensagemAction(){
		System.out.println("Deleting...");
		service.excluir(Mensagem);
		
		listMensagem = service.listar();
		
		return "listamensagemEMPREGADOR";
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	///////update
	public String updateMensagemAction(){
		System.out.println("Updating...");
		if(Mensagem.getResposta().equals("Sim")){
			Mensagem.setAtivo(true);
		}else{
			Mensagem.setAtivo(false);
		}
		service.atulizar(Mensagem);
		
		this.listMensagem = service.listar();
		
		
		
		return "listamensagemEMPREGADO";
	}

	////////////////////////////////////////limpar campos
	
	public String limpar(){
		System.out.println("limpando campos...");
	
		Mensagem = new Mensagem();
		
		return "novaMensagemEMPREGADO";
	}
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
	
	///////////////////////////////////////////
	public void atualizar(){
		service = new MensagemService();
		
		Mensagem = new Mensagem();
		
		listMensagem = service.listar();
	}
}
