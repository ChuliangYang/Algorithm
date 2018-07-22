package com.me.cl.java;

import java.util.Arrays;

/**
 * Created by CL on 7/21/18.
 */
public class InsertionSort {
    static int[] intArray= {20,35,-15,7,55,1,-22,-21,54,0,0,1000,-1,9000,1,1,1};
    public static void main(String[] args){
        for(int i=1;i<=intArray.length-1;i++){
            int current=intArray[i];
            int correctIndex=i;
            for(int j=i-1;j>=0;j--){
                if(current<intArray[j]){
                    intArray[correctIndex]=intArray[j];
                    correctIndex=j;
                }else{
                    break;
                }
            }
            intArray[correctIndex]=current;
        }

        System.out.println(Arrays.toString(intArray));
    }
}
