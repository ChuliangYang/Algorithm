package com.me.cl.java.array;

import java.util.HashSet;

/**
 * Remove duplicate from inputArray
 */
public class FindDuplicate {
    public static void main(String[] args){
            int[] test={3,2,2,3,1,100,-1};
            int[] result=findDuplicate(test);
            for(int i:result){
                System.out.println(i);
            }
    }

    public static int[] findDuplicate(int[] inputArray){
        HashSet<Integer> sets=new HashSet<>();

        for(int number:inputArray){
            sets.add(number);
        }
        int[] resultArray=new int[sets.size()];
        int i=0;
        for(Integer number:sets){
            resultArray[i++]=number;
        }
        return resultArray;
    }
}
