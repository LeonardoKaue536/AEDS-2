import java.util.Scanner;
import java.util.*;

public class Insertion {

    public static void insertion(int[] array){

        for(int i = 1; i < array.length; i++){
            
            int temp = array[i];
            int j = i - 1;

            while(j >= 0 && array[j] > temp ){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }

        
    }
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int[] num1 = new int[3];
        int[] num2 = new int[3];

        for (int i = 0; i < 3; i++) {
            num1[i] = ler.nextInt();
            num2[i] = num1[i];
        }

        insertion(num1);

        System.out.println(num1[0]);
        System.out.println(num1[1]);
        System.out.println(num1[2]);

        System.out.println();

        System.out.println(num2[0]);
        System.out.println(num2[1]);
        System.out.println(num2[2]);

        ler.close();
    }
}
