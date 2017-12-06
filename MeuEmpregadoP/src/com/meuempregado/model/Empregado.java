package com.meuempregado.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_empregado")
public class Empregado {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String nome;//nomeCompleto
	private Date data_nascimento;//dataNascimento
	private String cpf;
	private String rg;
	private String telefone_fixo;//telefoneFixo
	private String telefone_celular;//telefoneCelular
	
	private String cep;
	private String endereco_rua;//enderecoRua
	private Integer endereco_numero;//enderecoNumero
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;//uf
	
	private Boolean ativo; //true-Ativo false-Inativo
	private Boolean sexo; //true-Masculino false-Feminino
	
	private String descricao;/*atributo para realizar a descrição das funções que o empregado podera realizar e experiências
	*profissionais
	**/
	
	//FAVOR INSERIR PQ SERA NECESSÁRIO NA CONTRATAÇÃO 
	private String email;
	private String senha;
	//Construtor vazio
	public Empregado() {
		
	}
	
	//Construtor para alteração de dados. (Para buscar o registro que vai ser alterado, precisa do id do registro)
	public Empregado(Integer id, String nomeCompleto, Date dataNascimento, String cpf, String rg, String telefoneFixo,
			String telefoneCelular, String cep, String enderecoRua, Integer enderecoNumero, String complemento,
			String bairro, String cidade, String uf, Boolean ativo, Boolean sexo,String descricao,String email,String senha) {
		this.id = id;
		this.nome = nomeCompleto;
		this.data_nascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone_fixo = telefoneFixo;
		this.telefone_celular = telefoneCelular;
		this.cep = cep;
		this.endereco_rua = enderecoRua;
		this.endereco_numero = enderecoNumero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = uf;
		this.ativo = ativo;
		this.sexo = sexo;
		this.descricao = descricao;
		this.email = email;
		this.senha = senha;
	}
	
	/*Construtor para inserir novos Empregados. (Não há necessidade de id por parâmetro, pois a função AUTO INCREMENT 
	*do banco de dados seta automaticamente o id do próximo registro)
	**/
	public Empregado(String nomeCompleto, Date dataNascimento, String cpf, String rg, String telefoneFixo,
			String telefoneCelular, String cep, String enderecoRua, Integer enderecoNumero, String complemento,
			String bairro, String cidade, String uf, Boolean ativo, Boolean sexo, String descricao,String email,String senha) {
		this.nome = nomeCompleto;
		this.data_nascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone_fixo = telefoneFixo;
		this.telefone_celular = telefoneCelular;
		this.cep = cep;
		this.endereco_rua = enderecoRua;
		this.endereco_numero = enderecoNumero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = uf;
		this.ativo = ativo;
		this.sexo = sexo;
		this.descricao = descricao;
		this.email = email;
		this.senha = senha;
	}

	//Método toString
	@Override
	public String toString() {
		return "Empregado [id=" + id + ", nomeCompleto=" + nome + ", dataNascimento=" + data_nascimento
				+ ", cpf=" + cpf + ", rg=" + rg + ", telefoneFixo=" + telefone_fixo + ", telefoneCelular="
				+ telefone_celular + ", cep=" + cep + ", enderecoRua=" + endereco_rua + ", enderecoNumero="
				+ endereco_numero + ", complemento=" + complemento + ", bairro=" + bairro + ", cidade=" + cidade
				+ ", uf=" + estado + ", ativo=" + ativo + ", sexo=" + sexo
				+ ", descricao="+  descricao + "]\n";
	}
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nome;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nome = nomeCompleto;
	}

	public Date getDataNascimento() {
		return data_nascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.data_nascimento = dataNascimento;
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

	public String getTelefoneFixo() {
		return telefone_fixo;
	}

	public void setTelefoneFixo(String telefoneFixo) {
		this.telefone_fixo = telefoneFixo;
	}

	public String getTelefoneCelular() {
		return telefone_celular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefone_celular = telefoneCelular;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEnderecoRua() {
		return endereco_rua;
	}

	public void setEnderecoRua(String enderecoRua) {
		this.endereco_rua = enderecoRua;
	}

	public Integer getEnderecoNumero() {
		return endereco_numero;
	}

	public void setEnderecoNumero(Integer enderecoNumero) {
		this.endereco_numero = enderecoNumero;
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

	public String getUf() {
		return estado;
	}

	public void setUf(String uf) {
		this.estado = uf;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Boolean getSexo() {
		return sexo;
	}

	public void setSexo(Boolean sexo) {
		this.sexo = sexo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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