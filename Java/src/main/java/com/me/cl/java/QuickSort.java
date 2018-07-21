package com.me.cl.java;

import java.util.Arrays;

/**
 * Created by CL on 7/19/18.
 */
public class QuickSort {
    static int[] intArray= {20,35,-15,7,55,1,-22,-21,54,0,0,1000,-1,9000,1,1,1};

    public static void main(String[] args){
        quickSort(intArray,0,intArray.length-1);
        System.out.println(Arrays.toString(intArray));
    }

    private static void quickSort(int[] array, int startIndex, int endIndex){
        if(startIndex==endIndex){
            return;
        }
        int pivorIndex=pivotSort(array, startIndex, endIndex);
        quickSort(array,startIndex,pivorIndex);
        quickSort(array,pivorIndex+1,endIndex);
    }

    private static int pivotSort(int[] array, int startIndex, int endIndex){
        int i=startIndex;
        int j=endIndex;
        int pivot=array[startIndex];
        boolean fromRight=true;
        while(i<j){
            if(fromRight){
                for(;j>i;j--){
                    if(array[j]<pivot){
                        array[i]=array[j];
                        i++;
                        break;
                    }
                }
            }else{
                for(;i<j;i++){
                    if(array[i]>pivot){
                        array[j]=array[i];
                        j--;
                        break;
                    }
                }
            }
            fromRight=!fromRight;
        }
        array[j]=pivot;
        return j;
    }

}
