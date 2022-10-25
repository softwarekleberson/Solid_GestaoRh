package model;
import java.math.BigDecimal;
import java.time.LocalDate;

import excessao.ValidacaoException;

public class Funcionario {
	
	private DadosPessoais dadosPessoais;
	private LocalDate admissao;
	private LocalDate ultimoReajuste;
	private BigDecimal salario;
	
	
	public Funcionario(Cpf cpf, String nome, Cargo cargo, StatusCargo statusCargo, BigDecimal salario) throws ValidacaoException {
		
		this.dadosPessoais = new DadosPessoais(cpf, nome, cargo, statusCargo);
		this.admissao = LocalDate.now();
		
		setSalario(salario);
		
	}

	public StatusCargo getStatusCargo() {
		return dadosPessoais.getStatusCargo();
	}
	

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public LocalDate getAdmissao() {
		return admissao;
	}

	public void setAdmissao(LocalDate admissao) {
		this.admissao = admissao;
	}

	public LocalDate getUltimoReajuste() {
		return ultimoReajuste;
	}

	public void setUltimoReajuste(LocalDate ultimoReajuste) {
		this.ultimoReajuste = ultimoReajuste;
	}	

	public BigDecimal getSalario() {
		return salario;
	}
	
	public void setSalario(BigDecimal salario) throws ValidacaoException {
		BigDecimal salarioMinimo = new BigDecimal("1.100");
		
		if(!(salario.compareTo(salarioMinimo) == 1)) {
			throw new ValidacaoException("Salario deve ser maior que o minimo");
		}
		this.salario = salario;
	}
	
	@Override
	public String toString() {
		return "Funcionario [dadosPessoais=" + dadosPessoais + ", admissao=" + admissao + ", ultimoReajuste="
				+ ultimoReajuste + ", salario=" + salario + "]";
	}

	public void promover(StatusCargo novoCargo) {
		this.dadosPessoais.setStatusCargo(novoCargo);		
	}

	public void atualizarSalario(BigDecimal aumentoSalario) {
		this.dadosPessoais.setSalario(aumentoSalario);
		this.ultimoReajuste = LocalDate.now();
		
	}
	
	
}
