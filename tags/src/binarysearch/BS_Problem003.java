package binarysearch;

/*
 * ORDER AGNOSTIC SEARCH
 * Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
 * Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
 */
public class BS_Problem003 {
    public static void main(String[] args) {
        int[][] arr = {{9, 8, 7, 6, 5, 4, 3, 2, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9}};
        int k = 4;
        for (int[] a : arr) {
            System.out.println(solve(a, k));
        }
    }

    private static int solve(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (k == arr[mid]) {
                return mid;
            } else {
                if (arr[low] < arr[high]) {
                    // The array is in ascending order
                    if (k < arr[mid]) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    // The array is sorted in descending order
                    if (k < arr[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return -1;
    }
}
