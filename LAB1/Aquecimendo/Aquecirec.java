package Aquecimendo;

import java.util.*;

public class Aquecirec{

    public static boolean verifica(String texto){

        if(texto.charAt(0) == 'F' && texto.charAt(1) == 'I' && texto.charAt(2) == 'M' ){
            return false;
        }else{
            return true;
        }

    }

    public static int maius(String texto, int cont, int point){
        if(texto.length() == point){
            return cont;
        }else{
            if(texto.charAt(point) >= 'A' && texto.charAt(point) <= 'Z'){
                return maius(texto, cont+1, point+1);
            }else{
                return maius(texto, cont, point+1);
            }
        }
        

    }


    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        String texto;

        texto = ler.nextLine();

        while(verifica(texto)){

            System.out.println(maius(texto, 0, 0));

            texto = ler.nextLine();
        }


        ler.close();
    }
}