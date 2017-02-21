import java.util.HashMap;
import java.util.Stack;

/**
 * Created by diwenchen on 2017/2/21.
 * https://leetcode.com/problems/valid-parentheses/
 */
public class Solution20 {
    /**
     * 模拟stack的方式
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        char[] cs = s.toCharArray();
        int bottom = -1;
        char[] stack = new char[cs.length];
        for (int i = 0; i < cs.length; i++) {
            switch (cs[i]) {
                case '(':
                    bottom++;
                    stack[bottom] = cs[i];
                    break;
                case '[':
                    bottom++;
                    stack[bottom] = cs[i];
                    break;
                case '{':
                    bottom++;
                    stack[bottom] = cs[i];
                    break;
                case ')':
                    if (bottom < 0 || stack[bottom] != '(') {
                        return false;
                    }
                    bottom--;
                    break;
                case ']':
                    if (bottom < 0 || stack[bottom] != '[') {
                        return false;
                    }
                    bottom--;
                    break;
                case '}':
                    if (bottom < 0 || stack[bottom] != '{') {
                        return false;
                    }
                    bottom--;
                    break;
                default:
                    bottom--;
                    if (bottom < 0) {
                        return false;
                    }
                    break;
            }
        }
        if (bottom == -1) {
            return true;
        }
        return false;
    }

    /**
     * 栈版本的方式
     * @param s
     * @return
     */
    public boolean isValid2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' :
                    stack.push(')');
                    break;
                case '[' :
                    stack.push(']');
                    break;
                case '{' :
                    stack.push('}');
                    break;
                default:
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        String s = "()";
        System.out.println(solution20.isValid(s));
        System.out.println(solution20.isValid2(s));
    }
}
