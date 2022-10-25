package model;

import java.math.BigDecimal;

import excessao.ValidacaoException;

public class Empreitada extends LocalizacaoEmpreitada {
	
	private String nomeEmpresa;
	private BigDecimal valorEmpreitada;
	

	public Empreitada(String cidade, Terceirizado terceirizado,
			BigDecimal valorEmpreitada) throws ValidacaoException {
		
		super(cidade);
		
		this.valorEmpreitada = valorEmpreitada;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public BigDecimal getValorEmpreitada() {
		return valorEmpreitada;
	}

	public void setValorEmpreitada(BigDecimal valorEmpreitada) {
		this.valorEmpreitada = valorEmpreitada;
	}
	
}
