#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    //Declaração das variáveis
    char texto[100];
    //char *point1 = texto;
    //receber o texto
    int teste;
    //printf("Você disse: %s", texto);

    //while( texto != strcmp(texto,'FIM') ){

    //printf("%d", tam);
    do{

        fgets(texto,sizeof(texto),stdin);
        texto[strcspn(texto,"\n")]= '\0';
        int tam = strlen(texto) - 1;

        if(strcmp(texto,"FIM") != 0){ 

            for(int i = 0; i < tam/2; i++){
        
                if(texto[i] != texto[tam - i]){
                    i = strlen(texto) / 2;
                    teste = 0;
                }else{
                    teste = 1;
                }
                
            }
            if(teste == 1){
                printf("SIM\n");
            }else{
                printf("NAO\n");
            }
        }

    }while(strcmp(texto,"FIM") != 0);
    
    return 0;
}