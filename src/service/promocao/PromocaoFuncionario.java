package service.promocao;

import java.time.LocalDate;

import excessao.ValidacaoException;
import model.Funcionario;
import model.StatusCargo;

public class PromocaoFuncionario {

	public void promover(Funcionario funcionario, boolean metaBatida) throws ValidacaoException {
		
		StatusCargo statusCargo = funcionario.getStatusCargo();
		
		if(statusCargo == StatusCargo.GERENTE) {
			throw new ValidacaoException("Cargo maximo atingido");
		}
		
		if(metaBatida) {
			
			StatusCargo novoCargo = statusCargo.getProximoCargo();
			LocalDate ultimoReajuste = LocalDate.now();
			funcionario.setUltimoReajuste(ultimoReajuste);
			
			funcionario.promover(novoCargo);
		}
		
		else {
			throw new ValidacaoException("Meta não batida");
		}	
		
	}
}
