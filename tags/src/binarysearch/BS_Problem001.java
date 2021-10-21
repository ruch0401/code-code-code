package binarysearch;

/*
 * Given a sorted array arr[] of n elements, write a function to search a given element x in arr[].
 *
 * Binary Search: Search a sorted array by repeatedly dividing the search interval in half. Begin with an interval covering the whole array. If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half. Otherwise narrow it to the upper half. Repeatedly check until the value is found or the interval is empty.
 *
 * PROBLEM STATEMENT LINK: https://practice.geeksforgeeks.org/problems/who-will-win-1587115621/1
 */
public class BS_Problem001 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println(solve(arr, 4));
    }

    private static int solve(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (k == arr[mid]) {
                return mid;
            } else if (k < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
