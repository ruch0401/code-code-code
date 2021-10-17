package tiktok;

public class TT_Problem008 {
    public static void main(String[] args) {
        int c3 = 0;
        int c5 = 0;
        for (int i = 1; i <= 100; i++) {
            String op = "";
            c3++;
            c5++;
            if (c3  == 3) {
                op += "Fizz";
                c3 = 0;
            }

            if (c5  == 5) {
                op += "Buzz";
                c5 = 0;
            }

            if (op.equals("")) {
                System.out.println(i);
            } else {
                System.out.println(op);
            }
        }
    }
}
