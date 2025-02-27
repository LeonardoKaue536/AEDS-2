package somarDigitos;
import java.util.Scanner;

public class Somar {

    public static boolean verifica(String texto){

        if((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2)== 'M')){
            return false;
        }
        return true;
    }

    public static int somar(String texto,int total, int i){
        if(i == texto.length()){
            return total;
        }

        total += texto.charAt(i) - '0';

        return somar(texto, total, i+1);
    }
    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);

        String texto;
        texto = ler.nextLine();

        while(verifica(texto)){

            System.out.println(somar(texto,0,0));

            texto = ler.nextLine();
        }

        ler.close();
    }
}
