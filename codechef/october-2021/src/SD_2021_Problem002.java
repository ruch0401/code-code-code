import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class SD_2021_Problem002 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int[] arr = new int[5];
            for (int i = 0; i < 5; i++) {
                arr[i] = sc.nextInt();
            }
            int c0 = 0, c1 = 0, c2 = 0;
            for (int a: arr) {
                if (a == 0) c0++;
                else if (a == 1) c1++;
                else if (a == 2) c2++;
            }
            int validGames = 5 - c0;
            if (c1 >= validGames / 2 + 1) {
                System.out.println("INDIA");
            } else if (c2 >= validGames / 2 + 1) {
                System.out.println("ENGLAND");
            } else {
                System.out.println("DRAW");
            }
        }
    }
}
