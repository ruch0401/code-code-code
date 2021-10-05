import java.util.Scanner;

public class LongChallenge01 {
    public static void main (String[] args) throws java.lang.Exception  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            solve(a, b);
        }
    }

    private static void solve(int a, int b) {
        if (a > 0 && b > 0) {
            System.out.println("Solution");
        } else if (a == 0 && b != 0) {
            System.out.println("Liquid");
        } else if (a != 0 && b == 0) {
            System.out.println("Solid");
        }
    }
}
