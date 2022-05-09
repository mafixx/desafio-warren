package br.com.pedroromaguera;

import java.util.Arrays;

/**
 *
 * @author Pedro
 */
public class Desafio03 {
    public static void main(String[] args) {
        int n = 10;
        
        //int n = 15;
        
        //int n = 16;
        
        //int n = 100;
       
        //int n = 101;
        
        //int n = 35;
        
        //int n = 36;
        
        //int n = 23;
        
        int[] v1= {2, 3, 4};
        
        int[] v1a= {2, 4, 4};
        
        int[] v1b= {3, 3, 4};
        
        int[] v2 = {5, 3, 4};
        
        int[] v3 = {7, 3, 4, 5};
        
        System.out.println(somaEsperta(n, v1));
        
        System.out.println(somaEsperta(n, v1a));
        
        System.out.println(somaEsperta(n, v1b));
        
        System.out.println(somaEsperta(n, v2));
        
        System.out.println(somaEsperta(n, v3));
    }
    
    private static String somaEsperta(int numero, int[] vetorNumeros) {
        String strRetorno = "";
        
        Object[] intVetoresValidos = {};
        
        int intVetoresValidosContagem = 0;
        
        int[] intVetorAdiciona = {};
                
        int intSoma = 0;
        
        boolean blnSomado = false;
        
        int intNumeroAtual = 0;
        
        int intDivisaoNumeros = 0;
        
        Arrays.sort(vetorNumeros);
        
        int intSomaNumeroLivre = 0;
        
        int intVetorNumerosIndiceDecrescente = vetorNumeros.length;
        
        int intVetorNumerosIndiceDecrescente2 = 0;
        
        int intOutroNumero = 0;
        
        int intDiferencaSomaNumero = 0;
        
        // Object[] intVetorEstudo = {};
        
        strRetorno = "\n\nVETOR ENVIADO: " + Arrays.toString(vetorNumeros) + " PARA ENCONTRAR O NÚMERO: " + numero + ". RESULTADOS:\n\n";
        
        for (int i = 0; i < vetorNumeros.length; i++) {
            // intVetorNumerosIndiceDecrescente = i != 0 ? vetorNumeros.length - i : vetorNumeros.length - 1;
            // intVetorNumerosIndiceDecrescente = i != 0 ? vetorNumeros.length - i : vetorNumeros.length - i;
            // intVetorNumerosIndiceDecrescente = vetorNumeros.length - i;
            
            intVetorNumerosIndiceDecrescente--;
            
            if (intVetorNumerosIndiceDecrescente >= vetorNumeros.length) continue;
            
            if (intVetorNumerosIndiceDecrescente < 0) continue; // Atingiu valor menor que zero. Não tenta mais acessar o vetor.
            
            // if (intVetorNumerosIndiceDecrescente == 0) System.out.println("Índice decrescente do vetor atingiu valor: " + intVetorNumerosIndiceDecrescente);
            
            intNumeroAtual = vetorNumeros[intVetorNumerosIndiceDecrescente];
            intDivisaoNumeros = numero / intNumeroAtual; // Assume-se sempre que intNumeroAtual < numero (ou criar regra pra isso?)
            
            // 1º Método de encontrar o número
            // Descobre se o número pode ser atingido apenas somando os mesmos números do vetor, independente do número de vezes
            boolean blnSomaMesmoNumero = intDivisaoNumeros != 0;
            
            // strRetorno += "\n\n---Estudando uso do número " + vetorNumeros[intVetorNumerosIndiceDecrescente] + " de índice decrescente " + intVetorNumerosIndiceDecrescente + " no loop.---\n\n";
            
            if (blnSomaMesmoNumero)
            {
                if (intDivisaoNumeros * intNumeroAtual == numero)
                {
                    blnSomado = true;

                    // strRetorno += "Soma atingiu " + numero + " apenas somando o mesmo número do item " + intVetorNumerosIndiceDecrescente + ", " + intDivisaoNumeros + " vezes, que é = " + intNumeroAtual + "\n\n";
                	
                    intVetorAdiciona = new int[intDivisaoNumeros];
                    
                    for (int iT = 0; iT < intDivisaoNumeros; iT++) {
                    	intVetorAdiciona[iT] = intNumeroAtual;
                    }
                    
                    intVetoresValidosContagem++;
                    
                    intVetoresValidos = adicionaItemVetor(intVetoresValidos, intVetorAdiciona);
                    
                    /*if (intVetoresValidos.length == 0) intVetoresValidos = new Object[intVetoresValidosContagem];
                    
                    for (int iT = 0; iT < intVetoresValidosContagem; iT++) {
                        int intIndiceUltimoVetorValido;
                        
                        intIndiceUltimoVetorValido = intVetoresValidos.length == 0 ? 0 : intVetoresValidos.length + 1;
                        
                        intVetoresValidos[intIndiceUltimoVetorValido] = intVetorAdiciona;
                    }*/
                    
                    //break;
                }
                else
                {
                    // Armazena esta diferença e a procura no vetor enviado.
                    // Se não foi encontrado com a soma do mesmo número, deve-se verificar se pode ser encontrado
                    // Com a soma de um número do vetor enviado. Mas somente se a diferença for menor que o número alvo.
                    intDiferencaSomaNumero = numero - intDivisaoNumeros * intNumeroAtual;
                    
                    if (intDiferencaSomaNumero < numero) {
                        intVetorAdiciona = new int[intDivisaoNumeros + 1];

                        for (int iT = 0; iT < intDivisaoNumeros + 1; iT++) {
                            intVetorAdiciona[iT] = intNumeroAtual;
                        }
                        
                        for (int iT = 0; iT < vetorNumeros.length; iT++) {
                            if (vetorNumeros[iT] == intDiferencaSomaNumero) {
                                intVetoresValidosContagem++;
                                
                                intVetorAdiciona[intDivisaoNumeros] = intDiferencaSomaNumero;
                                // Número da diferença entre a soma dos elementos encontrado.
                                // Vetor de estudo agora pode ser transformado em vetor de vetor válido.
                                intVetoresValidos = adicionaItemVetor(intVetoresValidos, intVetorAdiciona);
                                
                                break; // Sai do loop, pois já encontrou a soma.
                            }
                        }
                    }
                }
            }
            
            // xº Método de encontrar a soma
            // Soma o número atual com todos os outros números do vetor e vê qual a distância (diferença) para alcançar {numero} ou
            // se ele foi atingido por exato com a soma (soma de dois números é sempre a melhor opção, pois é a operação mínima para soma.
            // Caso não haja nenhuma soma com dois números do vetor, aí, sim, tentar encontrar com 3, 4, etc...
            // (PODE SER QUE ESTA SEJA A ÚNICA FÓRMULA NECESSÁRIA, MAS DEVE DAR SUPORTE A SOMA DE MAIS DE DOIS NÚMEROS QUE NÃO SEJAM OS MESMOS)
            for (int iD = 0; iD < vetorNumeros.length; iD++) {
                // intVetorNumerosIndiceDecrescente2 = iD == 0 || iD == 1 ? intVetorNumerosIndiceDecrescente - 1 : intVetorNumerosIndiceDecrescente - iD;
                intVetorNumerosIndiceDecrescente2 = intVetorNumerosIndiceDecrescente - iD;
                
                if (intVetorNumerosIndiceDecrescente2 < 0 || intVetorNumerosIndiceDecrescente == 0) break; // Significa que ultrapassou o menor número do vetor (índice menor que 0)
                
                // System.out.println("O NÚMERO ATUAL É: " + intNumeroAtual + ". O OUTRO NÚMERO É: " + vetorNumeros[intVetorNumerosIndiceDecrescente2] + "\n");
                
                if (intVetorNumerosIndiceDecrescente2 != intVetorNumerosIndiceDecrescente) {

                    intOutroNumero = vetorNumeros[intVetorNumerosIndiceDecrescente2];

                    intSomaNumeroLivre = intNumeroAtual + intOutroNumero;

                    if (intSomaNumeroLivre == numero) {
                        intVetoresValidosContagem++;

                        intVetorAdiciona = new int[2];

                        intVetorAdiciona[0] = intNumeroAtual;
                        intVetorAdiciona[1] = intOutroNumero;
                        
                        intVetoresValidos = adicionaItemVetor(intVetoresValidos, intVetorAdiciona);
                        
                        /*if (intVetoresValidos.length == 0) 
                        {
                            intVetoresValidos = new Object[intVetoresValidosContagem];
                            
                            intVetoresValidos[0] = intVetorAdiciona;
                        } else {
                            
                            intVetoresValidos[intVetoresValidos.length] = intVetorAdiciona;
                        }*/
                    }
                    else
                    {
                        // Armazena esta diferença e a procura no vetor enviado.
                        // Se não foi encontrado com a soma do mesmo número, deve-se verificar se pode ser encontrado
                        // Com a soma de um número do vetor enviado. Mas somente se a diferença for menor que o número alvo.
                        if (numero > intSomaNumeroLivre) intDiferencaSomaNumero = numero - intSomaNumeroLivre;
                        else intDiferencaSomaNumero = intSomaNumeroLivre - numero;
                        
                        if (intDiferencaSomaNumero < numero) {
                            intVetorAdiciona = new int[3];

                            intVetorAdiciona[0] = intNumeroAtual;
                            intVetorAdiciona[1] = intOutroNumero;

                            for (int iT = 0; iT < vetorNumeros.length; iT++) {
                                if (vetorNumeros[iT] == intDiferencaSomaNumero) {
                                    intVetoresValidosContagem++;
                                    // Número da diferença entre a soma dos elementos encontrado.
                                    intVetorAdiciona[2] = vetorNumeros[iT];
                                    
                                    intVetoresValidos = adicionaItemVetor(intVetoresValidos, intVetorAdiciona);
                                    
                                    break; // Sai do loop, pois já encontrou a soma.
                                }
                            }
                        }
                    }
                }
            }
            
            // 2º Método de encontrar a soma
            // Verificar qual a diferença entre o {numero} e o maior número do vetor que seja menor que o {numero}
            // Então verifica se algum dos outros números do vetor somado a ele pode encontrar {numero} de forma exata ou aproximá-lo de {numero}
            // Armazena este vetor de números para correspondência por aproximação
            
            // 3º Método de encontrar a soma
            // Vê se a soma dos mesmos números no vetor é menor que numero enviado, se for, registra o vetor e o armazena para possível
            // correspondência por aproximação, mesmo que com uma quantidade maior de números no vetor para atingir o {numero}
            // if (intMesmo)
            
            /*for (int iA = 0; iA == numero; iA += iA) {
                
            }
            
            intSoma += vetorNumeros[i];
            
            if (intSoma < numero) {
                blnSomado = false;
                
                continue;
            } else if (intSoma == numero) {
                blnSomado = true;
                
                strRetorno = "Soma atingiu " + numero + " apenas somando os mesmos números do item " + vetorNumeros[i];
                
                break;
            }*/
        }
        
        int intIndiceEncontrado = 0, intMenorIndiceEncontrado = 0, intMaiorIndiceEncontrado = 0;
        
        String strSomaResultado;
        
        if (intVetoresValidos.length > 0 ) {
            // Arrays.sort(intVetoresValidos);
            
            strRetorno += "VETORES VÁLIDOS:\n\n";
            
            for (int iB = 0; iB < intVetoresValidos.length; iB++)
            {
                int[] intVetorValidoLeitor = (int[]) intVetoresValidos[iB];
                
                // Arrays.sort(intVetorValidoLeitor);
                
                if (intIndiceEncontrado == 0) {
                    intIndiceEncontrado = intVetorValidoLeitor.length;
                } else {
                    // Não exibe vetor, pois o índice deste novo vetor é maior do que o encontrado anteriormente, logo esta soma usa mais números
                    if (intIndiceEncontrado < intVetorValidoLeitor.length) {
                         intMaiorIndiceEncontrado = intVetorValidoLeitor.length;
                    } else {
                        intMenorIndiceEncontrado = intVetorValidoLeitor.length;
                    }
                }
                
                if (intMenorIndiceEncontrado == 0) intMenorIndiceEncontrado = intIndiceEncontrado;
                if (intMaiorIndiceEncontrado == 0) intMaiorIndiceEncontrado = intIndiceEncontrado;
                
                // Só exibe vetores com as menores somas
                if (intVetorValidoLeitor.length == intMenorIndiceEncontrado) {
                    strRetorno += "VETOR DE SOMA ***VÁLIDO*** ENCONTRADO DE Nº " + (iB+1) + ":\n";
                    
                    for (int iC = 0; iC < intVetorValidoLeitor.length; iC++) {
                        strRetorno += intVetorValidoLeitor[iC] + " + ";
                    }
                }
                /*else {
                    strRetorno += "VETOR DE SOMA ///INVÁLIDO (USA MAIS NÚMEROS QUE OS VETORES ANTERIORES)/// ENCONTRADO DE Nº " + (iB+1) + ":\n";
                    
                    for (int iC = 0; iC < intVetorValidoLeitor.length; iC++) {
                        strRetorno += intVetorValidoLeitor[iC] + " + ";
                    }
                }*/
                
                strSomaResultado = " = " + numero;
                
                strRetorno = strRetorno.substring(0, strRetorno.length() - 2);
                
                strRetorno = strRetorno.concat(strSomaResultado).replace(strSomaResultado + strSomaResultado, strSomaResultado);
                
                strRetorno += "\n\n";
            }
        }
        
        strRetorno += "MENOR ÍNDICE ENCONTRADO: " + intMenorIndiceEncontrado + ". MAIOR ÍNDICE ENCONTRADO: " + intMaiorIndiceEncontrado + "\n";
        strRetorno += "========================================================================================";
        
        return strRetorno;
    }
    
    private static Object[] adicionaItemVetor(Object[] objetoVetor, int[] objetoItem)
    {
        Object[] objRetorno = {};
        
        Object[] objNovo = {};
        
        boolean blnVetorExistente = false;
        
        for (int i = 0; i < objetoVetor.length; i++) {
            int[] intVetorProcura = (int[]) objetoVetor[i];
            
            Arrays.sort(intVetorProcura); 
            
            Arrays.sort(objetoItem);
            
            if (Arrays.equals(objetoItem, intVetorProcura)) 
            {
                blnVetorExistente = true;
                
                break;
            }
        }
        
        if (!blnVetorExistente) {
            int intNovoIndice = objetoVetor.length + 1;

            objNovo = new Object[intNovoIndice];

            for (int i = 0; i < objetoVetor.length; i++) {
                objNovo[i] = objetoVetor[i];
            }

            if (intNovoIndice > 1) {
                objNovo[intNovoIndice - 1] = objetoItem;
            } else {
                objNovo[0] = objetoItem;
            }

            objRetorno = objNovo;
        }
        else
        {
            objRetorno = objetoVetor;
        }
        
        return objRetorno;
    }
}
