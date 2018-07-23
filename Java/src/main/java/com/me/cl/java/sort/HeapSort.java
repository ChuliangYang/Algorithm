package com.me.cl.java.sort;

import java.util.Arrays;

/**
 * Created by CL on 7/21/18.
 */
public class HeapSort {
    static int[] intArray = {20, 35, -15, 7, 55, 1, -22, -21, 54, 0, 0, 1000, -1, 9000, 1, 1, 1};
    static int[] heap=new int[intArray.length];
    static int size=0;

    public static void main(String[] args) {
        for(int value:intArray){
            insertIntoHeap(heap,value);
        }

        for(int i=0;i<intArray.length;i++){
            int logicLastIndex=size-i-1;
            intArray[i]=heap[0];
            heap[0]=heap[logicLastIndex];
            heapifyDown(0,logicLastIndex--);
        }

        System.out.println(Arrays.toString(intArray));
    }

    private static void insertIntoHeap(int[] heap,int value){
            heap[size]=value;
            heapifyUp(size);
            size++;
    }

    private static int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private static void heapifyUp(int index) {
        if(index==0){
            return;
        }
        if (heap[index] > heap[getParentIndex(index)]) {
            int temp = heap[index];
            heap[index] = heap[getParentIndex(index)];
            heap[getParentIndex(index)] = temp;
            heapifyUp(getParentIndex(index));
        }
    }

    private static void heapifyDown(int index,int end){
        if(getChild(index,true)>end){
            return;
        }
        int biggerChildIndex=getChild(index,true);
        if(getChild(index,false)<=end&&heap[getChild(index,false)]>heap[getChild(index,true)]){
            biggerChildIndex=getChild(index,false);
        }
        if(heap[index]<heap[biggerChildIndex]){
            int temp=heap[index];
            heap[index]=heap[biggerChildIndex];
            heap[biggerChildIndex]=temp;
            heapifyDown(biggerChildIndex,end);
        }

    }

    private static int getChild(int index, boolean isLeft){
        return 2*index+(isLeft?1:2);
    }
}
