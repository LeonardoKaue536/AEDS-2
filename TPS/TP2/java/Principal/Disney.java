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
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);

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
        String endereco = "disneyplus.csv";
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy", Locale.ENGLISH);

        try (BufferedReader file = new BufferedReader(new FileReader(endereco))) {
            String linha;
            file.readLine(); // pular cabeçalho

            while ((linha = file.readLine()) != null) {
                String[] dados = linha.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (dados[0].equalsIgnoreCase(idBuscado)) {
                    String show_id = dados[0];
                    String type = dados[1];
                    String title = dados[2].replace("\"", "").trim();
                    String director = dados[3].trim();

                    String[] cast;
                    if (dados[4].isEmpty()) {
                        cast = new String[]{"NaN"};
                    } else {
                        cast = dados[4].replace("\"", "").split(",\\s*");
                    }

                    String country = dados[5].trim();

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

public class Disney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        while (!input.equalsIgnoreCase("FIM")) {
            Show resultado = Show.ler(input);

            if (resultado != null) {
                resultado.imprimir();
            }

            input = scanner.nextLine();
        }

        scanner.close();
    }
}
