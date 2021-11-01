import java.util.*;

public class Problem022 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {3,4};
        int[][] queries = {{1,5},{0,0,1},{1,5}};

//        int[] a = {1,2,2};
//        int[] b = {2,3};
//        int[][] queries = {{1,4},{0,0,3},{1,5}};
        System.out.println(coolFeature2(a, b, queries));
    }

    private static List<Integer> coolFeature2(int[] a, int[] b, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        for (int[] query: queries) {
            Map<Integer, Integer> hm1 = new HashMap<>();
            Map<Integer, Integer> hm2 = new HashMap<>();
            for (int i = 0; i < a.length; i++) {
                hm1.put(a[i], hm1.getOrDefault(a[i], 0) + 1);
            }
            int[] arr = new int[hm1.size()];
            int index = 0;
            for (int key: hm1.keySet()) {
                arr[index] = key;
                index++;
            }

            for (int i = 0; i < b.length; i++) {
                hm2.put(b[i], hm2.getOrDefault(b[i], 0) + 1);
            }
            if (query.length == 2) {
                int count = 0;
                for (int i = 0; i < arr.length; i++) {
                    int diff = query[1] - arr[i];
                    if (hm2.containsKey(diff)) {
                        count += hm1.get(arr[i]) * hm2.get(diff);
                    }
                }
                ans.add(count);
            } else if (query.length == 3) {
                hm2.put(b[query[1]], hm2.get(b[query[1]]) - 1);
                if (hm2.containsKey(b[query[1]])) {
                    hm2.put(b[query[1]], hm2.getOrDefault(b[query[1]], 0) + 1);
                } else {
                    hm2.put(b[query[2]], 1);
                }
                b[query[1]] = query[2];
            }
        }
        return ans;
    }
}
