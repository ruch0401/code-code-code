package binarysearch;

import java.util.ArrayList;

public class BS_Problem004 {
    public static void main(String[] args) {
        long[][] arr = {{1, 3, 5, 5, 5, 5, 67, 123, 125}, {1, 3, 5, 5, 5, 5, 7, 123, 125}};
        int k = 5;
        for (long[] a : arr) {
            System.out.println(solve(a, k));
        }
    }

    static ArrayList<Long> solve(long[] arr, int x) {
        ArrayList<Long> ans = new ArrayList<>();
        int low = 0;
        int high = arr.length - 1;

        long lowres = Long.MAX_VALUE;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x == arr[mid]) {
                // rather than returning the first index where we find the element, we continue to search for the first index of occurrence
                lowres = Math.min(lowres, mid);
                high = mid - 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        ans.add((lowres == Long.MAX_VALUE) ? -1 : lowres);

        low = 0;
        high = arr.length - 1;
        long hires = Long.MIN_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x == arr[mid]) {
                // rather than returning the first index where we find the element, we continue to search for the last index of occurre
                hires = Math.max(hires, mid);
                low = mid + 1;
            } else if (x < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        ans.add((hires == Long.MIN_VALUE) ? -1 : hires);
        return ans;
    }
}
