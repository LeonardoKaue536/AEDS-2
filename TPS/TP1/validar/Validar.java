package TP1.validar;
import java.util.Scanner;

public class Validar {

    public static boolean verifica(String texto){

        if((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2)== 'M')){
            return false;
        }
        return true;
    }

    public static boolean senha(String texto){
        int carc= 0, maius = 0, minus = 0, num = 0;
        char[] caracteres;
        caracteres = texto.toCharArray();

        if(texto.length() < 8){
            return false;
        }
        for(int i = 0; i < texto.length(); i++){
            if(caracteres[i] >= '!' && caracteres[i] <= '/' ){
                carc++;
            }
            if(caracteres[i] == '?' || caracteres[i] == '@' ){
                carc++;
            }


            if(caracteres[i] >= 48 && caracteres[i] <= 57 ){
                num++;
            }

            if(caracteres[i] >= 'A' && caracteres[i] <= 'Z' ){
                maius++;
            }

            if(caracteres[i] >= 'a' && caracteres[i] <= 'z' ){
                minus++;
            }
        }

        if(carc >=1 && minus >=1 && maius >=1 && num >=1){
            return true;
        }else{
            return false;
        }
        
    }

    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        
        String texto;

        texto = ler.nextLine();

        while(verifica(texto)){

            if(senha(texto)){
                System.out.println("SIM");
            }else{
                System.out.println(new String("N\u00C3O".getBytes(), java.nio.charset.StandardCharsets.UTF_8));;
            }

            texto = ler.nextLine();

        }
        


        ler.close();
    }
}
