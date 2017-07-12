/**
 * Author: dc0453
 * Since: 2017/7/12 下午10:51
 * https://leetcode.com/problems/implement-strstr/
 */
public class Solution28 {
    /**
     * 中规中矩的双层for循环
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if ((haystack == null && needle == null) || ("".equals(haystack) && "".equals(needle))) {
            return 0;
        }
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        int len = haystack.length() - needle.length();
        for (int i = 0; i <= len; i++) {
            int j = 0;
            for (int k = i; j < needle.length(); k++, j++) {
                if (haystack.charAt(k) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 简明的双层for循环
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr1(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;//needle遍历完毕
                if (i + j == haystack.length()) return -1; //needle没有遍历完，但是haystack已经遍历完
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }

    // todo 实现kmp算法


    public static void main(String[] args) {
        System.out.println(new Solution28().strStr("", ""));
        System.out.println(new Solution28().strStr1("", ""));
    }
}
