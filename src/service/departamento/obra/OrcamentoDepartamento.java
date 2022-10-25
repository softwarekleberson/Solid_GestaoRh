package service.departamento.obra;

import java.math.BigDecimal;

import excessao.ValidacaoException;
import model.Departamento;
import model.Empreitada;

public class OrcamentoDepartamento implements ControleContas {

		@Override
		public void validar(Departamento departamento, Empreitada empreitada) throws ValidacaoException {
		
		BigDecimal orcamentoDepartamento = departamento.getOrcamento();
		BigDecimal empreitadaOrcamento = empreitada.getValorEmpreitada();
		
		if(empreitadaOrcamento.compareTo(orcamentoDepartamento) == 1) {
			throw new ValidacaoException("Orcamento do departamento, inferior ao necessario para obra");
		}
		
	}

}


