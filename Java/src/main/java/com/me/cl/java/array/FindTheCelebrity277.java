package com.me.cl.java.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 277. Find the Celebrity
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 *
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 *
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 *
 * Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 */
public class FindTheCelebrity277 {
    public int findCelebrity(int n) {
        if(n<=1){
            return -1;
        }
        List<Integer> candidates=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i==0){
                for(int j=1;j<n;j++){
                    if(knows(0,j)){
                        candidates.add(Integer.valueOf(j));
                    }
                }
                if(candidates.isEmpty()){
                    candidates.add(0);
                }
            }else{
                boolean isCandidate=false;
                if(candidates.contains(Integer.valueOf(i))){
                    isCandidate=true;
                }
                for(int j=0;j<candidates.size();j++){
                    if(isCandidate&&candidates.get(j)==Integer.valueOf(i)) continue;
                    if(!knows(i,candidates.get(j))){
                        candidates.remove(j);
                        j--;
                    }else{
                        isCandidate=false;
                    }
                }
                if(!isCandidate&&candidates.contains(i)) {
                    candidates.remove(Integer.valueOf(i));
                }
            }
        }

        if(candidates.contains(Integer.valueOf(0))){
            return 0;
        }
        for(int i=0;i<candidates.size();i++){
            for(int j=0;j<n;j++){
                if(candidates.get(i).equals(Integer.valueOf(j))) continue;
                if(knows(candidates.get(i),j)){
                    candidates.remove(i);
                    i--;
                    break;
                }
            }
        }

        if(candidates.isEmpty()){
            return -1;
        }else{
            return candidates.get(0);
        }
    }

    boolean knows(int a, int b){
        return true;
    }
}
