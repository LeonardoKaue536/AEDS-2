//package TP3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

class Show {

    private String show_id;
    private String type;
    private String title;
    private String director;
    private String[] cast;
    private String country;
    private Date date;
    private int year;
    private String rating;
    private String duration;
    private String[] listedin;

    public Show() {}

    public Show(String show_id, String type, String title, String director, String[] cast, String country, Date date, int year, String rating, String duration, String[] listedin) {
        this.show_id = show_id;
        this.type = type;
        this.title = title;
        this.director = director;
        this.cast = cast;
        this.country = country;
        this.date = date;
        this.year = year;
        this.rating = rating;
        this.duration = duration;
        this.listedin = listedin;
    }

    public String getShow_id() {
        return show_id;
    }

    public void setShow_id(String show_id) {
        this.show_id = show_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String[] getListedin() {
        return listedin;
    }

    public void setListedin(String[] listedin) {
        this.listedin = listedin;
    }

    public void imprimir() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

        System.out.print("=> " + show_id + " ## ");
        System.out.print(title + " ## ");
        System.out.print(type + " ## ");

        if (director != null && !director.isEmpty()) {
            System.out.print(director + " ## ");
        } else {
            System.out.print("NaN ## ");
        }

        if (cast != null && cast.length > 0 && !cast[0].isEmpty()) {
            System.out.print("[" + String.join(", ", cast) + "] ## ");
        } else {
            System.out.print("[NaN] ## ");
        }

        if (country != null && !country.isEmpty()) {
            System.out.print(country + " ## ");
        } else {
            System.out.print("NaN ## ");
        }

        if (date != null) {
            String formattedDate = dateFormat.format(date);
            System.out.print(formattedDate + " ## ");
        } else {
            System.out.print("NaN ## ");
        }

        if (year != 0) {
            System.out.print(year + " ## ");
        } else {
            System.out.print("0 ## ");
        }

        if (rating != null && !rating.isEmpty()) {
            System.out.print(rating + " ## ");
        } else {
            System.out.print("NaN ## ");
        }

        if (duration != null && !duration.isEmpty()) {
            System.out.print(duration + " ## ");
        } else {
            System.out.print("NaN ## ");
        }

        if (listedin != null && listedin.length > 0 && !listedin[0].isEmpty()) {
            System.out.print("[" + String.join(", ", listedin) + "] ##");
        } else {
            System.out.print("[NaN] ##");
        }

        System.out.println();
    }

