import java.io.*;
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

    public String getShow_id() { return show_id; }
    public String getTitle() { return title; }

    public static Show ler(String idBuscado) {
        String endereco = "/tmp/disneyplus.csv";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
        try (BufferedReader file = new BufferedReader(new FileReader(endereco))) {
            String linha;
            file.readLine(); // Cabeçalho

            while ((linha = file.readLine()) != null) {
                String[] dados = linha.split(",(?=([^\"']*\"[^\"']*\")*[^\"']*$)", -1);

                if (dados[0].equalsIgnoreCase(idBuscado)) {
                    String show_id = dados[0];
                    String type = dados[1];
                    String title = dados[2].replace("\"", "").trim();
                    String director = dados[3].trim();
                    String[] cast = dados[4].isEmpty() ? new String[]{"NaN"} : dados[4].replace("\"", "").split(",\\s*");
                    String country = dados[5].trim();
                    Date date_added = null;
                    if (!dados[6].isEmpty()) {
                        try {
                            date_added = dateFormat.parse(dados[6].replace("\"", "").trim());
                        } catch (Exception ignored) {}
                    }
                    int year = 0;
                    if (!dados[7].isEmpty()) {
                        try {
                            year = Integer.parseInt(dados[7].trim());
                        } catch (Exception ignored) {}
                    }
                    String rating = dados[8].trim();
                    String duration = dados[9].trim();
                    String[] listed_in = dados[10].isEmpty() ? new String[]{"NaN"} : dados[10].replace("\"", "").split(",");

                    return new Show(show_id, type, title, director, cast, country, date_added, year, rating, duration, listed_in);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void imprimir() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);
        System.out.print("=> " + show_id + " ## ");
        System.out.print(title + " ## ");
        System.out.print(type + " ## ");
        System.out.print((director != null && !director.isEmpty() ? director : "NaN") + " ## ");
        if (cast != null && cast.length > 0 && !cast[0].isEmpty()) {
            Arrays.sort(cast);
            System.out.print("[" + String.join(", ", cast) + "]" + " ## ");
        } else {
            System.out.print("[NaN]" + " ## ");
        }
        System.out.print((country != null && !country.isEmpty() ? country : "NaN") + " ## ");
        System.out.print(date != null ? dateFormat.format(date) : "NaN" + " ## ");
        System.out.print(year != 0 ? year : "0" + " ## ");
        System.out.print((rating != null && !rating.isEmpty() ? rating : "NaN") + " ## ");
        System.out.print((duration != null && !duration.isEmpty() ? duration : "NaN") + " ## ");
        if (listedin != null && listedin.length > 0 && !listedin[0].isEmpty()) {
            Arrays.sort(listedin);
            System.out.print("[" + String.join(", ", listedin) + "]" + " ## ");
        } else {
            System.out.print("[NaN]" + " ## ");
        }
        System.out.println();
    }
}

public class Ordenacounting {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        int[] comparacoes = {0};
        int[] movimentacoes = {0};

        Scanner sc = new Scanner(System.in);
        List<Show> lista = new ArrayList<>();

        while (sc.hasNextLine()) {
            String entrada = sc.nextLine();
            if (entrada.equals("FIM")) break;

            Show s = Show.ler(entrada);
            if (s != null) lista.add(s);
        }

        countingSort(lista, comparacoes, movimentacoes);

        for (Show s : lista) {
            s.imprimir();
        }

        while (sc.hasNextLine()) {
            String entrada = sc.nextLine();
            if (entrada.equals("FIM")) break;

            boolean achou = false;
            for (Show s : lista) {
                comparacoes[0]++;
                if (s.getTitle().equalsIgnoreCase(entrada)) {
                    achou = true;
                    break;
                }
            }
            System.out.println(achou ? "SIM" : "NAO");
        }

        sc.close();
        long fim = System.currentTimeMillis();
        long tempo = fim - inicio;

        try {
            PrintWriter pw = new PrintWriter("matricula_counting.txt");
            pw.println("SEU_NUMERO_DE_MATRICULA\t" + comparacoes[0] + "\t" + movimentacoes[0] + "\t" + tempo);
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void countingSort(List<Show> lista, int[] comparacoes, int[] movimentacoes) {
        int tam = lista.size();
        Show[] saida = new Show[tam];
        int[] count = new int[256]; // ASCII

        for (int i = 0; i < tam; i++) {
            String titulo = lista.get(i).getTitle().toLowerCase();
            char c = titulo.length() > 0 ? titulo.charAt(0) : 0;
            count[c]++;
            comparacoes[0]++;
        }

        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }

        for (int i = tam - 1; i >= 0; i--) {
            String titulo = lista.get(i).getTitle().toLowerCase();
            char c = titulo.length() > 0 ? titulo.charAt(0) : 0;
            saida[count[c] - 1] = lista.get(i);
            count[c]--;
            movimentacoes[0]++;
        }

        for (int i = 0; i < tam; i++) {
            lista.set(i, saida[i]);
        }
    }
}