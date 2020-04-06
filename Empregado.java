package main;

public class Empregado {
	private String Nome;
	private int Idade;
	private char Sexo;
	private String Cargo;
	private String Endr;
	private String Cep;
	private int PacotesPorMes;
	private String PacoteTipo;

	public Empregado(String nome, int idade, char sexo, String cargo, String endr, String cep, int pct,
			String pcttipo) {
		this.Nome = nome;
		this.Idade = idade;
		this.Sexo = sexo;
		this.Cargo = cargo;
		this.Endr = endr;
		this.Cep = cep;
		this.PacotesPorMes = pct;
		this.PacoteTipo = pcttipo;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public int getIdade() {
		return Idade;
	}

	public void setIdade(int idade) {
		Idade = idade;
	}

	public char getSexo() {
		return Sexo;
	}

	public void setSexo(char sexo) {
		Sexo = sexo;
	}

	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
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

	public int getPacotesPorMes() {
		return PacotesPorMes;
	}

	public void setPacotesPorMes(int pacotespormes) {
		PacotesPorMes = pacotespormes;
	}

	public String getPacoteTipo() {
		return PacoteTipo;
	}

	public void setPacoteTipo(String pacoteTipo) {
		PacoteTipo = pacoteTipo;
	}

}
