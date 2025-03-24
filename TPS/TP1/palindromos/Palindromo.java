package TP1.palindromos;
import java.util.*;

public class Palindromo{

    public static boolean verifica(String texto){

        if((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2)== 'M')){
            return false;
        }
        return true;
    }
    
    public static void main(String[] args){

        String texto;
        Boolean palin = true;

        Scanner ler = new Scanner(System.in);
        texto = ler.nextLine();

        while (verifica(texto)){
            
            int tam = texto.length();

            for(int i = 0; i < tam/2;i++){

                if (texto.charAt(i) != texto.charAt(tam - i - 1))
            {
                i = texto.length() / 2;
                palin = false;
            }
            else
            {
                palin = true;
            }

            }

            if(palin == true){
                System.out.println("SIM");
            }else{
                System.out.println("NAO");
            }

            texto = ler.nextLine();

        }

        ler.close();
    }

}