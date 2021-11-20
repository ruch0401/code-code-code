package heap;

import java.util.*;

/*
 * Print the elements of an array in the increasing frequency if 2 numbers have same frequency then print the one which came first.
 *
 * Example:
 * Input : arr[] = {2, 5, 2, 8, 5, 6, 8, 8}
 * Output : arr[] = {8, 8, 8, 2, 2, 5, 5, 6}
 */
public class Heap_Problem006 {
    public static void main(String[] args) {
        int[][] a = {{2, 5, 2, 8, 5, 6, 8, 8}};
        for (int i = 0; i < a.length; i++) {
            int[] arr = a[i];
            System.out.println(Arrays.toString(frequencySort(arr)));
        }
    }

    static class Pair {
        int f;
        int s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }

    private static int[] frequencySort(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int elem : arr) {
            hm.put(elem, hm.getOrDefault(elem, 0) + 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.f));
        for (int key: hm.keySet()) {
            pq.add(new Pair(hm.get(key), key));
        }

        int[] ans = new int[arr.length];
        int i = 0;
        while (pq.size() > 0) {
            Pair p = pq.poll();
            while (p.f-- > 0) {
                ans[i++] = p.s;
            }
        }
        return ans;
    }
}
