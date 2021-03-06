package com.me.cl.java.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Example 1:
 *
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * Example 2:
 *
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * Example 3:
 *
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * Example 4:
 *
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length()==0) return false;
        String[] strArray=str.split("\\s");
        if(pattern.length()!=strArray.length) return false;
        Map<Character,String> patternMap=new HashMap<>();
        char[] charArray=pattern.toCharArray();
        for(int i=0;i<charArray.length;i++){
            if(patternMap.containsKey(charArray[i])){
                if(patternMap.get(charArray[i]).equals(strArray[i])){
                    continue;
                }else{
                    return false;
                }
            }else{
                if(patternMap.containsValue(strArray[i])){
                    return false;
                }else{
                    patternMap.put(charArray[i],strArray[i]);
                }
            }
        }
        return true;
    }
}
