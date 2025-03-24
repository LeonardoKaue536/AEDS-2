package TP1.inverterString;

import java.util.Scanner;

public class Inverter {

    public static String inverte(String texto){
        char [] caracteres;
        caracteres = texto.toCharArray();
        int tam = texto.length();
        char temp;
        for(int i = 0; i < tam/2 ; i++){
            temp = caracteres[i];
            caracteres[i] = caracteres[tam - i - 1];
            caracteres[tam - i - 1] = temp;
        }
        
        texto = new String(caracteres);

        return texto;
    }

    public static boolean verifica(String texto){

        if((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2)== 'M')){
            return false;
        }
        return true;
    }
    public static void main (String[] args){
        
        Scanner ler = new Scanner(System.in);


        String texto;
        texto = ler.nextLine();


        while(verifica(texto)){

            System.out.println(inverte(texto));
            texto = ler.nextLine();
        }



        ler.close();
    }
}
