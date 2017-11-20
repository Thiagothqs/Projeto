package com.meuempregado.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_empregado")
public class Empregado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String data_nascimento;
	private String cpf;
	private String rg;
	private String telefone_fixo;
	private String telefone_celular;
	private String cep;
	private String endereco_rua;
	private String endereco_numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private String email;
	private String senha;
	private String sexo;
	private String descricao;
	
	private boolean ativo;
	
	public Empregado(Integer id, String nome, String data_nascimento, String cpf, String rg, String telefone_fixo,
			String telefone_celular, String cep, String endereco_rua, String endereco_numero, String complemento,
			String bairro, String cidade, String estado, String email, String senha, String sexo,String descricao, boolean ativo) {
		//this.id = id;
		this.nome = nome;
		this.data_nascimento = data_nascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone_fixo = telefone_fixo;
		this.telefone_celular = telefone_celular;
		this.cep = cep;
		this.endereco_rua = endereco_rua;
		this.endereco_numero = endereco_numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.email = email;
		this.senha = senha;
		this.sexo = sexo;
		this.descricao=descricao;
		this.ativo = ativo;
	}
	
	public Empregado(){
		
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getData_nascimento() {
		return data_nascimento;
	}
	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getTelefone_fixo() {
		return telefone_fixo;
	}
	public void setTelefone_fixo(String telefone_fixo) {
		this.telefone_fixo = telefone_fixo;
	}
	public String getTelefone_celular() {
		return telefone_celular;
	}
	public void setTelefone_celular(String telefone_celular) {
		this.telefone_celular = telefone_celular;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco_rua() {
		return endereco_rua;
	}
	public void setEndereco_rua(String endereco_rua) {
		this.endereco_rua = endereco_rua;
	}
	public String getEndereco_numero() {
		return endereco_numero;
	}
	public void setEndereco_numero(String endereco_numero) {
		this.endereco_numero = endereco_numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
}
