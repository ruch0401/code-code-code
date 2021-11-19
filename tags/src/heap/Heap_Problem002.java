package heap;

import java.util.*;

/*
 * Write an efficient program for printing k largest elements in an array. Elements in array can be in any order.
 *
 * For example, if given array is [1, 23, 12, 9, 30, 2, 50] and you are asked for the largest 3 elements
 * i.e., k = 3 then your program should print 50, 30 and 23.
 */
public class Heap_Problem002 {
    public static void main(String[] args) {
        int[][] a = {{7, 10, 4, 3, 20, 15}, {1, 23, 12, 9, 30, 2, 50}};
        int[] ks = {3, 3};
        for (int i = 0; i < a.length; i++) {
            int[] arr = a[i];
            int k = ks[i];
            System.out.println(Arrays.toString(kLargeElements(arr, k)));
        }
    }

    private static int[] kLargeElements(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int elem: arr) {
            pq.add(elem);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.stream().mapToInt(e -> e).toArray();
    }
}
