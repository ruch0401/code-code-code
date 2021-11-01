package twitter;

/*
 * Coloring the Blocks
 */
public class TT_Problem007 {
    public static void main(String[] args) {
        int[][] colors1 = {{1, 2, 3}, {1, 2, 3}, {3, 3, 1}};
        int[][] colors2 = {{1, 2, 2}, {2, 2, 1}, {2, 1, 2}};
        System.out.println(colorBlocks(colors1));
        System.out.println(colorBlocks(colors2));
    }

    private static int colorBlocks(int[][] colors) {
        for (int i = 1; i < colors.length; i++) {
            colors[i][0] += Math.min(colors[i - 1][1], colors[i - 1][2]);
            colors[i][1] += Math.min(colors[i - 1][0], colors[i - 1][2]);
            colors[i][2] += Math.min(colors[i - 1][0], colors[i - 1][1]);
        }

        int n = colors.length - 1;
        return Math.min(Math.min(colors[n][0], colors[n][1]), colors[n][2]);
    }
}
