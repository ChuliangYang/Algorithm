package com.me.cl.java.sort;

import java.util.Arrays;

/**
 * Created by CL on 7/21/18.
 */
public class SelectionSort {
    static int[] intArray= {20,35,-15,7,55,1,-22,-21,54,0,0,1000,-1,9000,1,1,1};

    public static void main(String[] args){
        int j=intArray.length-1;
        while(j>=0){
            int maxIndex=0;
            for(int i=1;i<=j;i++){
                if(intArray[i]>intArray[maxIndex]){
                        maxIndex=i;
                }
            }
            int temp=intArray[j];
            intArray[j]=intArray[maxIndex];
            intArray[maxIndex]=temp;
            j--;
        }

        System.out.println(Arrays.toString(intArray));
    }
}
