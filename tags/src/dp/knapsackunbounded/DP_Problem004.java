package dp.knapsackunbounded;

/*
 * Coin Change Problem Minimum Numbers of coins
 * Given a value V, if we want to make change for V cents, and we have infinite supply of each of C = { C1, C2, .. , Cm} valued coins, what is the minimum number of coins to make the change?
 * Example:
 *
 * Input: coins[] = {25, 10, 5}, V = 30
 * Output: Minimum 2 coins required
 * We can use one coin of 25 cents and one of 5 cents
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/number-of-coins1824/1
 */
public class DP_Problem004 {
    public static void main(String[] args) {
        int[][] coins = {{3, 34, 4, 12, 5, 2}, {1, 2, 3}, {25, 10, 5}, {9, 6, 5, 1} };
        int[] changes = {9, 4, 30, 11};

        for (int i = 0; i < coins.length; i++) {
            int[] coin = coins[i];
            int change = changes[i];

            System.out.println(coinChange(coin, change));
        }
    }

    private static int coinChange(int[] coin, int change) {
        int n = coin.length;
        int[][] dp = new int[n + 1][change + 1];

        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int j = 1; j < dp[0].length; j++) {
            if (j % coin[0] == 0)
                dp[1][j] = j / coin[0];
            else
                dp[1][j] = Integer.MAX_VALUE - 1;
        }

        for (int i = 2; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (coin[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coin[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][change];
    }
}
