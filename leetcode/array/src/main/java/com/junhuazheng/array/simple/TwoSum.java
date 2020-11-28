package com.junhuazheng.array.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 、一个目标值 target
 * 请你在该数组中找出和为目标值的那两个整数 返回数组下标。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
    }

    /**
     * 4ms左右
     * @param nums
     * @param target
     * @return
     */
    public static int[] execute(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            if (!(null == map.get(target - nums[i]))) {
                Integer index = map.get(target - nums[i]);
                if (index != i) {
                    result[0] = i;
                    result[1] = map.get(target - nums[i]);
                }
            }
        }
        return result;
    }

    /**
     * 100ms左右
     * @param nums
     * @param target
     * @return
     */
    public static int[] execute2(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }

        return result;
    }

    public static int[] execute3(int[] nums, int target) {
        int[] result = new int[2];
        
        return result;
    }
}
