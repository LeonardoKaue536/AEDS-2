#include <stdio.h>


int main() {
    int N, K;

    while (1) {
        scanf("%d %d", &N, &K);
        if (N == 0 && K == 0)
            break;

        int frequencia[100 + 1] = {0};

        for (int i = 0; i < N; i++) {
            int pergunta;
            scanf("%d", &pergunta);
            frequencia[pergunta]++;
        }

        int countFrequentes = 0;
        for (int i = 1; i <= 100; i++) {
            if (frequencia[i] >= K)
                countFrequentes++;
        }

        printf("%d\n", countFrequentes);
    }

    return 0;
}