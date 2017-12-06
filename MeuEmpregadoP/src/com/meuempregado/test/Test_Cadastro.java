package com.meuempregado.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.meuempregado.bean.ContratoSeguroManagedBean;
import com.meuempregado.bean.MensagemManagedBean;
import com.meuempregado.model.ContratoDemissao;
import com.meuempregado.model.ContratoSeguro;
import com.meuempregado.model.Empregado;
import com.meuempregado.model.Empregador;
import com.meuempregado.model.Mensagem;
import com.meuempregado.service.ContratoSeguroService;
import com.meuempregado.service.EmpregadoService;
import com.meuempregado.service.EmpregadorService;
import com.meuempregado.service.MensagemService;
import com.meuempregado.service.TipoDemissaoService;

public class Test_Cadastro {
	@Test
	public void cadastrarEmpregados(){
		ContratoSeguroService service = new ContratoSeguroService();
		ContratoSeguroManagedBean bean = new ContratoSeguroManagedBean();
		List<ContratoSeguro> list = service.listar();
		
		bean.setContrato(list.get(0));
		bean.imprimir();
	}
}
