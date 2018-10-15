package com.me.cl.java.array;

/**
 * 287 Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 *
 * Note:
 * 1、Time complexity O(n)
 * 2、In place, space complexity O(1)
 */
public class FindtheDuplicateNumber287 {
    public int findDuplicate(int[] nums) {
        int index=nums[0]-1;
        nums[0]=-1;
        while(true){
            if(nums[index]==0) return index+1;
            if(nums[index]==-1){
                nums[index]=0;
                boolean find=false;
                for(int i=index+1;i<nums.length;i++){
                    if(nums[i]!=0){
                        index=nums[i]-1;
                        find=true;
                        nums[i]=-1;
                        break;
                    }
                }
                if(!find){
                    break;
                }
            }else{
                int oldIndex=index;
                index=nums[index]-1;
                nums[oldIndex]=0;
            }
        }
        return -1;
    }
}
