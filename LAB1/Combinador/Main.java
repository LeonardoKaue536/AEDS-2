package Combinador;

import java.util.*;

public class Main{

    public static String combina(String texto1, String texto2){
        int i = 0;
        int p = 0;
        
        int t1 = texto1.length();
        int t2 = texto2.length();
        
        char[] texto3 = new char[t1 + t2];

        char[] arr1 = texto1.toCharArray();
        char[] arr2 = texto2.toCharArray();

        while(i < t1 || i < t2){
            if(i < t1){
                texto3[p++] = arr1[i];
            }
            if(i < t2){
                texto3[p++] = arr2[i];
            }
            i++;
        }
        
        String combinado = new String(texto3);
        
        return combinado;
    }

    public static void main(String[] args){
        
        Scanner ler = new Scanner(System.in);

        String texto1;
        String texto2;

        for(int i = 0; i < 3; i++){
            texto1 = ler.next();
            texto2 = ler.next();
            
            String resposta = combina(texto1, texto2);

            System.out.println(resposta);
        
        }

        ler.close();
    }
}