//package TP1.Recusivos;

import java.util.Scanner;

public class Cifrarecursivo {

    public static boolean verifica(String texto) {
        if ((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2) == 'M')) {
            return false; 
        }
        return true; 
    }

    public static void processarTexto(String texto, Scanner ler) {
        if (!verifica(texto)) {
            return;
        }

        char[] caracteres = texto.toCharArray();
        int tam = texto.length();

        for (int i = 0; i < tam; i++) {
            if (texto.charAt(i) != '\uFFFD') { 
                caracteres[i] += 3; 
            }
        }

        texto = new String(caracteres);
        System.out.println(texto);

        texto = ler.nextLine();
        processarTexto(texto, ler);
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String texto = ler.nextLine();

        processarTexto(texto, ler);

        ler.close();
    }
}
