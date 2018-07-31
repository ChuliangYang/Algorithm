package com.me.cl.java.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javafx.util.Pair;

/**
 * Created by CL on 7/30/18.
 */
public class tree {
    private static int count=0;
    public static void main(String[] args){
        NQueen(8);
    }

//    Using a regular chess board, the challenge is to place eight queens on the board such that no queen is attacking any of the others. (For those not familiar with chess pieces, the queen is able to attack any square on the same row, any square on the same column, and also any square on either of the diagonals).
    public static void NQueen(int n){
        DFSRecursive(n,-1,-1,new int[n]);
        System.out.println(count);
        count=0;

    }
//    DFS Recursive solution -- start
    private static void DFSRecursive(int n,int decisionLevel, int decision, int[] decisionArray){
            if(decisionLevel==-1||checkVaild(decisionLevel, decision, decisionArray)){
                if(decisionLevel>=0){
                    decisionArray[decisionLevel]=decision;
                }
                if(decisionLevel>=n-1) {
                    count++;
//                    printResult(n,decisionArray);
                    return;
                }
                for(int i=0;i<n;i++){
                    DFSRecursive(n,decisionLevel+1,i,decisionArray);
                }
            }


    }

    private static boolean checkVaild(int decisionLevel, int decision, int[] decisionArray){
            for(int i=0;i<decisionLevel;i++){
                if(decisionArray[i] == decision||Math.abs(decision - decisionArray[i])== decisionLevel-i){
                    return false;
                }
            }
            return true;
    }

    private static void printResult(int n,int[] validArray){
         System.out.println();
            for(int i:validArray){
                for(int j=0;j<n;j++){
                    if(j==i){
                        System.out.print(" Q ");
                    }else{
                        System.out.print(" * ");
                    }
                }
                System.out.println();
            }
        System.out.println();

    }

//    DFS Recursive solution -- end

//    DFS Stack solution -- start
    private static void DFSStack(int n){
        Stack<Pair<Integer,Integer>> backStack= new Stack<>();
        backStack.push(new Pair(-1,-1));
        List[] visited=new ArrayList[n];
        Map<Pair<Integer,Integer>,Integer> map=new HashMap<>();
        while(backStack.size()>0){
            Pair<Integer,Integer> top=backStack.peek();

        }

    }

//    DFS Stack solution -- end

}
