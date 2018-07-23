package com.me.cl.java.sort;

import java.util.Arrays;

/**
 * Created by CL on 7/21/18.
 */
public class RadixSort {
    static int[] intArray= {20,35,15,7,55,1,22,21,54,0,0,1000,4,9000,1,1,1};

    public static void main(String[] args){
        numberSort(intArray,4);
        System.out.println(Arrays.toString(intArray));
    }

    private static void numberSort(int[] intArray, int maxWidth){
            for(int i=0;i<maxWidth;i++){
                radixSort(intArray,i);
            }
    }

    private static void radixSort(int[] intArray, int position){
            int[] countArray=new int[10];
            int[] sortedArray=new int[intArray.length];
            for(int i=0;i<intArray.length;i++){
                countArray[getDigit(intArray[i],position)]++;
            }

            for(int i=1;i<countArray.length;i++){
                countArray[i]+=countArray[i-1];
            }

            for(int j=intArray.length-1;j>=0;j--){
                sortedArray[(countArray[getDigit(intArray[j],position)]--)-1]=intArray[j];
            }
            System.arraycopy(sortedArray,0,intArray,0,sortedArray.length);
    }

    private static int getDigit(int value, int position){
            return value/(int)Math.pow(10,position)%10;
    }
}
