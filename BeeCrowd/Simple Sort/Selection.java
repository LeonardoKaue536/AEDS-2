import java.util.Scanner;

public class Selection{

    public static void ordenar(int[] num1) {
        int n = num1.length;
        int temp;
        for (int i = 0; i < n - 1; i++) {
            int menor = i;
            for (int j = i + 1; j < n; j++) {
                if (num1[j] < num1[menor]) {
                    menor = j;
                }
            }
            temp = num1[menor];
            num1[menor] = num1[i];
            num1[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        int[] num1 = new int[3];
        int[] num2 = new int[3];

        for (int i = 0; i < 3; i++) {
            num1[i] = ler.nextInt();
            num2[i] = num1[i];
        }

        ordenar(num1);

        System.out.println(num1[0]);
        System.out.println(num1[1]);
        System.out.println(num1[2]);

        System.out.println();

        System.out.println(num2[0]);
        System.out.println(num2[1]);
        System.out.println(num2[2]);

        ler.close();
    }
}
