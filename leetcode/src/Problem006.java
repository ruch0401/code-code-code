public class Problem006 {

    static int[] a = {1,2,3,4,5,6}; // prefix sum for this array would be = {1, 3, 6, 10, 15, 21}
    static int n = 6;
    static int[][] b = new int[n][n];
    static int[] prefix_sum;

    public static void main(String[] args) {
        getPrefixSum(a);
        bruteForce();
        optimizedAlgo();
        printAns();
    }

    private static void printAns() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(b[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void optimizedAlgo() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    b[i][j] = 0;
                } else {
                    if (i == 0) {
                        b[i][j] = prefix_sum[j];
                    } else {
                        b[i][j] = prefix_sum[j] - prefix_sum[i - 1];
                    }
                }
            }
        }
    }

    private static void bruteForce() {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += a[k];
                }
                b[i][j] = sum;
            }
        }
    }

    private static void getPrefixSum(int[] a) {
        int[] ps = new int[a.length];
        ps[0] = a[0];

        for (int i = 1; i < a.length; i++) {
            ps[i] = ps[i - 1] + a[i];
        }
        prefix_sum = ps;
    }
}
