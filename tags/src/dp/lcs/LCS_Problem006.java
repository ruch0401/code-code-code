package dp.lcs;

/*
 * Longest Palindromic Subsequence
 * Given a sequence, find the length of the longest palindromic subsequence in it.
 * Example :
 * Input:"bbbab"
 * Output:4
 *
 * PROBLEM STATEMENT LINK: https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/
 */
public class LCS_Problem006 {
    public static void main(String[] args) {
        String[] xs = {"ABCDGH", "abcdaf", "geek", "bbbab"};

        for (String x : xs) {
            System.out.println(longestPalindromicSubsequence(x));
        }
    }

    private static int longestPalindromicSubsequence(String x) {
        StringBuilder sb = new StringBuilder(x);
        String y = sb.reverse().toString();
        return lcs(x, y, x.length(), y.length());
    }

    private static int lcs(String x, String y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[j - 1][i]);
                }
            }
        }
        return dp[m][n];
    }
}
