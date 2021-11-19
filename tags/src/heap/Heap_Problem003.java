package heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Given an array of n elements, where each element is at most k away from its target position,
 * devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2, an
 * element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
 *
 * Example:
 * Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
 * k = 3
 * Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
 */
public class Heap_Problem003 {
    public static void main(String[] args) {
        int[][] a = {{7, 10, 4, 3, 20, 15}, {6, 5, 3, 2, 8, 10, 9}};
        int[] ks = {3, 3};
        for (int i = 0; i < a.length; i++) {
            int[] arr = a[i];
            int k = ks[i];
            System.out.println(Arrays.toString(sortNearlySortedArray(arr, k)));
        }
    }

    private static int[] sortNearlySortedArray(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();
        for (int j : arr) {
            pq.add(j);
            if (pq.size() > k) {
                list.add(pq.poll());
            }
        }
        while (pq.size() > 0) {
            list.add(pq.poll());
        }
        return list.stream().mapToInt(e -> e).toArray();
    }
}
