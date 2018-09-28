package com.me.cl.java.BackTrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 78.
 * Subsets
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> chains=new ArrayList<>();
        List<List<Integer>> results=new ArrayList<>();
        results.add(chains);
        if(nums.length==0) return results;
        for(int i=0;i<nums.length;i++){
            subsets(nums,i,chains,results);
            chains.remove(chains.size()-1);
        }
        return results;
    }

    public void subsets(int[] nums,int i,List<Integer> chains,List<List<Integer>> results){
        chains.add(nums[i]);
        results.add(new ArrayList<>(chains));
        for(int j=i+1;j<nums.length;j++){
            subsets(nums,j,chains,results);
            chains.remove(chains.size()-1);
        }
    }
}
