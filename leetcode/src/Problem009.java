import java.util.*;

public class Problem009 {
    public static void main(String[] args) {
        int[] arr1 = new int[]{5,7,9,13,11,6,6,3,3};
        int target1 = 12;

        int[] arr2 = new int[]{1,3,46,1,3,9};
        int target2 =  47;

        int count1 = solve(arr1, target1);
        int count2 = solve(arr2, target2);

        System.out.println(count1);
        System.out.println(count2);
    }

    public static int solve(int[] arr, int target) {
        int count = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        Map<Integer, Integer> freq = new LinkedHashMap<>();

        for (int elem: arr) {
            freq.put(elem, freq.getOrDefault(elem, 0) + 1);
        }

        for (int j : arr) {
            int complement = target - j;
            if (complement >= 0) {
                if (map.containsKey(complement) && freq.get(complement) > 0) {
                    count++;
                    freq.put(j, freq.get(j) - 1);
                    if (freq.containsKey(complement))
                        freq.put(complement, freq.get(complement) - 1);
                }
                map.put(j, complement);
            }
        }
        System.out.println(map);
        return count;
    }
}
