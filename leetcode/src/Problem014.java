import java.util.*;

// https://leetcode.com/problems/longest-string-chain/
public class Problem014 {
    public static void main(String[] args) {
        String[] arr1 = {"a","b","ba","bca","bda","bdca"};
        String[] arr2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        String[] arr3 = {"abcd","dbqca"};
        System.out.println(solve(arr1));
        System.out.println(solve(arr2));
        System.out.println(solve(arr3));
    }

    private static int solve(String[] arr) {
        Map<String, Integer> dp = new LinkedHashMap<>();
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        int ans = 1;
        for (String word: arr) {
            int presentLength = 1;
            int len = word.length();
            for (int i = 0; i < len; i++) {
                StringBuilder sb = new StringBuilder(word);
                String temp = sb.deleteCharAt(i).toString();
                int previousLength = dp.getOrDefault(temp, 0);
                presentLength = Math.max(presentLength, previousLength + 1);
            }
            dp.put(word, presentLength);
            ans = Math.max(ans, presentLength);
        }
        System.out.println(dp);
        return ans;
    }
}
