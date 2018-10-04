package com.me.cl.java.priority_queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 215.
 * Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> minHeap=new PriorityQueue<>(nums.length,new Comparator<Integer>(){
            @Override
            public int compare(Integer c1, Integer c2) {
                return c2-c1;
            }
        });
        for(int item:nums){
            minHeap.offer(item);
        }
        int result=0;
        for(int i=0;i<k;i++){
            result=minHeap.poll();
        }
        return result;
    }
}
