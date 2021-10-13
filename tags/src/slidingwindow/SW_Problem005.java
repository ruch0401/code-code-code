package slidingwindow;

import java.util.*;

public class SW_Problem005 {
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
            System.out.println(Arrays.toString(solve(list, k1)));
        }
    }

    private static int[] solve(List<Integer> list, int k) {
        int i = 0, j = 0;
        int size = list.size();
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        while (j < size) {
            pq.add(list.get(j));
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // find answer from calculation
                if (!pq.isEmpty())
                    ans.add(pq.peek());

                // reverse impact of element that is going out of the window
                pq.remove(list.get(i));

                // slide the window
                i++;
                j++;
            }
        }
        return ans.stream().mapToInt(elem -> elem).toArray();
    }
}
