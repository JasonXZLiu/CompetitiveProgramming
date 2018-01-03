package DataStructures;

import java.util.*;

public class BalancedBrackets {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') stack.push(s.charAt(i));
            else if (!stack.empty()) {
                if (s.charAt(i) == ')' && stack.peek() == '(') stack.pop();
                else if (s.charAt(i) == ']' && stack.peek() == '[') stack.pop();
                else if (s.charAt(i) == '}' && stack.peek() == '{') stack.pop();
                else return false;
            } else return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 0; t < T; t++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}