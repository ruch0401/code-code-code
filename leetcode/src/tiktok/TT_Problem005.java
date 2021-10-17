package tiktok;

public class TT_Problem005 {
    public static void main(String[] args) {
        String s = "APPLE";
        System.out.println(solve(s));
    }

    private static String solve(String s) {
        int len = s.length();
        return (s.charAt(len - 1) + "") + (s.charAt(len - 2) + "");
    }
}
