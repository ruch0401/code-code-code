import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Problem Name: Memory Allocation
 * Company Name: eBay
 * Platform: Code Signal Question 3
 */
public class Problem021 {
    static class Pair {
        int start;
        int end;

        Pair (int start, int end) {
            this.start = start;
            this.end = end;
        }

        public String toString() {
            return String.format("[Start: %s, End: %s]", start, end);
        }
    }

    static StringBuilder sb = new StringBuilder();
    static int[] memoryAllocator(int[][] queries) {
        Map<Integer, Pair> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int count = 1;
        for (int[] query: queries) {
            if (query[0] == 0) {
                int blobSize = query[1];
                String stosearch =  getStringToSearch(blobSize);
                int index = sb.indexOf(stosearch);
                if (index != -1) {
                    updateString(index, blobSize);
                    hm.put(count, new Pair(index, index + blobSize - 1));
                    count++;
                    list.add(index);
                } else {
                    list.add(index);
                }
            } else {
                int indexToSearch = query[1];
                if (!hm.containsKey(indexToSearch)) {
                    list.add(-1);
                } else {
                    System.out.println(hm);
                    Pair p = hm.get(indexToSearch);
                    int start = p.start;
                    int end = p.end;
                    int val = end - start + 1;
                    updateString(indexToSearch, val);
                    list.add(val);
                }
            }
        }

        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    private static void updateString(int index, int blobSize) {
        for (int i = index; i < index + blobSize; i++) {
            sb.setCharAt(i, '1');
        }
        System.out.println("Updated String: " + sb.toString());
    }

    private static String getStringToSearch(int blobSize) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < blobSize; i++) {
            ans.append("0");
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0};
        int[][] queries = {{0, 2}, {0, 1}, {0, 1}, {1, 2}, {1, 4}, {0, 4}};

        for (int elem: a) {
            sb.append(elem);
        }

        int[] ans = memoryAllocator(queries);
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}