package com.me.cl.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by CL on 7/21/18.
 */
public class BucketSort {
    static int[] intArray= {134,245,342,567,213,332,201,104,506,300,640,567,786,666,999,888,765};
    public static void main(String[] args){
        List[] buckets=new ArrayList[9];
        Object[] sortedArray=new Object[intArray.length];
        for(int i=0;i<intArray.length;i++){
            int bucketIndex=mapToBucket(intArray[i]);
            if(buckets[bucketIndex]==null){
                buckets[bucketIndex]=new ArrayList();
            }

            buckets[bucketIndex].add(intArray[i]);
        }

        int unsortedFirstIndex=0;

        for(int i=0;i<buckets.length;i++){
            if(buckets[i]!=null){
                Collections.sort(buckets[i]);
                System.arraycopy(buckets[i].toArray(),0,sortedArray,unsortedFirstIndex,buckets[i].size());
                unsortedFirstIndex+=buckets[i].size();
            }
        }

        System.out.println(Arrays.toString(sortedArray));
    }

    private static int mapToBucket(int value){
        return value/100%10-1;
    }
}
