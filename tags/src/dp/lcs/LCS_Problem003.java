package dp.lcs;

public class LCS_Problem003 {
    public static void main(String[] args) {
        String[] xs = {"ABCDGH", "abcdaf"};
        String[] ys = {"AEDFHR", "abcf"};

        for (int i = 0; i < xs.length; i++) {
            String x = xs[i];
            String y = ys[i];
            int p = x.length();
            int q = y.length();
            System.out.println(printLongestCommonSubsequence(x, y, p, q));
        }
    }

    private static String printLongestCommonSubsequence(String x, String y, int m, int n) {
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
        while (i > 0 || j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                lcs.append(x.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }

        return lcs.reverse().toString();
    }
}