    public static Show ler(String idBuscado) {
        String endereco = "/tmp/disneyplus.csv";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

        try (BufferedReader file = new BufferedReader(new FileReader(endereco))) {
            String linha;
            file.readLine(); // pular cabeçalho

            while ((linha = file.readLine()) != null) {
                String[] dados = linha.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (dados[0].equalsIgnoreCase(idBuscado)) {
                    String show_id = dados[0];
                    String type = dados[1];
                    String title = dados[2].replace("\"", "").trim();
                    String director = dados[3].replace("\"", "").trim();

                    String[] cast;
                    if (dados[4].isEmpty()) {
                        cast = new String[]{"NaN"};
                    } else {
                        cast = dados[4].replace("\"", "").split(",\\s*");
                        if (!cast[0].equals("NaN")) {
                            Arrays.sort(cast);
                        }
                    }

                    String country = dados[5].replace("\"", "").trim();

                    Date date_added = null;
                    if (!dados[6].isEmpty()) {
                        try {
                            date_added = dateFormat.parse(dados[6].replace("\"", "").trim());
                        } catch (Exception ignored) {
                        }
                    }

                    int year = 0;
                    if (!dados[7].isEmpty()) {
                        try {
                            year = Integer.parseInt(dados[7].trim());
                        } catch (Exception ignored) {
                        }
                    }

                    String rating = dados[8].trim();
                    String duration = dados[9].trim();

                    String[] listed_in;
                    if (dados[10].isEmpty()) {
                        listed_in = new String[]{"NaN"};
                    } else {
                        String[] temp = dados[10].replace("\"", "").split(",");
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = temp[i].trim();
                        }
                        listed_in = temp;
                    }

                    return new Show(show_id, type, title, director, cast, country, date_added, year, rating, duration, listed_in);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null; // não encontrado
    }
}

class Lista {
    private Show[] array;
    private int n;

    public Lista() {
        this(1000); // Tamanho padrão da lista
    }

    public Lista(int tamanho) {
        array = new Show[tamanho];
        n = 0;
    }

    public void inserirInicio(Show show) throws Exception {
        if (n >= array.length) {
            throw new Exception("Erro: Lista cheia");
        }
        
        // Shift elementos para a direita
        for (int i = n; i > 0; i--) {
            array[i] = array[i-1];
        }

        array[0] = show;
        n++;
    }

    public void inserir(Show show, int pos) throws Exception {
        if (n >= array.length) {
            throw new Exception("Erro: Lista cheia");
        }
        if (pos < 0 || pos > n) {
            throw new Exception("Erro: Posição inválida");
        }

        // Shift elementos para a direita
        for (int i = n; i > pos; i--) {
            array[i] = array[i-1];
        }

        array[pos] = show;
        n++;
    }

    public void inserirFim(Show show) throws Exception {
        if (n >= array.length) {
            throw new Exception("Erro: Lista cheia");
        }

        array[n] = show;
        n++;
    }

    public Show removerInicio() throws Exception {
        if (n == 0) {
            throw new Exception("Erro: Lista vazia");
        }

        Show resp = array[0];
        n--;

        for (int i = 0; i < n; i++) {
            array[i] = array[i+1];
        }

        return resp;
    }

    public Show remover(int pos) throws Exception {
        if (n == 0) {
            throw new Exception("Erro: Lista vazia");
        }
        if (pos < 0 || pos >= n) {
            throw new Exception("Erro: Posição inválida");
        }

        Show resp = array[pos];
        n--;

        for (int i = pos; i < n; i++) {
            array[i] = array[i+1];
        }

        return resp;
    }

    public Show removerFim() throws Exception {
        if (n == 0) {
            throw new Exception("Erro: Lista vazia");
        }

        return array[--n];
    }

    public void mostrar() {
        for (int i = 0; i < n; i++) {
            array[i].imprimir();
        }
    }
}

public class Ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lista lista = new Lista();
        String input = scanner.nextLine();

        // Primeira parte: leitura inicial dos shows
        while (!input.equalsIgnoreCase("FIM")) {
            try {
                Show show = Show.ler(input);
                if (show != null) {
                    lista.inserirFim(show);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            input = scanner.nextLine();
        }

        // Segunda parte: operações de inserção e remoção
        int n = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < n; i++) {
            try {
                String line = scanner.nextLine();
                String[] comando = line.split(" ");

                switch (comando[0]) {
                    case "II": // Inserir Início
                        lista.inserirInicio(Show.ler(comando[1]));
                        break;
                    case "IF": // Inserir Fim
                        lista.inserirFim(Show.ler(comando[1]));
                        break;
                    case "I*": // Inserir em posição específica
                        int pos = Integer.parseInt(comando[1]);
                        lista.inserir(Show.ler(comando[2]), pos);
                        break;
                    case "RI": // Remover Início
                        Show removidoInicio = lista.removerInicio();
                        System.out.println("(R) " + removidoInicio.getTitle());
                        break;
                    case "RF": // Remover Fim
                        Show removidoFim = lista.removerFim();
                        System.out.println("(R) " + removidoFim.getTitle());
                        break;
                    case "R*": // Remover de posição específica
                        pos = Integer.parseInt(comando[1]);
                        Show removido = lista.remover(pos);
                        System.out.println("(R) " + removido.getTitle());
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Mostrar a lista final
        lista.mostrar();
        
        scanner.close();
    }
}
