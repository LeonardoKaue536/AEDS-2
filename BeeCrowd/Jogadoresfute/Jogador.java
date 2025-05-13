package Jogadoresfute;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Jogadores {
    private String Nome;
    private String Foto;
    private Date Nascimento;
    private int Id;
    private int[] Times;

    public Jogadores() {}

    public Jogadores(String nome, String foto, Date nascimento, int id, int[] times) {
        Nome = nome;
        Foto = foto;
        Nascimento = nascimento;
        Id = id;
        Times = times;
    }

    public void setFoto(String foto) {
        Foto = foto;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setNascimento(Date nascimento) {
        Nascimento = nascimento;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setTimes(int[] times) {
        Times = times;
    }

    public String getFoto() {
        return Foto;
    }

    public int getId() {
        return Id;
    }

    public Date getNascimento() {
        return Nascimento;
    }

    public String getNome() {
        return Nome;
    }

    public int[] getTimes() {
        return Times;
    }

    // Lê uma linha CSV e retorna um objeto Jogadores
    public static Jogadores ler(String linha) throws ParseException {
        Jogadores j = new Jogadores();

        // Split limitado a 7 partes por segurança com campos extras
        String[] dados = linha.split(",", 7);
        j.setId(Integer.parseInt(dados[5].trim()));
        j.setNome(dados[1].trim());
        j.setFoto(dados[2].trim());

        // Parse da data
        SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
        j.setNascimento(sdf.parse(dados[3].trim()));

        // Parse do array de times: remove colchetes e aspas, separa por vírgulas
        String timesStr = dados[6].replaceAll("[\\[\\]\"]", "");
        String[] timesArray = timesStr.split(",");
        int[] times = new int[timesArray.length];
        for (int i = 0; i < timesArray.length; i++) {
            times[i] = Integer.parseInt(timesArray[i].trim());
        }
        j.setTimes(times);

        return j;
    }

    // Imprime os dados no formato: id nome nascimento foto (times)
    public void imprimir() {
        SimpleDateFormat sdf = new SimpleDateFormat("d/MM/yyyy");
        System.out.print(Id + " " + Nome + " " + sdf.format(Nascimento) + " " + Foto + " (");
        for (int i = 0; i < Times.length; i++) {
            System.out.print(Times[i]);
            if (i < Times.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(")");
    }
}

public class Jogador {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Jogadores> jogadores = new ArrayList<>();

        while (sc.hasNextLine()) {
            String linha = sc.nextLine();
            if (linha.equals("FIM")) break;

            Jogadores j = Jogadores.ler(linha);
            jogadores.add(j);
        }

        for (Jogadores j : jogadores) {
            j.imprimir();
        }

        sc.close();
    }
}
