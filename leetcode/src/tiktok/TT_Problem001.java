package tiktok;

import java.util.Arrays;

/*
 * Matrix Summation
 * https://leetcode.com/discuss/general-discussion/886274/online-assessment-questions-matrix-summation
 */
public class TT_Problem001 {
    public static void main(String[] args) {
        int[][] after = new int[2][2];
        after[0][0] = 2;
        after[0][1] = 5;
        after[1][0] = 7;
        after[1][1] = 17;

        int[][] before = solve(after);

        for (int[] b: before) {
            System.out.println(Arrays.toString(b));
        }
    }

    private static int[][] solve(int[][] after) {
        int[][] before = new int[after.length][after[0].length];
        for (int i = 0; i < after.length; i++) {
            for (int j = 0; j < after[0].length; j++) {
                if (i == 0 && j == 0) {
                    before[i][j] = after[i][j];
                } else if (j == 0) {
                    before[i][j] = after[i][j] - after[i - 1][j];
                } else if (i == 0) {
                    before[i][j] = after[i][j] - after[i][j - 1];
                } else {
                    before[i][j] = after[i][j] + after[i - 1][j - 1] - after[i - 1][j] - after[i][j - 1];
                }
            }
        }
        return before;
    }
}
