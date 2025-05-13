package ListaDeChamada;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Chamada {
    public static void ordena(List<String> listas){

        for(int i = 1; i < listas.size(); i++){
            String temp = listas.get(i); 
            int j = i - 1;

            while(j >= 0 && listas.get(j).compareTo(temp) > 0){

                listas.set(j + 1, listas.get(j));
                j--;
            }
            listas.set(j + 1, temp);

        }


    }

    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);

        List<String> lista = new ArrayList<>();

        int tam = ler.nextInt();
        int sorteado = ler.nextInt();
        

        for(int i = 0; i < tam; i++){
            String name = ler.next();
            lista.add(name);

        }

        ordena(lista);

        System.out.println(lista.get(sorteado - 1));



        ler.close();
    }
}
