package dp.lcs;

/*
 * Shortest Common Supersequence
 * Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
 * Examples:
 *
 * Input:   str1 = "geek",  str2 = "eke"
 * Output: "geeke"
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
 */
public class LCS_Problem004 {
    public static void main(String[] args) {
        String[] xs = {"ABCDGH", "abcdaf", "geek"};
        String[] ys = {"AEDFHR", "abcf", "eke"};

        for (int i = 0; i < xs.length; i++) {
            String x = xs[i];
            String y = ys[i];
            int p = x.length();
            int q = y.length();
            System.out.println(shortestCommonSupersequence(x, y, p, q));
        }
    }

    private static int shortestCommonSupersequence(String x, String y, int m, int n) {
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

        return m + n - dp[m][n];
    }
}
