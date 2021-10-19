import java.util.Scanner;

public class SD_2021_Problem001 {
    public static void main (String[] args) throws java.lang.Exception  {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            if (a == 7 || b == 7 || c == 7) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
