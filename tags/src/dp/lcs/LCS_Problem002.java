package dp.lcs;


public class LCS_Problem002 {
    public static void main(String[] args) {
        String[] xs = {"ABCDGH"};
        String[] ys = {"AEDFHR"};

        for (int i = 0; i < xs.length; i++) {
            String x = xs[i];
            String y = ys[i];
            int p = x.length();
            int q = y.length();
            System.out.println(longestCommonSubstring(x, y, p, q));
        }
    }

    private static int longestCommonSubstring(String x, String y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // traverse the entire array again to find the maximum value as the substring can occur at any point in the given string
        int max = Integer.MIN_VALUE;
        for (int[] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                max = Math.max(max, ints[j]);
            }
        }
        return max;
    }
}
