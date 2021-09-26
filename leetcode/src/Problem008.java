import java.util.*;

public class Problem008 {
    public static void main(String[] args) {
        String[] input1 = new String[]{"bin", "can", "bin", "bin"};
        String[] input2 = new String[]{"notebook", "notebook", "mouse", "keyboard", "mouse"};

        solve(input1);
        solve(input2);
    }

    public static void solve(String[] input) {
        Arrays.sort(input);
        int i = 0;
        int j = i;
        int len = input.length;
        int count = 0;
        List<String> ans = new ArrayList<>();
        while (j < len) {
            if (Objects.equals(input[j], input[i])) {
                count++;
                j++;
            } else {
                ans.add(input[i] + " " + count);
                count = 0;
                i = j;
            }
        }
        if (j == len) {
            ans.add(input[j - 1] + " " + count);
        }
        sort(ans);
        System.out.println(ans);
    }

    public static void sort(List<String> list) {
        list.sort((o1, o2) -> {
            int n1 = Integer.parseInt(o1.split(" ")[1]);
            int n2 = Integer.parseInt(o2.split(" ")[1]);

            return Integer.compare(n2, n1);
        });
    }
}
