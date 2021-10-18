package dp.lcs;

import java.util.Arrays;

/*
 * Given two strings X and Y, print the shortest string that has both X and Y as subsequences. If multiple shortest supersequence exists, print any one of them.

 * Examples:
 *
 * Input: X = "AGGTAB",  Y = "GXTXAYB"
 * Output: "AGXGTXAYB" OR "AGGXTXAYB"
 * OR Any string that represents shortest
 * supersequence of X and Y
 *
 * Input: X = "HELLO",  Y = "GEEK"
 * Output: "GEHEKLLO" OR "GHEEKLLO"
 * OR Any string that represents shortest
 * supersequence of X and Y
 *
 * PROBLEM STATEMENT LINK: https://www.geeksforgeeks.org/print-shortest-common-supersequence/
 */
public class LCS_Problem007 {
    public static void main(String[] args) {
        String[] xs = {"ABCDGH", "AGGTAB", "HELLO", "geek"};
        String[] ys = {"AEDFHRER", "GXTXAYB", "GEEK", "eke"};

        for (int i = 0; i < xs.length; i++) {
            String x = xs[i];
            String y = ys[i];
            int p = x.length();
            int q = y.length();
            System.out.println(printShortestCommonSupersequence(x, y, p, q));
        }
    }

    private static String printShortestCommonSupersequence(String x, String y, int m, int n) {
        StringBuilder lcs = new StringBuilder();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // code to print the longest common subsequence -> we get the lcs in reverse.
        int i = m, j = n;
        while (i > 0 && j > 0) {
            System.out.println(i + "\t" + j + "\t" + lcs);
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                lcs.append(x.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    lcs.append(x.charAt(i - 1));
                    i--;
                } else {
                    lcs.append(y.charAt(j - 1));
                    j--;
                }
            }
        }

        while (i > 0) {
            lcs.append(x.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            lcs.append(y.charAt(j - 1));
            j--;
        }

        return lcs.reverse().toString();
    }
}
