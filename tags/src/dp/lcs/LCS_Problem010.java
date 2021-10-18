package dp.lcs;

/*
 * Minimum number of insertions to make a string palindrome
 * Given a string, find the minimum number of characters to be inserted to form Palindrome string out of given string
 *
 * Examples:
 * ab: Number of insertions required is 1. bab
 * aa: Number of insertions required is 0. aa
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1
 */
public class LCS_Problem010 {
    public static void main(String[] args) {
        String[] xs = {"ABCDGH", "abcdaf", "geek", "bbbab"};

        for (String x : xs) {
            System.out.println(countMin(x));
        }
    }

    static int countMin(String str) {
        // Number of insertions = number of deletions required to make string a palindrome
        return str.length() - lps(str);
    }

    static int lps(String s) {
        String a = s;
        String b = new StringBuilder(s).reverse().toString();
        int m = a.length();
        int n = b.length();

        return lcs(a, b, m, n);
    }

    public static int lcs(String a, String b, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
