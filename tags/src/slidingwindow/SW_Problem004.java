package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/*
 * Find all anagrams in a string
 * Technique: Sliding Window [Fixed]
 */
public class SW_Problem004 {
    public static void main(String[] args) {
        String[] strings = {"cbaebabacd", "abab"};
        String[] patterns = {"abc", "ab"};

        for (int i = 0; i < strings.length; i++) {
            String s = strings[i];
            String pattern = patterns[i];
            System.out.println(solve(s, pattern));
        }
    }

    private static int solve(String s, String pattern) {
        Map<Character, Integer> hm = new HashMap<>();
        for (char c : pattern.toCharArray()) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        System.out.println("Start: " + hm);
        int i = 0, j = 0, k = pattern.length();
        int size = s.length();
        int count = hm.size();
        int ans = 0;
        while (j < size) {
            // calculation part
            char tempChar = s.charAt(j);
            if (hm.containsKey(tempChar)) {
                hm.put(tempChar, hm.get(tempChar) - 1);
                if (hm.get(tempChar) == 0) {
                    count--;
                }
            }
            System.out.println(hm);
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // calculating answer from the calculation
                System.out.println("Window Size reached. Count: " + count);
                if (count == 0) {
                    ans++;
                }

                // Reversing effect of the element that is going out of the window
                char charToAdd = s.charAt(i);
                if (hm.containsKey(charToAdd)) {
                    if (hm.get(charToAdd) == 0)
                        count++;
                    hm.put(charToAdd, hm.get(charToAdd) + 1);
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}
