/**
 * Created by diwenchen on 2017/2/20.
 * https://leetcode.com/problems/palindrome-number/
 */
public class Solution9 {
    /**
     * 不需要考虑溢出,因为溢出的肯定不会是回文数
     * 负数都不是回文数
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        int result = 0;
        int y = x;
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result == y;
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        int x = -2147447412;
        System.out.println(solution9.isPalindrome(x));

    }
}
