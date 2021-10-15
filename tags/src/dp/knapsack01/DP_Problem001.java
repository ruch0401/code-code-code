package dp.knapsack01;

import java.util.Arrays;

/*
 * 0/1 Knapsack Problem
 * Given weights and values of n items,
 * put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
 * Dynamic Programming
 */
public class DP_Problem001 {
    public static void main(String[] args) {
        int[][] wts = {{1, 2, 3}, {1, 3, 4, 5}, {10, 20, 30}};
        int[][] vals = {{10, 15, 40}, {1, 4, 5, 7}, {60, 100, 120}};
        int[] Ws = {6, 7, 50};

        for (int i = 0; i < wts.length; i++) {
            int[] wt = wts[i];
            int[] val = vals[i];
            int W = Ws[i];

            System.out.println(solve01Knapsack(wt, val, W));
        }
    }

    private static int solve01Knapsack(int[] wt, int[] val, int w) {
        int n = wt.length;
        int[][] dp = new int[n + 1][w + 1];

        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        // Initialize the 2D DP array for base conditions
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    // replacing n(size of the weight array) -> i and w(total weight) -> j
                    // since the element has been chosen to either be included or excluded, the count of remaining elements is n - 1
                    // if included -> weight of that element is decreased hence, j - wt[i - 1]
                    // if included, the value of that element is also added -> val[i - 1] + dp[i - 1][j - wt[i - 1]]
                    // if excluded, there is no weight deduction nor contribution hence dp[i - 1][j]
                    // we need to find maximum from both
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    // if the weight of the element being considered is greater than the available weight of the knapsack,
                    // that element is not chosen. Hence, dp[i][j] = dp[i - 1][j]
                    // i - 1 is done because although the element is not to be included, but it has been processed so the solution space decreases by 1
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[n][w];
    }
}
