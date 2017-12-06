package com.meuempregado.bean;

import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.meuempregado.model.ContratoDemissao;
import com.meuempregado.model.Mensagem;
import com.meuempregado.service.MensagemService;
import com.meuempregado.service.TipoDemissaoService;




@ManagedBean(name = "DemissaoBean")
@SessionScoped

public class DemissaoBean implements Serializable {

	private static final long serialVersionUID = -5852851847769851291L;
	
	private TipoDemissaoService demissaoS ;
	private ContratoDemissao contratodemissao;
	private Mensagem mensagem;
	private MensagemService mgmservice;
	
	
	public DemissaoBean() throws SQLException{
		mensagem = new Mensagem();
		demissaoS = new TipoDemissaoService();
		contratodemissao = new ContratoDemissao(null, "", 0, 0, 0, 0, "", "", "");
		mgmservice = new MensagemService();
	}
	public String ObterDadosAction(){
		contratodemissao.setSaldosalario(mensagem.getSalario());
		
		return "telaDemissao";
	}
	public String CalculoDemissaoAction() {
			
		contratodemissao.setTotal(demissaoS.tipoDemisao(mensagem.getSalario(), contratodemissao.getDiastrabalhados(), contratodemissao.getAvisotrabalhado(), contratodemissao.getFeriasvencida(), mensagem.getData(), contratodemissao.getDatademissao(), contratodemissao.getTipodemissao()));
	
		return "telaDemissao";
	}
	public String salvarDemissaoAction(){
		demissaoS.cadastrar(contratodemissao);
		mgmservice.excluir(mensagem);
		return "listamensagemEMPREGADOR";
	}
	public ContratoDemissao getContratodemissao() {
		return contratodemissao;
	}

	public void setContratodemissao(ContratoDemissao contratodemissao) {
		this.contratodemissao = contratodemissao;
	}

	public TipoDemissaoService getDemissaoS() {
		return demissaoS;
	}

	public void setDemissaoS(TipoDemissaoService demissaoS) {
		this.demissaoS = demissaoS;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
}
