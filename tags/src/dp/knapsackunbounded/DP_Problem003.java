package dp.knapsackunbounded;

/*
 * Coin Change Problem Maximum Number of ways
 * Given a value N, if we want to make change for N cents, and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many ways can we make the change? The order of coins doesn’t matter.
 * Example:
 * for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4.
 *
 * PROBLEM STATEMENT LINK:https://www.geeksforgeeks.org/coin-ch...
 */
public class DP_Problem003 {
    public static void main(String[] args) {
        int[][] coins = {{3, 34, 4, 12, 5, 2}, {1, 2, 3}};
        int[] changes = {9, 4};

        for (int i = 0; i < coins.length; i++) {
            int[] coin = coins[i];
            int change = changes[i];

            System.out.println(coinChange(coin, change));
        }
    }

    private static int coinChange(int[] coin, int change) {
        int n = coin.length;
        int[][] dp = new int[n + 1][change + 1];

        for (int[] d : dp) {
            d[0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coin[i - 1] <= j) {
                    dp[i][j] = dp[i][j - coin[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][change];
    }
}
