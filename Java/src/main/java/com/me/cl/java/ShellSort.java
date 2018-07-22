package com.me.cl.java;

import java.util.Arrays;

public class ShellSort {
    static int[] intArray= {20,35,-15,7,55,1,-22,-21,54,0,0,1000,-1,9000,1,1,1};

    public static void main(String[] args){
        int gap=intArray.length/2;
        while(gap>=1){
            for(int i=0;i<gap;i++){
                int nextIndex=i+gap;
                while(nextIndex<=intArray.length-1){
                    sort(gap,nextIndex);
                    nextIndex+=gap;
                }
            }
            gap/=2;
        }

        System.out.println(Arrays.toString(intArray));
    }

    private static void sort(int gap,int index){
            int previousIndex=index-gap;
            int originalValue=intArray[index];
            int correntLocation=index;
            while(previousIndex>=0){
                //比较待排序的和之前的值大小，如果待排序的较大，那么已找到正确位置，break
                //如果待排序的较小，之前的值移动到后面，继续比较新位置和更前的位置
                if (intArray[previousIndex]<originalValue){
                    break;
                }else{
                    intArray[previousIndex+gap] =intArray[previousIndex];
                }

                correntLocation=previousIndex;
                previousIndex-=gap;
            }
            intArray[correntLocation]=originalValue;
    }
}
