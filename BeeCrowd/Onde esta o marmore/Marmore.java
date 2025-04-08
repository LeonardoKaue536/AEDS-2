import java.util.Scanner;

public class Marmore {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        int n;
        int q;
        int casos = 1;
        int num;
        int temp;

        n = ler.nextInt();
        q = ler.nextInt();
        while ((n > 0 && q > 0) && casos < 65) {
            int[] mar = new int[n];
            
            for(int i = 0; i < n; i++){
                mar[i] = ler.nextInt();
            }

            System.out.println("CASE# "+casos+":");

            for(int j = 0; j < q; j++){
                num = ler.nextInt();
               
               for(int i = 0; i < n;i++){
                    if(num == mar[i]){
                        temp = j;
                        System.out.println(num+" found at "+(i+1));
                        i = n;
                    }else if(i == n - 1){
                        System.out.println(num+" not found");
                    }
               }
               
                
            }
            


            casos++;
            n = ler.nextInt();
            q = ler.nextInt();
        }


        ler.close();
    }
}