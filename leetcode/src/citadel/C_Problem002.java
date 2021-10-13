package citadel;

import java.util.Arrays;

/*
 * Sprint Training | Range Sum and use of Prefix Array
 * Hackerrank
 * Citadel
 */
public class C_Problem002 {
    public static void main(String[] args) {
        int[][] sprints = {{2, 4, 1, 3}, {1, 5, 10, 3}, {1, 5}};
        int[] n = {5, 10, 5};
        for (int i = 0; i < sprints.length; i++) {
            int[] sprint = sprints[i];
            int n1 = n[i];
            System.out.println(solve(sprint, n1));
        }
    }

    private static int solve(int[] sprint, int c) {
        int[] ans = new int[c + 1];
        for (int i = 0; i < sprint.length - 1; i++) {
            int start, end;
            if (sprint[i] < sprint[i + 1]) {
                start = sprint[i];
                end = sprint[i + 1];
            } else {
                start = sprint[i + 1];
                end = sprint[i];
            }
            System.out.println(start + "\t" + end);
            ans[start] += 1;
            if (end + 1 <= c) {
                ans[end + 1] -= 1;
            }
            System.out.println(Arrays.toString(ans));
        }

        // calculate prefix sum of entire array
        for (int i = 1; i < c + 1; i++) {
            ans[i] += ans[i - 1];
        }
        System.out.println("PrefixSum Array: " + Arrays.toString(ans));

        // finding max from the above array and its index
        int max = Integer.MIN_VALUE;
        int res = -1;
        for (int i = 0; i < ans.length; i++) {
            if (max < ans[i]) {
                max = ans[i];
                res = i;
            }
        }
        return res;
    }
}
