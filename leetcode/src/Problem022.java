import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem022 {
    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {3,4};
        int[][] queries = {{1,5},{0,0,1},{1,5}};
        System.out.println(coolFeature(a, b, queries));
    }

    private static List<Integer> coolFeature(int[] a, int[] b, int[][] queries) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map1.put(a[i], i);
        }
        for (int i = 0; i < b.length; i++) {
            map2.put(b[i], map2.getOrDefault(b[i], 0) + 1);
        }

        for (int[] q: queries) {
            if (q[0] == 0) {
                b[q[1]] = q[2];
            } else if (q[0] == 1) {
                // find pairs form a and b where sum = q[1] and store answer in arraylist
                int count = 0;

            }
        }
        return ans;
    }
}
