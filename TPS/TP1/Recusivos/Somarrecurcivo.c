#include <stdio.h>
#include <string.h>

int somar(char texto[], int total, int i) {

    if (i == strlen(texto)) {
        return total;
    }

    total += texto[i] - '0';

    return somar(texto, total, i + 1);
}

int verifica(char texto[]) {

    if (texto[0] == 'F' && texto[1] == 'I' && texto[2] == 'M' && texto[3] == '\0') {
        return 0; 
    }
    return 1; 
}

int main() {
    char texto[1000];

    // Lê a primeira linha
    fgets(texto, sizeof(texto), stdin);
    texto[strcspn(texto, "\n")] = '\0'; 

    while (verifica(texto)) {

        printf("%d\n", somar(texto, 0, 0));

        fgets(texto, sizeof(texto), stdin);
        texto[strcspn(texto, "\n")] = '\0';
    }

    return 0;
}
