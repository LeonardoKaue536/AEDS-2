import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Arquivo {

    // Corrigindo a lógica de verificação
    public static boolean verifica(int n) {
        return n != 200;  // Continua o loop enquanto n não for 200
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        // Lê o número de valores que será processado
        int n = ler.nextInt();
        
        // Executa o loop enquanto n for diferente de 200
        while (verifica(n)) {

            // Grava os valores no arquivo
            gravarValoresArquivo(n, ler);

            // Lê os valores do arquivo de trás para frente
            lerValoresReverso(n);

            // Lê o próximo valor de n para continuar o loop
            n = ler.nextInt();
        }

        // Fecha o scanner após a execução
        ler.close();
    }

    // Método para gravar os valores no arquivo
    public static void gravarValoresArquivo(int n, Scanner scanner) {
        RandomAccessFile arquivo = null;

        try {
            // Abre o arquivo para gravação (rw - leitura e escrita)
            arquivo = new RandomAccessFile("valores.txt", "rw");

            // Grava os números no arquivo
            for (int i = 0; i < n; i++) {
                double numero = scanner.nextDouble();  // Lê o número real
                arquivo.writeDouble(numero);  // Escreve o número no arquivo
            }

        } catch (IOException e) {
            System.out.println("Erro ao gravar os números no arquivo.");
        } finally {
            // Fecha o arquivo
            fecharArquivo(arquivo);
        }
    }

    // Método para ler os valores do arquivo de trás para frente
    public static void lerValoresReverso(int n) {
        RandomAccessFile arquivo = null;

        try {
            // Abre o arquivo para leitura
            arquivo = new RandomAccessFile("valores.txt", "r");

            // Lê os valores de trás para frente
            for (int i = n - 1; i >= 0; i--) {
                arquivo.seek(i * 8);  // Cada número double ocupa 8 bytes
                double numeroLido = arquivo.readDouble();  // Lê o número do arquivo
                System.out.println(numeroLido);  // Exibe o número na tela
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler os números do arquivo.");
        } finally {
            // Fecha o arquivo
            fecharArquivo(arquivo);
        }
    }

    // Método para fechar o arquivo
    public static void fecharArquivo(RandomAccessFile arquivo) {
        try {
            if (arquivo != null) {
                arquivo.close();
            }
        } catch (IOException e) {
            System.out.println("Erro ao fechar o arquivo.");
        }
    }
}
