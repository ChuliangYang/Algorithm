package com.me.cl.java.DP;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CL on 8/2/18.
 */
public class Solution {
    private static List<Integer> maxValues=new ArrayList<>();
    private static List<Integer> minValues=new ArrayList<>();
    private static List<Integer> maxSum=new ArrayList<>();

    public static void main(String[] args){
        int[] test={2,3,-2,4};
        System.out.println(findBestContigousSum(test));
    }
//    Maximum Subarray
//    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
//
//    Example:
//
//    Input: [-2,1,-3,4,-1,2,1,-5,4],
//    Output: 6
//    Explanation: [4,-1,2,1] has the largest sum = 6.

    private static int findBestContigousSum(int[] arrays){
          int bestResult= getBestContiguousSum(arrays,0);
          for(int i=1;i<arrays.length;i++){
                if(getBestContiguousSum(arrays,i)>bestResult){
                    bestResult= getBestContiguousSum(arrays,i);
                }
          }
          return bestResult;
    }

    private static int getBestContiguousSum(int[] arrays, int index){
            if(index==0){
                maxSum.add(0,arrays[0]);
                return arrays[0];
            }
            Integer oldMaxSum=maxSum.get(index-1);
            if(oldMaxSum==null){
                oldMaxSum=getBestContiguousSum(arrays,index-1);
            }

            if(oldMaxSum+arrays[index]>arrays[index]){
                maxSum.add(index,oldMaxSum+arrays[index]);
            }else{
                maxSum.add(index,arrays[index]);
            }
            return maxSum.get(index);
    }

//    Maximum Product Subarray
//    Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
//    Example 1:
//
//    Input: [2,3,-2,4]
//    Output: 6
//    Explanation: [2,3] has the largest product 6.
//    Example 2:
//
//    Input: [-2,0,-1]
//    Output: 0
//    Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

    private static int findBestContigousProduct(int[] arrays){
        int bestResult= getBestContigousProduct(arrays,0)[0];
        for(int i=1;i<arrays.length;i++){
            if(getBestContigousProduct(arrays,i)[0]>bestResult){
                bestResult= getBestContigousProduct(arrays,i)[0];
            }
        }
        return bestResult;
    }

    private static int[] getBestContigousProduct(int[] arrays, int index){
        if(index==0){
            maxValues.add(index,arrays[0]);
            minValues.add(index,arrays[0]);
            return new int[]{arrays[0],arrays[0]};
        }
        int[] result=new int[2];
        Integer oldMaxValue;
        Integer oldMinValue;
        if(arrays[index]>=0){
            oldMaxValue=maxValues.get(index-1);
            oldMinValue=minValues.get(index-1);
            if(oldMaxValue==null){
                oldMaxValue=getBestContigousProduct(arrays,index-1)[0];
            }
            if(oldMinValue==null){
                oldMinValue=getBestContigousProduct(arrays,index-1)[1];
            }
            result[0]=Math.max(oldMaxValue*arrays[index],arrays[index]);
            result[1]=Math.min(oldMinValue*arrays[index],arrays[index]);
        }else{
            oldMaxValue=maxValues.get(index-1);
            oldMinValue=minValues.get(index-1);
            if(oldMaxValue==null){
                oldMaxValue=getBestContigousProduct(arrays,index-1)[0];
            }
            if(oldMinValue==null){
                oldMinValue=getBestContigousProduct(arrays,index-1)[1];
            }
            result[0]=Math.max(oldMinValue*arrays[index],arrays[index]);
            result[1]=Math.min(oldMaxValue*arrays[index],arrays[index]);
        }
        maxValues.add(index,result[0]);
        minValues.add(index,result[1]);
        return result;
    }
}
