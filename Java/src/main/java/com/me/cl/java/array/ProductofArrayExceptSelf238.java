package com.me.cl.java.array;

/**
 238. Product of Array Except Self
 Medium

 2422

 207

 Favorite

 Share
 Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

 Example:

 Input:  [1,2,3,4]
 Output: [24,12,8,6]
 Note: Please solve it without division and in O(n).
 */
public class ProductofArrayExceptSelf238 {
    public int[] productExceptSelf(int[] nums) {
        int[] leftTotal=new int[nums.length];
        int[] rightTotal=new int[nums.length];
        int[] resultArray=new int[nums.length];

        int leftAccumulate=1;
        int rightAccumulate=1;
        for(int i=0;i<nums.length;i++){
            if(i==0){
                leftTotal[i]=leftAccumulate;
            }else{
                leftAccumulate=leftAccumulate*nums[i-1];
                leftTotal[i]=leftAccumulate;
            }
        }

        for(int i=nums.length-1;i>=0;i--){
            if(i==nums.length-1){
                rightTotal[i]=rightAccumulate;
            }else{
                rightAccumulate=rightAccumulate*nums[i+1];
                rightTotal[i]=rightAccumulate;
            }
        }

        for(int i=0;i<nums.length;i++){
            resultArray[i]=leftTotal[i]*rightTotal[i];
        }
        return resultArray;
    }
}
