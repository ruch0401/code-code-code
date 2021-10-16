package dp.knapsack01;

/*
 * Equal Sum Partition Problem
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of elements in both subsets is same.
 * Examples:
 * arr[] = {1, 5, 11, 5}
 * Output: true
 * The array can be partitioned as {1, 5, 5} and {11}
 */
public class DP_Problem003 {
    public static void main(String[] args) {
        int[][] set = {{1, 5, 11, 5}};

        for (int[] arr : set) {
            System.out.println(equalSumPartition(arr));
        }
    }

    private static boolean equalSumPartition(int[] arr) {
        int sum = 0;
        for (int a: arr) {
            sum += a;
        }

        if (sum % 2 != 0) {
            return false;
        } else {
            sum = sum / 2;
            return solve01Knapsack(arr, sum);
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
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
