package com.me.cl.java.string;

import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 *
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * Example 1:
 *
 * Input:  "69"
 * Output: true
 * Example 2:
 *
 * Input:  "88"
 * Output: true
 * Example 3:
 *
 * Input:  "962"
 * Output: false
 */
public class StrobogrammaticNumber246 {
    public boolean isStrobogrammatic(String num) {
        int leftIndex=-1;
        int rightIndex=-1;
        Map<Integer,Integer> stroboMap=new HashMap<Integer,Integer>();
        stroboMap.put(6,9);
        stroboMap.put(9,6);
        int[] selfStro={1,0,8};
        if(num.length()%2==0){
            leftIndex=num.length()/2-1;
            rightIndex=num.length()/2;
        }else{
            int midIndex=num.length()/2;
            boolean isSelf=isSelfStro(Character.getNumericValue(num.charAt(midIndex)),selfStro);
            if(!isSelf){return false;}
            leftIndex=midIndex-1;
            rightIndex=midIndex+1;
        }
        while(leftIndex>=0){
            int leftValue=Character.getNumericValue(num.charAt(leftIndex));
            int rightValue=Character.getNumericValue(num.charAt(rightIndex));
            if(stroboMap.containsKey(leftValue)){
                if(stroboMap.get(leftValue)!=rightValue){
                    return false;
                }
            }else if(isSelfStro(leftValue,selfStro)){
                if(leftValue!=rightValue){
                    return false;
                }
            }else{
                return false;
            }
            leftIndex--;
            rightIndex++;
        }
        return true;
    }

    private boolean isSelfStro(int value, int[] selfStro){
        for(int self:selfStro){
            if(self==value){
                return true;
            }
        }
        return false;
    }
}
