package service.departamento.obra;

import excessao.ValidacaoException;
import model.Departamento;
import model.Empreitada;

public interface ControleContas {

	void validar(Departamento departamento, Empreitada empreitada) throws ValidacaoException;
}
