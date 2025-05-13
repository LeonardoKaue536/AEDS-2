#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int top = 0;

void ordena(int* array, char* op){
     if (strcmp(op,"POP") == 0)
        {
            if (top == 0)
            {
                printf("EMPTY\n");
            }
            else
            {
                top--;
            }
        }
        else if (strcmp(op, "MIN") == 0)
        {
            if (top == 0)
            {
                printf("EMPTY\n");
            }else
            {
                int min = array[0];
                for (int j = 1; j < top; j++)
                {
                    if (min > array[j])
                    {
                        min = array[j];
                    }
                }


                printf("%i\n", min);
            }
            
        }
        else
        {
            int val;
            sscanf(op, "PUSH %d", &val);
            array[top] = val;
            top++;
        }
}

int main()
{

    int n;

    scanf("%i", &n);
    getchar();

    int *array = (int *)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
    {
        char op[200];

        fgets(op, sizeof(op), stdin);
        op[strcspn(op,"\n")] = '\0';

        ordena(array, op);
    }

    free(array);

    return 0;
}