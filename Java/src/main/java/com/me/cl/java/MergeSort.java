package com.me.cl.java;

import java.util.Arrays;

/**
 * Created by CL on 7/18/18.
 */
public class MergeSort {
    static int[] intArray= {20,35,-15,7,55,1,-22,-21,54,0,0,1000,-1,9000,1,1,1};
    public static void main(String[] args){
        mergeSort(intArray,0,intArray.length-1);
        System.out.println(Arrays.toString(intArray));
    }

    private static void mergeSort(int[] arrays,int startIndex,int endIndex){
            if (startIndex==endIndex){
                return;
            }
            int midIndex=(startIndex+endIndex)/2;
            mergeSort(arrays,startIndex,midIndex);
            mergeSort(arrays,midIndex+1,endIndex);
            merge(arrays,startIndex,midIndex,endIndex);
    }

    private static void merge(int[] arrays,int start,int middle,int end){
            int i=0;
            int j=0;
            int sortedIndex=0;
            int[] sortedArray=new int[end-start+1];
            while(start+i<=middle&&middle+1+j<=end){
                    //保持相同的值的左右次序，以保证是稳定排序
                    if(arrays[start+i]<=arrays[middle+1+j]){
                        sortedArray[sortedIndex++]=arrays[start+i];
                        i++;
                    }else{
                        sortedArray[sortedIndex++]=arrays[middle+1+j];
                        j++;
                    }
            }

            if(start+i>middle){
                for(int m=middle+1+j;m<=end;m++){
                    sortedArray[sortedIndex++]=arrays[m];
                }
            }else{
                for(int m=start+i;m<=middle;m++){
                    sortedArray[sortedIndex++]=arrays[m];
                }
            }

        System.arraycopy(sortedArray,0,arrays,start,sortedArray.length);
    }
}
