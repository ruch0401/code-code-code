package twitter;

/*
 * Activate Fountain
 */
public class TT_Problem009 {
    public static void main(String[] args) {
        int[] ns = {3, 4};
        int[][] arrs = {{1, 1, 1}, {2, 0, 0, 0}, {}};

        for (int i = 0; i < arrs.length; i++) {
            int n = ns[i];
            int[] arr = arrs[i];
            System.out.println(minTaps(n, arr));
        }
    }

    public static int minTaps(int n, int[] arr) {
        int[] jumps = new int[n];
        for (int i = 0; i < n; i++) {
            int l = Math.max(i + 1 - arr[i], 1);
            int r = Math.min(i + 1 + arr[i], n);
            jumps[l - 1] = Math.max(jumps[l - 1], r);
        }

        int right = jumps[0];
        int nextGreaterRight = right;
        int fountainsNeeded = 1;

        for (int i = 1; i < n; i++) {
            nextGreaterRight = Math.max(nextGreaterRight, jumps[i]);
            if (i == right) {
                fountainsNeeded++;
                right = nextGreaterRight;
            }
        }
        return fountainsNeeded;
    }
}
