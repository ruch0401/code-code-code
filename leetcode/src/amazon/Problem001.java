package amazon;

import java.util.Arrays;
import java.util.List;

public class Problem001 {
    public static void main(String[] args) {
//        List<String> list = List.of("1010", "0101", "1010");
        List<String> list = List.of("101", "001", "110");
        int ans = getMaximumGreyness(list);
        System.out.println(ans);
    }

    public static int getMaximumGreyness(List<String> pixels) {
        int m = pixels.get(0).length();
        int n = pixels.size();

        int[][] grid = new int[n][m];
        for (int i = 0; i < pixels.size(); i++) {
            for (int j = 0; j < pixels.get(0).length(); j++) {
                grid[i][j] = Integer.parseInt(pixels.get(i).charAt(j) + "");
            }
        }

        int[][] ans = new int[n][m];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < pixels.size(); i++) {
            for (int j = 0; j < pixels.get(0).length(); j++) {
                ans[i][j] = getAns(grid, i, j);
                max = Math.max(max, ans[i][j]);
            }
        }

        for (int i = 0; i < pixels.size(); i++) {
            System.out.println(Arrays.toString(ans[i]));
        }
        return max;
    }

    private static int getAns(int[][] grid, int i, int j) {
        int countOnesRows = 0;
        int countZeroesRows = 0;
        int countOnesCols = 0;
        int countZeroesCols = 0;

        int[] col = getColumn(grid, j);
        for (int elem: col) {
            if (elem == 0) {
                countZeroesCols++;
            } else {
                countOnesCols++;
            }
        }

        int[] row = grid[i];
        for (int elem: row) {
            if (elem == 0) {
                countZeroesRows++;
            } else {
                countOnesRows++;
            }
        }

        return (countOnesRows + countOnesCols) - (countZeroesRows + countZeroesCols);
    }

    public static int[] getColumn(int[][] array, int index) {
        int[] column = new int[array[0].length];
        for (int i = 0; i < column.length; i++) {
            column[i] = array[i][index];
        }
        return column;
    }
}
