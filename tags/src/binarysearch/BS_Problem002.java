package binarysearch;

/*
 * BINARY SEARCH ON REVERSE SORTED ARRAY:
 *
 * Let's suppose that we have an array sorted in descending order and we want to find index of an element e within this array. Binary search in every step picks the middle element (m) of the array and compares it to e. If these elements are equal, than it returns the index of m. If e is greater than m, than e must be located in the left subarray. On the contrary, if m greater than e, e must be located in the right subarray. At this moment binary search repeats the step on the respective subrarray.
 *
 * Because the algoritm splits in every step the array in half (and one half of the array is never processed) the input element must be located (or determined missing) in at most \\log_{2}{n} steps.
 *
 * PROBLEM STATEMENT LINK:
 */
public class BS_Problem002 {
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        int k = 4;
        System.out.println(solve(arr, k));
    }

    private static int solve(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (k == arr[mid]) {
                return mid;
            } else if (k < arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
