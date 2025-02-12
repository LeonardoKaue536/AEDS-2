#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int FIM(){
    return 2;
}

int verifica()
{
    char texto[1000];
    int fim;

    fgets(texto, sizeof(texto), stdin);
    texto[strcspn(texto, "\n")] = '\0';
    int tam = strlen(texto);

    if (strcmp(texto, "FIM") != 0)
    {

        for (int i = 0; i < tam / 2; i++)
        {

            if (texto[i] != texto[tam - i - 1])
            {
                i = strlen(texto) / 2;
                return false;
            }
            else
            {
                return true;
            }
        }

    }else{
        fim = FIM();
        return fim;
    }
    
}

int main()
{   
    int teste;
    int FIM = 0;

    do
    {
        teste = verifica();
        if (teste == true)
        {
            printf("SIM\n");
        }
        else if(teste == false)
        {
            printf("NÃO\n");
        }else{
            FIM = 1;
        }

    }while (FIM != 1);

    return 0;
}