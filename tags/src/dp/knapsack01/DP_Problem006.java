package dp.knapsack01;

import java.util.Arrays;

/*
 * Count number of subsets with a given differences
 * Difference of sums of the 2 subsets should be equal to the given difference
 */
public class DP_Problem006 {
    public static void main(String[] args) {
        int[][] set = {{3, 34, 4, 12, 5, 2}, {1, 2, 3, 3}, {1, 1, 2, 3}};
        int[] diffs = {9, 6, 1};

        for (int i = 0; i < set.length; i++) {
            int[] arr = set[i];
            int diff = diffs[i];

            System.out.println(countSubsetsWithGivenDifference(arr, diff));
        }
    }

    private static int countSubsetsWithGivenDifference(int[] arr, int diff) {
        int s = Arrays.stream(arr).sum();
        return ((s + diff) % 2 != 0) ? 0 : countSubsetSum(arr, (s + diff) / 2);
    }

    private static int countSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int[] d : dp) {
            d[0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }
}
