package service.departamento.obra;

import java.math.BigDecimal;
import java.util.List;

import excessao.ValidacaoException;
import model.Departamento;
import model.Empreitada;

public class ControleOrcamentoService {
	
	private List <ControleContas> controleContasDepartamentoObras;
	
	
	public ControleOrcamentoService(List<ControleContas> controleContasDepartamentoObras) {	
		this.controleContasDepartamentoObras = controleContasDepartamentoObras;
	}
	
	
	public void controleOrcamento(Departamento departamento, Empreitada empreitada) {
		this.controleContasDepartamentoObras.forEach(v -> {
			
			try {
				v.validar(departamento, empreitada);
				
			} catch (ValidacaoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		BigDecimal orcamentoAtual = departamento.getOrcamento();
		BigDecimal valorDaEmpreitada = empreitada.getValorEmpreitada();
		BigDecimal orcamentoDepoisDaHobra = orcamentoAtual.subtract(valorDaEmpreitada);
		
		departamento.subtrairOrcamentoDepoisDaObra(orcamentoDepoisDaHobra);
		
	}
}
