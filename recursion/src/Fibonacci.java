import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the term of the fibonacci series that you want to find: ");
        int n = sc.nextInt();

        int nthTerm = fibonacci(n);
        System.out.printf("%dth Term of the Fibonacci Series is : %d", n, nthTerm);
    }

    private static int fibonacci(int termN) {
        if (termN == 0 || termN == 1) {
            return termN;
        }
        else {
            return  fibonacci(termN - 1) + fibonacci(termN - 2);
        }
    }
}
