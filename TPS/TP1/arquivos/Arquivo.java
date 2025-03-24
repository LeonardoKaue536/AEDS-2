//package TP1.arquivos;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Arquivo {

    public static boolean verifica(int n){
        if (n != 200) {
            return false;
        }
         return true;
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        int n = ler.nextInt();
        while (verifica(n)) {

            gravarValoresArquivo(n, ler);
         
            lerValoresReverso(n);
            
            n = ler.nextInt();
        }

        ler.close();
    }

    public static void gravarValoresArquivo(int n, Scanner scanner) {
        RandomAccessFile arquivo = null;

        try {
            arquivo = new RandomAccessFile("valores.txt", "rw");

            for (int i = 0; i < n; i++) {
                double numero = scanner.nextDouble();
                arquivo.writeDouble(numero);
            }

        } catch (IOException e) {
            System.out.println("Erro ao gravar os números no arquivo.");
        } finally {
            fecharArquivo(arquivo);
        }
    }

    public static void lerValoresReverso(int n) {
        RandomAccessFile arquivo = null;

        try {
            arquivo = new RandomAccessFile("valores.txt", "r");

            for (int i = n - 1; i >= 0; i--) {
                arquivo.seek(i * 8); 
                double numeroLido = arquivo.readDouble();
                System.out.println(numeroLido);
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler os números do arquivo.");
        } finally {
            fecharArquivo(arquivo);
        }
    }

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