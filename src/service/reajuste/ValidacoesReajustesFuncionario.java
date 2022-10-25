package service.reajuste;

import java.math.BigDecimal;

import excessao.ValidacaoException;
import model.Funcionario;

public interface ValidacoesReajustesFuncionario {

	void validar(Funcionario funcionario, BigDecimal aumento) throws ValidacaoException;
}
