package service.reajuste;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import excessao.ValidacaoException;
import model.Funcionario;

public class ReajusteMaximoPeriodico implements ValidacoesReajustesFuncionario {

	@Override
	public void validar(Funcionario funcionario, BigDecimal aumento) throws ValidacaoException  {
		
		LocalDate dataUltimoReajuste = funcionario.getUltimoReajuste();
		LocalDate dataAtual = LocalDate.now();
				
		if(dataUltimoReajuste == null) {
			throw new ValidacaoException("Não houve reajuste");
		}
		
		long mesesDesdeUltimoReajuste = ChronoUnit.MONTHS.between(dataUltimoReajuste, dataAtual);
		
		if(mesesDesdeUltimoReajuste < 8) {
			throw new ValidacaoException("Para ter um reajuste é necessario mais de 8 meses");
		}
			
	}

}
