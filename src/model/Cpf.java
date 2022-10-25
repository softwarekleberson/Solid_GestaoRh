package model;

import excessao.ValidacaoException;

public class Cpf {
	
	private String cpf;

	public Cpf(String cpf) throws ValidacaoException {
		setCpf(cpf);
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) throws ValidacaoException {
		if(cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
			throw new ValidacaoException("Cpf invalido");
		}
		this.cpf = cpf;
	}

	@Override
	public String toString() {
		return "Cpf [cpf=" + cpf + "]";
	}
	
	
}