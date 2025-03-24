package TP1.alteracaoale;

import java.util.Random;
import java.util.Scanner;
public class aleatorio {

    public static boolean verifica(String texto){

        if((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2)== 'M')){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Random gerador = new Random();
        gerador.setSeed(4);
        char letra = ((char)('a' + (Math.abs(gerador.nextInt()) % 26)));

        Scanner ler = new Scanner(System.in);
        String texto;
        texto = ler.nextLine();

        while(verifica(texto)){

            int tam = texto.length();
            char[] caracteres = texto.toCharArray();

            for(int i = 0; i < tam; i++){
                if(caracteres[i] == 'a'){
                    caracteres[i] = letra; 
                }
            }
            texto = new String(caracteres);
            System.out.println(texto);

            texto = ler.nextLine();
        }


        ler.close();
    }

}
