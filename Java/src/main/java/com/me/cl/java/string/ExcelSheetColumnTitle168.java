package com.me.cl.java.string;

import java.util.Stack;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
public class ExcelSheetColumnTitle168 {
    public String convertToTitle(int n) {
        StringBuilder resultString=new StringBuilder();
        Stack<Character> resultStack=new Stack<Character>();
        int highestValue=n;
        while(true){
            if(highestValue<=26){
                resultStack.push(Character.valueOf((char)('A'+(highestValue-1))));
                highestValue=0;
                break;
            }else{
                int remainder=highestValue%26;
                if(remainder==0){
                    resultStack.push(Character.valueOf((char)('Z')));
                    highestValue=highestValue/26-1;
                }else{
                    resultStack.push(Character.valueOf((char)('A'+(remainder-1))));
                    highestValue=highestValue/26;
                }
            }
        }

        while(!resultStack.empty()){
            resultString.append(resultStack.pop());
        }
        return resultString.toString();
    }
}
