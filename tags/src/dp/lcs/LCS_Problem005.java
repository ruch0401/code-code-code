package dp.lcs;


/*
 * Minimum number of deletions and insertions to transform one string into another
 * Given two strings ‘str1’ and ‘str2’ of size m and n respectively. The task is to remove/delete and insert minimum number of characters from/in str1 so as to transform it into str2. It could be possible that the same character needs to be removed/deleted from one point of str1 and inserted to some another point.
 * Example:
 * Input : str1 = "geeksforgeeks", str2 = "geeks"
 * Output : Minimum Deletion = 8
 *          Minimum Insertion = 0
 *
 * PROBLEM STATEMENT LINK:
 */
public class LCS_Problem005 {
    public static void main(String[] args) {
        String[] xs = {"ABCDGH", "abcdaf", "geek"};
        String[] ys = {"AEDFHR", "abcf", "eke"};

        for (int i = 0; i < xs.length; i++) {
            String x = xs[i];
            String y = ys[i];
            int p = x.length();
            int q = y.length();
            numberOfInsertionsAndDeletions(x, y, p, q);
        }
    }

    private static void numberOfInsertionsAndDeletions(String x, String y, int m, int n) {
        int l = lcs(x, y, m, n);
        System.out.println("Insertions: " + (n - l));
        System.out.println("Deletions: " + (m - l));
    }

    private static int lcs(String x, String y, int m, int n) {
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
        return dp[m][n];
    }

    // Levenshtein Distance
    // O(nm) time | O(nm) space
    // where n = length of the first input string and m = length of the second input string
    public static int levenshteinDistance(String str1, String str2) {
        int p = str1.length();
        int q = str2.length();

        int[][] dp = new int[p + 1][q + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                }
            }
        }
        return dp[p][q];
    }
}