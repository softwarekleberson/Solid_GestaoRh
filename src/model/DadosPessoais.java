package model;

import java.math.BigDecimal;

import excessao.ValidacaoException;

public class DadosPessoais {

	private static int minimoString = 3;
	
	private Cpf cpf;
	private String nome;
	private Cargo cargo;
	private StatusCargo statusCargo;
	private BigDecimal salario;
	
	public DadosPessoais(Cpf cpf, String nome, Cargo cargo, StatusCargo statusCargo) throws ValidacaoException {
		
		this.cpf = cpf;
		setNome(nome);
		
		this.cargo = cargo;
		this.statusCargo = statusCargo;

	}

	public BigDecimal getSalario() {
		return salario;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public Cpf getCpf() {
		return cpf;
	}

	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws ValidacaoException {
		
		if(nome.length() <= minimoString) {
			throw new ValidacaoException("Nome deve ser maior que 3 caracteres");
		}
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public StatusCargo getStatusCargo() {
		return statusCargo;
	}

	public void setStatusCargo(StatusCargo statusCargo) {
		this.statusCargo = statusCargo;
	}

	@Override
	public String toString() {
		return "DadosPessoais [cpf=" + cpf + ", nome=" + nome + ", cargo=" + cargo + ", statusCargo=" + statusCargo
				+ "]";
	}

	
}
