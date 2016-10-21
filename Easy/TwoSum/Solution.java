import java.util.Arrays;
import java.lang.Math;
import java.util.HashMap;

/**
 * Created by diwenchen on 2016/10/20.
 * https://leetcode.com/problems/two-sum/
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] tmp = new int[length];
        for (int i = 0; i < length; ++i) {
            tmp[i] = target - nums[i];
        }
        for (int i = 0; i < length; ++i) {
            int a = tmp[i];
            for (int j = 0; j < length; ++j) {
                if (i == j) {
                    continue;
                }
                if (a == nums[j]) {
                    int min = Math.min(i, j);
                    int max = Math.max(i, j);
                    return new int[] {min, max};
                }
            }
        }
        return tmp;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(nums[i])) {
               return new int[] {map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return new int[] {};
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] rets = solution.twoSum(nums, target);
        System.out.println(Arrays.toString(rets));
        int[] rets2 = solution.twoSum2(nums, target);
        System.out.println(Arrays.toString(rets2));
    }
}

