package com.me.cl.java.string;

import java.util.HashMap;
import java.util.Map;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.
 *
 * Write a function to determine if the starting player can guarantee a win.
 *
 * Example:
 *
 * Input: s = "++++"
 * Output: true
 * Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 * Follow up:
 * Derive your algorithm's runtime complexity.
 */
public class FlipGameII294 {
    Map<String,Boolean> memo=new HashMap<>();
    public boolean canWin(String s) {
        return canWin(new StringBuilder(s),false);
    }

    public boolean canWin(StringBuilder decisions, boolean myDecision){
        for(int i=0;i<decisions.length()-1;i++){
            if(decisions.charAt(i)=='+'&&decisions.charAt(i+1)=='+'){
                decisions=decisions.replace(i,i+2,"--");
                Boolean canWin=memo.get(decisions.toString()+!myDecision);
                if(canWin==null){
                    canWin=canWin(decisions,!myDecision);
                }
                if(!myDecision&&canWin||myDecision&&!canWin){
                    memo.put(decisions.toString()+!myDecision,canWin);
                    decisions=decisions.replace(i,i+2,"++");
                    return canWin;
                }
                decisions=decisions.replace(i,i+2,"++");
            }
        }
        memo.put(decisions.toString()+myDecision,myDecision);
        return myDecision;
    }
}
