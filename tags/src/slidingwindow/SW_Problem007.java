package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;

/*
 * Longest substring with K unique characters
 * Technique: Sliding Window [Variable]
 */
public class SW_Problem007 {
    public static void main(String[] args) {
        String[] strings = {"aabacbebebe"};
        int[] ks = {3};

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            int k = ks[i];
            System.out.println(solve(s, k));
        }
    }

    private static int solve(String s, int k) {
        int i = 0, j = 0, size = s.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = Integer.MIN_VALUE;
        while (j < size) {
            System.out.println("HashMap: " + hm);
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);
            if (hm.size() < k) {
                j++;
            } else if (hm.size() == k) {
                max = Math.max(max, j - i + 1);
                j++;
            } else {
                while (hm.size() > k) {
                    char ch = s.charAt(i);
                    if (hm.containsKey(ch)) {
                        hm.put(ch, hm.get(ch) - 1);
                        if (hm.get(ch) == 0) {
                            hm.remove(ch);
                        }
                    }
                    i++;
                    if (hm.size() == k) {
                        max = Math.max(max, hm.size());
                    }
                }
                j++;
            }
        }
        return max;
    }
}
