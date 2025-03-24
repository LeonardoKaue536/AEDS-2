#include <stdio.h>
#include <string.h>

void inverte(char texto[], int inicio, int fim) {
    
    if (inicio >= fim) {
        return;
    }


    char temp = texto[inicio];
    texto[inicio] = texto[fim];
    texto[fim] = temp;


    inverte(texto, inicio + 1, fim - 1);
}

int verifica(char texto[]) {
   
    if (texto[0] == 'F' && texto[1] == 'I' && texto[2] == 'M' && texto[3] == '\0') {
        return 0;
    }
    return 1;
}

int main() {
    char texto[1000];

    fgets(texto, sizeof(texto), stdin);
    texto[strcspn(texto, "\n")] = '\0'; 

  
    while (verifica(texto)) {
      
        inverte(texto, 0, strlen(texto) - 1);
        printf("%s\n", texto);

        fgets(texto, sizeof(texto), stdin);
        texto[strcspn(texto, "\n")] = '\0'; 
    }

    return 0;
}
