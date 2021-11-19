package stack;

/*
 * Given an array arr[] of N non-negative integers representing the height of blocks.
 * If width of each block is 1, compute how much water can be trapped between the blocks during the rainy season.
 * https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1
 */
public class Stack_Problem008 {
    public static void main(String[] args) {
        int[][] arr = {{6, 2, 5, 4, 5, 1, 6}, {10, 4, 5, 90, 120, 80}, {3, 0, 0, 2, 0, 4}};
        for (int[] a : arr) {
            System.out.println(rainwaterTrapping(a, a.length));
        }
    }

    private static int rainwaterTrapping(int[] a, int length) {
        int[] mxl = new int[length];
        mxl[0] = a[0];
        for (int i = 1; i < length; i++) {
            mxl[i] = Math.max(mxl[i - 1], a[i]);
        }

        int[] mxr = new int[length];
        mxr[length - 1] = a[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            mxr[i] = Math.max(mxr[i + 1], a[i]);
        }

        int res = 0;
        for (int i = 0; i < length; i++) {
            res += Math.min(mxl[i], mxr[i]) - a[i];
        }
        return res;
    }
}
