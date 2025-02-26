package Ciframento;

import java.util.*;

public class Ciframento {

    public static boolean verifica(String texto){

        if((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2)== 'M')){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {

        String texto;
        int tam = 0;

        Scanner ler = new Scanner(System.in);
        texto = ler.nextLine();

        while (verifica(texto)) {
            char[] caracteres = texto.toCharArray();
            tam = texto.length();
            for (int i = 0; i < tam; i++){
                if((texto.charAt(i) != '\uFFFD')){
                    caracteres[i] += 3;
                }
            }
            texto = new String(caracteres);
            System.out.println(texto);
            texto = ler.nextLine();
        }

        ler.close();

    }
}
