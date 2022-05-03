package desafioWarren;

import java.util.Scanner; 

public class Desafio2 {
	
public static void main(String[] args) { 
	/** @author Pedro Henrique Romaguera Barbieri	**/
	
	Scanner scan = new Scanner(System.in); 
			
			System.out.println("Digite o número de alunos presentes: \n Tendo mais de 2, a aula ocorrerá!");
			int numAlunos = scan.nextInt();
			System.out.println("Qual a média de atraso dos alunos? \n Sendo menor que 2 min, a aula ocorrerá!");
			int tempoChegada = scan.nextInt();
			
			if (numAlunos >= 2 && tempoChegada <= 2) {	
			System.out.println("Aula normal");
			}else{
				System.out.println("Aula cancelada");
			
		}
	}
}
	