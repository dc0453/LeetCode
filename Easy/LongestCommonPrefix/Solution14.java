import java.util.Arrays;

/**
 * Created by diwenchen on 2017/2/20.
 * https://leetcode.com/problems/longest-common-prefix/
 */
public class Solution14 {
    /**
     * 纵向比较,先把最短的字符串找出来,再以这最短的字符串作为基准,比较每一个字符
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (length > strs[i].length()) {
                index = i;
                length = strs[i].length();
            }
        }
        for (int i = 0; i < length; i++) {
            char c = strs[index].toCharArray()[i];
            for (int j = 0; j < strs.length; j++) {
                if (j == index) {
                    continue;
                }
                if (c != strs[j].toCharArray()[i]) {
                    return strs[index].substring(0, i);
                }
            }
        }
        return strs[index];
    }

    /**
     * 先把字符串按照字母序排序,这样,只需要比较第一个字符串和最后一个字符串,直接就能找出最长的公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length - 1].toCharArray();

        int length = Math.min(first.length, last.length);
        int i = 0;
        for (; i < length && first[i] == last[i]; ++i);
        return strs[0].substring(0, i);
    }

    /**
     * 利用string.indexOf来查找公共前缀
     * @param strs
     * @return
     */
    public String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
        }
        return pre;

    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String[] strs = new String[]{
                "abaca",
                "abaab",
                "abaac"
        };
        System.out.println(solution14.longestCommonPrefix(strs));
        System.out.println(solution14.longestCommonPrefix2(strs));
        System.out.println(solution14.longestCommonPrefix3(strs));
    }
}
