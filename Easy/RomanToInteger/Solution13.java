import java.util.HashMap;
import java.util.Map;
import java.util.zip.Inflater;

/**
 * Created by diwenchen on 2017/2/20.
 * https://leetcode.com/problems/roman-to-integer/
 * 罗马数规则:
 * 去搜wiki
 */
public class Solution13 {
    /**
     * 将字符串转变为整形数组,这样就可以比较相邻位置的两个数字的关系了
     * @param s
     * @return
     */
    public int romanToInt(String s) {
        int[] num = new int[s.length()];
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            switch (cs[i]) {
                case 'I' :
                    num[i] = 1;
                    break;
                case 'V' :
                    num[i] = 5;
                    break;
                case 'X' :
                    num[i] = 10;
                    break;
                case 'L' :
                    num[i] = 50;
                    break;
                case 'C' :
                    num[i] = 100;
                    break;
                case 'D' :
                    num[i] = 500;
                    break;
                case 'M' :
                    num[i] = 1000;
                    break;
            }
        }
        int sum = 0;
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] < num[i+1]) {
                sum -= num[i];
            } else {
                sum += num[i];
            }
        }
        sum += num[num.length - 1];
        return sum;
    }

    public int romanToInt2(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        char[] cs = s.toCharArray();
        int sum = map.get(cs[cs.length - 1]);
        for (int i = cs.length - 2; i >= 0; i--) {
            if (map.get(cs[i]) < map.get(cs[i + 1])) {
                sum -= map.get(cs[i]);
            } else {
                sum += map.get(cs[i]);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        System.out.println(solution13.romanToInt("IV"));
        System.out.println(solution13.romanToInt2("IV"));
    }
}
