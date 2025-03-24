package TP1.Contagem;

import java.util.Scanner;

public class Contagem {

    public static boolean verifica(String texto) {

        if ((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2) == 'M')) {
            return false;
        }
        return true;
    }

    public static int teste(String texto) {
        int tam = texto.length();
        int cont = 1;

        for (int i = 0; i < tam; i++) {
            if (texto.charAt(i) == 32) {
                cont += 1;
            }

        }
        return cont;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String texto;

        texto = ler.nextLine();

        while (verifica(texto) == true) {

            System.out.println(teste(texto));

            texto = ler.nextLine();
        }

        ler.close();

    }
}
