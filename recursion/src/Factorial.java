import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number for which you want to find the factorial: ");
        int number = sc.nextInt();

        int factorial = factorial(number);
        System.out.printf("Factorial of %d is %d", number, factorial);
    }

    private static int factorial(int number) {
        if (number == 1) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
