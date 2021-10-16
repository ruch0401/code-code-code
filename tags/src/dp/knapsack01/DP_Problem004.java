package dp.knapsack01;

/*
 * Count of subsets sum with a Given sum
 * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.
 * Example:
 *
 * Input: arr[] = {1, 2, 3, 3}, X = 6
 * Output: 3
 * All the possible subsets are {1, 2, 3},
 * {1, 2, 3} and {3, 3}
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/perfect-sum-problem5633/1
 *
 */
public class DP_Problem004 {
    public static void main(String[] args) {
        int[][] set = {{3, 34, 4, 12, 5, 2}, {1, 2, 3, 3}};
        int[] sums = {9, 6};

        for (int i = 0; i < set.length; i++) {
            int[] arr = set[i];
            int sum = sums[i];

            System.out.println(subsetSumGivenSum(arr, sum));
        }
    }

    private static int subsetSumGivenSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];

        for (int[] d: dp) {
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
