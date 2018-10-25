package com.me.cl.java.string;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to compute all possible states of the string after one valid move.
 *
 * Example:
 *
 * Input: s = "++++"
 * Output:
 * [
 *   "--++",
 *   "+--+",
 *   "++--"
 * ]
 * Note: If there is no valid move, return an empty list [].
 */
public class FlipGame293 {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> results=new ArrayList<>();
        if(s.length()==0) return results;
        char[] charArrays=s.toCharArray();
        for(int i=0;i<charArrays.length-1;i++){
            if(charArrays[i]=='+'&&charArrays[i+1]=='+'){
                StringBuilder sb=new StringBuilder(s);
                sb.replace(i,i+2,"--");
                results.add(sb.toString());
            }
        }
        return results;
    }
}
