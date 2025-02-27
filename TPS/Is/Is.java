//package Is;

import java.util.Scanner;

public class Is {
    public static boolean verifica(String texto){

        if((texto.charAt(0) == 'F' && texto.charAt(1) == 'I') && (texto.charAt(2)== 'M')){
            return false;
        }
        return true;
    }

    public static boolean vogais(String texto){
        
        int pontos = 0;
        int tam = texto.length();
        for(int i = 0; i < tam; i++){

            if(texto.charAt(i) == 'a'|| texto.charAt(i) == 'e'|| texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u'){
                pontos += 1;
            }   
        }

        if(pontos == tam){
            return true;
        }else{
            return false;
        }
        
    }

    public static boolean Consoantes(String texto){
        
        int pontos = 0;
        int tam = texto.length();
        for(int i = 0; i < tam; i++){

            if(texto.charAt(i) >= 'b'&& texto.charAt(i) <= 'd'|| texto.charAt(i) >= 'f' && texto.charAt(i) <= 'h' || texto.charAt(i) >= 'j' && texto.charAt(i) <= 'n' || texto.charAt(i) >= 'p' && texto.charAt(i) <= 't' || texto.charAt(i) >= 'v' && texto.charAt(i) <= 'z'){
                pontos += 1;
            }
            
        }
        if(pontos == tam){
            return true;
        }else{
            return false;
        }
        
    }

    public static boolean inteiro(String texto){
        
        int pontos = 0;
        int tam = texto.length();
        for(int i = 0; i < tam; i++){
            char c = texto.charAt(i);
            if(c >= '0' && c <= '9'){
                pontos += 1;
            }
            
        }
        if(pontos == tam){
            return true;
        }else{
            return false;
        }
    }

    public static boolean real(String texto){
        int sinais = 0;
        int pontos = 0;
        int tam = texto.length();
        for(int i = 0; i < tam; i++){
            char c = texto.charAt(i);
            if(c >= '0' && c <= '9'){
                pontos += 1;
            }else if(c == '.' || c == ','){
                sinais += 1;
                if(sinais == 1){
                    pontos += 1;
                }
            }
            
        }
        if(pontos == tam){
            return true;
        }else{
            return false;
        }
    }
    public static void main(String[] args) {
        Scanner ler =new Scanner(System.in);
    
        String texto = ler.nextLine();
        
        while(verifica(texto)){

            if(vogais(texto) == true){
                System.out.print("SIM ");
            }else{
                System.out.print("NAO ");
            }
    
            if(Consoantes(texto) == true){
                System.out.print("SIM ");
            }else{
                System.out.print("NAO ");
            }
    
            if(inteiro(texto) == true){
                System.out.print("SIM ");
            }else{
                System.out.print("NAO ");
            }

            if(real(texto) == true){
                System.out.println("SIM");

            }else{
                System.out.println("NAO");
            }


            
            texto = ler.nextLine();
        }
        ler.close();

    }
}
