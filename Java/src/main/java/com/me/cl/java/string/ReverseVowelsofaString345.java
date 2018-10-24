package com.me.cl.java.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 *
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 *
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsofaString345 {
    public String reverseVowels(String s) {
        int left=0;
        int right=s.length()-1;
        char[] charArray=s.toCharArray();
        Set hashSet=new HashSet<Character>();
        hashSet.add('a');
        hashSet.add('e');
        hashSet.add('i');
        hashSet.add('o');
        hashSet.add('u');
        hashSet.add('A');
        hashSet.add('E');
        hashSet.add('I');
        hashSet.add('O');
        hashSet.add('U');
        boolean findLeft=false;
        boolean findRight=false;
        while(left<right){
            if(hashSet.contains(charArray[left])) findLeft=true;
            if(hashSet.contains(charArray[right])) findRight=true;
            if(!findLeft){
                left++;
            }
            if(!findRight){
                right--;
            }
            if(findLeft&&findRight){
                char temp=charArray[left];
                charArray[left]=charArray[right];
                charArray[right]=temp;
                findLeft=false;
                findRight=false;
                left++;
                right--;
            }
        }

        return new String(charArray);
    }
}
