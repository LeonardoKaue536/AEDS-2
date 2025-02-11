#include <stdio.h>
#include <string.h>

int main() {
    char entrada[100];  // Buffer para armazenar a entrada do usuário

    printf("Digite algo (ou 'FIM' para sair): ");
    fgets(entrada, sizeof(entrada), stdin);  
    entrada[strcspn(entrada, "\n")] = '\0';  // Remove o '\n'

    // Enquanto a entrada for diferente de "FIM", continua
    while (strcmp(entrada, "FIM") != 0) {
        printf("Você digitou: %s\n", entrada);

        printf("Digite algo (ou 'FIM' para sair): ");
        fgets(entrada, sizeof(entrada), stdin);
        entrada[strcspn(entrada, "\n")] = '\0';  // Remove o '\n'
    }

    printf("Encerrando o programa...\n");
    return 0;
}