package bancoDeHorasDV;

import java.io.IOException;
import java.util.Scanner;

public class mainDv {

	public static void main(String[] args) throws IOException, InterruptedException {
		FuncionarioRepository Fr = new FuncionarioRepository();
		
		System.out.printf(
				   "==================================================\n" +
		           "==========BANCO DE HORAS DIVINA VELAS=============\n" +
		           "==================================================\n"
				);
		String escolha = "";
		Scanner scanner = new Scanner(System.in);
		while(!escolha.equals("5")) {
			escolha = menu(scanner);
			comando(escolha,scanner,Fr);
			try{Thread.sleep(1500);}catch(Exception erro) {}
		}
		
		

	}
	
	public static String menu(Scanner scanner) {
		System.out.printf( "\n1-Registrar horas\n" +
                "2-Ver saldo funcion�rios\n"+
                "3-Adicionar funcionario\n" +
                "4-Remover funcionario\n"+
                "5-Encerrar programa\n" +
                "\nEscolha uma op��o:");
		return scanner.next();
	}
	
	private static void comando(String escolha, Scanner scanner, FuncionarioRepository Fr) throws IOException{
		switch(escolha) {
		case "1":
			registrarHoras(scanner,Fr);
			break;
		case "2":
			verSaldos(scanner,Fr);
			break;
		case "3":
			add(scanner,Fr);
			break;
		case "4":
			remove(scanner,Fr);
			break;
		case "5":
			System.out.printf("Programa encerrado.\n");
			break;
		default:
			System.out.println("Op��o inv�lida!");
		
		}
	}
	
	private static void registrarHoras(Scanner scanner, FuncionarioRepository Fr) throws IOException{
		System.out.println(Fr.todosFuncionarios());
		System.out.println("Qual n�mero do funcion�rio desejado para registro?");
		int posicao = scanner.nextInt();
		System.out.println("Quantas horas quer registrar desse funcion�rio:");
		int horas = scanner.nextInt();
		System.out.println(Fr.alterarHora(posicao-1,horas));
	}
	
	private static void verSaldos(Scanner scanner, FuncionarioRepository Fr) {
		System.out.println(Fr.todosFuncionarios());
		System.out.println("Qual n�mero do funcion�rio desejado ver o saldo?(Para ver de todos, digite 0):");
		int posicao = scanner.nextInt();
		System.out.println(Fr.getSaldo(posicao));
	}
	
	private static void add(Scanner scanner, FuncionarioRepository Fr) throws IOException {
		System.out.println("Qual nome do novo funcion�rio?\n");
		String nome = scanner.next();
		Fr.add(nome);
		System.out.println("Funcion�rio adicionado com sucesso.\n");
	}
	
	private static void remove(Scanner scanner, FuncionarioRepository Fr) throws IOException {
		System.out.println(Fr.todosFuncionarios());
		System.out.println("Qual n�mero do funcion�rio desejado?\n");
		int id = scanner.nextInt();
		Fr.remove(id);
		System.out.println("Funcion�rio removido com sucesso.\n");
	}

}
