import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SD_2021_Problem003 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) {
                    ans.add(arr[i] + 1);
                } else {
                    ans.add(arr[i] - 1);
                }
            }

            for (int elem: ans) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
