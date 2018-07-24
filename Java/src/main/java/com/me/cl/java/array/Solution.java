package com.me.cl.java.array;

/**
 * Created by CL on 7/23/18.
 */
public class Solution {
    public static void main(String[] args){
        strStr("a","");
    }


//    Find Pivot Index
//    Given an array of integers nums, write a method that returns the "pivot" index of this array.
//
//    We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
//
//    If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
//
//            Example 1:
//    Input:
//    nums = [1, 7, 3, 6, 5, 6]
//    Output: 3
//    Explanation:
//    The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
//    Also, 3 is the first index where this occurs.
//            Example 2:
//    Input:
//    nums = [1, 2, 3]
//    Output: -1
//    Explanation:
//    There is no index that satisfies the conditions in the problem statement.
//    Note:
//
//    The length of nums will be in the range [0, 10000].
//    Each element nums[i] will be an integer in the range [-1000, 1000].
    public int pivotIndex(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int leftSum=0;
        int RightSum=0;
        for(int i=1;i<nums.length;i++){
            RightSum+=nums[i];
        }
        for(int i=0;i<nums.length;i++){
            if(i>0){
                leftSum+=nums[i-1];
                RightSum-=nums[i];
            }
            if(leftSum==RightSum){
                return i;
            }
        }
        return -1;
    }

//    Largest Number At Least Twice of Others
//    In a given integer array nums, there is always exactly one largest element.
//
//    Find whether the largest element in the array is at least twice as much as every other number in the array.
//
//    If it is, return the index of the largest element, otherwise return -1.
//
//    Example 1:
//
//    Input: nums = [3, 6, 1, 0]
//    Output: 1
//    Explanation: 6 is the largest integer, and for every other number in the array x,
//            6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
//
//
//    Example 2:
//
//    Input: nums = [1, 2, 3, 4]
//    Output: -1
//    Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
//
//
//    Note:
//
//    nums will have a length in the range [1, 50].
//    Every nums[i] will be an integer in the range [0, 99].

    public int dominantIndex(int[] nums) {
        int max=nums[0];
        Integer secondMax=null;
        int maxIndex=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max){
                secondMax=max;
                max=nums[i];
                maxIndex=i;
            }else if(nums[i]<max){
                if(secondMax==null||nums[i]>secondMax){
                    secondMax=nums[i];
                }
            }

        }
        if(secondMax==null){
            return 0;
        }else if(max>=2*secondMax){
            return maxIndex;
        }else{
            return -1;
        }

    }

    public static String addBinary(String a, String b) {
        int aLength=a.length();
        int bLength=b.length();
        int longLength=Math.max(aLength,bLength);
        boolean carry=false;
        StringBuilder resultBuilder=new StringBuilder();
        for(int i=0;i<longLength;i++){
            int aDigit=aLength-1-i>=0?Character.getNumericValue(a.charAt(aLength-1-i)):0;
            int bDigit=bLength-1-i>=0?Character.getNumericValue(b.charAt(bLength-1-i)):0;
            int result=aDigit+bDigit;
            if(carry){
                result+=1;
                carry=false;
            }
            if(result>1){
                result-=2;
                carry=true;
            }
            resultBuilder.append(result);
            if(i==longLength-1&&carry){
                resultBuilder.append(1);
            }
        }
        return resultBuilder.reverse().toString();
    }

    public static int strStr(String haystack, String needle) {
        if(""==needle||needle==null){
            return 0;
        }
        int matchIndex=0;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(matchIndex)){
                matchIndex++;
            }else{
                matchIndex=0;
            }

            if(matchIndex==needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;

    }
}
