

//Não fiz o Radixsort


#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include <ctype.h>
#include <stdbool.h>

#define MAX_LINE 1000
#define MAX_FIELD 200
#define MAX_ARRAY 50

typedef struct {
    char show_id[MAX_FIELD];
    char type[MAX_FIELD];
    char title[MAX_FIELD];
    char director[MAX_FIELD];
    char** cast;
    int cast_size;
    char country[MAX_FIELD];
    char date_added[MAX_FIELD];  // Armazenaremos como string
    int year;
    char rating[MAX_FIELD];
    char duration[MAX_FIELD];
    char** listedin;
    int listedin_size;
} Show;

// Remove aspas e limpa espaços
void clean_field(char* str) {
    if (str == NULL) return;
    
    int j = 0;
    bool in_quotes = false;
    
    for (int i = 0; str[i]; i++) {
        if (str[i] == '"') {
            in_quotes = !in_quotes;
            continue;
        }
        str[j++] = str[i];
    }
    str[j] = '\0';
    
    // Remove espaços extras no início/fim
    while (j > 0 && isspace(str[j-1])) str[--j] = '\0';
    char* start = str;
    while (isspace(*start)) start++;
    if (start != str) memmove(str, start, strlen(start) + 1);
}

// Divide string por delimitador
char** split(const char* str, const char* delim, int* size) {
    if (str == NULL || strlen(str) == 0) {
        *size = 0;
        return NULL;
    }

    char* copy = strdup(str);
    char* token = strtok(copy, delim);
    char** result = NULL;
    *size = 0;

    while (token != NULL) {
        result = realloc(result, (*size + 1) * sizeof(char*));
        result[*size] = strdup(token);
        clean_field(result[*size]);
        (*size)++;
        token = strtok(NULL, delim);
    }

    free(copy);
    return result;
}

// Imprime dados do Show no formato exato do Java
void imprimir(Show* s) {
    printf("=> %s ## %s ## %s ## ", s->show_id, s->title, s->type);
    printf("%s ## ", strlen(s->director) > 0 ? s->director : "NaN");

    // Elenco
    printf("[");
    if (s->cast_size > 0) {
        for (int i = 0; i < s->cast_size; i++) {
            printf("%s", s->cast[i]);
            if (i < s->cast_size - 1) printf(", ");
        }
    } else {
        printf("NaN");
    }
    printf("] ## ");

    // País
    printf("%s ## ", strlen(s->country) > 0 ? s->country : "NaN");

    // Data - agora usando a string original
    printf("%s ## ", strlen(s->date_added) > 0 ? s->date_added : "NaN");

    // Ano, Classificação e Duração
    printf("%d ## %s ## %s ## ", s->year, 
           strlen(s->rating) > 0 ? s->rating : "NaN", 
           strlen(s->duration) > 0 ? s->duration : "NaN");

    // Gêneros
    printf("[");
    if (s->listedin_size > 0) {
        for (int i = 0; i < s->listedin_size; i++) {
            printf("%s", s->listedin[i]);
            if (i < s->listedin_size - 1) printf(", ");
        }
    } else {
        printf("NaN");
    }
    printf("] ##\n");
}

// Lê dados do CSV seguindo a mesma lógica do Java
Show* ler(int* total) {
    FILE* file = fopen("C:/Users/Leonardo/Desktop/Leleo/programs/AEDS-2/TPS/TP2/EM c/disneyplus.csv", "r");
    if (!file) {
        perror("Erro ao abrir o arquivo");
        *total = 0;
        return NULL;
    }

    Show* shows = NULL;
    int count = 0;
    char linha[MAX_LINE];

    fgets(linha, sizeof(linha), file); // Pula cabeçalho

    while (fgets(linha, sizeof(linha), file)) {
        char* tokens[11];
        char* tmp = strdup(linha);
        char* ptr = strtok(tmp, ",");

        for (int i = 0; i < 11 && ptr != NULL; i++) {
            tokens[i] = ptr;
            ptr = strtok(NULL, ",");
        }

        Show s = {0};
        
        // Processa cada campo igual ao Java
        strncpy(s.show_id, tokens[0], MAX_FIELD);
        clean_field(s.show_id);
        
        strncpy(s.type, tokens[1], MAX_FIELD);
        clean_field(s.type);
        
        strncpy(s.title, tokens[2], MAX_FIELD);
        clean_field(s.title);
        
        strncpy(s.director, tokens[3], MAX_FIELD);
        clean_field(s.director);

        // Cast - trata como no Java
        if (strlen(tokens[4]) > 0) {
            s.cast = split(tokens[4], ";", &s.cast_size);
        } else {
            s.cast = malloc(sizeof(char*));
            s.cast[0] = strdup("NaN");
            s.cast_size = 1;
        }
        
        strncpy(s.country, tokens[5], MAX_FIELD);
        clean_field(s.country);

        // Data - armazena como string original
        strncpy(s.date_added, tokens[6], MAX_FIELD);
        clean_field(s.date_added);
        
        // Ano - trata como no Java
        s.year = atoi(tokens[7]);
        
        strncpy(s.rating, tokens[8], MAX_FIELD);
        clean_field(s.rating);
        
        strncpy(s.duration, tokens[9], MAX_FIELD);
        clean_field(s.duration);
        
        // Listed in - trata como no Java
        if (strlen(tokens[10]) > 0) {
            s.listedin = split(tokens[10], ",", &s.listedin_size);
        } else {
            s.listedin = malloc(sizeof(char*));
            s.listedin[0] = strdup("NaN");
            s.listedin_size = 1;
        }

        shows = realloc(shows, (count + 1) * sizeof(Show));
        shows[count++] = s;

        free(tmp);
    }

    fclose(file);
    *total = count;
    return shows;
}

int main() {
    int total;
    Show* shows = ler(&total);

    char input[MAX_FIELD];
    fgets(input, sizeof(input), stdin);
    input[strcspn(input, "\n")] = 0;

    while (strcmp(input, "FIM") != 0) {
        for (int i = 0; i < total; i++) {
            if (strcmp(shows[i].show_id, input) == 0) {
                imprimir(&shows[i]);
                break;
            }
        }
        fgets(input, sizeof(input), stdin);
        input[strcspn(input, "\n")] = 0;
    }

    // Liberar memória
    for (int i = 0; i < total; i++) {
        for (int j = 0; j < shows[i].cast_size; j++) free(shows[i].cast[j]);
        free(shows[i].cast);
        for (int j = 0; j < shows[i].listedin_size; j++) free(shows[i].listedin[j]);
        free(shows[i].listedin);
    }
    free(shows);

    return 0;
}