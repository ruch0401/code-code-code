package twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
 * Maximum of the smallest numbers from all the windows of size k
 * Technique: Sliding Window [Fixed]
 */
public class SW_Problem003 {
    public static void main(String[] args) {
        int[][] arr = {{12, -1, -7, 8, -15, 30, 16, 28}, {2, 5, 4, 6, 8}, {1, 1, 1}, {1, 2, 3, 1, 2}};
        int[] k = {2, 3, 2, 1};

        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            int[] arr1 = arr[i];
            for (int elem : arr1) {
                list.add(elem);
            }
            int k1 = k[i];
            System.out.println(solve(list, k1));
        }
    }

    private static int solve(List<Integer> a, int k) {
        int i = 0, j = 0, len = a.size();
        List<Integer> l = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while (j < len) {
            pq.add(a.get(j));
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                int smallest = Integer.MAX_VALUE;
                if (pq.size() > 0)
                    smallest = pq.peek();
                pq.remove(a.get(i));
                l.add(smallest);
                i++;
                j++;
            }
        }
        System.out.println(l);

        int max = Integer.MIN_VALUE;
        for (int elem : l) {
            if (max < elem) {
                max = elem;
            }
        }
        return max;
    }
}
