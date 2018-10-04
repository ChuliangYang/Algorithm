package com.me.cl.java.binary_search;

/**
 * 35.
 * Search Insert Position
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        int result=bs(nums,target,0,nums.length-1);
        if(nums[result]==target) return result;
        if(nums[result]>target){
            return result;
        }else{
            return result+1;
        }

    }
    public int bs(int[] nums,int target,int start,int end){
        if(start>=end){
            return start;
        }
        int mid=start+(end-start)/2;
        if(nums[mid]==target) return mid;
        if(nums[mid]>target){
            return bs(nums,target,start,mid-1);
        }else{
            return bs(nums,target,mid+1,end);
        }
    }
}
