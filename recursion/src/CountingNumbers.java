import java.util.Scanner;

public class CountingNumbers {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number till where you want to print the series: ");
        int n = sc.nextInt();

        System.out.println("Tail Recursion");
        printNumbersTail(n);

        System.out.println("\nHead Recursion");
        printNumbersHead(n);
    }

    private static void printNumbersHead(int number) {
        if (number == 0)
            return;
        else
            printNumbersHead(number - 1);
        System.out.print(number + " ");
    }

    private static void printNumbersTail(int number) {
        if (number == 0)
            return;
        else
            System.out.print(number + " ");
        printNumbersTail(number - 1);
    }
}
