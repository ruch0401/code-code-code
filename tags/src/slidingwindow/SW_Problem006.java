package slidingwindow;

import java.util.ArrayList;
import java.util.List;

/*
 * Maximum subarray of size k
 * Technique: Sliding Window [Variable]
 * This approach will not work for negative numbers - need to use hashmaps
 * https://www.geeksforgeeks.org/longest-sub-array-sum-k/
 */
public class SW_Problem006 {
    public static void main(String[] args) {
        int[][] arr = {{4, 1, 1, 1, 2, 3, 5}, /* {-5, 8, -14, 2, 4, 12}, {4, 1, 1, -2, 1, 5} */};
        int[] sums = {5, /* -5, 5 */};

        for (int i = 0; i < arr.length; i++) {
            List<Integer> list = new ArrayList<>();
            int[] arr1 = arr[i];
            for (int elem : arr1) {
                list.add(elem);
            }
            int k1 = sums[i];
            System.out.println(solve(list, k1));
        }
    }

    private static int solve(List<Integer> list, int target) {
        int i = 0, j = 0, size = list.size();
        int sum = 0;
        int maxWindowSize = Integer.MIN_VALUE;
        while (j < size) {
            sum += list.get(j);
            if (sum < target) {
                j++;
            } else if (sum == target) {
                int windowSize = j - i + 1;
                System.out.println("Window Size: " + windowSize);
                maxWindowSize = Math.max(maxWindowSize, j - i + 1);
                j++;
                System.out.println("Max Window Size: " + maxWindowSize);
            } else {
                while (sum > target) {
                    sum -= list.get(i);
                    i++;
                    if (sum == target) {
                        maxWindowSize = Math.max(maxWindowSize, j - i + 1);
                    }
                }
                j++;
            }
        }

        return maxWindowSize;
    }
}
