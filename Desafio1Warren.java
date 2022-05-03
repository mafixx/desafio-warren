package desafioWarren;

public class Desafio1Warren {

	public static void main(String[] args) {
		/** @author Pedro Henrique Romaguera Barbieri	**/
		
		        // Imprime verdadeiro
		        System.out.println(imparDetectado(21349));

		        // Imprime verdadeiro
		        System.out.println(imparDetectado(333));

		        // Imprime falso
		        System.out.println(imparDetectado(2126));

		        // Reverter número
		        // System.out.println(reveterNumero(123456789));
		        
		        // Imprime listagem de números abaixo de 1000 - mil
		        // System.out.println(listarSomaNReversoImpares(1000));

		        // Imprime listagem de números abaixo de 1000000 - 1 milhão
		        System.out.println(listarSomaNReversoImpares(1000000));
		    }

		    private static int reveterNumero(int numero) {
		        int intUltimoDigito = 0;

		        int intReverso = 0;

		        boolean blnNaoNegativo = numero < 0 ? true : false;

		        if (blnNaoNegativo) {
		            numero = numero * -1;
		        }

		        while (numero >= 1) {
		            intUltimoDigito = numero % 10;
		            intReverso = intReverso * 10 + intUltimoDigito;
		            
		            numero = numero / 10;
		        }

		        return blnNaoNegativo == true ? intReverso * -1 : intReverso;
		    }

		    private static boolean imparDetectado(int numero) {
		        boolean blnRetorno = false;

		        String strFinsImpares = "1, 3, 5, 7, 9";

		        String[] arrFimImpar = strFinsImpares.split(", ");

		        String strNumero = String.valueOf(numero);

		        for (int i = 0; i < arrFimImpar.length; i++) {
		            String strI = String.valueOf(arrFimImpar[i]);

		            if (strNumero.endsWith(strI)) {
		                blnRetorno = true;

		                break;
		            }
		        }

		        return blnRetorno;
		    }

		    private static String listarSomaNReversoImpares(int abaixoDe) {
		        String strRetorno = "\n";

		        int iReal;
		        int iRealReverso;

		        int intSomaNReverso;

		        int intContaTotal = 0;

		        for (int i = 0; i < abaixoDe; i++) {
		            iReal = i + 1;
		            iRealReverso = reveterNumero(iReal);

		            intSomaNReverso = iReal + reveterNumero(iReal);

		            // if (iRealReverso < abaixoDe) {
		            if (iReal >= 10) {
		                if (!String.valueOf(iReal).endsWith("0")) {
		                    if (confirmaReversivel(iReal)) {
		                        //if (imparDetectado(intSomaNReverso)) {
		                            intContaTotal++;

		                            strRetorno += "RESULTADO " + intContaTotal + ". " + iReal + " + " + iRealReverso + " = " + String.valueOf(intSomaNReverso) + " (RESULTADO ÍMPAR. O NÚMERO {" + iReal + "} É REVERSÍVEL.) " + "\n";
		                        //}
		                    }
		                }
		                // }
		            }
		        }

		        return strRetorno;
		    }

		    private static boolean confirmaReversivel(int numero) {
		        boolean blnRetorno = false;
		        
		        int intReversivel = 0;
		        int intRem = 0;

		        int intNumeroUso = numero;

		        while (intNumeroUso > 0) {
		            intRem = intNumeroUso % 10;

		            intReversivel *= 10;
		            intReversivel += intRem;

		            intNumeroUso /= 10;
		        }

		        int intSoma = intReversivel + numero;

		        while (intSoma > 0 && (intRem % 2 != 0)) {
		            intRem = intSoma % 10;

		            intSoma /= 10;
		        }

		        if (intSoma == 0) {
		            blnRetorno = true;
		        } else {
		            blnRetorno = false;
		        }
		        
		        return blnRetorno;
		    }
		}
	
		
