package ua.com.alevel.two;

import java.util.Stack;

public class Bracket {

    public boolean isValid(String s) {

        Stack<Character> c = new Stack<>();
        int n = s.length();

        if (s.isEmpty()) {
            return true;
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '{') {
                c.push('{');
            } else if (s.charAt(i) == '[') {
                c.push('[');
            } else if (s.charAt(i) == '(') {
                c.push('(');

            } else if (s.charAt(i) == '}' & c.peek() == '{') {
                c.pop();
            } else if (s.charAt(i) == ']' & c.peek() == '[') {
                c.pop();
            } else if (s.charAt(i) == ')' & c.peek() == '(') {
                c.pop();
            } else if (s.charAt(i) == '}') {
                if (!c.isEmpty() && c.peek() == '{') {
                    c.pop();
                } else {
                    return false;
                }
            }
        }
        return c.isEmpty();
    }
}