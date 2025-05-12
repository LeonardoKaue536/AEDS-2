#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void ordena(char *array[], int tam)
{
    char temp[20];

    for (int i = 1; i < tam; i++)
    {
        strcpy(temp, array[i]);
        int j = i - 1;

        while (j >= 0 && strcmp(array[j], temp) > 0)
        {

            strcpy(array[j + 1], array[j]);
            j--;
        }
        strcpy(array[j + 1], temp);
    }
}

int main()
{

    int tam;
    int comportou = 0;
    int baguncou = 0;

    scanf("%i", &tam);

    char **array = (char **)malloc(tam * sizeof(char *));

    for (int i = 0; i < tam; i++)
    {

        array[i] = (char *)malloc(20 * sizeof(char));

        char comp;
        scanf(" %c", &comp);
        scanf(" %s", array[i]);

        if (comp == '+')
        {
            comportou++;
        }
        else if (comp == '-')
        {
            baguncou++;
        }
    }

    ordena(array, tam);

    for (int i = 0; i < tam; i++)
    {
        printf("%s\n", array[i]);
    }
    printf("Se comportaram: %i | Nao se comportaram: %i\n", comportou, baguncou);

    for (int i = 0; i < tam; i++)
    {
        free(array[i]);
    }
    free(array);

    return 0;
}
