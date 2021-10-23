package binarysearch;

/*
 * SEARCH IN A NEARLY SORTED ARRAY:

 * Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions, i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array. Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].
 *
 * For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.
 *
 * Example :
 * Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
 * Output: 2
 * Output is index of 40 in given array
 *
 * PROBLEM STATEMENT LINK: https://www.geeksforgeeks.org/search-almost-sorted-array/
 */
public class BS_Problem008 {
    public static void main(String[] args) {
        int[][] arr = {{10, 3, 40, 20, 50, 80, 70}, {10, 3, 40, 20, 50, 80, 70}};
        int[] target = {40, 90};
        for (int i = 0; i < arr.length; i++) {
            int[] a = arr[i];
            int t = target[i];
            System.out.println(solve(a, t));
        }
    }

    private static int solve(int[] arr, int target) {
        int n = arr.length - 1;
        int lo = 0;
        int hi =n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (mid > lo && arr[mid - 1] == target) {
                return mid - 1;
            } else if (mid < hi && arr[mid + 1] == target) {
                return mid + 1;
            } else if (target > arr[mid]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
