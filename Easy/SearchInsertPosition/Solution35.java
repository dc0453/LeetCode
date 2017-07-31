/**
 * Author: dc0453
 * Since: 2017/7/31 下午6:10
 * https://leetcode.com/problems/search-insert-position/
 */
public class Solution35 {
    /**
     * 第一次提交不知道是升序还是降序的，写了一个先判断升序还是降序，默认是升序
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        boolean isAsc = isAsc(nums);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (isAsc && target < nums[i]) {
                return i;
            } else if (!isAsc && target > nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * 看了一下别人的答案，好像都是升序的操作，就写了一个升序的。
     * 题意没有说明是升序还是降序啊，例子给的倒是升序的s
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }

    /**
     * Arrays.binarySearch(int[] nums, int target)版本的，二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midNum = nums[mid];
            if (midNum == target) {
                return mid;
            } else if (midNum > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int searchInsert3(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    private boolean isAsc(int[] nums) {
        boolean isAsc = true;
        if (nums.length > 1) {
            isAsc = nums[0] < nums[1] ? true : false;
        }
        return isAsc;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,6};
        Solution35 s = new Solution35();
        System.out.println(s.searchInsert3(nums, 5));
        System.out.println(s.searchInsert3(nums, 2));
        System.out.println(s.searchInsert3(nums, 7));
        System.out.println(s.searchInsert3(nums, 0));

    }
}
