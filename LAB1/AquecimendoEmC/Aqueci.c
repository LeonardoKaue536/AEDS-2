#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int verifica(char *texto){

    if(texto[0] == 'F' && texto[1] == 'I' && texto[2] == 'M' && texto[3] == '\0'){
        return 0;
    }else{
        return 1;
    }
}

int maius(char *texto){
    int conte = 0;
    int n = strlen(texto);
    for(int i = 0; i < n;i++){
        if(texto[i] >= 'A' && texto[i] <= 'Z'){
            conte += 1;
        }
    }

    return conte;
}

int main(){

    char texto[1000];
    fgets(texto,sizeof(texto),stdin);
    texto[strcspn(texto,"\n")] = '\0';

    while(verifica(texto)){
        
        printf("%i",maius(texto));

        fgets(texto,sizeof(texto),stdin);
        texto[strcspn(texto,"\n")] = '\0';
    }


    return 0;
}