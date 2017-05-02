package FacebookInterview;

import java.util.Stack;

/**
 * Created by fernandopauer on 5/1/17.
 *
 * Provide an algorithm to check whether a certain statement has balanced parenthesis or not.
 *
 */
public class BalancedParenthesis {

    String openParenthesis = "({[";
    String closeParenthesis = ")}]";

    public boolean isBalanced (String string) {
        char[] charArray = string.toCharArray();
        Stack<Character> checker = new Stack<>();

        for (char c: charArray) {
            if (checker.isEmpty()) {
                checker.add(c);
            } else {
                int charDiff = Math.abs(checker.peek()-c);
                if (openParenthesis.indexOf(checker.peek()) >= 0 &&
                    closeParenthesis.indexOf(c) >= 0 &&
                    charDiff <= 2) {
                    checker.pop();
                } else {
                    checker.add(c);
                }
            }
        }

        return checker.isEmpty();
    }
}
