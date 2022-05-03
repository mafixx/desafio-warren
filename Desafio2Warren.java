package desafioWarren;

public class Desafio2Warren {

	public static void main(String[] args) {
		/** @author Pedro Henrique Romaguera Barbieri	**/
		
		int x = 3;
		int tempoChegada[] = {-4, -5, 2, 3, 4, 5, 1, 6, 7, 8, 11};
        int tempoChegada2[] = {-2, 0, 1, 1, 2, -1}; 
        
        boolean temAula = temAula(x, tempoChegada);
        
        System.out.println(temAula ? "\n***Tem aula.***\n" : "\n***Não tem aula.***\n");
        
        temAula = temAula(x, tempoChegada2);
        
        System.out.println(temAula ? "\n***Tem aula.***\n" : "\n***Não tem aula.****\n");
    }
    
    private static boolean temAula(int alunosMinimo, int alunosHorarios[])
    {
        boolean blnRetorno = false;
        
        int intAlunoChegada;
        
        int intTotalAlunosValidos = 0;
        
        int intTotalAlunosInvalidos = 0;
        
        int intReal = 0;
        
        for (int i = 0; i < alunosHorarios.length; i++)
        {
            intReal++;
            
            intAlunoChegada = alunosHorarios[i];
            
            if (intAlunoChegada <= 0)
            {
                intTotalAlunosValidos++;
                
                System.out.println("A chegada do aluno (" + intReal + ") do vetor é VÁLIDA: " + intAlunoChegada + " (TOTAL DE " + intTotalAlunosValidos + " ALUNOS VÁLIDOS)");
            }
            else
            {
                intTotalAlunosInvalidos++;
                
                System.out.println("A chegada do aluno (" + intReal + ") do vetor é INVÁLIDA: " + intAlunoChegada + " (TOTAL DE " + intTotalAlunosInvalidos + " ALUNOS INVÁLIDOS)");
            }
        }
        
        if (intTotalAlunosValidos >= alunosMinimo)
        {
            blnRetorno = true;
        }
        else
        {
            blnRetorno = false;
        }
        
        return blnRetorno;
    }


	}


