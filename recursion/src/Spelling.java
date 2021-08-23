import java.util.Scanner;

public class Spelling {
    public static String[] spelling = new String[]{"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number that you want to spell: ");
        int number = sc.nextInt();

        spell(number);
    }

    private static void spell(int number) {
        if (number == 0)
            return;
        else {
            spell(number / 10);
        }
        System.out.print(spelling[number % 10] + " ");
    }
}
