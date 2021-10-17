package dp.knapsackunbounded;

/*
 * Rod Cutting Problem
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. Determine the  maximum value obtainable by cutting up the rod and selling the pieces.
 * Example:
 * if length of the rod is 8 and the values of different pieces are given as following, then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/rod-cutting0840/1
 */
public class DP_Problem002 {
    public static void main(String[] args) {
        int[][] prices = {{3, 34, 4, 12, 5, 2}, {1, 5, 8, 9, 10, 17, 17, 20}};
        int[] lengths = {9, 8};

        for (int i = 0; i < prices.length; i++) {
            int[] price = prices[i];
            int n = lengths[i];

            System.out.println(rodCutting(price, n));
        }
    }

    private static int rodCutting(int[] price, int n) {
        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }

        int len = price.length;
        int[][] dp = new int[n + 1][len + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][len];
    }
}
