package binarysearch;

/*
 * CEILING OF AN ELEMENT IN A SORTED ARRAY:
 *
 * Given a sorted array and a value x, the ceiling of x is the smallest element in array greater than or equal to x, and the floor is the greatest element smaller than or equal to x. Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.
 *
 * Examples :
 *
 * For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
 * For x = 0:    floor doesn't exist in array,  ceil  = 1
 * For x = 1:    floor  = 1,  ceil  = 1
 * For x = 5:    floor  = 2,  ceil  = 8
 * For x = 20:   floor  = 19,  ceil doesn't exist in array
 *
 * PROBLEM STATEMENT LINK:
 */
public class BS_Problem010 {
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

        int res = Integer.MIN_VALUE;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == t) {
                return mid;
            } else if (arr[mid] < t) {
                start = mid + 1;
            } else {
                res = arr[mid];
                end = mid - 1;
            }
        }
        return res;
    }
}
