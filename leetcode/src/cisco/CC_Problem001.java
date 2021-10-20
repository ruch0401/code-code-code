package cisco;

import java.util.Stack;

public class CC_Problem001 {
    public static void main(String[] args) {
        String[] ss = {"(ab(d){3}){2}", "(a(bc){3}){2}"};
        for (String s: ss) {
            System.out.println(solve(s));
        }
    }

    private static String solve(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < c.length; i++) {
            if (c[i] != ')') {
                stack.push(c[i]);
                continue;
            }

            i = i + 2;
            StringBuilder num = new StringBuilder();
            while (c[i] != '}') {
                num.append(c[i]);
                i++;
            }

            StringBuilder stringToRepeat = new StringBuilder();
            while (stack.peek() != '(') {
                char charToRepeat = stack.pop();
                stringToRepeat.append(charToRepeat);
            }
            stringToRepeat.reverse();
            int numOfTimes = Integer.parseInt(num.toString());
            StringBuilder s1 = new StringBuilder();
            while (numOfTimes-- > 0) {
                s1.append(stringToRepeat);
            }
            stack.pop();
            for (int idx = 0; idx < s1.length(); idx++) {
                stack.push(s1.charAt(idx));
            }
        }

        StringBuilder ans = new StringBuilder();
        while (stack.size() > 0) {
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}
