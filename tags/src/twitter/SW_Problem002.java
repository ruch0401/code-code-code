package twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * First negative number in every window of size k
 * Technique: Sliding Window [Fixed]
 */
public class SW_Problem002 {
    public static void main(String[] args) {
        int[][] arr = {{12, -1, -7, 8, -15, 30, 16, 28}};
        int k = 2;
        for (int[] a : arr) {
            System.out.println(Arrays.toString(solve(a, k)));
        }
    }

    private static int[] solve(int[] a, int k) {
        int i = 0, j = 0;
        int len = a.length;
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        while (j < len) {
            if (a[j] < 0) {
                list.add(a[j]);
            }
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // find answer based on the calculations
                if (list.size() == 0) {
                    ans.add(0);
                } else {
                    ans.add(list.get(0));

                    // Consider the window 12 -1 -7 of size 3. Here, pointer i is at 12 initially. Size for 12
                    // no insertion was done on the list, hence, removal of element from the list of only done if
                    // the element under question is the same as that of the first element of the list
                    if (a[i] ==  list.get(0)) {
                        list.remove(0);
                    }
                }
                i++;
                j++;
            }
        }
        return ans.stream().mapToInt(elem -> elem).toArray();
    }
}


/*
   int slidingWindowTemplate () {
        int i = 0, j = 0; // i -> start of the window, j -> end of the window
        while (j < array.length) {
            // calculation on j
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                // find answer from calculation
                // remove the character at the start of the window conditionally
                i++;
                j++;
            }
        }
    }
 */

