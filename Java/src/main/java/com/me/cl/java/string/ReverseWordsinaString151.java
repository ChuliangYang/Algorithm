package com.me.cl.java.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 151.
 * Reverse Words in a string
 * Given an input string, reverse the string word by word.
 *
 * Example:
 *
 * Input: "the sky is blue",
 * Output: "blue is sky the".
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 * Follow up: For C programmers, try to solve it in-place in O(1) space.
 */
public class ReverseWordsinaString151 {
    public String reverseWords(String s) {
        if(s==null||s.isEmpty()) return "";
        List<String> words=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        for(char current:s.toCharArray()){
            if(current==' '){
                if(sb.length()>0){
                    words.add(sb.toString());
                    sb=new StringBuilder();
                }
            }else{
                sb.append(current);
            }
        }
        if(sb.length()>0){
            words.add(sb.toString());
            sb=new StringBuilder();
        }
        Collections.reverse(words);
        for(String word:words){
            sb.append(word);
            sb.append(" ");
        }
        if(sb.length()>0){
            sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
