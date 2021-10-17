package dp.lcs;

import java.util.Arrays;

/*
 * Longest Common Subsequence Problem solution using Memoization
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 *
 * For example, “abc”,  “abg”, “bdf”, “aeg”,  ‘”acefg”, .. etc are subsequences of “abcdefg”.
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
 */
public class LCS_Problem001 {
    static int[][] dp = new int[1001][1001];
    public static void main(String[] args) {
        String[] xs = {"ABCDGH"};
        String[] ys = {"AEDFHR"};

        for (int[] d: dp) {
            Arrays.fill(d, - 1);
        }

        for (int i = 0; i < xs.length; i++) {
            String x = xs[i];
            String y = ys[i];
            int p = x.length();
            int q = y.length();
            System.out.println(lcsRecursive(x, y, p, q));
            System.out.println(lcsMemoized(x, y, p, q));
            System.out.println(lcsTopDown(x, y, p, q));
        }
    }

    private static int lcsRecursive(String x, String y, int p, int q) {
        if (p == 0 || q == 0)
            return 0;

        if (x.charAt(p - 1) == y.charAt(q - 1)) {
            return 1 + lcsRecursive(x, y, p - 1, q - 1);
        } else {
            return Math.max(lcsRecursive(x, y, p - 1, q), lcsRecursive(x, y, p, q - 1));
        }
    }

    private static int lcsMemoized(String x, String y, int p, int q) {
        if (p == 0 || q == 0)
            return 0;

        if (dp[p][q] != -1) {
            return dp[p][q];
        }

        if (x.charAt(p - 1) == y.charAt(q - 1)) {
            // We only consider one character at a time. Starting from the rear, if both the characters at the end of the string are the same
            // then the result set i.e. both the strings decrease by 1 in length. And since they are equal, the lcs count increases by 1
            dp[p][q] = 1 + lcsRecursive(x, y, p - 1, q - 1);
        } else {
            // If the last character of both the strings are unequal, it means than we need to consider both the possibilities and decrease the
            // length of each of these strings once and check. Take max of each result
            dp[p][q] = Math.max(lcsRecursive(x, y, p - 1, q), lcsRecursive(x, y, p, q - 1));
        }
        return dp[p][q];
    }

    private static int lcsTopDown(String x, String y, int p, int q) {
        int[][] dp = new int[p + 1][q + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[p][q];
    }
}
