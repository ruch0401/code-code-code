package heap;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Given an unsorted array and two numbers x and k, find k closest values to x.
 * Input : arr[] = {10, 2, 14, 4, 7, 6}, x = 5, k = 3
 */
public class Heap_Problem004 {
    static class Pair implements Comparable {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Object o) {
            return -(first - second);
        }
    }

    public static void main(String[] args) {
        int[][] a = {{10, 2, 14, 4, 7, 6}, {5, 6, 7, 8, 9}};
        int[] ks = {3, 3};
        int[] xs = {5, 7};
        for (int i = 0; i < a.length; i++) {
            int[] arr = a[i];
            int k = ks[i];
            int x = xs[i];
            System.out.println(Arrays.toString(findKClosest(arr, k, x)));
        }
    }

    private static int[] findKClosest(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o.first));
        for (int elem : arr) {
            pq.add(new Pair(Math.abs(x - elem), elem));

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.stream().mapToInt(e -> e.second).toArray();
    }

}
