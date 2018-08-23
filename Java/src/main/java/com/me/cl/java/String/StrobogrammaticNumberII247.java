package com.me.cl.java.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by CL on 8/23/18.
 */
public class StrobogrammaticNumberII247 {
    private int length;
    private int mirrorIndex;
    private List<Character> posibilities=Arrays.asList('0','1','8','6','9');
    private List<Character> posibilityMiddle=Arrays.asList('0','1','8');
    private char[] tempResult;
    private List<String> results=new ArrayList<>();
    public List<String> findStrobogrammatic(int n) {
        length=n;
        mirrorIndex=(n-1)/2;
        tempResult=new char[n];
        makeDecision(0,tempResult);
        return results;
    }

    private void makeDecision(int level,char[] resultArray){
        if(level==length){
            results.add(new String(resultArray));
            return;
        }

        int currentLevel=level;
        int nextLevel=level+1;

        if(level==mirrorIndex&&length%2!=0){
            for(int i=0;i<posibilityMiddle.size();i++){
                resultArray[currentLevel]=posibilityMiddle.get(i);
                makeDecision(nextLevel,resultArray);
            }
        }else if(level<=mirrorIndex){
            boolean passZero=false;
            if(level==0&&length>1) passZero=true;
            for(int i=0;i<posibilities.size();i++){
                if(passZero&&posibilities.get(i)=='0') continue;
                resultArray[currentLevel]=posibilities.get(i);
                makeDecision(nextLevel,resultArray);
            }
        }else{
            int index;
            if(length%2!=0){
                index=(2*mirrorIndex-level);
            }else{
                index=(2*mirrorIndex-level+1);
            }
            if(index<0) index=0;
            char origin=resultArray[index];
            char mirror=origin;
            if(origin=='6'){
                mirror='9';
            }else if(origin=='9'){
                mirror='6';
            }
            resultArray[currentLevel]=mirror;
            makeDecision(nextLevel,resultArray);
        }
    }
}
