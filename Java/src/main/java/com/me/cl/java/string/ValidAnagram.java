package com.me.cl.java.string;

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * Example 2:
 *
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())  return false;
        int[] map=new int[26];
        for(char current:s.toCharArray()){
            map[current-'a']++;
        }
        for(char ncurrent:t.toCharArray()){
            map[ncurrent-'a']--;
            if(map[ncurrent-'a']<0){
                return false;
            }
        }
        return true;
    }
}
