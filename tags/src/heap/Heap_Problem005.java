package heap;

import java.util.*;

/*
 * Given an array of n numbers. Your task is to read numbers from the array and keep at-most K numbers at the top
 * (According to their decreasing frequency) every time a new number is read.
 * We basically need to print top k numbers sorted by frequency when input stream has included k distinct elements,
 * else need to print all distinct elements sorted by frequency.
 *
 * Example:
 * Input :  arr[] = {5, 2, 1, 3, 2}
 * k = 4
 * Output : 5 2 5 1 2 5 1 2 3 5 2 1 3 5
 */
public class Heap_Problem005 {
    public static void main(String[] args) {
        int[][] a = {{5, 2, 1, 3, 2}};
        int[] ks = {3};
        for (int i = 0; i < a.length; i++) {
            int[] arr = a[i];
            int k = ks[i];
            System.out.println(Arrays.toString(topKFrequentElements(arr, k)));
        }
    }

    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static int[] topKFrequentElements(int[] arr, int k) {
        Map<Integer, Integer> hm = new TreeMap<>();
        for (int elem : arr) {
            hm.put(elem, hm.getOrDefault(elem, 0) + 1);
        }
        System.out.println(hm);

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.first));
        for (int key : hm.keySet()) {
            pq.add(new Pair(hm.get(key), key));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<Integer> ans = new ArrayList<>();
        while (pq.size() > 0) {
            ans.add(pq.poll().second);
        }
        return ans.stream().mapToInt(e -> e).toArray();
    }

}
