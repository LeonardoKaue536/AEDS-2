package ListaPapainoel;
import java.util.*;

public class Noel {
    
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
        int comportou = 0;
        int baguncou = 0;

        for(int i = 0; i < tam; i++){
            
            String comp = ler.next();
            String name = ler.next();

            if(comp.equals("+")){
                comportou++;
            }else if(comp.equals("-")){
                baguncou++;
            }
            lista.add(name);

        }

        ordena(lista);

        for(int i = 0; i < lista.size();i++){
            System.out.println(lista.get(i));
        }
        System.out.println("Se comportaram: " + comportou + " | Nao se comportaram: " + baguncou);


        ler.close();
    }

}
