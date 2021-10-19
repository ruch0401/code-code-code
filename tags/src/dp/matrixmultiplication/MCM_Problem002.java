package dp.matrixmultiplication;

import java.util.Arrays;

/*
 * Palindrome Partitioning using Recursion
 * Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
 * Example:
 *   “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/palindromic-patitioning4845/1#
 */
public class MCM_Problem002 {
    static int[][] dp = new int[501][501];
    static int left = -1;
    static int right = -1;
    public static void main(String[] args) {
        String[] ss = {"ababbbabbababa", "abaaaabbbabababaa"};
        for(int[] d: dp) {
            Arrays.fill(d, -1);
        }
        for (String s: ss) {
            System.out.println(palindromePartitioning(s));
        }
    }

    private static int palindromePartitioning(String s) {
        int i = 0;
        int j = s.length() - 1;
        return solve(s, i, j);
    }

    private static int solve(String s, int i, int j) {
        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (isPalindrome(s, i, j)) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            // For better optimization -> we are also checking if the initial 2 problem division has been solved previously or not
            if (dp[i][k] != -1) {
                left = dp[i][k];
            } else {
                left = solve(s, i, k);
                dp[i][k] = left;
            }

            if (dp[k + 1][j] != -1) {
                right = dp[k + 1][j];
            } else {
                right = solve(s, k + 1, j);
                dp[k + 1][j] = right;
            }
            int temp = 1 + left + right;
            min = Math.min(min, temp);
        }
        dp[i][j] = min;
        return dp[i][j];
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
