#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

int verifica() {
    char texto[1000];

    fgets(texto, sizeof(texto), stdin);
    texto[strcspn(texto, "\n")] = '\0';

    if (strcmp(texto, "FIM") == 0) {
        return 2;
    }

    return ehPalindromo(texto, 0);
}

int ehPalindromo(char texto[], int i) {
    int tam = strlen(texto);

    if (i >= tam / 2) {
        return 1;
    }

    if (texto[i] != texto[tam - i - 1]) {
        return 0;
    }

    return ehPalindromo(texto, i + 1);
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
