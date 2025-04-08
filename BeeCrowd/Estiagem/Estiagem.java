import java.util.*;

public class Estiagem {
    //Saida errada no beecrowd
    public static void organi(int[] custo, int[] pes){

        int n = custo.length;
        int temp;
        for(int i = 0; i < n-1; i++){

            int menor = i;
            for(int j = i + 1; j < n; j++){
                if(custo[j] < custo[menor]){
                    menor = j;
                    
                }

            }
            int move = pes[i];
            pes[i] = pes[menor];
            pes[menor] = move;

            temp = custo[menor];
            custo[menor] = custo[i];
            custo[i] = temp;

        }

        for(int i = 0; i < n; i++){
            System.out.print(pes[i]+"-"+custo[i]+" ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args){
        Scanner ler = new Scanner(System.in);
        int num = 1;
        int n;
        double fx;
        

        n = ler.nextInt();

        while(n > 0){
            int tpessoas = 0;
            int tcusto= 0;

            int[] custo = new int[n];
            int[] pes = new int[n];
             
            for(int i = 0; i < n; i++){
                int x = ler.nextInt();
                int y = ler.nextInt();
                
                pes[i] = x;
                custo[i] = y / x;
                
               tpessoas += x;
               tcusto += y;
            }

            fx = (double)tcusto/ tpessoas;

            System.out.println("Cidade# " + num + ":");
            organi(custo,pes);
            System.out.printf("Consumo medio: %.2lf m3.", fx);
            
            num++;
            
            //if(n > 0){
             //   System.out.println("");
            //}
            n = ler.nextInt();
            
        }


        ler.close();
    }
}
