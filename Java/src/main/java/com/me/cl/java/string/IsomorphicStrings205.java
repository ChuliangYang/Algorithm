package com.me.cl.java.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        Map reflection=new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            if(reflection.containsKey(s.charAt(i))){
                if(!reflection.get(s.charAt(i)).equals(t.charAt(i)))  {
                    return false;
                }
            }else{
                if(reflection.containsValue(t.charAt(i))) return false;
                reflection.put(s.charAt(i),t.charAt(i));
            }
        }
        return true;
    }
}
