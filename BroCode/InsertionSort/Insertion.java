package InsertionSort;
import java.util.*;

public class Insertion {
    
    public static void InsertionSort(int array[]){

        for(int i = 1; i < array.length; i++){
            int temp = array [i];
            int j = i - 1;

            while(j >= 0 && array[j] > temp){
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;

        }

    }

    public static void main(String[] args) {
        
        int array[] = {9,1,8,2,7,3,6,5,4};

        InsertionSort(array);

        for (int i : array){
            System.out.print(i + " ");
        }

    }

}
