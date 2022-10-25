package model;

import excessao.ValidacaoException;

public abstract class LocalizacaoEmpreitada {

	private static int minimoString = 3;
	private static int valorMinimoNumero = 1;

	
	private String cidade;
	private String rua;
	private int numero;
	private String cep;
	
	public LocalizacaoEmpreitada(String cidade) throws ValidacaoException {
		
		setCidade(cidade);		
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) throws ValidacaoException {
		
		if(cidade.length() < minimoString) {
			throw new ValidacaoException("Cidade deve conter 3 ou mais caracteres");
		}
		
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) throws ValidacaoException {
		if(rua.length() < minimoString) {
			throw new ValidacaoException("Rua deve ter no minimo 3 caracteres");
		}
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numro) throws ValidacaoException {
		if(numero < valorMinimoNumero) {
			throw new ValidacaoException("numero deve ser maior que 0");
		}
		this.numero = numro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) throws ValidacaoException {
		if(cep == null || !cep.matches("/^[0-9]{5}-[0-9]{3}$/")) {
			throw new ValidacaoException("cep invalido");
		}
		this.cep = cep;
	}
	
	
}
