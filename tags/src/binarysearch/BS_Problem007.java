package binarysearch;

/*
 * FIND AN ELEMENT IN A ROTATED SORTED ARRAY:

 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 * You are given a target value to search. If found in the array return its index, otherwise return -1.

 * You may assume no duplicate exists in the array.

 * Your algorithm's runtime complexity must be in the order of O(log n).

 * Example:

 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4

 * PROBLEM STATEMENT LINK: https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class BS_Problem007 {
    public static void main(String[] args) {
        // Note: {9, 8, 7, 6, 5, 4, 3, 2, 1} is not a rotated array and hence not a valid input
        int[][] arr = {{4, 5, 6, 7, 0, 1, 2}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {5, 1, 2, 3, 4}};
        int target = 7;
        for (int[] a : arr) {
            System.out.println(solve(a, target));
        }
    }

    private static int solve(int[] a, int target) {
        int n = a.length;
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (a[mid] == target) {
                return mid;
            } else {
                if (a[lo] <= a[mid]) {
                    if (target >= a[lo] && target < a[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else {
                    if (target > a[mid] && target <= a[hi]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
