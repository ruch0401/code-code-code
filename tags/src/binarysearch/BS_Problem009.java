package binarysearch;

/*
 * FIND FLOOR OF AN ELEMENT IN A SORTED ARRAY:
 *
 * Given a sorted array and a value x, the floor of x is the largest element in array smaller than or equal to x. Write efficient functions to find floor of x.
 *
 * Example:
 *
 * Input : arr[] = {1, 2, 8, 10, 10, 12, 19}, x = 5
 * Output : 2
 * 2 is the largest element in arr[] smaller than 5.
 *
 * PROBLEM STATEMENT LINK:https: https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1
 */
public class BS_Problem009 {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 10, 11, 12, 19}, {1, 2, 8, 10, 11, 12, 19}};
        int[] target = {0, 5};
        for (int i = 0; i < arr.length; i++) {
            int[] a = arr[i];
            int t = target[i];
            System.out.println(solve(a, t));
        }
    }

    private static int solve(int[] arr, int t) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        int res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == t) {
                return mid;
            } else if (arr[mid] < t) {
                res = Math.max(res, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
