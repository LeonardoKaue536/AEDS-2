import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        String texto;
        Boolean palin = true;

        Scanner ler = new Scanner(System.in);
        texto = ler.nextLine();

        while (!(texto.equalsIgnoreCase("FIM"))) {
            
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
                System.err.println("SIM");
            }else{
                System.err.println("NAO");
            }

            texto = ler.nextLine();

        }



        ler.close();

    }

}