package model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import excessao.ValidacaoException;

public class Departamento {
	
	private static int minimoNome = 3;
	
	private List<Funcionario> funcionario = new LinkedList<Funcionario>();
	private List<Empreitada>empreitada = new ArrayList<>();
	
	private String nome;
	private String localizacao;
	private BigDecimal orcamento = new BigDecimal("5000.00");

	public Departamento(String nome, String localizacao) throws ValidacaoException {
		
		setNome(nome);
		setLocalizacao(localizacao);
	}
	
	public void inserirFuncionario(Cpf cpf, String nome, Cargo cargo, StatusCargo statusCargo, BigDecimal salario) throws ValidacaoException{
		this.funcionario.add(new Funcionario(cpf, nome, cargo, statusCargo, salario));
	}
	
	public void empreitada(String cidade, Terceirizado terceirizado,
			BigDecimal valorEmpreitada) throws ValidacaoException { 

		this.empreitada.add(new Empreitada(cidade, terceirizado, valorEmpreitada));
	}
	
	public List<Funcionario> getFuncionario() {
		return funcionario;
	}
	
	public void setFuncionario(List<Funcionario> funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<Empreitada> getEmpreitada() {
		return empreitada;
	}
	
	public void setEmpreitada(List<Empreitada> empreitada) {
		this.empreitada = empreitada;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ValidacaoException {
		
		if(nome.length() <= minimoNome) {
			throw new ValidacaoException("Nome deve ter 3 caracteres ou maios");
		}
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) throws ValidacaoException {
		
		if(localizacao.length() <= minimoNome) {
			throw new ValidacaoException("localiacao deve ter 3 ou maios caracteres");
		}		
		this.localizacao = localizacao;
	}

	public BigDecimal getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
	}

	public void subtrairOrcamentoDepoisDaObra(BigDecimal orcamentoDepoisDaHobra) {
		setOrcamento(orcamentoDepoisDaHobra);
	}

	
	@Override
	public String toString() {
		return "Departamento [funcionario=" + funcionario + ", empreitada=" + empreitada + ", nome=" + nome
				+ ", localizacao=" + localizacao + ", orcamento=" + orcamento + "]";
	}


	
}