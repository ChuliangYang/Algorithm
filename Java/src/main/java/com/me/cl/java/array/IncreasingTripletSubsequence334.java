package com.me.cl.java.array;

/**
 * 334.Increasing Triplet Subsequence
 * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
 *
 * Formally the function should:
 *
 * Return true if there exists i, j, k
 * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
 * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5]
 * Output: true
 * Example 2:
 *
 * Input: [5,4,3,2,1]
 * Output: false
 */
public class IncreasingTripletSubsequence334 {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length==0) return false;
        Integer matchTwo=null;
        int mathOne=nums[0];
        for(int i=1;i<nums.length;i++){
            if(matchTwo!=null&&nums[i]>matchTwo){
                return true;
            }
            if(nums[i]>mathOne){
                if(matchTwo==null) {
                    matchTwo=nums[i];
                    continue;
                }
                if(nums[i]<matchTwo) matchTwo=nums[i];
            }else if(nums[i]<mathOne){
                mathOne=nums[i];
            }
        }
        return false;
    }
}
