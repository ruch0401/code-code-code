import java.util.*;

public class SD_2021_Problem004 {
    static class Pair {
        int first;
        int last;

        Pair(int first, int last) {
            this.first = first;
            this.last = last;
        }

        public String toString() {
            return String.format("First: %d | Last: %d\n", first, last);
        }
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            List<Pair> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(new Pair(arr[i], i));
            }
            list.sort(Comparator.comparingInt(o -> o.first));
            int k = 0;
            for (Pair p: list) {
                if (k < p.first) {
                    p.first = k;
                    k++;
                }
            }
            list.sort(Comparator.comparingInt(o -> o.last));
            for (Pair p: list) {
                System.out.print(p.first + " ");
            }
        }
    }
}
