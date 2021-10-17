package dp.knapsack01;

import java.util.Arrays;

/*
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 */
public class DP_Problem007 {
    public static void main(String[] args) {
        int[][] set = {{1, 1, 1, 1, 1}, {1}, {0, 0, 0, 0, 0, 0, 0, 0, 1}, {100}};
        int[] sums = {3, 1, 1, -200};

        for (int i = 0; i < set.length; i++) {
            int[] arr = set[i];
            int sum = sums[i];

            System.out.println(targetSum(arr, sum));
        }
    }

    private static int targetSum(int[] arr, int target) {
        int sum = Arrays.stream(arr).sum();
        int cal = sum + target;

        return (cal % 2 != 0) ? 0 : countSubsetSum(arr, Math.abs(cal / 2));
    }

    private static int countSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        dp[0][0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
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
