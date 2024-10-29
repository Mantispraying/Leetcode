import java.util.*;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character character : s.toCharArray()) {
            if (character == '{' || character == '[' || character == '(')
                stack.push(character);
            else if (stack.empty())
                return false;
            else if ((character.equals(')') && stack.peek().equals('('))
                    || (character.equals(']') && stack.peek().equals('['))
                    || (character.equals('}') && stack.peek().equals('{')))
                stack.pop();
            else
                return false;
        }
        return stack.empty();
    }
}
// @lc code=end
