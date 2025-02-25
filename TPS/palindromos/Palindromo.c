#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int verifica() {
    char texto[1000];

    fgets(texto, sizeof(texto), stdin);
    texto[strcspn(texto, "\n")] = '\0';
    int tam = strlen(texto);

    if (strcmp(texto, "FIM") == 0) {
        return 2;
    }

    for (int i = 0; i < tam / 2; i++) {
        if (texto[i] != texto[tam - i - 1]) {
            return 0;
        }
    }

    return 1;
}

int main() {   
    int teste;
    
    do {
        teste = verifica();
        if (teste == 1) {
            printf("SIM\n");
        } else if (teste == 0) {
            printf("NAO\n");
        }
    } while (teste != 2);

    return 0;
}