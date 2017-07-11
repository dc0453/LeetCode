import java.util.Arrays;

/**
 * Author: dc0453
 * Since: 2017/7/11 下午10:26
 * https://leetcode.com/problems/remove-element/
 */
public class Solution27 {
    /**
     * 思路比较像26题RemoveDuplicatesFromSortedArray
     * 使用两个指针，快指针对比val，慢指针构造数组
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;

        int newLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[newLength++] = nums[i];
            }
        }

        return newLength;
    }

    /**
     * 这个方法比较巧妙，题中说了最后得到的数组中元素的顺序可以打乱。那么对于一个数组中，要移除的元素非常少的话
     * 这种方法的效率是很高的，缩短数组的长度以及交换元素的位置
     * @param nums
     * @param val
     * @return
     */
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    public static void main(String[] args) {
        int nums[] = new int[] {3,2,2,3};
        System.out.println(new Solution27().removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));

        nums = new int[] {4,1,2,3,5};
        System.out.println(new Solution27().removeElement1(nums, 4));
        System.out.println(Arrays.toString(nums));
    }
}
