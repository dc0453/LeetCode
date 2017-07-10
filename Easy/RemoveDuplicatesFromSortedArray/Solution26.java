import java.util.Arrays;
/**
 * Created by dc0453 on 2017/2/20.
 * https://leetcode.com/problems/palindrome-number/
 */
public class Solution26 {
    /**
     * 遍历一遍，在遍历的过程中，直接使用统计的新的数组的长度作为下标，来赋值新的数
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int newLength = 1;
        int temp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                continue;
            } else {
                nums[newLength ++] = nums[i];
                temp = nums[i];
            }
        }
        return newLength;
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,2,2,3,4};
        int newLength = new Solution26().removeDuplicates(nums);
        System.out.println(newLength);
        System.out.println(Arrays.toString(nums));
    }
}