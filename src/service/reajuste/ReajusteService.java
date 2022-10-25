package service.reajuste;

import java.math.BigDecimal;
import java.util.List;

import excessao.ValidacaoException;
import model.Departamento;
import model.Funcionario;

public class ReajusteService {

	private List<ValidacoesReajustesFuncionario> validacoes;

	public ReajusteService(List<ValidacoesReajustesFuncionario> validacoes) {
		this.validacoes = validacoes;
	}
	
	public void reajustarSalario(Funcionario funcionario, BigDecimal aumento) {
		this.validacoes.forEach(v -> {
			try {
				v.validar(funcionario, aumento);
			} catch (ValidacaoException e) {
				System.out.println("Funcionario não pode receber reajuste");
				e.printStackTrace();
			}
		});
		
		BigDecimal aumentoSalario = funcionario.getSalario().add(aumento);
		funcionario.atualizarSalario(aumentoSalario);
		
		
	}
	
}
