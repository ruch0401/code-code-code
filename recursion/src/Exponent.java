import java.util.Scanner;

public class Exponent {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number and power of that number that you wish to calculate: ");
        int number = sc.nextInt();
        int power = sc.nextInt();

        long result = exponent(number, power);
        System.out.printf("%d raised to the power of %d is %d", number, power, result);
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
}
