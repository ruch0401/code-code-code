package twitter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * Unique Twitter User ID Set
 */
public class TT_Problem001 {
    public static void main(String[] args) {
        int[][] arrs = {{3, 2, 1, 2, 7}, {1, 2, 2}};
        for (int[] arr : arrs) {
            System.out.println(solve2(arr));
        }
    }

    // This is the Brute Force approach and will cause a TLE
    private static int solve(int[] arr) {
        int sum = 0;
        Set<Integer> hs = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            while (true) {
                if (hs.contains(arr[i])) {
                    arr[i]++;
                } else {
                    break;
                }
            }
            hs.add(arr[i]);
            sum += arr[i];
        }
        return sum;
    }

    private static int solve2(int[] arr) {
        Arrays.sort(arr);
        int sum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
            sum += arr[i];
        }
        return sum;
    }
}
