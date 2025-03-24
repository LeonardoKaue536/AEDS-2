#include <stdio.h>

void gravarValoresArquivo(FILE *arquivo, int n) {
    double numero;
    for (int i = 0; i < n; i++) {
        scanf("%lf", &numero);  
        fwrite(&numero, sizeof(double), 1, arquivo);  
    }
}

void lerValoresReverso(FILE *arquivo, int n) {
    double numero;
    for (int i = n - 1; i >= 0; i--) {
        fseek(arquivo, i * sizeof(double), SEEK_SET);  
        fread(&numero, sizeof(double), 1, arquivo);
        printf("%.3lf\n", numero);  
    }
}

int main() {
    int n;

    scanf("%d", &n);

    while (n != 200) {

        FILE *arquivo = fopen("valores.txt", "wb");
        if (arquivo == NULL) {
            printf("Erro ao abrir o arquivo.\n");
            return 1;
        }

        gravarValoresArquivo(arquivo, n);

        fclose(arquivo);

        arquivo = fopen("valores.txt", "rb");
        if (arquivo == NULL) {
            printf("Erro ao abrir o arquivo para leitura.\n");
            return 1;
        }

        lerValoresReverso(arquivo, n);

      
        fclose(arquivo);

        
        scanf("%d", &n);
    }

    return 0;
}