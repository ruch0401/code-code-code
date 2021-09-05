import java.util.*;

public class Problem004 {
    public static void main(String[] args) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(0);
        l1.add(1);
        l1.add(10);
        ans.add(l1);

        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(3);
        l2.add(5);
        ans.add(l2);

        List<Integer> l3 = new ArrayList<>();
        l3.add(2);
        l3.add(4);
        l3.add(12);
        ans.add(l3);

//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(2);
//        l1.add(603);
//        ans.add(l1);
//
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(0);
//        l2.add(0);
//        l2.add(286);
//        ans.add(l2);
//
//        List<Integer> l3 = new ArrayList<>();
//        l3.add(3);
//        l3.add(3);
//        l3.add(882);
//        ans.add(l3);


        System.out.println(maxValue(5, ans));
    }


    public static int maxValue(int n, List<List<Integer>> rounds) {
        for (List<Integer> l: rounds) {
            System.out.println(l);
        }

        int[] arr = new int[n];
        System.out.println(Arrays.toString(arr));

        // solve all queries given
        for (List<Integer> round: rounds) {
            int start = round.get(0);
            int end = round.get(1);
            int val = round.get(2);

            System.out.println(String.format("Start: %d\tEnd: %d\tValue: %d", start, end, val));

            arr[start] += val;
            if (end != n - 1) {
                arr[end + 1] -= val;
            }
            System.out.println(String.format("For Round: %s, array is %s", round, Arrays.toString(arr)));
        }

        // now calculate prefix sum for the entire array
        int[] ps = new int[n];
        ps[0] = arr[0];
        for (int i = 1; i < n; i++) {
            ps[i] = arr[i] + ps[i - 1];
        }

        System.out.println(Arrays.toString(ps));

        // finding max of the final array
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (ps[i] > max) {
                max = ps[i];
            }
        }

        return max;
    }
}
