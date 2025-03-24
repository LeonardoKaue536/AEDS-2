package Aquecimendo;

import java.util.*;

public class Aqueci {

    public static boolean verifica(String texto){

        if(texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M' ){
            return false;
        }else{
            return true;
        }

    }

    public static int contarM(String texto){
        int cont = 0;

        for(int i = 0; i < texto.length(); i++){
            if(texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z'){
                cont++;
            }
        }

        return cont;
    }

    public static void main(String[] args){
        
        Scanner ler = new Scanner(System.in);

        String texto;
        texto = ler.nextLine();

        while(verifica(texto)){
            int n = contarM(texto);

            System.out.println(n);

            texto = ler.nextLine();
        }

        ler.close();
    }
}
