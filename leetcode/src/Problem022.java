import java.util.*;

public class Problem022 {
    public static void main(String[] args) {
//        int[] a = {1,2,3};
//        int[] b = {3,4};
//        int[][] queries = {{1,5},{0,0,1},{1,5}};

        int[] a = {1,2,2};
        int[] b = {2,3};
        int[][] queries = {{1,4},{0,0,3},{1,5}};
        System.out.println(coolFeature(a, b, queries));
    }

    private static List<Integer> coolFeature(int[] a, int[] b, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        for (int[] q: queries) {
            Map<Integer, Integer> map2 = new HashMap<>();
            Set<Integer> set2 = new HashSet<>();
            for (int k : b) {
                map2.put(k, map2.getOrDefault(k, 0) + 1);
                set2.add(k);
            }
            System.out.println(Arrays.toString(a) + "\t" + Arrays.toString(b));
            System.out.println(map2 + "\t" + set2);
            if (q[0] == 0) {
                b[q[1]] = q[2];
            } else if (q[0] == 1) {
                // find pairs form a and b where sum = q[1] and store answer in arraylist
                int count = 0;
                for (int j : a) {
                    int diff = q[1] - j;
                    while (set2.contains(diff)) {
                        if (map2.get(diff) == 1) {
                            count++;
                            map2.remove(diff);
                            set2.remove(diff);
                        } else {
                            count++;
                            map2.put(diff, map2.get(diff) - 1);
                        }
                    }
                }
                ans.add(count);
            }
        }
        return ans;
    }
}
