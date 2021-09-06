import java.util.*;

/**
 * Sample Input -
 * 10
 * 33 14 50 9 8 11 6 40 2 15
 * 7 2 5 9 3 2 1 10 3 3
 * 5
 */
public class Problem003 {

    static class Item {
        public int val;
        public int wt;

        Item(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] weight = new int[n];
        int[] value = new int[n];

        Item[] items = new Item[n];

        for (int i = 0; i < n; i++) {
            value[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            items[i] = new Item(value[i], weight[i]);
        }

        int cap = sc.nextInt();

        Arrays.sort(items, (o1, o2) -> {

            double vw1 = (double) o1.val / (double) o1.wt;
            double vw2 = (double) o2.val / (double) o2.wt;

            return Double.compare(vw2, vw1);
        });

        double sumW = 0;
        double sumV = 0;

        for (Item i : items) {
            int val1 = i.val;
            int w1 = i.wt;

            if (w1 + sumW <= cap) {
                sumV += val1;
                sumW += w1;
            } else {
                double remainingW = cap - sumW;
                sumV += remainingW * ((double) val1 / (double) w1);
                break;
            }
        }

        System.out.println(sumV);
    }
}