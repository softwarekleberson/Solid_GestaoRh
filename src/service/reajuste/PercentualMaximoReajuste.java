package service.reajuste;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import excessao.ValidacaoException;
import model.Funcionario;

public class PercentualMaximoReajuste implements ValidacoesReajustesFuncionario{

	@Override
	public void validar(Funcionario funcionario, BigDecimal aumento) throws ValidacaoException {
		BigDecimal salarioAtual = funcionario.getSalario();
		BigDecimal percentual = aumento.divide(salarioAtual, RoundingMode.HALF_UP);
		
		if(percentual.compareTo(new BigDecimal("0.40")) > 0){
			throw new ValidacaoException("Aumento superior a 40 % não podem ocorrer");
		}
		
	}

}
