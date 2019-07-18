package com.me.cl.java.array;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        boolean found=false;
        int resultBefore=-1;
        int resultAfter=-1;
        for(int beforeIndex=0;beforeIndex<nums.length-1;beforeIndex++){
            int before=nums[beforeIndex];
            for(int afterIndex=beforeIndex+1;afterIndex<nums.length;afterIndex++){
                int after=nums[afterIndex];
                if(before+after==target){
                    found=true;
                    resultAfter=afterIndex;
                    break;
                }
            }
            if(found){
                resultBefore=beforeIndex;
                break;
            }
        }
        return new int[]{resultBefore,resultAfter};
    }
}
