#include <stdio.h>

void insertion(int array[],int size){

    for(int i = 1; i < size; i++){
        
        int temp = array[i];
        int j = i - 1;

        while(j >= 0 && array[j] > temp){
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = temp;
    }


}

int main(){

        int num1 [3];
        int num2 [3];

        for (int i = 0; i < 3; i++) {
            scanf("%i", &num1[i]);
            num2[i] = num1[i];
        }

        int size = sizeof(num1)/sizeof(num2[0]);

        insertion(num1,size);

        printf("%i\n",num1[0]);
        printf("%i\n",num1[1]);
        printf("%i\n",num1[2]);

        printf("\n");

        printf("%i\n",num2[0]);
        printf("%i\n",num2[1]);
        printf("%i\n",num2[2]);

}