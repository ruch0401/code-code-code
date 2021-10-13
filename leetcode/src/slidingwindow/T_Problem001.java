package slidingwindow;

import java.util.*;

/*
 * Birthday card collection
 * Hackerrank
 * Twitter | Goldmann Sachs
 *
 */
public class T_Problem001 {
    public static void main(String[] args) {
        int[][] collections = {{4, 6, 12, 8}, {2, 4, 5}, {1, 2, 3, 4}};
        int[] ds = {14, 7, 5};

        for (int i = 0; i < ds.length; i++) {
            int[] collection = collections[i];
            int d = ds[i];
            System.out.println(Arrays.toString(solve(collection, d)));
        }
    }

    private static int[] solve(int[] collection, int d) {
        List<Integer> list = new ArrayList<>();

        Set<Integer> set = new HashSet<>();
        for (int c : collection) {
            set.add(c);
        }

        int sum = 0;
        for (int i = 1; i <= d; i++) {
            if (set.add(i)) {
                sum += i;
                if (sum > d) {
                    break;
                }
                list.add(i);
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
