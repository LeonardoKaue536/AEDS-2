package TP1.substring;

import java.util.Scanner;

public class Subtring {

    public static boolean verifica(String texto){

        if((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2)== 'M')){
            return false;
        }
        return true;
    }

    public static int teste(String texto){
        int maior = 0, teste, esq = 0;
        char[] caracteres;
        caracteres = texto.toCharArray();

        for(int dir = 0; dir < texto.length();dir++){

            for(int j = esq; j < dir; j++){
                if(caracteres[j] == caracteres[dir]){
                    esq = j + 1;
                    j = dir;
                }
            }

            teste = dir - esq + 1;
            if(teste > maior){
                maior = teste;
            }

        }



        return maior;
    }

    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        String texto;

        texto = ler.nextLine();

        while(verifica(texto)){
            System.out.println(teste(texto));

            texto = ler.nextLine();
        }



        ler.close();
    }
}
