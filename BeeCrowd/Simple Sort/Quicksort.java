import java.util.*;

public class Quicksort {
    public static void quick(int[] array, int start, int end) {
        if(end <= start)return;
        
        int pivo = ordenar(array, start, end);
        quick(array, start, pivo - 1);
        quick(array, pivo + 1, end);

    }

    public static int ordenar(int[] array, int start, int end){

        int i = start - 1;
        int pivo = array[end];

        for(int j = start; j <= end-1;j++){
            if(array[j] < pivo){
                i++;
                int temp = array [i];
                array[i] = array [j];
                array[j] = temp;
            }
        }
        i++;

        int temp = array[i];
        array[i] = array[end];
        array[end] = temp;

        return i;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int[] num1 = new int[3];
        int[] num2 = new int[3];

        for (int i = 0; i < 3; i++) {
            num1[i] = ler.nextInt();
            num2[i] = num1[i];
        }

        quick(num1, 0, num1.length - 1);

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
