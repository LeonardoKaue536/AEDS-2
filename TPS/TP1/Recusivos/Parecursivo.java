//package TP1.Recusivos;
import java.util.*;

public class Parecursivo {

    public static boolean verifica(String texto) {
        if ((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2) == 'M')) {
            return false;
        }
        return true;
    }

    public static boolean ehPalindromo(String texto, int i) {
        int tam = texto.length();
        
       
        if (i >= tam / 2) {
            return true;
        }

       
        if (texto.charAt(i) != texto.charAt(tam - i - 1)) {
            return false;
        }

        
        return ehPalindromo(texto, i + 1);
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String texto = ler.nextLine();
        
      
        while (verifica(texto)) {
            
            if (ehPalindromo(texto, 0)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }

            texto = ler.nextLine();
        }

        ler.close();
    }
}