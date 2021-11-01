package twitter;

import java.util.HashMap;
import java.util.Map;

/*
 * Partitioning the array
 */
public class TT_Problem004 {
    public static void main(String[] args) {
        int[][] arrs = {{1, 2, 3, 4}, {1, 2, 3, 3}, {1, 2, 3, 4}, {3, 3, 3, 6, 6, 6, 9, 9, 9}, {1, 2, 3, 1, 2, 3, 1, 2, 2}, {}, {1}, {1, 2}};
        int[] ks = {2, 2, 3, 3, 3, 1, 1, 2};

        for (int i = 0; i < arrs.length; i++) {
            int[] arr = arrs[i];
            int k = ks[i];
            System.out.println(solve(arr, k));
        }
    }

    private static boolean solve(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;

        if (n % k != 0) {
            return false;
        }

        Map<Integer, Integer> hm = new HashMap<>();
        for (int elem : arr) {
            hm.put(elem, hm.getOrDefault(elem, 0) + 1);
            if (hm.get(elem) > max) {
                max = hm.get(elem);
            }
        }

        return max <= n / k;
    }
}
