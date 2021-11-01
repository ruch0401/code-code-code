package twitter;

import java.util.HashMap;
import java.util.Map;

/*
 * Sub-Palindrome
 */
public class TT_Problem006 {
    public static void main(String[] args) {
        String[] ss = {"aabaa", "aaa", "abc"};
        for (String s: ss) {
            System.out.println(countSubstrings(s));
        }
    }

    public static int countSubstrings(String s) {
        Map<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String ss = s.substring(i, j + 1);
                if (isPalindrome(ss)) {
                    hm.put(ss, hm.getOrDefault(ss, 0) + 1);
                }
            }
        }
        return hm.size();
    }

    public static boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}
