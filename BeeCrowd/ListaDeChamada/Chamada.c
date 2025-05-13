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

    int sorteado;
    int tam;

    scanf("%i", &tam);
    scanf("%i", &sorteado);

    char **array = (char **)malloc(tam * sizeof(char *));

    for (int i = 0; i < tam; i++)
    {

        array[i] = (char *)malloc(20 * sizeof(char));

        scanf(" %s", array[i]);

    }

    ordena(array, tam);

    printf("%s\n", array[sorteado - 1]);

    for (int i = 0; i < tam; i++)
    {
        free(array[i]);
    }
    free(array);

    return 0;
}
