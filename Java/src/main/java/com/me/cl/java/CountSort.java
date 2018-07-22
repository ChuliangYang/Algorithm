package com.me.cl.java;

import java.util.Arrays;

/**
 * Created by CL on 7/21/18.
 */
public class CountSort {
    static int[] intArray = {1, 1, 0, 34, 23, 12, 44, 1, 3, 50, 23, 17};

    public static void main(String[] args) {
        sort(intArray,0,50);
        System.out.println(Arrays.toString(intArray));
    }

    private static void sort(int[] arrays, int min, int max) {
                int[] countArray=new int[max-min+1];
                int[] sortedArray=new int[intArray.length];
                for(int i=0;i<intArray.length;i++){
                    countArray[arrays[i]-min]++;
                }

                for(int i=1;i<countArray.length;i++){
                    countArray[i]+=countArray[i-1];
                }

                for(int j=intArray.length-1;j>=0;j--){
                    sortedArray[(countArray[intArray[j]-min]--)-1]=intArray[j];
                }
                System.arraycopy(sortedArray,0,intArray,0,sortedArray.length);
    }
}
