package Principal;

import java.math.BigDecimal;
import java.util.Arrays;

import excessao.ValidacaoException;
import model.Cargo;
import model.Cpf;
import model.Departamento;
import model.Empreitada;
import model.Funcionario;
import model.StatusCargo;
import model.Terceirizado;
import service.departamento.obra.ControleOrcamentoService;
import service.departamento.obra.OrcamentoDepartamento;
import service.promocao.PromocaoFuncionario;
import service.reajuste.PercentualMaximoReajuste;
import service.reajuste.ReajusteMaximoPeriodico;
import service.reajuste.ReajusteService;

public class Main {

	public static void main(String[] args) throws ValidacaoException {
		
		Departamento ti = new Departamento("Tecnologia Da Informaçaõ", "São Paulo");	
		
		Cpf cpfKleberson = new Cpf("438.036.548-40");
		ti.inserirFuncionario(cpfKleberson, "kleberson", Cargo.BACKEND, StatusCargo.ANALISTA, new BigDecimal("2000"));
				
		Cpf cpfKleber = new Cpf("138.099.447-40");
		ti.inserirFuncionario(cpfKleber, "kleber", Cargo.DATAMODELAR, StatusCargo.ASSISTENTE, new BigDecimal("3500.00"));
		
		
		Funcionario kleberson = ti.getFuncionario().get(0);
		PromocaoFuncionario promocaoFuncionario1 = new PromocaoFuncionario();
		promocaoFuncionario1.promover(kleberson, true);
		
		Funcionario kleber = ti.getFuncionario().get(1);
		PromocaoFuncionario promocaoFncionario2 = new PromocaoFuncionario();
		promocaoFncionario2.promover(kleber, true);
		
		
		PercentualMaximoReajuste percentualMaximoReajuste = new PercentualMaximoReajuste();
		percentualMaximoReajuste.validar(kleberson, new BigDecimal("400"));
		
		ReajusteMaximoPeriodico reajusteMaximoPeriodico = new ReajusteMaximoPeriodico();
		reajusteMaximoPeriodico.validar(kleberson, new BigDecimal("100"));
		
		ReajusteService reajusteServico = new ReajusteService(Arrays.asList(percentualMaximoReajuste
																));
		reajusteServico.reajustarSalario(kleber, new BigDecimal("100"));
		
		OrcamentoDepartamento orcamento = new OrcamentoDepartamento();
		Terceirizado terceiro = new Terceirizado("Hector");
		
		ControleOrcamentoService obra1 = new ControleOrcamentoService(Arrays.asList(orcamento));
		obra1.controleOrcamento(ti, new Empreitada("santos", terceiro, new BigDecimal("200")));
				
		System.out.println(ti.toString());
		System.out.println(ti.getOrcamento());

	}

}
