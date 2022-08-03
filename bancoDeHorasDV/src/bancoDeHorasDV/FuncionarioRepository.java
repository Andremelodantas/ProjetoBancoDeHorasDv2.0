package bancoDeHorasDV;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepository {
	
	private List<Funcionario> listaFuncionarios;
	public Funcionario Funcionario;
	private File BD = new File("bancoDeHoras.txt");
	
	public FuncionarioRepository() throws IOException {
		this.listaFuncionarios = new ArrayList<Funcionario>();
		/*
		 * ADIÇAO MANUAL. OBSOLETA
		 * this.Funcionario = new Funcionario("Andrezinho");
		this.listaFuncionarios.add(Funcionario);
		
		this.Funcionario = new Funcionario("Vaqueiro");
		this.listaFuncionarios.add(Funcionario);
		this.Funcionario = new Funcionario("Janaina");
		this.listaFuncionarios.add(Funcionario);
		this.Funcionario = new Funcionario("Fabricio");
		this.listaFuncionarios.add(Funcionario);*/
		// LER UM ARQUIVO E ADICIONAR TODOS OS FUNCIONARIOS PERTENCENTES NELE
		lerBancoDeDados();
		
		
	}
	
	public void lerBancoDeDados() throws IOException {
		FileReader FileReade = new FileReader(BD);
		BufferedReader buffRead = new BufferedReader(FileReade);
		String linha = buffRead.readLine();
		while (true) {
			if (linha != null) {
				//System.out.println(linha);
				String [] dados = linha.split(" ");
				this.Funcionario = new Funcionario(dados[0],Integer.parseInt(dados[1]));
				this.listaFuncionarios.add(Funcionario);
			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
	}
	
	public void armazenarBD() throws IOException{
		if(this.listaFuncionarios.size()==0)return;
		FileWriter FileWriter = new FileWriter(BD);
		BufferedWriter escrever = new BufferedWriter(FileWriter);
		escrever.write(this.listaFuncionarios.get(0).getNome() + " " + this.listaFuncionarios.get(0).getSaldo() + "");
		escrever.newLine();
		int n = 1;
		while(n<this.listaFuncionarios.size()) {
			escrever.append(this.listaFuncionarios.get(n).getNome() + " " + this.listaFuncionarios.get(n).getSaldo() + "\r");
			n++;
		}
		
		escrever.close();
	}
	
	public String todosFuncionarios(){
		String retorno = "Lista de funcionários:\n";
		for(int i = 0; i < this.listaFuncionarios.size(); i++) {
			retorno += i+1 + "- " + this.listaFuncionarios.get(i).getNome() + ".\n";
			
		}
		return retorno;
		
	}

	public String alterarHora(int posicao, int horas) throws IOException {
		if(posicao<0 || posicao>this.listaFuncionarios.size()) {
			return "número do funcionário invalido.";
		}
		this.listaFuncionarios.get(posicao).registrarHoras(horas);
		armazenarBD();
		return "Registro feito com sucesso.\n";
		
	}
	
	public String getSaldo(int posicao) {
		if(posicao<0 || posicao>this.listaFuncionarios.size()) {
			return "número do funcionário invalido.";
		}
		else if(posicao == 0) {
			String retorno = "Lista de funcionários:\n";
			for(int i = 0; i < this.listaFuncionarios.size(); i++) {
				retorno += i+1 + "- " + this.listaFuncionarios.get(i).getNome() + " - "+this.listaFuncionarios.get(i).getSaldo() +" horas.\n";
				
			}
			return retorno;
		}
		return this.listaFuncionarios.get(posicao-1).getNome() + " - " + this.listaFuncionarios.get(posicao-1).getSaldo() +" horas.\n";
	}
	
	public void setHoras(int id, int horas) {
		this.listaFuncionarios.get(id).setHoras(horas);
		
	}
	
	public void remove(int id) throws IOException {
		this.listaFuncionarios.remove(id-1);
		armazenarBD();
	}
	
	public void add(String nome) throws IOException {
		this.Funcionario = new Funcionario(nome);
		this.listaFuncionarios.add(Funcionario);
		armazenarBD();
	}
	
	
	

}
