import java.util.Scanner;

public class Exponent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number and power of that number that you wish to calculate: ");
        int number = sc.nextInt();
        int power = sc.nextInt();

        System.out.println("Using Normal Exponentiation");
        long result = exponent(number, power);
        System.out.printf("%d raised to the power of %d is %d", number, power, result);

        System.out.println("\nUsing Fast Exponentiation");
        long resultFast = exponentFast(number, power);
        System.out.printf("%d raised to the power of %d is %d", number, power, resultFast);
    }

    private static long exponent(int number, int power) {
        // base case
        if (power == 0)
            return 1;

        // recursion followed by actual operation -> HEAD Recursion approach -> Evident after making the recursion tree
        long temp = exponent(number, power - 1);
        return number * temp;

        // lines 19 and 20 can be combined in the following manner
        // return number * exponent(number, power - 1);
    }

    private static long exponentFast(int number, int power) {
        if (power == 0)
            return 1;

        // recursion step -> HEAD recursion approach
        long small_ans = exponentFast(number, power / 2);

        // work step -> follows recursion step hence HEAD recursion
        // even power
        if (power % 2 == 0)
            return small_ans * small_ans;
        else
            return number * small_ans * small_ans;
    }
}
