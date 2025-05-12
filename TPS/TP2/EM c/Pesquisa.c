#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

#define MAX_TITLE_LENGTH 100
#define MAX_SHOWS 1000
#define MAX_CAST_LENGTH 200
#define MAX_LISTEDIN_LENGTH 200
#define DATE_FORMAT "%B %d, %Y"

// Estrutura Show
typedef struct {
    char show_id[MAX_TITLE_LENGTH];
    char type[MAX_TITLE_LENGTH];
    char title[MAX_TITLE_LENGTH];
    char director[MAX_TITLE_LENGTH];
    char cast[MAX_CAST_LENGTH];
    char country[MAX_TITLE_LENGTH];
    char date[MAX_TITLE_LENGTH]; 
    int year;
    char rating[MAX_TITLE_LENGTH];
    char duration[MAX_TITLE_LENGTH];
    char listedin[MAX_LISTEDIN_LENGTH];
} Show;


Show* ler(const char* idBuscado) {
    FILE *file = fopen("/tmp/disneyplus.csv", "r");
    if (!file) {
        return NULL;
    }

    char line[1024];
    fgets(line, sizeof(line), file);  // Pular o cabeçalho

    while (fgets(line, sizeof(line), file)) {
        Show* show = (Show*)malloc(sizeof(Show));
        if (show == NULL) {
            fclose(file);
            return NULL;
        }

        char* token = strtok(line, ",");
        if (token != NULL && strcmp(token, idBuscado) == 0) {
           
            strcpy(show->show_id, token);
            token = strtok(NULL, ",");
            strcpy(show->type, token ? token : "");

            token = strtok(NULL, ",");
            strcpy(show->title, token ? token : "");

            token = strtok(NULL, ",");
            strcpy(show->director, token ? token : "");

            token = strtok(NULL, ",");
            strcpy(show->cast, token ? token : "");

            token = strtok(NULL, ",");
            strcpy(show->country, token ? token : "");

            token = strtok(NULL, ",");
            strcpy(show->date, token ? token : "");

            token = strtok(NULL, ",");
            show->year = token ? atoi(token) : 0;

            token = strtok(NULL, ",");
            strcpy(show->rating, token ? token : "");

            token = strtok(NULL, ",");
            strcpy(show->duration, token ? token : "");

            token = strtok(NULL, ",");
            strcpy(show->listedin, token ? token : "");

            fclose(file);
            return show;
        }
        free(show);
    }
    fclose(file);
    return NULL;
}

int main() {

    Show* shows[MAX_SHOWS];
    int showCount = 0;
    char input[MAX_TITLE_LENGTH];

    while (fgets(input, sizeof(input), stdin)) {
        input[strcspn(input, "\n")] = 0;  
        if (strcmp(input, "FIM") == 0) {
            break;
        }

        Show* result = ler(input);
        if (result != NULL && showCount < MAX_SHOWS) {
            shows[showCount++] = result;
        }
    }

   
    while (fgets(input, sizeof(input), stdin)) {
        input[strcspn(input, "\n")] = 0; 
        if (strcmp(input, "FIM") == 0) {
            break;
        }

        int found = 0;
        for (int i = 0; i < showCount; i++) {
            
            if (strcasecmp(shows[i]->title, input) == 0) {
                found = 1;
                break;
            }
        }
        printf("%s\n", found ? "SIM" : "NAO");
    }

    

   
    for (int i = 0; i < showCount; i++) {
        free(shows[i]);
    }

    return 0;
}
