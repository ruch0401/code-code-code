import java.util.Scanner;

public class Permutation {
    public static String str = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string for which you wish to find permutations: ");
        str = sc.nextLine();

        permutations(0);
    }

    private static void permutations(int index) {
        if (index == str.length()) {
            System.out.println(str);
            return;
        }

        for (int i = index; i < str.length(); i++) {
            swap(index, i);
            permutations(index + 1);

            // backtrack now for correct permutations
            swap(index, i);
        }
    }

    private static void swap(int a, int b) {
        char[] charTemp = str.toCharArray();

        char temp = charTemp[a];
        charTemp[a] = charTemp[b];
        charTemp[b] = temp;

        StringBuilder ans = new StringBuilder();
        for (char c: charTemp) {
            ans.append(c);
        }
        str = ans.toString();
    }
}
