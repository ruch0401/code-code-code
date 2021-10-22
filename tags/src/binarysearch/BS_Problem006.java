package binarysearch;

/*
 * Find the Rotation Count in Rotated Sorted array
 * Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.
 *
 * Examples:
 *
 * Input : arr[] = {15, 18, 2, 3, 6, 12}
 * Output: 2
 * Explanation : Initial array must be {2, 3,
 * 6, 12, 15, 18}. We get the given array after
 * rotating the initial array twice.
 *
 * Input : arr[] = {7, 9, 11, 12, 5}
 * Output: 4
 *
 * Input: arr[] = {7, 9, 11, 12, 15};
 * Output: 0
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/rotation4723/1
 */
public class BS_Problem006 {
    public static void main(String[] args) {
        int[][] arr = {{9, 8, 7, 6, 5, 4, 3, 2, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {5, 1, 2, 3, 4}};
        for (int[] a : arr) {
            System.out.println(solve(a));
        }
    }

    private static int solve(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        // to handle if the array is sorted in decending order
        int mid = start + (end - start) / 2;
        if (arr[mid] <= arr[start] && arr[mid] >= arr[end]) {
            // the array is sorted in decending order
            return end;
        }

        while (start <= end) {
            int mid1 = start + (end - start) / 2;
            int next = (mid1 + 1) % arr.length;
            int prev = (mid1 + arr.length - 1) % arr.length;

            // This checks if the element is minimum by comparing it with the left and right arrays
            if (arr[mid1] <= arr[prev] && arr[mid1] >= arr[next]) {
                return mid1;
            } else {
                // if the array is sorted
                if (arr[mid1] >= arr[start] && arr[mid1] <= arr[end]) {
                    return start;
                }
                // if the right portion of the array is sorted, then discard that part of the array as minimum element is always present in the unsorted array
                else if (arr[mid1] <= arr[end]) {
                    end = mid1 - 1;
                }
                // if the left portion of the array is sorted, then discard that part of the array as minimum element is always present in the unsorted array
                else if (arr[mid1] >= arr[start]) {
                    start = mid1 + 1;
                }
            }
        }
        return -1;
    }
}
