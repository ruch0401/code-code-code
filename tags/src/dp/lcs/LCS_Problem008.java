package dp.lcs;

import java.util.Arrays;

/*
 * Longest Repeating Subsequence
 * Given a string, print the longest repeating subsequence such that the two subsequence don’t have same string character at same position, i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
 * Example:
 * Input: str = "aab"
 * Output: "a"
 * The two subsequence are 'a'(first) and 'a'
 * (second). Note that 'b' cannot be considered
 * as part of subsequence as it would be at same
 * index in both.
 *
 * PROBLEM STATEMENT LINK:https://www.geeksforgeeks.org/longest...
 *
 */
public class LCS_Problem008 {
    public static void main(String[] args) {
        String[] xs = {"aab", "AABEBCDD", "geek", "bbbaba"};

        for (String x : xs) {
            System.out.println(longestRepeatingSubsequence(x));
        }
    }

    private static int longestRepeatingSubsequence(String x) {
        return lcs(x, x, x.length(), x.length());
    }

    private static int lcs(String a, String b, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // printing the DP array
        for (int[] d: dp) {
            System.out.println(Arrays.toString(d));
        }

        // outputting the longest repeating subsequence as well
        // printing of the LRS is different than standard printing of LCS. We do not compare the characters as it will always turn out to be the same
        // instead, we compare the dp[][] array values
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                lcs.append(a.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] ==  dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.println(lcs.reverse());
        return dp[m][n];
    }
}
