package heap;

import java.util.*;
import java.util.stream.Collectors;

/*
 * Given a list of points on the 2-D plane and an integer K. The task is to find K closest points to the origin and print them.
 * Note: The distance between two points on a plane is the Euclidean distance.
 * Example:
 * Input : point = [[3, 3], [5, -1], [-2, 4]], K = 2
 */
public class Heap_Problem007 {
    public static void main(String[] args) {
        int[][] a = {{3, 3}, {5, -1}, {-2, 4}};
        int k = 2;
        System.out.println(findKClosestPointsToOrigin(a, k)
                .stream()
                .map(Arrays::toString)
                .collect(Collectors.joining()));
    }

    static class Pair {
        int freq;
        int[] coordinate;

        Pair (int freq, int[] coordinate) {
            this.freq = freq;
            this.coordinate = coordinate;
        }
    }

    private static List<int[]> findKClosestPointsToOrigin(int[][] arr, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(e -> -e.freq));
        for (int[] a: arr) {
            int distance = a[0]* a[0] + a[1]* a[1];
            pq.add(new Pair(distance, a));

            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<int[]> list = new ArrayList<>();
        while (pq.size() > 0) {
            Pair p = pq.poll();
            list.add(p.coordinate);
        }
        return list;
    }
}
