package bancoDeHorasDV;

public class Funcionario {
	private String nome = "";
	private int saldoHoras;
	
	public Funcionario(String nome) {
		this.nome = nome;
		this.saldoHoras = 0;
	}
	
	public Funcionario(String nome, int horas) {
		this.nome = nome;
		this.saldoHoras = horas;
	}
	
	public void setHoras(int horas) {
		this.saldoHoras = horas;
	}
	
	public String getNome() {
		return this.nome;
	}

	public void registrarHoras(int horas) {
		this.saldoHoras+=horas;
		
	}
	
	public int getSaldo() {
		return this.saldoHoras;
	}

}
