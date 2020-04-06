package main;

import java.util.*;

public class Compania {
	private String Nome, Atuacao;
	private String Cnpj;
	private String Endr;
	private String Cep;
	private List<Empregado> Empregados = new ArrayList<>();

	public Compania(String nome, String atuacao, String cnpj, String endr, String cep) {
		if (nome != null && atuacao != null) {
			this.Nome = nome.toUpperCase();
			this.Atuacao = atuacao.toUpperCase();
			this.Cnpj = cnpj;
			this.Endr = endr;
			this.Cep = cep;
		}
	}

	public boolean adicionarEmpregado(String nomeEmpregado, int idadeEmpregado, char sexoEmpregado,
			String cargoEmpregado, String endrEmpregado, String cepEmpregado, int pctMesEmpregado,
			String pctTipoEmpregado) {

		try {

			Empregados.add(new Empregado(nomeEmpregado, idadeEmpregado, sexoEmpregado, cargoEmpregado, endrEmpregado,
					cepEmpregado, pctMesEmpregado, "A4"));

		} catch (Exception ex) {

			return false;
		}

		return true;
	}

	public boolean removerEmpregado(int index) {

		try {
			Empregados.remove(index);

		} catch (Exception e) {
			return false;

		}

		return true;
	}

	public float mediaAnoArvoresDesmatadas() {
		if (Empregados.size() > 0) {
			int quantPacotesTotal = 0;
			float quantArvoresMes = 0.00f;
			float quantArvoresAno = 0.00f;

			// Empregados.forEach(empregado -> empregado.getPacotesPorMes());
			for (int empregadoIndex = 0; empregadoIndex < Empregados.size(); empregadoIndex++) {
				quantPacotesTotal += Empregados.get(empregadoIndex).getPacotesPorMes();
			}

			quantArvoresMes = ((float) (quantPacotesTotal * 500) / 10000);
			quantArvoresAno = ((float) quantArvoresMes * 12);

			return quantArvoresAno;

		} else
			return 0.00f;

	}

	/*
	 * Artigo da pagina:
	 * https://www.pensamentoverde.com.br/meio-ambiente/afinal-quantas-arvores-sao-
	 * necessarias-para-produzir-uma-folha-de-papel/
	 * 
	 * Considere que uma árvore padrão na produção de papel, que é o eucalipto, é
	 * capaz de produzir 20 resmas de papel. Como cada resma possui 500 folhas, 20
	 * resmas possuem 10 mil folhas tamanho A4 de 75 g/m2 de gramatura por tronco.
	 * Se uma árvore é capaz de dar vida a 10 mil dessas folhas, isso significa que
	 * para produzir uma folha de papel é necessário 1/10.000 de árvore.
	 */

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getAtuacao() {
		return Atuacao;
	}

	public void setAtuacao(String atuacao) {
		Atuacao = atuacao;
	}

	public String getCnpj() {
		return Cnpj;
	}

	public void setCnpj(String cnpj) {
		Cnpj = cnpj;
	}

	public String getEndr() {
		return Endr;
	}

	public void setEndr(String endr) {
		Endr = endr;
	}

	public String getCep() {
		return Cep;
	}

	public void setCep(String cep) {
		Cep = cep;
	}

	public List<Empregado> getEmpregados() {
		return Empregados;
	}

	public void setEmpregados(List<Empregado> empregados) {
		Empregados = empregados;
	}

}
