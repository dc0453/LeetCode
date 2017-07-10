/**
 * Created by dc0453 on 2017/2/19.
 * https://leetcode.com/problems/reverse-integer/
 */
public class Solution7 {
    /**
     * 在每一步求和的过程中,计算新产生的值与原差值之间,是不是相等
     * 如果有溢出,那么一定是不相等
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            int residue = x % 10;
            int newRes = res * 10 + residue;
            if ((newRes - residue)/10 != res) {
                return 0;
            }
            res = newRes;
            x /= 10;
        }
        return res;
    }

    /**
     * 如果int溢出,那么用long能存下,就使用long来判断会不会溢出
     * @param x
     * @return
     */
    public int reverse2(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                return 0;
            }
            x /= 10;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int x = 223;
        System.out.println(solution7.reverse2(x));
    }
}
