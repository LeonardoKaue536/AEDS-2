#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *combina(char *texto1, char *texto2){
    char *texto3 = malloc(2000);

    int i = 0;
    int p = 0;

    int t1 = strlen(texto1);
    int t2 = strlen(texto2);
    
    while(i < t1 || i < t2){
        if(i < t1){
            texto3[p++] = texto1[i];
        }
        if(i < t2){
            texto3[p++] = texto2[i];
        }
        i++;
    }

    texto3[p] = '\0';

    return texto3;

}


int main(){
    char texto1[1000];
    char texto2[1000];

    for(int i = 0; i < 3; i++)
    {
        scanf("%s", texto1);
        scanf("%s", texto2);
        
        char *resposta = combina(texto1, texto2);

        printf("%s\n",resposta);
    }

}