package dp.knapsack01;

import java.util.Arrays;

/*
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set
 * with sum equal to given sum.
 * Example:
 *
 * Input:  set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output:  True  //There is a subset (4, 5) with sum 9.
 */
public class DP_Problem002 {
    public static void main(String[] args) {
        int[][] set = {{3, 34, 4, 12, 5, 2}};
        int[] sums = {9};

        for (int i = 0; i < set.length; i++) {
            int[] arr = set[i];
            int sum = sums[i];

            System.out.println(solve01Knapsack(arr, sum));
        }
    }

    private static boolean solve01Knapsack(int[] arr, int sum) {

        int n = arr.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (boolean[] d: dp) {
            d[0] = true;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                // with array of size 0, can we have a subarray with sum 's'? No.

                // columns store the size of the array
                // rows store every possible sum value eg. if sum = 4, then row will store 0, 1, 2, 3, 4
                // subproblem = for array size = n and sum = s, does a subset of array exist with sum = s
                // the condition j == 0 means that the sum is required to be 0, does a subarray of size 's' exist with sum = 0
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        for (boolean[] d: dp) {
            System.out.println(Arrays.toString(d));
        }
        return dp[n][sum];
    }
}
