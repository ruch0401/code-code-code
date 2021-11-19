package heap;

import java.util.PriorityQueue;

/*
 * Given an array and a number k where k is smaller than size of array, we need to find the k’th smallest element in the given array.
 * It is given that all array elements are distinct.
 *
 * Example:
 * Input: arr[] = {7, 10, 4, 3, 20, 15}
 * k = 3
 * Output: 7
 */
public class Heap_Problem001 {
    public static void main(String[] args) {
        int[][] a = {{7, 10, 4, 3, 20, 15}};
        int[] ks = {3};
        for (int i = 0; i < a.length; i++) {
            int[] arr = a[i];
            int k = ks[i];
            System.out.println(kthSmallestElement(arr, k));
        }
    }

    private static int kthSmallestElement(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int elem: arr) {
            pq.add(elem);
            if (pq.size() > 4) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
