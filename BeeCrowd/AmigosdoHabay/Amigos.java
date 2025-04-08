package AmigosdoHabay;

import java.util.*;

class inscrito{

    public String nome;
    public boolean amigo;

    

}

public class Amigos {

    public static boolean verifica(String nome){
        if(nome.equals("FIM")){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        String nome = ler.nextLine();

        while(verifica(nome)){

            

        }

        ler.close();
    }
}
