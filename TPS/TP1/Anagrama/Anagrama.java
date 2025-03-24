package TP1.Anagrama;

import java.util.Scanner;

public class Anagrama{
    
    public static boolean verifica(String texto){

        if((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2)== 'M')){
            return false;
        }
        return true;
    }

    public static boolean teste(String texto){
        int tam = texto.length();
        boolean traco = false;
        String p1 = "";
        String p2 = "";

        for(int i = 0; i < tam; i++){
            char c = texto.charAt(i);
            
            if(c == '-'){
                traco = true;
            }else if(traco != true){
                p1 += c;
            }else{
                p2 += c;
            }
        }

        if(p1.length() != p2.length()){
            return false;
        }

        return(ordenar(p1, p2));
    }

    public static boolean ordenar(String p1, String p2){
        int tam = p1.length();
        char temp;
        boolean igual = true;

        String tempString1 = p1.toLowerCase();
        String tempString2 = p2.toLowerCase();

        char[] carac1 = tempString1.toCharArray();
        char[] carac2 = tempString2.toCharArray();

        for(int i = 0; i < tam; i++){
            for(int j = i + 1; j < tam; j++){
                 
                if(carac1[i] > carac1[j]){
                    
                    temp = carac1[i];
                    carac1[i] = carac1[j];
                    carac1[j] = temp;
                }

                if(carac2[i] > carac2[j]){
                    temp = carac2[i];
                    carac2[i] = carac2[j];
                    carac2[j] = temp;
                }
            }
        }



        for(int i = 0; i < tam; i++){
            if(carac1[i] != carac2[i]){
                igual = false;
                i = tam;
            }
        }


        
        return igual;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String texto;

        texto = ler.nextLine();

        while(verifica(texto) == true){

            if(teste(texto)){
                System.out.println("SIM");
            }else{
                System.out.println("NÃO");
            }


            texto = ler.nextLine();
        }


        ler.close();
    }
}
