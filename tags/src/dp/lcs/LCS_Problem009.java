package dp.lcs;

public class LCS_Problem009 {
    public static void main(String[] args) {
        String[] xs = {"ABCDGH", "AGGTAB", "HELLO", "geek", "aba"};
        String[] ys = {"AEDFHRER", "GXTXAYB", "GEEK", "eke", "abababababababab"};

        for (int i = 0; i < xs.length; i++) {
            String x = xs[i];
            String y = ys[i];
            int p = x.length();
            int q = y.length();
            System.out.println(isSubsequence(x, y));
        }
    }

    public static boolean isSubsequence(String s, String t) {
        return s.length() == lcs(s, t, s.length(), t.length());
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
