import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();//Para eu limpar o Buffer      

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your height(in meters): ");
        double height = scanner.nextDouble();

        System.out.println("Hello " + name);
        System.out.println("You are " + age + " years old");
        System.out.println("You are " + height + "m");


        scanner.close();
    }
}
